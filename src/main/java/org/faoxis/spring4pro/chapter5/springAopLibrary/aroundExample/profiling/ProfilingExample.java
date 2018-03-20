package org.faoxis.spring4pro.chapter5.springAopLibrary.aroundExample.profiling;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingExample {

    public static void main(String[] args) {
        WorkerBean workerBean = getWorkerBean();
        workerBean.soSomeWork(100_000_000);
    }

    private static WorkerBean getWorkerBean() {
        WorkerBean target = new WorkerBean();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new ProfilingInterceptor());

        return (WorkerBean) factory.getProxy();
    }

}
