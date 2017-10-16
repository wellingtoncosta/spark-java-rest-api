package br.com.wellingtoncosta.sjae.service;

import br.com.wellingtoncosta.sjae.domain.Message;
import br.com.wellingtoncosta.sjae.domain.User;

import br.com.wellingtoncosta.sjae.repository.Repository;
import br.com.wellingtoncosta.sjae.repository.UserRepository;
import com.google.gson.Gson;
import spark.Request;

import java.util.List;

public class UserService {

    private Repository<Long, User> repository;

    public UserService() {
        repository = new UserRepository();
    }

    public List<User> findAll(Request request) {
        return repository.findAll();
    }

    public User findById(Request request) {
        Long id = request.attribute("id");
        return repository.findById(id);
    }

    public User save(Request request, Gson gson) {
        User user = gson.fromJson(request.body(), User.class);
        return repository.save(user);
    }

    public User update(Request request, Gson gson) {
        User user = gson.fromJson(request.body(), User.class);
        return repository.save(user);
    }

    public Message delete(Request request) {
        Long id = request.attribute("id");
        repository.delete(id);
        return new Message("User with identifier "+ id + " was deleted.");
    }

}