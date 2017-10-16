package br.com.wellingtoncosta.sjae.route;

import br.com.wellingtoncosta.sjae.service.UserService;

import com.google.gson.Gson;

import static spark.Spark.*;

public class UserRoute {

    private static UserService service;

    static {
        service = new UserService();
    }

    public static void configureRoutes(Gson gson) {
        path("/api/users", () -> {
            get("", (request, response) -> service.findAll(request), gson::toJson);
            get("/:id", (request, response) -> service.findById(request), gson::toJson);
            post("", (request, response) -> service.save(request, gson), gson::toJson);
            put("", (request, response) -> service.update(request, gson), gson::toJson);
            delete("", (request, response) -> service.delete(request), gson::toJson);
        });
    }

}