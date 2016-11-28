package sumSpring.test;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import sumSpring.SumBeanDefinition;
import sumSpring.SumPropertyValue;
import sumSpring.SumPropertyValues;
import sumSpring.factory.AutowireCapableBeanFactory;
import sumSpring.factory.SumBeanFactory;
import sumSpring.io.SumResouceLoader;
import sumSpring.xml.XmlSumBeanDefinitionReader;

public class SumBeanFactoryTest {
	
	//ioc容器的预先处理
	@Test
	public void test() throws Exception
	{
		//初始化容器,此时利用接口进行操作
		/*
		 * 软件开发大多是一个协作性的工作,例如Comparable
		 * 软件需要不断演化
		 * api需要指定 面向接口编程
		 * 
		 * */
		
//		SumBeanFactory sumBeanFactory = new SumBeanFactory();
		AutowireCapableBeanFactory sumBeanFactory = new AutowireCapableBeanFactory();
	
		//用xmlReader 测试 分步进行构造载入器
		SumResouceLoader resouceLoader = new SumResouceLoader();
		XmlSumBeanDefinitionReader reader = new XmlSumBeanDefinitionReader(resouceLoader);
		reader.loadSumBeanDefinitions("sumIoc.xml");
//		
//		
//		
//		//再次更改测试用例 这时 加入属性元素
//		//注入bean
//		SumBeanDefinition sumBeanDefinition = new SumBeanDefinition();
//		sumBeanDefinition.setSumBeanClassName("sumSpring.test.SumHelloWorldService");
//		
//		//设置属性
//		SumPropertyValues spvs = new SumPropertyValues();
//		spvs.addPropertyValue(new SumPropertyValue("text","Hehe"));
//		sumBeanDefinition.setSumPropertyValues(spvs);
//		
		
		//这里完成了普通注册 现在需要自己的注册 在获取bean的时候应该直接用注解进行处理的实现
		//用for循环对其进行注册初始化 
		for (Map.Entry<String, SumBeanDefinition> beanDefinitionEntry : reader.getRegister().entrySet()) {
			sumBeanFactory.registerSumBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
					}
		
		//生成bean
	//	sumBeanFactory.registerSumBeanDefinition("SumHelloWorldService", sumBeanDefinition);
	
		//解决循环依赖问题，先初始化再获取
		/*
		 * 
		 * 
		 * A->B
		 * B->A
		 * 
		 * 先全部放置在SumbeanMap Map不分先后顺序
		 * 需要用的时候就进行初始化 
		 * 怎么解决循环依赖？
		 * 
		 * 
		 * 
		 * 
		 * */
		sumBeanFactory.preInstanceSumSinglelons();
		
		//获取bean
		SumHelloWorldService sumHelloWorldService =  (SumHelloWorldService) sumBeanFactory.getSumBean("helloWorldService");
		sumHelloWorldService.helloWorld();
		
	}



}
