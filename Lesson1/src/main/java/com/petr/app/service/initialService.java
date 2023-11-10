package com.petr.app.service;

import org.springframework.stereotype.Component;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
@Component
public class initialService {
    public static File getFileContacts() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("default-contacts.txt");
        String name = url.getPath();
        File file = null;
        if (url == null) {
            String dir = initialService.class.getResource("/").getFile();
            try {
                file = new File(dir + name);
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("can not create file ");
            }

        } else {
            try {
                file = new File(url.toURI());
            } catch (URISyntaxException e) {
                file = new File(url.getPath());
            }
        }
        return file;
    }
}
