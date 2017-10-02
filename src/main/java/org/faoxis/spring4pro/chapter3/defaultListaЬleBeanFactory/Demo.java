package org.faoxis.spring4pro.chapter3.defaultListaЬleBeanFactory;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class Demo {
    public static void main(String[] args) throws IOException {

        byte[] buffer = new byte[100];
        InputStream is = new ClassPathResource("org/hello.txt").getInputStream();
        is.read(buffer);
        is.close();

        System.out.println(new String(buffer));

    }
}
