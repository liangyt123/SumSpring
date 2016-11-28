package sumSpring;

//属性注入类  属性类
public class SumPropertyValue {
	
	private  String name = null;
	
	private  Object value = null;
	
	public SumPropertyValue(String name, Object value)
	{
		this.name = name; 
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
	
	
	

}
