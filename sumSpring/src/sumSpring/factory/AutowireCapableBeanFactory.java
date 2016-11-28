package sumSpring.factory;

import java.lang.reflect.Field;

import sumSpring.SumBeanDefinition;
import sumSpring.SumBeanReference;
import sumSpring.SumPropertyValue;

/*
 * 最终工厂的方法
 * 所有的东西实例化都在这里实现
 * 
 * */

public class AutowireCapableBeanFactory extends AbstractSumBeanFactory {



	//还能修改application的 这边是普通的注解注入
	//设置自动装配内容的BeanFactory
	protected void applyPropertyValues(Object bean, SumBeanDefinition sumBean) throws Exception {
		//用Field进行处理
		//每个bean都有一个propertyList
		for(SumPropertyValue pv:sumBean.getSumPropertyValues().getSumPropertyValues())
		{
			//获得属性值 bean就是实例化的instance
			//之后再将property的name取出来
			//通过反射进行赋值
			//这里才有instance
		    //进行变量的赋值
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
