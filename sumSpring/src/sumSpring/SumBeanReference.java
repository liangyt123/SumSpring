package sumSpring;

//������refʱ��͵��ø��࣬bean������bean
public class SumBeanReference {

	String ref =null;
	
	Object bean;
	
	
	//���ֻ��id���� Ҫ�鿴�Ƿ���beanFactory����
	public SumBeanReference(String ref) {
		this.ref = ref;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}
	
	
	
	
}
