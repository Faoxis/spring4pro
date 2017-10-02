package org.faoxis.spring4pro.chapter2.springProp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "org/faoxis/spring4pro/chapter2/springProp/app-context.xml"
        );

        MessageRenderer messageRenderer = context.getBean("renderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
