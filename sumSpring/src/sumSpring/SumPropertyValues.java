package sumSpring;

import java.util.ArrayList;
import java.util.List;

/*
 * 把属性的结构定义好后就将其放入该类中
 * 不在bean放置List而制造该类是为了可扩展性
 * 
 * */
public class SumPropertyValues {
	
	private final List<SumPropertyValue> sumPropertyValueList = new ArrayList<SumPropertyValue>();
	
	public SumPropertyValues(){
		
	}
	
	//返回现在的list
	public List<SumPropertyValue> getSumPropertyValues(){
		return this.sumPropertyValueList;
	}
	
	
	
	public void addPropertyValue(SumPropertyValue v) throws Exception{

		//对重复的property进行判断 只能设置一个property
		if(this.sumPropertyValueList.contains(v))
		{
			throw new Exception(v.getName()+"已定义");
			
		}
		this.sumPropertyValueList.add(v);
	}

}
