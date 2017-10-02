package org.faoxis.spring4pro.chapter3.methodReplacement;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class FormatMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {

        if (isFormatMessage(method)) {
            String message = (String) args[0];
            return "<h2>" + message + "</h2>";
        } else {
            throw new IllegalArgumentException("Unable to remplace method " + method.getName());
        }

    }

    private boolean isFormatMessage(Method method) {
        if (method.getParameterTypes().length != 1) {
            return false;
        }

        if (!("formatMessage").equals(method.getName())) {
            return false;
        }

        if (method.getReturnType() != String.class) {
            return false;
        }

        if (method.getParameterTypes()[0] != String.class) {
            return false;
        }

        return true;
    }
}
