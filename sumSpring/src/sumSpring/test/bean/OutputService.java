package sumSpring.test.bean;

import sumSpring.test.SumHelloWorldService;

public class OutputService {

    String text;
	SumHelloWorldService helloWorldService = new SumHelloWorldService();
	
	public OutputService() {
		text="outputService";
	}
	
	public void output()
	{
		System.out.println("this is "+text);
		helloWorldService.helloWorld();
	}
}
