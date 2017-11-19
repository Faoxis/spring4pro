package org.faoxis.spring4pro.chapter4.beanLifecircle.beanInit.interfaceForSpringInit;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithInterface implements InitializingBean {

    private static final String DEFAULT_NAME = "Some Name";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void myInit() {
        System.out.println("My init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialization bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set property of any beans of type " + this.getClass());
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter4/beanLifecircle/beanInit/interfaceForSpringInit/context.xml");
        context.refresh();

        System.out.println("--------------------------------------------------");
        getBean("simpleBean1", context);
        System.out.println("--------------------------------------------------\n");
    }

    public static SimpleBeanWithInterface getBean(String beanName, ApplicationContext context) {
        try {
            SimpleBeanWithInterface bean = (SimpleBeanWithInterface) context.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error has been happened: " + ex.getMessage());
            return null;
        }
    }

}
