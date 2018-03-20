package org.faoxis.spring4pro.chapter5.springAopLibrary.helloWorld;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("Hello, ");
        Object returnedValue = invocation.proceed();
        System.out.println("!");
        return returnedValue;
    }

}
