package sumSpring.factory;

import java.lang.reflect.Field;

import sumSpring.SumBeanDefinition;
import sumSpring.SumBeanReference;
import sumSpring.SumPropertyValue;

/*
 * ���չ����ķ���
 * ���еĶ���ʵ������������ʵ��
 * 
 * */

public class AutowireCapableBeanFactory extends AbstractSumBeanFactory {



	//�����޸�application�� �������ͨ��ע��ע��
	//�����Զ�װ�����ݵ�BeanFactory
	protected void applyPropertyValues(Object bean, SumBeanDefinition sumBean) throws Exception {
		//��Field���д���
		//ÿ��bean����һ��propertyList
		for(SumPropertyValue pv:sumBean.getSumPropertyValues().getSumPropertyValues())
		{
			//�������ֵ bean����ʵ������instance
			//֮���ٽ�property��nameȡ����
			//ͨ��������и�ֵ
			//�������instance
		    //���б����ĸ�ֵ
			Field declaredField = bean.getClass().getDeclaredField(pv.getName());
			declaredField.setAccessible(true);
			Object value = pv.getValue();
			if(value instanceof SumBeanReference)
			{
				SumBeanReference beanReference = (SumBeanReference) value;
				value = getSumBean(beanReference.getRef());
			}
			
			declaredField.set(bean, value);
		}
		
	}


}
