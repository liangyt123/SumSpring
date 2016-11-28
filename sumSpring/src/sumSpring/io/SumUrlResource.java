package sumSpring.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class SumUrlResource implements Resource {

	private final URL url;
	
	public SumUrlResource(URL resource) {
		// TODO Auto-generated constructor stub
		//获得url后就可以
		this.url = resource;
	}

	@Override
	public InputStream getInputSteam() throws Exception {
		// TODO Auto-generated method stub
		//获得值的定位的流  用URLConnection方法
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();
		//获得字节流
		return urlConnection.getInputStream();
	}

}
