package sumSpring.aop.bean;

public class TargetSource {
	
	private Class targetClass;
	
	private Object target;
	
	public TargetSource(Object t,Class tc){
		this.target=t;
		this.targetClass=tc;
		
	}

	public Class getTargetClass() {
		return targetClass;
	}

	public Object getTarget() {
		return target;
	}
	
	
	

}
