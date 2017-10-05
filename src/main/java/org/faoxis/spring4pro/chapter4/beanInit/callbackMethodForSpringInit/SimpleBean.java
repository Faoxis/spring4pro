package org.faoxis.spring4pro.chapter4.beanInit.callbackMethodForSpringInit;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
    private static final String DEFAULT_NAME = "Some Name";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SimpleBean() {
        System.out.println("Constructor method has been called for class:\n" + this);
    }

    private void afterSpringInit() {
        System.out.println("Bean initialization");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set property of any beans of type " + SimpleBean.class);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter4/beanInit/callbackMethodForSpringInit/context.xml");
        context.refresh();

        System.out.println("---------------------------------------");
        getBean("simpleBean", context);
        System.out.println("---------------------------------------\n");

        System.out.println("---------------------------------------");
        getBean("simpleBean2", context);
        System.out.println("---------------------------------------\n");

        System.out.println("---------------------------------------");
        getBean("simpleBean3", context);
        System.out.println("---------------------------------------\n");
    }

    public static SimpleBean getBean(String beanName, ApplicationContext context) {
        try {
            SimpleBean bean = (SimpleBean) context.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error has been happened: " + ex.getMessage());
            return null;
        }
    }
}
