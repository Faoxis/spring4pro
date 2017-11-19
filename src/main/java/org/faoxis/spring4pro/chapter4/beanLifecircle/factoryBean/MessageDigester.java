package org.faoxis.spring4pro.chapter4.beanLifecircle.factoryBean;

import java.security.MessageDigest;

public class MessageDigester {

    private MessageDigest digest1;
    private MessageDigest digest2;

    public void setMessageDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }

    public void setMessageDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }

    public void digest(String msg) {
        System.out.println("Using digest1");
        digest(msg, digest1);
        System.out.println("Using digest2");
        digest(msg, digest2);
    }

    private void digest(String msg, MessageDigest digest) {
        System.out.println("Digest algorithm: " + digest.getAlgorithm());
        digest.reset();

        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);

        System.out.println(out);

    }

}
