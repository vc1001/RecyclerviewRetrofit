package com.example.retrofitrecyclerapiex.serviceapi;

import com.example.retrofitrecyclerapiex.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/popular")
    Call<Result> getMovie(@Query("api_key") String apiKey);
}