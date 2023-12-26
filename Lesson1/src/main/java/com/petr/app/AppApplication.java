package com.petr.app;

import com.petr.app.config.AppConfig;
import com.petr.app.service.ContactService;
import com.petr.app.service.ProfileWorker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class AppApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            ProfileWorker profileWorker = applicationContext.getBean(ProfileWorker.class);
            ContactService contactService = new ContactService(profileWorker);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter command (displayContacts, addContact, deleteContactByEmail, saveContactsToFile):");
                String command = scanner.nextLine();

                switch (command) {
                    case "displayContacts":
                        contactService.displayContacts();
                        break;
                    case "addContact":
                        System.out.println("Enter the contact details in the format: Surname, First name, Patronymic;Phone number;Email");
                        String inputContact = scanner.nextLine();
                        String[] inputContactArray = inputContact.split(";");
                        String addContactResult = contactService.addContact(inputContactArray);
                        System.out.println(addContactResult);
                        break;
                    case "deleteContactByEmail":
                        System.out.println("Enter the Email address of the contact you want to delete:");
                        String emailToDelete = scanner.nextLine();
                        String deleteContactResult = contactService.deleteContactByEmail(emailToDelete);
                        System.out.println(deleteContactResult);
                        break;
                    case "saveContactsToFile":
                        String saveContactsResult = contactService.saveContactsToFile();
                        System.out.println(saveContactsResult);
                        break;
                    default:
                        System.out.println("Incorrect command. Try again.");
                        break;
                }
                System.out.println();
            }
        }
    }
}
