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
	 		System.out.println("���ǻ������ķָ��ߡ�������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	 		// --------- helloWorldService with AOP
	 		// 1. ���ñ��������(Joinpoint) ͨ���ӿڽ��д���
	 		AdviseSupport advisedSupport = new AdviseSupport();
	 		TargetSource targetSource = new TargetSource(helloWorldService, SumHelloWorld.class);
	 		advisedSupport.setTargetSource(targetSource);
	 
	 		// 2. ����������(Advice)
	 		SumTimerInterceptor timerInterceptor = new SumTimerInterceptor();
	 		advisedSupport.setMethodInterceptor(timerInterceptor);
	 
	 		// 3. ��������(Proxy)
	 		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
	 		SumHelloWorld helloWorldServiceProxy = (SumHelloWorld) jdkDynamicAopProxy.getProxy();
	 
	         // 4. ����AOP�ĵ���
	         helloWorldServiceProxy.helloWorld();
		}
}
