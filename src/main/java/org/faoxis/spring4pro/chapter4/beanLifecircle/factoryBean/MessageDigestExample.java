package org.faoxis.spring4pro.chapter4.beanLifecircle.factoryBean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExample {
    public static void main(String[] args) {

        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter4/beanLifecircle/factoryBean/context.xml");
        context.refresh();

        MessageDigester messageDigester
                = (MessageDigester) context.getBean("messageDigester");
        messageDigester.digest("Some message");

    }
}
