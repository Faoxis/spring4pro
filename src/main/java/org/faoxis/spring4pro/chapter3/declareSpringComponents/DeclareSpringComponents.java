package org.faoxis.spring4pro.chapter3.declareSpringComponents;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter3/declareSpringComponents/app-context.xml");
        context.refresh();

        MessageProvider messageProvider = context.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageProvider.getMessage());

        MessageRenderer messageRenderer = context.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();


        System.out.println(((MessageProvider) context.getBean("confMessageProvider")).getMessage());

    }
}
