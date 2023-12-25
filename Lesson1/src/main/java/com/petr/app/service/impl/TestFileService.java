package com.petr.app.service.impl;

import com.petr.app.dto.Contact;
import com.petr.app.service.FileService;
import com.petr.app.utils.ContactUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

@Component
public class TestFileService implements FileService {
    @Value("${app.env}")
    private String env;
    @Value("${contacts.path}")
    private String path;

    @Value("${save.path}")
    private String savePath;
    @Override
    public ArrayList<Contact> getFileContacts() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource(path);
        File file = null;
        if (url != null) {
            file = new File(url.getPath());
        } else {
            try {
                file = new File(classloader.getResource(path).toURI());
            } catch (URISyntaxException e) {
                file = new File(classloader.getResource(path).getPath());
            }
        }

        try {
            if (file.canRead()) {
                return ContactUtils.parseContactsFromFile(file);
            } else {
                System.out.println("Cannot read file");
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return new ArrayList<>();
    }

    @Override
    public String getSavePath() {
        return savePath;
    }
}