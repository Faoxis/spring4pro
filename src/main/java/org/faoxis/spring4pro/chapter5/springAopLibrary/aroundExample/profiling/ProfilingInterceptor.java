package org.faoxis.spring4pro.chapter5.springAopLibrary.aroundExample.profiling;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        StopWatch sw = new StopWatch();
        sw.start(invocation.getMethod().getName());

        Object returnValue = invocation.proceed();

        sw.stop();
        dumpInfo(invocation, sw.getTotalTimeMillis());

        return returnValue;
    }

    private void dumpInfo(MethodInvocation invocation, long ms) {

        Method method = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

        System.out.println("Executed method: " + method.getName());

        System.out.println("With arguments:");
        for (int x = 0; x < args.length; x++) {
            System.out.println("    > " + args[x]);
        }

        System.out.println("\n");
        System.out.println("Took: " + ms + " ms");
    }
}
