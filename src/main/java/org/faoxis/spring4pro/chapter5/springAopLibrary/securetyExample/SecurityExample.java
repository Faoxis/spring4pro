package org.faoxis.spring4pro.chapter5.springAopLibrary.securetyExample;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();

        SecureBean secureBean = getSecureBean();

        securityManager.login("Sergei", "123");
        secureBean.writeSecureMessage();
        secureBean.writeNotSecureMessage();
        securityManager.logout();

        try {
            secureBean.writeNotSecureMessage();
            securityManager.login("Somebody", "else");
            secureBean.writeSecureMessage();
        } catch (SecurityException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            securityManager.logout();
        }

        try {
            secureBean.writeNotSecureMessage();
            secureBean.writeSecureMessage();
        } catch (SecurityException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();
        SecurityAdvise advise = new SecurityAdvise();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advise);

        return (SecureBean) factory.getProxy();
    }
}
