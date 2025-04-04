package com.example.Contacts.list.service;

import com.example.Contacts.list.model.Contact;

import java.util.List;

public interface ContactService {


    List<Contact> findAll();


    void saveOrUpdateContact(Contact contact);


    void deleteContactById(Long id);

    Contact findById(Long id);

    void bachInsert(List<Contact> contacts);
}
