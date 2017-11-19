package org.faoxis.spring4pro.chapter4.beanLifecircle.beanNameSetter;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SetBeanNameExample implements BeanNameAware, InitializingBean {

    private String beanName;

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean name is " + beanName);
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter4/beanLifecircle/beanNameSetter/context.xml");
        context.refresh();

    }


}
