package org.faoxis.spring4pro.chapter3.constructorConfusion;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ConstructorConfusion {

    private String someValue;

    public ConstructorConfusion(String someValue) {
        System.out.println("String constructor has been called with value " + someValue);
        this.someValue = someValue;
    }

    public ConstructorConfusion(int someValue) {
        System.out.println("int constructor has been called with value" + someValue);
        this.someValue = String.valueOf(someValue);
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter3/constructorConfusion/context.xml");
        context.refresh();
    }

}

