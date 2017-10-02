package org.faoxis.spring4pro.chapter3.methodLookup;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    public static void main(String[] args) throws InterruptedException {
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext();
        context.load("org/faoxis/spring4pro/chapter3/methodLookup/context.xml");
        context.refresh();

        DemoBean abstractLookupBean = (DemoBean) context.getBean("abstractLookupBean");
        DemoBean standardLookupBean = (DemoBean) context.getBean("standardLookupBean");

        displayInfo(abstractLookupBean); // Каждый раз новый инстанс MyHelper
        displayInfo(standardLookupBean); // Значение прислаивается полю единожды

//        System.out.println(abstractLookupBean.getMyHelper() == abstractLookupBean.getMyHelper());

//        System.out.println(abstractLookupBean.getMyHelper() == standardLookupBean.getMyHelper());
//        System.out.println(abstractLookupBean.getMyHelper() == standardLookupBean.getMyHelper());

    }

    public static void displayInfo(DemoBean demoBean) {
        MyHelper helper1 = demoBean.getMyHelper();
        MyHelper helper2 = demoBean.getMyHelper();

        System.out.println("Helper instance the same ? " + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookup demo");

        for (int i = 0; i < 1_000_000; ++i) {
            MyHelper helper = demoBean.getMyHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();
        System.out.println("1kk iterations get took: " + stopWatch.getTotalTimeMillis());
    }

}
