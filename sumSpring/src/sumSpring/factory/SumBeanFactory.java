package sumSpring.factory;

//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;

/*
 * sumbean工厂
 * 后面将class转为Interface
 * */
public interface SumBeanFactory {
	
	Object getSumBean(String name) throws Exception;
	//void registerSumBeanDefinition(String name, SumBeanDefinition sumBean) throws Exception;

}
