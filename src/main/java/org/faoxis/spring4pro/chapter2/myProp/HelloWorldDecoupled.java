package org.faoxis.spring4pro.chapter2.myProp;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageProvider messageProvider = MessageSupportFactory.getInstance().getMessageProvider();
        MessageRenderer messageRenderer = MessageSupportFactory.getInstance().getMessageRenderer();

        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}
