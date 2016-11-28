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
 * 用Xml实现的Reader
 * 一个将XML转为一个普通MAP的东西
 * 
 * */
public class XmlSumBeanDefinitionReader extends AbstractBeanDefinitionReader {

	public XmlSumBeanDefinitionReader(SumResouceLoader s) {
		super(s);
	}
	
	
	@Override
	public void loadSumBeanDefinitions(String location) throws Exception {
	
		//把文件载入inputStream中
		InputStream inputStream = getSumResourceLoader().getResource(location).getInputSteam();
		//进行解析
		doLoadSumBeanDefinition(inputStream);
		
	}


	protected void doLoadSumBeanDefinition(InputStream inputStream) throws Exception {
		//对inputStream进行解析 用DocumentBuilderFactory
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		Document doc = docBuilder.parse(inputStream);
		
		//将Inpustream转化为document对象后进行解析
		registerSumBeanDefinition(doc);
		
		
	}


	protected void registerSumBeanDefinition(Document doc) throws Exception {
		
		Element root = doc.getDocumentElement();
		
		parseSumBeanDefinition(root);
		
		
	}


	//从入口解析树
	protected void parseSumBeanDefinition(Element root) throws Exception {
		
		NodeList nl = root.getChildNodes();
		
		for(int i=0;i<nl.getLength();i++)
		{
			Node node = nl.item(i);
			//只保存有用的节点信息 去掉注释等东西
			if(node instanceof Element)
			{
				Element ele = (Element) node;
				processSumBeanDefinition(ele);
			}
		}
	}


	protected void processSumBeanDefinition(Element ele) throws Exception {
		//获取每一个结点的信息<bean class="hehe" name="hehe">进行类名的处理
		//<bean id="hehe">
		String name = ele.getAttribute("id");
		String className = ele.getAttribute("class");
		//产生一个beanDefinition来存储信息
		SumBeanDefinition sumBeanDefinition = new SumBeanDefinition();
		
		//进行属性值得处理
		//第二层结点
		
		sumBeanDefinition.setSumBeanClassName(className);
		processProperty(sumBeanDefinition,ele);
		
		//维护父类的Map
		getRegister().put(name, sumBeanDefinition);
		
		
	}


	protected void processProperty(SumBeanDefinition sumBeanDefinition,
			Element ele) throws Exception {
		//<property name = "hehe" value = "hehe">
		//<property name = "hehe" ref = "hehe">
		//加入依赖的依赖进行解析
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
					//构造beanReference对象
					SumBeanReference sumBeanReference = new SumBeanReference(ref);
					sumBeanDefinition.getSumPropertyValues().addPropertyValue(new SumPropertyValue(name, sumBeanReference) );
				}
				
					
				
			}
		}
	}

}
