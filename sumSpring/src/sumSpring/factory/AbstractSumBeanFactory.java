package sumSpring.factory;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import sumSpring.SumBeanDefinition;

/*
 * 引入property后对abstract进行改造,提供异常抛出
 * 转为普通Map
 * 先实现IOC 再实现AOP 
 * 循环依赖最后实现
 * 
 * 已解决循环依赖
 * */

public  abstract class AbstractSumBeanFactory  implements SumBeanFactory{

	private Map<String,SumBeanDefinition> sumBeanDefinitionMap = new ConcurrentHashMap<String,SumBeanDefinition>();
	//引入property进行改造 让更多功能在父类实现
	//增加reference参考功能的类
	
	
	//把id的先初始化先,因为只有getBean的时候，他才进行反射
	private List<String> sumSeanDefinitionNames = new ArrayList<String>();
	
	@Override
	public Object getSumBean(String name) throws Exception
	{
		//添加判断 
	
		//先生成后注入
		SumBeanDefinition sumBeanDefinition = sumBeanDefinitionMap.get(name);
		
		
		if(sumBeanDefinition==null)
			throw new IllegalArgumentException("没"+name+"类");
		//
		Object obj = sumBeanDefinition.getSumBean();
		if(obj == null)
		{
			//获取bean
			obj = doCreateBean(sumBeanDefinition);
			//禁止循环引用的措施
			obj = initializeBean(obj, name);
			
		}
			
		return obj;
	}
	
	
	
	private Object initializeBean(Object obj, String name) {
		// TODO Auto-generated method stub
		return null;
	}



	//注册,即是将工厂的巨大Map填值
	//必须将BeanFactory进行扩展，以期达到真正的ioc容器功能
	public void registerSumBeanDefinition (String name,SumBeanDefinition sumBeanDefinition) throws Exception
	{
		
		//去掉注册的时候初始化功能  进行初始化 Object newsumbean = doCreateBean(sumBeanDefinition);
		//重新改变设值,把传入的值进行改变,用object作为bean的接口 此时用的是代理模式
//		sumBeanDefinition.setSumBean(newsumbean);
		sumBeanDefinitionMap.put(name, sumBeanDefinition);
		sumSeanDefinitionNames.add(name);
		
	
	}


	//先不考虑ref,直接创建类
	public void preInstanceSumSinglelons() throws Exception{
		for (Iterator<String> it = this.sumSeanDefinitionNames.iterator(); it.hasNext();) {
					String beanName = (String) it.next();
					getSumBean(beanName);
			}
	}
	/*
	 * 初始化bean 提供初始化设值的方式builder设计模式
	 * 在这里进行新的初始化
	 * 新bean的出现使容器能对特殊bean进行特殊处理
	 * */
	/*
	 * 
	 * 
	 * 注解模式进行doCreatebean
	 * 对doCreateBean进行改造
	 * 为了解决循环依赖，最好是获取的时候在进行doCreate
	 * @return object
	 * */ 
	
	protected Object doCreateBean(SumBeanDefinition sumBean) throws Exception {
		
			//改造newInstance 方法  传入property 进行构造新bean 用函数进行化简
			//Object bean = sumBean.getSumBeanClass().newInstance();
			Object bean = createSumBeanInstance(sumBean);
			//进行property注入
			sumBean.setSumBean(bean);
			applyPropertyValues(bean,sumBean);
		
			return bean;
		
	}
	
	protected Object createSumBeanInstance(SumBeanDefinition sumBean) throws Exception {
		// TODO Auto-generated method stub
		return sumBean.getSumBeanClass().newInstance();
	}



	protected abstract void applyPropertyValues(Object bean, SumBeanDefinition sumBean) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, Exception;
	
}
