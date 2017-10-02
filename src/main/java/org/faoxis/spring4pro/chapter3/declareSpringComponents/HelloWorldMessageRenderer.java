package org.faoxis.spring4pro.chapter3.declareSpringComponents;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("messageRenderer")
public class HelloWorldMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null) throw new RuntimeException("There is no message provider!");
        System.out.println(messageProvider.getMessage());
    }

    @Override
    @Resource(name = "messageProvider")
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
