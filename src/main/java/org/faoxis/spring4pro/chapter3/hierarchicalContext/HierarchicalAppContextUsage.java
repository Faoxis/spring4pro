package org.faoxis.spring4pro.chapter3.hierarchicalContext;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContextUsage {
    public static void main(String[] args) {
        GenericXmlApplicationContext parentContext =
                new GenericXmlApplicationContext();
        parentContext.load("org/faoxis/spring4pro/chapter3/hierarchicalContext/parent-context.xml");
        parentContext.refresh();

        System.out.println(parentContext.getBean("firstInjectedBean"));

        GenericXmlApplicationContext childContext =
                new GenericXmlApplicationContext();
        childContext.setParent(parentContext);
        childContext.load("org/faoxis/spring4pro/chapter3/hierarchicalContext/child-context.xml");
        childContext.refresh();

        System.out.println(((SimpleTarget) childContext.getBean("target1")).getVal());
        System.out.println(((SimpleTarget) childContext.getBean("target2")).getVal());
    }
}
