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

	//构造map
	//Configure 设置Configuration
	//这个类充当Factory产生对象
	//传入配置文件自动注册 就不用自己生产beanFactory了
	AbstractSumBeanFactory beaFactory;
	
	String configuration;
	
	//构造器1
	public SumClassPathXmlApplicationContext(String configuration) {
		this(configuration,new AutowireCapableBeanFactory());
		// TODO Auto-generated constructor stub
	}
	
	//构造器2
	public SumClassPathXmlApplicationContext(String con,AbstractSumBeanFactory beanFactory) {
		// TODO Auto-generated constructor stub
		this.configuration = con;
		this.beaFactory = new AutowireCapableBeanFactory();
		//进行处理
		try{
			refresh();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	protected void refresh() throws Exception {
		//在这里进行各种初始化
		XmlSumBeanDefinitionReader sBeanDefinitionReader = new XmlSumBeanDefinitionReader(new SumResouceLoader());
		sBeanDefinitionReader.loadSumBeanDefinitions(configuration);
		beaFactory.preInstanceSumSinglelons();
		//进行注册
		for(Map.Entry<String, SumBeanDefinition> beanDefinition:sBeanDefinitionReader.getRegister().entrySet()){
			beaFactory.registerSumBeanDefinition(beanDefinition.getKey(), beanDefinition.getValue());
		}
		
		
	}

	@Override
	public Object getSumBean(String name) throws Exception {
		// TODO Auto-generated method stub
		if(beaFactory.getSumBean(name)==null)
		{
			throw new Exception(name + "类不存在");
		}
		
		return beaFactory.getSumBean(name);
	}

	

}
