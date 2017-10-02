package org.faoxis.spring4pro.chapter3.autowire;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {
    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target() {

    }

    public Target(Foo foo) {
        System.out.println("Target (Foo) called");
    }

    public Target(Foo foo, Bar bar) {
        System.out.println("Target (Foo, Bar) called");
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
        System.out.println("Property foo set");
    }

    public void setFoo2(Foo foo) {
        this.foo2 = foo;
        System.out.println("Property foo2 set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter3/autowire/context.xml");
        context.refresh();

        System.out.println("------------ Calling autowire by name ------------------");
        context.getBean("targetByName");
        System.out.println("--------------------------------------------------------");
        System.out.println();

        System.out.println("------------ Calling autowire by type ------------------");
        context.getBean("targetByType");
        System.out.println("--------------------------------------------------------");
        System.out.println();

        System.out.println("------------ Calling autowire by constructor -----------");
        context.getBean("targetConstructor");
        System.out.println("--------------------------------------------------------");
        System.out.println();

    }

}
