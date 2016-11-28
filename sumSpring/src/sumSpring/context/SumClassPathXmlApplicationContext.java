package sumSpring.context;

import java.util.HashMap;
import java.util.Map;

import sumSpring.SumBeanDefinition;
import sumSpring.factory.AbstractSumBeanFactory;
import sumSpring.factory.AutowireCapableBeanFactory;
import sumSpring.io.SumResouceLoader;
import sumSpring.reader.BeanDefinitionReader;
import sumSpring.xml.XmlSumBeanDefinitionReader;

public class SumClassPathXmlApplicationContext  implements ApplicationContext {

	//����map
	//Configure ����Configuration
	//�����䵱Factory��������
	//���������ļ��Զ�ע�� �Ͳ����Լ�����beanFactory��
	AbstractSumBeanFactory beaFactory;
	
	String configuration;
	
	//������1
	public SumClassPathXmlApplicationContext(String configuration) {
		this(configuration,new AutowireCapableBeanFactory());
		// TODO Auto-generated constructor stub
	}
	
	//������2
	public SumClassPathXmlApplicationContext(String con,AbstractSumBeanFactory beanFactory) {
		// TODO Auto-generated constructor stub
		this.configuration = con;
		this.beaFactory = new AutowireCapableBeanFactory();
		//���д���
		try{
			refresh();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	protected void refresh() throws Exception {
		//��������и��ֳ�ʼ��
		XmlSumBeanDefinitionReader sBeanDefinitionReader = new XmlSumBeanDefinitionReader(new SumResouceLoader());
		sBeanDefinitionReader.loadSumBeanDefinitions(configuration);
		//����ע��
		for(Map.Entry<String, SumBeanDefinition> beanDefinition:sBeanDefinitionReader.getRegister().entrySet()){
			beaFactory.registerSumBeanDefinition(beanDefinition.getKey(), beanDefinition.getValue());
		}
		
		
	}

	@Override
	public Object getSumBean(String name) throws Exception {
		// TODO Auto-generated method stub
		if(beaFactory.getSumBean(name)==null)
		{
			throw new Exception(name + "�಻����");
		}
		
		return beaFactory.getSumBean(name);
	}

	

}
