package com.contacts.app.repository;

import com.contacts.app.entity.Contact;

import java.util.List;
import java.util.Optional;


public interface ContactRepository {

    Contact save(Contact contact);

    Contact update(Contact contact);

    Optional<Contact> findById(Long aLong);

    List<Contact> findAll();

    void deleteById(Long aLong);
}