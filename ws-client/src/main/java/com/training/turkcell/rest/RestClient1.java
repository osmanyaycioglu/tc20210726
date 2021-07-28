package com.training.turkcell.rest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Random;

import com.google.gson.Gson;
import com.person.Person;

public class RestClient1 {

    public static void main(final String[] args) throws Exception {
        Random randomLoc = new SecureRandom();
        Person personLoc = new Person();
        personLoc.setUsername("osman" + randomLoc.nextLong());
        personLoc.setName("osman" + randomLoc.nextLong());
        personLoc.setSurname("yaycıoğlu");
        personLoc.setHeight(200);
        personLoc.setWeight(95);

        HttpURLConnection urlConnectionLoc = (HttpURLConnection) new URL("http://127.0.0.1:8080/eetraining/rest/api/v1/person/provision/add").openConnection();
        urlConnectionLoc.setDoOutput(true);
        urlConnectionLoc.setRequestProperty("Content-Type",
                                            "application/json");
        urlConnectionLoc.setRequestMethod("POST");
        OutputStream outputStreamLoc = urlConnectionLoc.getOutputStream();
        Gson gsonLoc = new Gson();
        String jsonLoc = gsonLoc.toJson(personLoc);
        outputStreamLoc.write(jsonLoc.getBytes("UTF-8"));

        int responseCodeLoc = urlConnectionLoc.getResponseCode();
        System.out.println("Response status : " + responseCodeLoc);
        String responseMessageLoc = urlConnectionLoc.getResponseMessage();
        System.out.println("Response message : " + responseMessageLoc);
        InputStream inputStreamLoc = urlConnectionLoc.getInputStream();
        InputStreamReader inputStreamReaderLoc = new InputStreamReader(inputStreamLoc);
        BufferedReader bufferedReaderLoc = new BufferedReader(inputStreamReaderLoc);
        bufferedReaderLoc.lines()
                         .forEach(System.out::println);
    }
}
