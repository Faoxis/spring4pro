package org.faoxis.spring4pro.chapter4.applicationContext.internalization;

import org.springframework.context.support.GenericXmlApplicationContext;
import java.util.Locale;

public class MessageSourceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter4/applicationContext/internalization/context.xml");
        context.refresh();

        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("cs", "CZ");

        System.out.println(context.getMessage("msg", null, english));
        System.out.println(context.getMessage("msg", null, czech));

        System.out.println(context.getMessage("nameMsg", new Object[] {"Sergei", "Samoilov"}, english));
    }
}
