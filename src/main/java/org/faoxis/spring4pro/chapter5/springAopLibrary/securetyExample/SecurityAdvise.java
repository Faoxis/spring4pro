package org.faoxis.spring4pro.chapter5.springAopLibrary.securetyExample;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

public class SecurityAdvise implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvise() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        if (!method.isAnnotationPresent(MySecure.class)) {
            return;
        }

        UserInfo user = securityManager.getLoggedOnUser();

        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before using method " + method.getName());
        } else if ("Sergei".equals(user.getLogin())) {
            System.out.println("Sergei here");
        } else {
            System.out.println("Wrong user: " + user.getLogin());
            throw new SecurityException("Login is not correct");
        }


    }
}
