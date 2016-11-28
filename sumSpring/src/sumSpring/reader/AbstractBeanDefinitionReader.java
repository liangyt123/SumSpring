package sumSpring.reader;

import java.util.HashMap;
import java.util.Map;

import sumSpring.SumBeanDefinition;
import sumSpring.io.SumResouceLoader;

//�������ж�ȡBeanDefinition
//ͬ��ʹ��ע��ķ���
//������ע����Ϣ�洢��һ����
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
 