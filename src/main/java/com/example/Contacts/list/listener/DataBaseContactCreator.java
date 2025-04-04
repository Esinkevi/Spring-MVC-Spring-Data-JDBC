package com.example.Contacts.list.listener;

import com.example.Contacts.list.model.Contact;
import com.example.Contacts.list.service.ContactService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.desktop.AppReopenedEvent;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataBaseContactCreator {

    private final ContactService contactService;

    @Value("${app.create-test-data:false}")
    private boolean createTestData;


    @PostConstruct
    public void createContactData() {
        log.debug(" DataBaseContactCreator Call createContactData");
        if (createTestData){
            List<Contact> contactList = new ArrayList<>();

            for (int i = 1; i <= 10; i++) {
                Contact contact = new Contact();
                contact.setId((long) i);
                contact.setName("Name" + i);
                contact.setLastName("LastName " + i);
                contact.setPhoneNumber(String.valueOf(i));
                contactList.add(contact);
            }

            contactService.bachInsert(contactList);
        }

    }
}
