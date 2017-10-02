package org.faoxis.spring4pro.chapter3.inheritBean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age;
    }


    public static void main(String[] args) {
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter3/inheritBean/context.xml");
        context.refresh();

//        SimpleBean inheritParent = (SimpleBean) context.getBean("inheritParent");
//        System.out.println(inheritParent);

        SimpleBean inheritChild = (SimpleBean) context.getBean("inheritChild");
        System.out.println(inheritChild);
    }
}
