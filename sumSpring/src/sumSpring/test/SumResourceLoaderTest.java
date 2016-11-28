package sumSpring.test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.sql.ResultSet;

import org.junit.Assert;
import org.junit.Test;

import sumSpring.io.Resource;
import sumSpring.io.SumResouceLoader;

public class SumResourceLoaderTest {

	@Test
	public void test() throws Exception {
		
		SumResouceLoader sumResouceLoader = new SumResouceLoader();
		Resource resource = sumResouceLoader.getResource("sumIoc.xml");
		//测试是否进行连接了
		InputStream inputStream = resource.getInputSteam();
		//断言实现是否进行了导入
		Assert.assertNotNull(inputStream);
		
	}

}
