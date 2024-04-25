package com.contacts.app.service;

import com.contacts.app.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> getAllContacts();

    Optional<Contact> getContactById(Long id);

    Contact addContact(Contact contact);

    void deleteContactById(Long id);

    void updateContact(Contact contact);
}
