package com.example.Contacts.list.controller;

import com.example.Contacts.list.model.Contact;
import com.example.Contacts.list.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactsController {

    private final ContactService contactService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        model.addAttribute("contact", new Contact());
        return "index";
    }

    @PostMapping("/save")
    public String saveOrUpdateContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveOrUpdateContact(contact);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editContact(@PathVariable Long id, Model model) {
        Contact contact = contactService.findById(id); // Находим контакт по ID
        model.addAttribute("contact", contact); // Передаем его в форму
        model.addAttribute("contacts", contactService.findAll()); // Загружаем список контактов
        return "index"; // Используем тот же HTML-файл
    }


}
