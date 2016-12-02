package sumSpring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import sumSpring.aop.bean.TargetSource;

public class JdkDynamicAopProxy implements AopPoxy,InvocationHandler {

	
	
    //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的

	private AdviseSupport adviseSupport;
	
	public JdkDynamicAopProxy(AdviseSupport obj)
	{
		this.adviseSupport = obj;
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		
		//被代理对象的方法
		MethodInterceptor methodInterceptor = adviseSupport.getMethodInterceptor();
		//返回代理对象的invoke方法	
		return methodInterceptor.invoke(new ReflectiveMethodInvocation(adviseSupport.getTargetSource().getTarget(),method,args));
	}

	@Override
	public Object getProxy() {
		// TODO Auto-generated method stub
		return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{
		adviseSupport.getTargetSource().getTargetClass()},
		this);
	}

}
