package sumSpring.io;

import java.net.URL;

public class SumResouceLoader {
	
	//获得资源定位
	public Resource getResource(String location){
		
		//获得location的资源url this.getClass.get...
		URL resource = this.getClass().getClassLoader().getResource(location);
		
		
		return  new SumUrlResource(resource);
	}

}
