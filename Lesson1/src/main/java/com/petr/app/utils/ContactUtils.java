package com.petr.app.utils;

import com.petr.app.dto.Contact;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class ContactUtils {
    public static ArrayList<Contact> parseContactsFromFile(File inputData) {
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
