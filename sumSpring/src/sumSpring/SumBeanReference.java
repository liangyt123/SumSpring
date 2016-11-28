package sumSpring;

//遇到的ref时候就调用该类，bean的依赖bean
public class SumBeanReference {

	String ref =null;
	
	Object bean;
	
	
	//这个只是id名字 要查看是否在beanFactory里面
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
