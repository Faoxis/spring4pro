package org.faoxis.spring4pro.chapter3.collectionInjection;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext();
        context.load("org/faoxis/spring4pro/chapter3/collectionInjection/context.xml");
        context.refresh();

        System.out.println(context.getBean("injectedCollection"));

        CollectionInjection collectionInjection
                = (CollectionInjection) context.getBean("injectedCollection");

        System.out.println(collectionInjection.list.get(1));
        System.out.println(collectionInjection.map.get("somValue"));

    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "map=" + map + "\n" +
                "props" + props + "\n" +
                "set" + set + "\n" +
                "list" + list;
    }
}
