package org.faoxis.spring4pro.chapter3.defaultListaЬleBeanFactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigurationBeanFactory {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory =
                new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader =
                new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(new ClassPathResource(
                "org/faoxis/spring4pro/chapter3//defaultListaЬleBeanFactory/xml-bean-factory-config.xml"
        ));

        Oracle oracle = (Oracle) factory.getBean("oracle");
        System.out.println(oracle.defineMeaningOfLife());

        reader.loadBeanDefinitions(new ClassPathResource(
                "org/faoxis/spring4pro/chapter3//defaultListaЬleBeanFactory/another-xml-bean-factory-config.xml"
        ));

        Orator orator = (Orator) factory.getBean("orator");
        System.out.println(orator.getSpearking());
    }
}

