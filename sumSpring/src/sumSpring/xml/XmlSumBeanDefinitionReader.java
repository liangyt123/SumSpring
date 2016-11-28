package sumSpring.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sumSpring.SumBeanDefinition;
import sumSpring.SumBeanReference;
import sumSpring.SumPropertyValue;
import sumSpring.io.SumResouceLoader;
import sumSpring.reader.AbstractBeanDefinitionReader;

/*
 * ��Xmlʵ�ֵ�Reader
 * һ����XMLתΪһ����ͨMAP�Ķ���
 * 
 * */
public class XmlSumBeanDefinitionReader extends AbstractBeanDefinitionReader {

	public XmlSumBeanDefinitionReader(SumResouceLoader s) {
		super(s);
	}
	
	
	@Override
	public void loadSumBeanDefinitions(String location) throws Exception {
	
		//���ļ�����inputStream��
		InputStream inputStream = getSumResourceLoader().getResource(location).getInputSteam();
		//���н���
		doLoadSumBeanDefinition(inputStream);
		
	}


	protected void doLoadSumBeanDefinition(InputStream inputStream) throws Exception {
		//��inputStream���н��� ��DocumentBuilderFactory
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		Document doc = docBuilder.parse(inputStream);
		
		//��Inpustreamת��Ϊdocument�������н���
		registerSumBeanDefinition(doc);
		
		
	}


	protected void registerSumBeanDefinition(Document doc) throws Exception {
		
		Element root = doc.getDocumentElement();
		
		parseSumBeanDefinition(root);
		
		
	}


	//����ڽ�����
	protected void parseSumBeanDefinition(Element root) throws Exception {
		
		NodeList nl = root.getChildNodes();
		
		for(int i=0;i<nl.getLength();i++)
		{
			Node node = nl.item(i);
			//ֻ�������õĽڵ���Ϣ ȥ��ע�͵ȶ���
			if(node instanceof Element)
			{
				Element ele = (Element) node;
				processSumBeanDefinition(ele);
			}
		}
	}


	protected void processSumBeanDefinition(Element ele) throws Exception {
		//��ȡÿһ��������Ϣ<bean class="hehe" name="hehe">���������Ĵ���
		//<bean id="hehe">
		String name = ele.getAttribute("id");
		String className = ele.getAttribute("class");
		//����һ��beanDefinition���洢��Ϣ
		SumBeanDefinition sumBeanDefinition = new SumBeanDefinition();
		
		//��������ֵ�ô���
		//�ڶ�����
		
		sumBeanDefinition.setSumBeanClassName(className);
		processProperty(sumBeanDefinition,ele);
		
		//ά�������Map
		getRegister().put(name, sumBeanDefinition);
		
		
	}


	protected void processProperty(SumBeanDefinition sumBeanDefinition,
			Element ele) throws Exception {
		//<property name = "hehe" value = "hehe">
		//<property name = "hehe" ref = "hehe">
		//�����������������н���
		NodeList nl = ele.getElementsByTagName("property");
		for(int i=0;i<nl.getLength();i++)
		{
			Node node = nl.item(i);
			if(node instanceof Element)
			{
				Element propertyEle = (Element)node;
				String name = propertyEle.getAttribute("name");
				String value = propertyEle.getAttribute("value");
				String ref = propertyEle.getAttribute("ref");
				
				if(value!=null&&value.length()>0)
				sumBeanDefinition.getSumPropertyValues().addPropertyValue(new SumPropertyValue(name, value));
				else{
				
					if(ref==null||ref.length()==0)
					{
						throw new IllegalArgumentException("Configuration problem: <property> element for property '"
								+ name + "' must specify a ref or value");

					}
					//����beanReference����
					SumBeanReference sumBeanReference = new SumBeanReference(ref);
					sumBeanDefinition.getSumPropertyValues().addPropertyValue(new SumPropertyValue(name, sumBeanReference) );
				}
				
					
				
			}
		}
	}

}
