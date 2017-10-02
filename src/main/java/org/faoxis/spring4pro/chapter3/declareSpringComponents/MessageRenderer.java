package org.faoxis.spring4pro.chapter3.declareSpringComponents;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
