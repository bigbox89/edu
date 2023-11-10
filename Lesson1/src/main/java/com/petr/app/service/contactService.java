package com.petr.app.service;

import com.petr.app.dto.Contact;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@ShellComponent
public class contactService {
    private List<Contact> contacts;
    File file = initialService.getFileContacts();
    public contactService() {
        contacts = parseContactsFromFile(file);
    }

    @ShellMethod(key = "displayContacts")
    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    @ShellMethod(key = "addContact")
    public void addContact(@ShellOption(arity = 3) String[] inputContact) {
        String [] params = inputContact[2].split(";");
        String fullName = inputContact[0] + " " + inputContact[1] + " " + params [0];
        String phoneNumber = params [1];
        String email = params [2];
        Contact contact = new Contact(fullName, phoneNumber, email);
       contacts.add(contact);
    }

    @ShellMethod(key = "deleteContactByEmail")
    public void deleteContactByEmail(String email) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getEmail().equals(email)) {
                iterator.remove();
                System.out.println("Контакт успешно удален!");
                return;
            }
        }
        System.out.println("Контакт с указанным email не найден!");
    }

    @ShellMethod(key = "saveContactsToFile")
    public boolean saveContactsToFile() {
        if (!file.exists()) {
            return false;
        } else {
            PrintWriter writer;
            try {
                writer = new PrintWriter(file);

                for (Contact contact : contacts) {
                    writer.println(contact.toNewLine());
                }
                writer.flush();
                writer.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
    public  ArrayList<Contact> parseContactsFromFile(File inputData) {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            Scanner reader = new Scanner(inputData);
            reader.useDelimiter(";");

            String line;
            while (reader.hasNextLine()) {
                String[] params = reader.nextLine().split(";");
                Contact contact = new Contact(params[0], params[1], params[2]);
                contacts.add(contact);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, Error: " + e);
        }
        return contacts;
    }
}