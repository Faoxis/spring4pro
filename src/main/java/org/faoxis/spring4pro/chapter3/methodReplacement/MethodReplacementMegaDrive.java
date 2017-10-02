package org.faoxis.spring4pro.chapter3.methodReplacement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementMegaDrive {
    public static void main(String[] args) {
        GenericXmlApplicationContext context
                = new GenericXmlApplicationContext();

        context.load("org/faoxis/spring4pro/chapter3/methodReplacement/context.xml");
        context.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget) context.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) context.getBean("standardTarget");

        displayInfo(replacementTarget);
        displayInfo(standardTarget);
    }

    public static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World!"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int i = 0; i < 1_000_000; ++i) {
            String out = target.formatMessage("foo");
        }

        stopWatch.stop();
        System.out.println("1kk invocation took " + stopWatch.getTotalTimeMillis());
    }

}
