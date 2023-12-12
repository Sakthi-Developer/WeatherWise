package com.example.weatherwise.ApiPackage;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static String BASE_URL = "https://weatherapi-com.p.rapidapi.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        if(retrofit == null){


           HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
           httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

           OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client)
                    .build();
        }
        return retrofit;
    }
}
