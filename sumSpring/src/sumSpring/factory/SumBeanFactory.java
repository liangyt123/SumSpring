package sumSpring.factory;

//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;

/*
 * sumbean����
 * ���潫classתΪInterface
 * */
public interface SumBeanFactory {
	
	Object getSumBean(String name) throws Exception;
	//void registerSumBeanDefinition(String name, SumBeanDefinition sumBean) throws Exception;

}
