package com.petr.app.service.impl;

import com.petr.app.dto.Contact;
import com.petr.app.service.FileService;
import com.petr.app.utils.ContactUtils;
import org.springframework.beans.factory.annotation.Value;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class TestFileService implements FileService {

    @Value("${app.env}")
    private String env;

    @Value("${contacts.path}")
    private String path;
    @Override
    public ArrayList<Contact> getFileContacts() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource(path);
        String name = url.getPath();
        File file = null;

        if (url == null) {
            String dir = TestFileService.class.getResource("/").getFile();
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
        return ContactUtils.parseContactsFromFile(file);
    }
}
