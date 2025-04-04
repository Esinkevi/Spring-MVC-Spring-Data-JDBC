package com.example.Contacts.list.service;

import com.example.Contacts.list.model.Contact;
import com.example.Contacts.list.model.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }


    @Override
    public void saveOrUpdateContact(Contact contact) {
        contactRepository.saveOrUpdateContact(contact);
    }


    @Override
    public void deleteContactById(Long id) {
        contactRepository.deleteContactById(id);
    }


    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow();
    }

    @Override
    public void bachInsert(List<Contact> contacts) {
        contactRepository.bachInsert(contacts);
    }
}
