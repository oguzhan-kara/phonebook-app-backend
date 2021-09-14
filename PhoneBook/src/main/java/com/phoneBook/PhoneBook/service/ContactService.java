package com.phoneBook.PhoneBook.service;

import com.phoneBook.PhoneBook.Model.Contact;
import com.phoneBook.PhoneBook.exception.UserNotFoundException;
import com.phoneBook.PhoneBook.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;

@Service
public class ContactService {

    private final ContactRepo contactRepo;

    @Autowired
    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public Contact addContact(Contact contact){
        return contactRepo.save(contact);
    }

    public List<Contact> findAllContacts(){
        return contactRepo.findAll();
    }

    public Contact updateContact(Contact contact){
        return contactRepo.save(contact);
    }

    public Contact findContactById(Long id) {
        return contactRepo.findContactById(id)
                .orElseThrow(()-> new UserNotFoundException("Contact by id "+ id + "was not found"));
    }

    public void deleteContact(Long id){
        contactRepo.deleteContactById(id);
    }

}
