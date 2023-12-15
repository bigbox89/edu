package com.petr.app.service;

import com.petr.app.dto.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ShellComponent
public class ContactService {
    @Autowired
    ProfileWorker profileWorker;
    private List<Contact> contacts = new ArrayList<>();
    @Value("${save.path}")
    private String savePath;

    @ShellMethod(key = "displayContacts")
    public void displayContacts() {
        if (contacts.isEmpty()) {
            contacts = profileWorker.getContactsList();
        }
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    @ShellMethod(key = "addContact")
    public String addContact(@ShellOption(arity = 3) String[] inputContact) {
        if (inputContact.length < 3) {
            return "Не корректный ввод. Введите контакт в формате Смирнов Иван Иванович | +890999991 | someEmail2@example.example";
        }
        String[] params = inputContact[2].split(";");
        String fullName = inputContact[0] + " " + inputContact[1] + " " + params[0];
        String phoneNumber = params[1];
        String email = params[2];
        Contact contact = new Contact(fullName, phoneNumber, email);
        contacts.add(contact);
        return "Контакт успешно сохранен!";
    }

    @ShellMethod(key = "deleteContactByEmail")
    public String deleteContactByEmail(String email) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getEmail().equals(email)) {
                iterator.remove();
                return "Контакт успешно удален!";
            }
        }
        return "Контакт с указанным email не найден!";
    }

    @ShellMethod(key = "saveContactsToFile")
    public String saveContactsToFile() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String dir = ContactService.class.getResource("/").getFile();
        File file = new File(dir + savePath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                return "Не возможно прочитать файл";
            }
        }
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Contact contact : contacts) {
                writer.println(contact.toNewLine());
            }
        } catch (FileNotFoundException e) {
            return "Ошибка сохранения контактов";
        }
        return "Контакты успешно сохранены!";
    }
}