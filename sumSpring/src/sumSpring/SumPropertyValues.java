package sumSpring;

import java.util.ArrayList;
import java.util.List;

/*
 * �����ԵĽṹ����ú�ͽ�����������
 * ����bean����List�����������Ϊ�˿���չ��
 * 
 * */
public class SumPropertyValues {
	
	private final List<SumPropertyValue> sumPropertyValueList = new ArrayList<SumPropertyValue>();
	
	public SumPropertyValues(){
		
	}
	
	//�������ڵ�list
	public List<SumPropertyValue> getSumPropertyValues(){
		return this.sumPropertyValueList;
	}
	
	
	
	public void addPropertyValue(SumPropertyValue v) throws Exception{

		//���ظ���property�����ж� ֻ������һ��property
		if(this.sumPropertyValueList.contains(v))
		{
			throw new Exception(v.getName()+"�Ѷ���");
			
		}
		this.sumPropertyValueList.add(v);
	}

}
