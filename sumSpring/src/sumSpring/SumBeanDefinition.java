package sumSpring;

/*
 * ioc容器的bean类
 * 
 * */
public class SumBeanDefinition {

	
	//sumDefinition保存有Class信息
	//className信息
	//bean信息
	private String sumBeanClassName;
	private Class sumBeanClass;
	private Object sumBean;
	//增加属性值
	private SumPropertyValues sumPropertyValues = new SumPropertyValues();

	public SumBeanDefinition(){
		//建造者模式不需要带参数的构造函数
	}
	

	public String getSumBeanClassName() {
		return sumBeanClassName;
	}



	public void setSumBeanClassName(String sumBeanClassName) {
		this.sumBeanClassName = sumBeanClassName;
		try {
			//同时设定beanClass
			this.sumBeanClass = Class.forName(sumBeanClassName);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}



	public Class getSumBeanClass() {
		return sumBeanClass;
	}



	public void setSumBeanClass(Class sumBeanClass) {
		this.sumBeanClass = sumBeanClass;
	}

	
	/*
	 * 依赖的依赖属性
	 * */
	public Object getSumBean(){
		
		return sumBean;
	}
	
	public void setSumBean(Object bean)
	{
		this.sumBean = bean;
	}


	public SumPropertyValues getSumPropertyValues() {
		return sumPropertyValues;
	}


	public void setSumPropertyValues(SumPropertyValues sumPropertyValues) {
		this.sumPropertyValues = sumPropertyValues;
	}
	
}
