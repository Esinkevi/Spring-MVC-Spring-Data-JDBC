package com.example.Contacts.list.model.repository;

import com.example.Contacts.list.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class InMemoryContactRepository implements ContactRepository {

    private final List<Contact> contactList = new ArrayList<>();

    @Override
    public List<Contact> findAll() {
        return contactList;
    }

    @Override
    public void saveOrUpdateContact(Contact contact) {
        Contact existed = findById(contact.getId()).orElse(null);
        if (existed == null){
            contact.setId(System.currentTimeMillis());
            contactList.add(contact);
        } else {
            existed.setName(contact.getName());
            existed.setLastName(contact.getLastName());
            existed.setPhoneNumber(contact.getPhoneNumber());
        }
    }


    @Override
    public void deleteContactById(Long id) {
        contactList.remove(findById(id).orElseThrow());
    }


    @Override
    public Optional<Contact> findById(Long id) {
        return contactList.stream().filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public void bachInsert(List<Contact> contacts) {
        contactList.addAll(contacts);
    }
}
