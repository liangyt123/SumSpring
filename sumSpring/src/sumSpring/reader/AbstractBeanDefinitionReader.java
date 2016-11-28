package sumSpring.reader;

import java.util.HashMap;
import java.util.Map;

import sumSpring.SumBeanDefinition;
import sumSpring.io.SumResouceLoader;

//从配置中读取BeanDefinition
//同样使用注册的方法
//该类是注册信息存储类一个类
//Map,resourceLoader
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

	private Map<String, SumBeanDefinition> register;
	
	private SumResouceLoader sumResourceLoader;
	
	protected AbstractBeanDefinitionReader(SumResouceLoader s){
		
		this.register = new HashMap<String, SumBeanDefinition>();
		this.sumResourceLoader = s;
		
	}
	
	
	public Map<String, SumBeanDefinition> getRegister() {
		return register;
	}


	public SumResouceLoader getSumResourceLoader() {
		return sumResourceLoader;
	}


	@Override
	public void loadSumBeanDefinitions(String location) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
 