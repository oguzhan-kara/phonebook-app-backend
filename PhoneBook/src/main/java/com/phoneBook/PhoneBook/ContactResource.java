package com.phoneBook.PhoneBook;


import com.phoneBook.PhoneBook.Model.Contact;
import com.phoneBook.PhoneBook.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactResource {
    private final ContactService contactService;

    public ContactResource(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts (){
        List<Contact> contacts = contactService.findAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Contact> getContactById (@PathVariable("id") Long id){
        Contact contact = contactService.findContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
        Contact newContact = contactService.addContact(contact);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
        Contact updateContact = contactService.updateContact(contact);
        return new ResponseEntity<>(updateContact, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
