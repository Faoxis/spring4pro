package org.faoxis.spring4pro.chapter4.beanLifecircle.destroyBean.shutdownHook;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PreDestroy;

public class ShutdownHookDestroyExample implements DisposableBean {

    public void destroyMethodXML() {
        hasCalled("destroyMethodXML");
    }

    @PreDestroy
    public void destroyMethodAnnotation() {
        hasCalled("destroyMethodAnnotation");
    }


    @Override
    public void destroy() throws Exception {
        hasCalled("destroyMethodInterface");
    }


    private void hasCalled(String who) {
        System.out.println(who + " has been called!");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext();
        context.load("org/faoxis/spring4pro/chapter4/beanLifecircle/destroyBean/shutdownHook/context.xml");
        context.registerShutdownHook();
        context.refresh();

        context.getBean("simpleBean");

    }
}
