package sumSpring.test;

import org.junit.Test;

import sumSpring.aop.AdviseSupport;
import sumSpring.aop.JdkDynamicAopProxy;
import sumSpring.aop.SumTimerInterceptor;
import sumSpring.aop.bean.TargetSource;
import sumSpring.context.ApplicationContext;
import sumSpring.context.SumClassPathXmlApplicationContext;

public class JdkDynamicAopProxyTest {

		@Test
	 	public void testInterceptor() throws Exception {
	 	// --------- helloWorldService without AOP
	 		ApplicationContext applicationContext = new SumClassPathXmlApplicationContext("sumioc.xml");
	 		SumHelloWorldService helloWorldService = (SumHelloWorldService) applicationContext.getSumBean("helloWorldService");
	 		helloWorldService.helloWorld();
	 		System.out.println("这是华丽丽的分割线·································································································");
	 		// --------- helloWorldService with AOP
	 		// 1. 设置被代理对象(Joinpoint) 通过接口进行代理
	 		AdviseSupport advisedSupport = new AdviseSupport();
	 		TargetSource targetSource = new TargetSource(helloWorldService, SumHelloWorld.class);
	 		advisedSupport.setTargetSource(targetSource);
	 
	 		// 2. 设置拦截器(Advice)
	 		SumTimerInterceptor timerInterceptor = new SumTimerInterceptor();
	 		advisedSupport.setMethodInterceptor(timerInterceptor);
	 
	 		// 3. 创建代理(Proxy)
	 		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
	 		SumHelloWorld helloWorldServiceProxy = (SumHelloWorld) jdkDynamicAopProxy.getProxy();
	 
	         // 4. 基于AOP的调用
	         helloWorldServiceProxy.helloWorld();
		}
}
