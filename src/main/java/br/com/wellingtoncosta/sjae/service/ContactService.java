package br.com.wellingtoncosta.sjae.service;

import br.com.wellingtoncosta.sjae.domain.Contact;
import br.com.wellingtoncosta.sjae.domain.Message;

import br.com.wellingtoncosta.sjae.repository.ContactRepository;
import br.com.wellingtoncosta.sjae.repository.Repository;
import com.google.gson.Gson;
import spark.Request;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private Repository<Long, Contact> repository;

    public ContactService() {
        this.repository = new ContactRepository();
    }

    public List<Contact> findAll() {
        return repository.findAll();
    }

    public Contact findById(Request request) {
        Long id = request.attribute("id");
        return repository.findById(id);
    }

    public Contact save(Request request, Gson gson) {
        Contact contact = gson.fromJson(request.body(), Contact.class);
        return repository.save(contact);
    }

    public Contact update(Request request, Gson gson) {
        Contact contact = gson.fromJson(request.body(), Contact.class);
        return repository.save(contact);
    }

    public Message delete(Request request) {
        Long id = request.attribute("id");
        repository.delete(id);
        return new Message("Contact with identifier " + id + " was deleted.");
    }

}