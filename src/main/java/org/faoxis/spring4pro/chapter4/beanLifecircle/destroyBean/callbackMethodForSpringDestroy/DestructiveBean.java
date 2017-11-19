package org.faoxis.spring4pro.chapter4.beanLifecircle.destroyBean.callbackMethodForSpringDestroy;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBean implements InitializingBean {
    private File file;
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialization bean");

        if (filePath == null) {
            throw new IllegalArgumentException("You must specify filepath property of " + this.getClass());
        }

        file = new File(filePath);
        file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    public void destroy() {
        System.out.println("Destroy bean");

        if (!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
        }

        System.out.println("File exits: " + file.exists());
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter4/beanLifecircle/destroyBean/callbackMethodForSpringDestroy/context.xml");
        context.refresh();

        System.out.println("---------------------------------");
        getBean("simpleBean", context);
        System.out.println("---------------------------------\n");
        context.getDefaultListableBeanFactory().destroySingletons();


    }

    private static DestructiveBean getBean(String beanName, ApplicationContext context) {
        try {
            DestructiveBean bean = (DestructiveBean) context.getBean(beanName);
            System.out.println(bean + " has been created!");
            return bean;
        } catch (BeanCreationException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
