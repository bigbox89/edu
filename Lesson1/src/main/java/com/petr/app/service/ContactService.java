package com.petr.app.service;

import com.petr.app.dto.Contact;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ContactService {

    public ContactService(ProfileWorker profileWorker) {
        this.profileWorker = profileWorker;
    }

    ProfileWorker profileWorker;
    private List<Contact> contacts = new ArrayList<>();

    public void displayContacts() {
        if (contacts.isEmpty()) {
            contacts = profileWorker.getContactsList();
        }
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }
    public String addContact(String[] inputContact) {
        if (inputContact.length < 2) {
            return "Incorrect input. Enter the contact in the format Smirnov Ivan Ivanovich;+89099991;someEmail2@example.example";
        }
        String fullName = inputContact[0];
        String phoneNumber = inputContact[1];
        String email = inputContact[2];
        Contact contact = new Contact(fullName, phoneNumber, email);
        contacts.add(contact);
        return "The contact has been successfully saved!";
    }
    public String deleteContactByEmail(String email) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getEmail().equals(email)) {
                iterator.remove();
                return "The contact has been successfully deleted!";
            }
        }
        return "The contact with the specified email was not found!";
    }
    public String saveContactsToFile() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String dir = ContactService.class.getResource("/").getFile();
        File file = new File(dir + profileWorker.getSavePath());

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                return "The file cannot be read";
            }
        }
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Contact contact : contacts) {
                writer.println(contact.toNewLine());
            }
        } catch (FileNotFoundException e) {
            return "Error saving contacts";
        }
        return "Contacts have been saved successfully!";
    }
}