package sumSpring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SumTimerInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		long time = System.nanoTime();
		System.out.println("Invoke Method "+invocation.getMethod().getName()+" Start");
		Object proceed = invocation.proceed();
		System.out.println("Invocation of Method " + invocation.getMethod().getName() + " end! takes " + (System.nanoTime() - time)
				+ " nanoseconds.");
		return proceed;
	}

}
