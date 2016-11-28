package sumSpring.test;

import org.junit.Test;

import sumSpring.context.ApplicationContext;
import sumSpring.context.SumClassPathXmlApplicationContext;

public class ApplicationContextTest {
	
	@Test
	public void test() throws Exception{
		
		ApplicationContext applicationContext = new SumClassPathXmlApplicationContext("sumIoc.xml");
		SumHelloWorldService helloWorldService = (SumHelloWorldService)applicationContext.getSumBean("helloWorldService");
		helloWorldService.helloWorld();
		
		
	}

}
