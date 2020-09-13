package com.example.gadsleaderboard.services;

import com.example.gadsleaderboard.LearnersInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface LeaderBoardService {

    @GET("hours")
    Call<List<LearnersInfo>> getTopLearners();

    @GET("skilliq")
    Call<List<LearnersInfo>> getTopSkills();

    @POST
    @FormUrlEncoded
    Call<Void> submitEntry(@Url String altUrl,
                           @Field("entry.1877115667") String firstName,
                           @Field("entry.2006916086") String lastName,
                           @Field("entry.1824927963") String emailAddress,
                           @Field("entry.284483984") String link);
}
