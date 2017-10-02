package org.faoxis.spring4pro.chapter2.myProp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private Properties properties;
    private MessageProvider messageProvider;
    private MessageRenderer messageRenderer;

    static {
        instance = new MessageSupportFactory();
    }

    private MessageSupportFactory() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/java/org/faoxis/spring4pro/chapter2/myProp/msf.properties"));
            String rendererClassName = properties.getProperty("renderer.class");
            String providerClassName = properties.getProperty("provider.class");

            messageProvider = (MessageProvider) Class.forName(providerClassName).newInstance();
            messageRenderer = (MessageRenderer) Class.forName(rendererClassName).newInstance();

        } catch (IOException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    public MessageRenderer getMessageRenderer() {
        return messageRenderer;
    }
}
