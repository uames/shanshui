package uames.util;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class DemoInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		// TODO 自动生成的方法存根
		System.out.println(ai.getController().getClass());

		System.out.println("actionkey: " + ai.getActionKey());
		
		ai.invoke();
	}

}
