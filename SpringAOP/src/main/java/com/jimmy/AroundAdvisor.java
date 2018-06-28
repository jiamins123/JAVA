package com.jimmy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvisor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// TODO Auto-generated method stub
		Object obj;
		System.out.println("additional concern before actual logic");
		obj=mi.proceed();
		System.out.println("additional concern after actual logic");
		return obj;
	}

}
