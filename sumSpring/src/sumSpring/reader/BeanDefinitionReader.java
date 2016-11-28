package sumSpring.reader;

//读取接口定义
public interface BeanDefinitionReader {

	void loadSumBeanDefinitions(String location) throws Exception;
}
