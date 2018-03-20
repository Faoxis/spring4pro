package org.faoxis.spring4pro.chapter5.springAopLibrary.securetyExample;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MySecure {
}
