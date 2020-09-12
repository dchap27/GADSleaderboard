package com.example.gadsleaderboard.services;

import com.example.gadsleaderboard.LearnersInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardService {

    @GET("hours")
    Call<List<LearnersInfo>> getTopLearners();

    @GET("skilliq")
    Call<List<LearnersInfo>> getTopSkills();
}
