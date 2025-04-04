package com.example.Contacts.list.model.repository;

import com.example.Contacts.list.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {

    List<Contact> findAll();

    void saveOrUpdateContact(Contact contact);

    void deleteContactById(Long id);

    Optional<Contact> findById(Long id);

    void bachInsert(List<Contact> contacts);
}
