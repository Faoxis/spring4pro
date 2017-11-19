package org.faoxis.spring4pro.chapter2.springProp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        BeanFactory context = new ClassPathXmlApplicationContext(
                "org/faoxis/spring4pro/chapter2/springProp/app-context.xml"
        );

        MessageRenderer messageRenderer = context.getBean("renderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
