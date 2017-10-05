package org.faoxis.spring4pro.chapter4.beanInit.annotationForSpringInit;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

public class SimpleBeanWithJSR250 {
    private static final String DEFAULT_NAME = "Some Name";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    private void afterSpringInit() throws Exception {
        System.out.println("Initialization bean");

        if (name == null) {
            System.out.println("setup default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Wrong age number!");
        }
    }

    @Override
    public String toString() {
        return "Age: " + age + "\nName: " + name;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter4/beanInit/annotationForSpringInit/context.xml");
        context.refresh();

        System.out.println("----------------------------------------");
        getBean("simpleBean1", context);
        System.out.println("----------------------------------------\n");

    }

    private static SimpleBeanWithJSR250 getBean(String beanName, ApplicationContext context) {
        try {
            SimpleBeanWithJSR250 bean = (SimpleBeanWithJSR250) context.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
