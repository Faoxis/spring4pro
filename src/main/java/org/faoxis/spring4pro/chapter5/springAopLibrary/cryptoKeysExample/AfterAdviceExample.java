package org.faoxis.spring4pro.chapter5.springAopLibrary.cryptoKeysExample;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceExample {

    private static KeyGenerator getKeyGenerator() {
        KeyGenerator target = new KeyGenerator();
        WeakKeyCheckAdvice advice = new WeakKeyCheckAdvice();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(advice);

        return (KeyGenerator) proxyFactory.getProxy();
    }

    public static void main(String[] args) {
        KeyGenerator keyGenerator = getKeyGenerator();

        for (int x = 0; x < 10; x++) {
            try {
                long key = keyGenerator.getKey();
                System.out.println("Key: " + key);
            } catch (SecurityException e) {
                System.out.println("Weak Key Generated!");
            }
        }
    }

}
