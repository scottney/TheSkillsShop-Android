package com.example.theskillsshop;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //Base URL for the APP
    private static final String BASE_URL = "192.168.1.101/android_handler/";
    private static RetrofitClient myClient;
    private Retrofit retrofit;

    //Constructor
    private RetrofitClient() {
        //Initialization of retrofit in constructor
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    //This will return a retrofit instance
    public static synchronized RetrofitClient getInstance() {
        //Check if my client is initiated or not
        if(myClient == null) {
            myClient = new RetrofitClient();
        }
        return myClient;
    }

    //APIs Interface
    public MessagesAPIsInterface getAPI() {
        return retrofit.create(MessagesAPIsInterface.class);

    }

}
