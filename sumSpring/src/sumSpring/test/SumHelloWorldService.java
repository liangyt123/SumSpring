package sumSpring.test;

import sumSpring.test.bean.OutputService;

public class SumHelloWorldService {

		private String text;
		private OutputService outputService;
		
		
	    public void helloWorld(){
		       System.out.println(text);
		       outputService.output();
		 }
	    
	    public void setText(){
	    	this.text = text;
	    }
	    
}
