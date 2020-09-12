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
public class TopLearnerFragment extends Fragment {


    private View mRootView;

    public TopLearnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.activity_top_learner, container, false);

        initializeDisplayContent();
        return mRootView;
    }

    private void initializeDisplayContent() {

        RecyclerView recyclerLearners = (RecyclerView) mRootView.findViewById(R.id.list_learners);
        LinearLayoutManager learnersLayoutManager = new LinearLayoutManager(mRootView.getContext());
        recyclerLearners.setLayoutManager(learnersLayoutManager);

        ArrayList<LearnersInfo> learners = DataManager.getInstance().getLearners();
        final LearnerRecyclerAdapter learnerRecyclerAdapter = new LearnerRecyclerAdapter(mRootView.getContext(), learners);
        recyclerLearners.setAdapter(learnerRecyclerAdapter);

    }

}
