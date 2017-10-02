package org.faoxis.spring4pro.chapter3.injectSimple.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimple {
    private String name;
    private int age;
    private double height;
    private boolean programmer;
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter3/injectSimple/xml/context.xml");
        context.refresh();

        System.out.println(context.getBean("injectSimple"));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        return "InjectSimple={" +
                "name=" + name + "," +
                "age=" + age + "," +
                "height=" + height + "," +
                "programmer=" + programmer + "," +
                "ageInSeconds=" + ageInSeconds +
                "}";
    }
}

