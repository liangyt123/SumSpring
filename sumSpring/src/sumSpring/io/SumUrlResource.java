package sumSpring.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class SumUrlResource implements Resource {

	private final URL url;
	
	public SumUrlResource(URL resource) {
		// TODO Auto-generated constructor stub
		//���url��Ϳ���
		this.url = resource;
	}

	@Override
	public InputStream getInputSteam() throws Exception {
		// TODO Auto-generated method stub
		//���ֵ�Ķ�λ����  ��URLConnection����
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();
		//����ֽ���
		return urlConnection.getInputStream();
	}

}
