package sumSpring;

/*
 * ioc������bean��
 * 
 * */
public class SumBeanDefinition {

	
	//sumDefinition������Class��Ϣ
	//className��Ϣ
	//bean��Ϣ
	private String sumBeanClassName;
	private Class sumBeanClass;
	private Object sumBean;
	//��������ֵ
	private SumPropertyValues sumPropertyValues = new SumPropertyValues();

	public SumBeanDefinition(){
		//������ģʽ����Ҫ�������Ĺ��캯��
	}
	

	public String getSumBeanClassName() {
		return sumBeanClassName;
	}



	public void setSumBeanClassName(String sumBeanClassName) {
		this.sumBeanClassName = sumBeanClassName;
		try {
			//ͬʱ�趨beanClass
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
	 * ��������������
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
