package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SkillIQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_iq);

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        RecyclerView recyclerLearners = (RecyclerView) findViewById(R.id.list_skill_iq_learners);
        LinearLayoutManager learnersLayoutManager = new LinearLayoutManager(this);
        recyclerLearners.setLayoutManager(learnersLayoutManager);

        ArrayList<LearnersInfo> learners = DataManager.getInstance().getLearners();
        final LearnerRecyclerAdapter learnerRecyclerAdapter = new LearnerRecyclerAdapter(this, learners);
        recyclerLearners.setAdapter(learnerRecyclerAdapter);
    }
}
