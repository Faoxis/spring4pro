package org.faoxis.spring4pro.chapter4.beanLifecircle.propertyEditor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyEditorExample {
    private Name name;

    public static void main(String[] args) {
        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter4/beanLifecircle/propertyEditor/context.xml");
        context.refresh();

        PropertyEditorExample example
                = (PropertyEditorExample) context.getBean("example");

        System.out.println(example.getName());

    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
