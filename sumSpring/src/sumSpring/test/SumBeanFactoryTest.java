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
	
	//ioc������Ԥ�ȴ���
	@Test
	public void test() throws Exception
	{
		//��ʼ������,��ʱ���ýӿڽ��в���
		/*
		 * ������������һ��Э���ԵĹ���,����Comparable
		 * �����Ҫ�����ݻ�
		 * api��Ҫָ�� ����ӿڱ��
		 * 
		 * */
		
//		SumBeanFactory sumBeanFactory = new SumBeanFactory();
		AutowireCapableBeanFactory sumBeanFactory = new AutowireCapableBeanFactory();
	
		//��xmlReader ���� �ֲ����й���������
		SumResouceLoader resouceLoader = new SumResouceLoader();
		XmlSumBeanDefinitionReader reader = new XmlSumBeanDefinitionReader(resouceLoader);
		reader.loadSumBeanDefinitions("sumIoc.xml");
//		
//		
//		
//		//�ٴθ��Ĳ������� ��ʱ ��������Ԫ��
//		//ע��bean
//		SumBeanDefinition sumBeanDefinition = new SumBeanDefinition();
//		sumBeanDefinition.setSumBeanClassName("sumSpring.test.SumHelloWorldService");
//		
//		//��������
//		SumPropertyValues spvs = new SumPropertyValues();
//		spvs.addPropertyValue(new SumPropertyValue("text","Hehe"));
//		sumBeanDefinition.setSumPropertyValues(spvs);
//		
		
		//�����������ͨע�� ������Ҫ�Լ���ע�� �ڻ�ȡbean��ʱ��Ӧ��ֱ����ע����д����ʵ��
		//��forѭ���������ע���ʼ�� 
		for (Map.Entry<String, SumBeanDefinition> beanDefinitionEntry : reader.getRegister().entrySet()) {
			sumBeanFactory.registerSumBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
					}
		
		//����bean
	//	sumBeanFactory.registerSumBeanDefinition("SumHelloWorldService", sumBeanDefinition);
	
		//���ѭ���������⣬�ȳ�ʼ���ٻ�ȡ
		/*
		 * 
		 * 
		 * A->B
		 * B->A
		 * 
		 * ��ȫ��������SumbeanMap Map�����Ⱥ�˳��
		 * ��Ҫ�õ�ʱ��ͽ��г�ʼ�� 
		 * ��ô���ѭ��������
		 * 
		 * 
		 * 
		 * 
		 * */
		sumBeanFactory.preInstanceSumSinglelons();
		
		//��ȡbean
		SumHelloWorldService sumHelloWorldService =  (SumHelloWorldService) sumBeanFactory.getSumBean("helloWorldService");
		sumHelloWorldService.helloWorld();
		
	}



}
