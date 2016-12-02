package sumSpring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import sumSpring.aop.bean.TargetSource;

public class JdkDynamicAopProxy implements AopPoxy,InvocationHandler {

	
	
    //    ����Ҫ�����ĸ���ʵ���󣬾ͽ��ö��󴫽�ȥ�������ͨ������ʵ�����������䷽����

	private AdviseSupport adviseSupport;
	
	public JdkDynamicAopProxy(AdviseSupport obj)
	{
		this.adviseSupport = obj;
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		
		//���������ķ���
		MethodInterceptor methodInterceptor = adviseSupport.getMethodInterceptor();
		//���ش�������invoke����	
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
