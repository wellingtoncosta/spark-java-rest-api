package br.com.wellingtoncosta.sjae;

import br.com.wellingtoncosta.sjae.route.ContactRoute;
import br.com.wellingtoncosta.sjae.route.UserRoute;
import com.google.gson.Gson;

public class App {

    public static void main(String[] args) {
        Gson gson = new Gson();
        UserRoute.configureRoutes(gson);
        ContactRoute.configureRoutes(gson);
    }

}