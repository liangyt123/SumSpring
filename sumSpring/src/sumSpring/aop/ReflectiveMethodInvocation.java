package sumSpring.aop;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

public class ReflectiveMethodInvocation implements MethodInvocation {
	
	
	private Object target;
	private Method method;
	private Object[] args;

	public ReflectiveMethodInvocation(Object target, Method method,
			Object[] args) {
		this.target=target;
		this.method=method;
		this.args=args;

	}

	@Override
	public Object[] getArguments() {
		// TODO Auto-generated method stub
		return args;
	}

	@Override
	public AccessibleObject getStaticPart() {
		// TODO Auto-generated method stub
		return method;
	}

	@Override
	public Object getThis() {
		// TODO Auto-generated method stub
		return target;
	}

	@Override
	public Object proceed() throws Throwable {
		// TODO Auto-generated method stub
		return method.invoke(target, args);
	}

	@Override
	public Method getMethod() {
		// TODO Auto-generated method stub
		return method;
	}

}
