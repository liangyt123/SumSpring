package sumSpring.io;

import java.net.URL;

public class SumResouceLoader {
	
	//�����Դ��λ
	public Resource getResource(String location){
		
		//���location����Դurl this.getClass.get...
		URL resource = this.getClass().getClassLoader().getResource(location);
		
		
		return  new SumUrlResource(resource);
	}

}
