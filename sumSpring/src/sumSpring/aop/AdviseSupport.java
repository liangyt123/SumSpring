package sumSpring.aop;
import org.aopalliance.intercept.MethodInterceptor;

import sumSpring.aop.bean.TargetSource;
//������ ��Դ ����
public class AdviseSupport {
	
	private TargetSource targetSource;
	private MethodInterceptor methodInterceptor;
	public TargetSource getTargetSource() {
		return targetSource;
	}
	public void setTargetSource(TargetSource targetSource) {
		this.targetSource = targetSource;
	}
	public MethodInterceptor getMethodInterceptor() {
		return methodInterceptor;
	}
	public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
		this.methodInterceptor = methodInterceptor;
	}

	
	
}
