package com.example.gadsleaderboard;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillIQFragment extends Fragment {


    private View mRootView;

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
        RecyclerView recyclerLearners = (RecyclerView) mRootView.findViewById(R.id.list_skill_iq_learners);
        LinearLayoutManager learnersLayoutManager = new LinearLayoutManager(mRootView.getContext());
        recyclerLearners.setLayoutManager(learnersLayoutManager);

        ArrayList<LearnersInfo> learners = DataManager.getInstance().getLearners();
        final SkillIQRecyclerAdapter skillRecyclerAdapter = new SkillIQRecyclerAdapter(mRootView.getContext(), learners);
        recyclerLearners.setAdapter(skillRecyclerAdapter);
    }

}
