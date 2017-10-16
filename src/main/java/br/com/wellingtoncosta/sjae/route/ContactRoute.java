package br.com.wellingtoncosta.sjae.route;

import br.com.wellingtoncosta.sjae.service.ContactService;

import com.google.gson.Gson;

import static spark.Spark.*;

public class ContactRoute {

    private static ContactService service;

    static {
        service = new ContactService();
    }

    public static void configureRoutes(Gson gson) {
        path("/api/contacts", () -> {
            get("", (request, response) -> service.findAll(), gson::toJson);
            get("/:id", (request, response) -> service.findById(request), gson::toJson);
            post("", (request, response) -> service.save(request, gson), gson::toJson);
            put("", (request, response) -> service.update(request, gson), gson::toJson);
            delete("", (request, response) -> service.delete(request), gson::toJson);
        });
    }

}