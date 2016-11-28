package sumSpring.factory;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import sumSpring.SumBeanDefinition;

/*
 * ����property���abstract���и���,�ṩ�쳣�׳�
 * תΪ��ͨMap
 * ��ʵ��IOC ��ʵ��AOP 
 * ѭ���������ʵ��
 * 
 * */

public  abstract class AbstractSumBeanFactory  implements SumBeanFactory{

	private Map<String,SumBeanDefinition> sumBeanDefinitionMap = new ConcurrentHashMap<String,SumBeanDefinition>();
	//����property���и��� �ø��๦���ڸ���ʵ��
	//����reference�ο����ܵ���
	
	
	//��id���ȳ�ʼ����,��Ϊֻ��getBean��ʱ�����Ž��з���
	private List<String> sumSeanDefinitionNames = new ArrayList<String>();
	
	@Override
	public Object getSumBean(String name) throws Exception
	{
		//����ж� 
	
		//�����ɺ�ע��
		SumBeanDefinition sumBeanDefinition = sumBeanDefinitionMap.get(name);
		
		
		if(sumBeanDefinition==null)
			throw new IllegalArgumentException("û"+name+"��");
		//
		Object obj = sumBeanDefinition.getSumBean();
		if(obj == null)
		{
			//��ȡbean
			obj = doCreateBean(sumBeanDefinition);
			//��ֹѭ�����õĴ�ʩ
			obj = initializeBean(obj, name);
			
		}
			
		return obj;
	}
	
	
	
	private Object initializeBean(Object obj, String name) {
		// TODO Auto-generated method stub
		return null;
	}



	//ע��,���ǽ������ľ޴�Map��ֵ
	//���뽫BeanFactory������չ�����ڴﵽ������ioc��������
	public void registerSumBeanDefinition (String name,SumBeanDefinition sumBeanDefinition) throws Exception
	{
		Object newsumbean = doCreateBean(sumBeanDefinition);
		//���¸ı���ֵ,�Ѵ����ֵ���иı�,��object��Ϊbean�Ľӿ� ��ʱ�õ��Ǵ���ģʽ
		sumBeanDefinition.setSumBean(newsumbean);
		sumBeanDefinitionMap.put(name, sumBeanDefinition);
	}


	//�Ȳ�����ref,ֱ�Ӵ�����
	public void preInstanceSumSinglelons() throws Exception{
		for (Iterator<String> it = this.sumSeanDefinitionNames.iterator(); it.hasNext();) {
					String beanName = (String) it.next();
					getSumBean(beanName);
			}
	}
	/*
	 * ��ʼ��bean �ṩ��ʼ����ֵ�ķ�ʽbuilder���ģʽ
	 * ����������µĳ�ʼ��
	 * ��bean�ĳ���ʹ�����ܶ�����bean�������⴦��
	 * */
	/*
	 * 
	 * 
	 * ע��ģʽ����doCreatebean
	 * ��doCreateBean���и���
	 * Ϊ�˽��ѭ������������ǻ�ȡ��ʱ���ڽ���doCreate
	 * @return object
	 * */ 
	
	protected Object doCreateBean(SumBeanDefinition sumBean) throws Exception {
		
			//����newInstance ����  ����property ���й�����bean �ú������л���
			//Object bean = sumBean.getSumBeanClass().newInstance();
			Object bean = createSumBeanInstance(sumBean);
			//����propertyע��
			applyPropertyValues(bean,sumBean);
		
			return bean;
		
	}
	
	protected Object createSumBeanInstance(SumBeanDefinition sumBean) throws Exception {
		// TODO Auto-generated method stub
		return sumBean.getSumBeanClass().newInstance();
	}



	protected abstract void applyPropertyValues(Object bean, SumBeanDefinition sumBean) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, Exception;
	
}
