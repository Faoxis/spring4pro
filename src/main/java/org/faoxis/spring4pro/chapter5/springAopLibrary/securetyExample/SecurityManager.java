package org.faoxis.spring4pro.chapter5.springAopLibrary.securetyExample;

public class SecurityManager {

    private static ThreadLocal<UserInfo> threadLocal
            = new ThreadLocal<>();

    public void login(String login, String password) {
        threadLocal.set(new UserInfo(login, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser() {
        return threadLocal.get();
    }

}
