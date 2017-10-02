package org.faoxis.spring4pro.chapter3.methodLookup;

public abstract class AbstractLookupDemoBean implements DemoBean {

    @Override
    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}
