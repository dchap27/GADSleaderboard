package com.example.gadsleaderboard;

import java.util.ArrayList;

public class DataManager {
    private static DataManager ourInstance = null;

    private ArrayList<LearnersInfo> mLearners = new ArrayList<>();

    public static DataManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeLearners();
            ourInstance.initializeExampleLearners();
        }
        return ourInstance;
    }

    private void initializeExampleLearners() {
        final DataManager dm = getInstance();

        LearnersInfo learner = dm.getLearner("Adeola Modupe");
        learner.setHours(15);
        learner.setScore(198);

        learner = dm.getLearner("Bonsue Goldi");
        learner.setHours(67);
        learner.setScore(250);

        learner = dm.getLearner("Mahmud Onyezi");
        learner.setHours(45);
        learner.setScore(120);
    }

    private DataManager() {

    }

    public ArrayList<LearnersInfo> getLearners() {
        return mLearners;
    }

    public LearnersInfo getLearner(String name) {
        for (LearnersInfo learner : mLearners) {
            if (name.equals(learner.getName()))
                return learner;
        }
        return null;
    }

    private void initializeLearners(){
        mLearners.add(initializeLearner1());
        mLearners.add(initializeLearner2());
        mLearners.add(initializeLearner3());
        mLearners.add(initializeLearner4());
    }

    private LearnersInfo initializeLearner1(){
        return new LearnersInfo();
    }
    private LearnersInfo initializeLearner2(){
        return new LearnersInfo();
    }

    private LearnersInfo initializeLearner3(){
        return new LearnersInfo();
    }

    private LearnersInfo initializeLearner4(){
        return new LearnersInfo();
    }
}
