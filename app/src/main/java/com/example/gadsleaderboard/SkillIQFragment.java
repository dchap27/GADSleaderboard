package com.example.gadsleaderboard;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gadsleaderboard.services.LeaderBoardService;
import com.example.gadsleaderboard.services.ServiceBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillIQFragment extends Fragment {


    private View mRootView;
    private RecyclerView mRecyclerLearners;
    private SkillIQRecyclerAdapter mSkillRecyclerAdapter;

    public SkillIQFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.activity_skill_iq, container, false);

        initializeDisplayContent();

        return mRootView;
    }

    private void initializeDisplayContent() {
        mRecyclerLearners = (RecyclerView) mRootView.findViewById(R.id.list_skill_iq_learners);
        LinearLayoutManager learnersLayoutManager = new LinearLayoutManager(mRootView.getContext());
        mRecyclerLearners.setLayoutManager(learnersLayoutManager);

        makeApiCall();
    }

    private void makeApiCall() {
        LeaderBoardService leaderBoardService = ServiceBuilder.buildService(LeaderBoardService.class);
        Call<List<LearnersInfo>> leaderBoardRequest = leaderBoardService.getTopSkills();

        leaderBoardRequest.enqueue(new Callback<List<LearnersInfo>>() {
            @Override
            public void onResponse(Call<List<LearnersInfo>> call, Response<List<LearnersInfo>> response) {
                response.body().sort(Comparator.comparing(LearnersInfo::getScore, Comparator.reverseOrder()));
                mSkillRecyclerAdapter = new SkillIQRecyclerAdapter(mRootView.getContext(), response.body());
                mRecyclerLearners.setAdapter(mSkillRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<LearnersInfo>> call, Throwable t) {
                Toast.makeText(mRootView.getContext(),
                        "Failed to retrieve leaderboards", Toast.LENGTH_LONG).show();
            }
        });
    }

}
