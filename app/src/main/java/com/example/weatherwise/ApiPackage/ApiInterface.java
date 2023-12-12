package com.example.weatherwise.ApiPackage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers({
            "X-RapidAPI-Host: weatherapi-com.p.rapidapi.com",
            "X-RapidAPI-Key: 8af205ae45mshbcaac1502baa827p14546cjsn6b33ae93a588"
    })

    @GET("forecast.json")
    Call<HourlyWeatherResponseModel.Root> getHourlyWeather(

            @Query("q") String q,
            @Query("days") int days
    );

    @Headers({
            "X-RapidAPI-Host: weatherapi-com.p.rapidapi.com",
            "X-RapidAPI-Key: 8af205ae45mshbcaac1502baa827p14546cjsn6b33ae93a588"
    })
    @GET("current.json")
    Call<CurrentWeatherResponseModel.Root> getCurrentWeather(
            @Query("q") String q
    );


}
