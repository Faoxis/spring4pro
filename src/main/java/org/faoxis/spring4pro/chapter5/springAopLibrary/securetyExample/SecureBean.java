package org.faoxis.spring4pro.chapter5.springAopLibrary.securetyExample;

public class SecureBean {

    @MySecure
    public void writeSecureMessage() {
        System.out.println("This message not for anybody");
    }

    public void writeNotSecureMessage() {
        System.out.println("This is public message");
    }
}
