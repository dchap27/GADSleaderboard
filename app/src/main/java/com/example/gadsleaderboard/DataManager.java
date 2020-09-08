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
        learner.setmHoursWatched(15);
        learner.setmIQScore(198);

        learner = dm.getLearner("Bonsue Goldi");
        learner.setmHoursWatched(67);
        learner.setmIQScore(250);

        learner = dm.getLearner("Mahmud Onyezi");
        learner.setmHoursWatched(45);
        learner.setmIQScore(120);
    }

    private DataManager() {

    }

    public ArrayList<LearnersInfo> getLearners() {
        return mLearners;
    }

    public LearnersInfo getLearner(String name) {
        for (LearnersInfo learner : mLearners) {
            if (name.equals(learner.getmName()))
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
        return new LearnersInfo("Adeola Modupe", "Nigeria");
    }
    private LearnersInfo initializeLearner2(){
        return new LearnersInfo("Mahmud Onyezi", "Kenya");
    }

    private LearnersInfo initializeLearner3(){
        return new LearnersInfo("John Authur", "Nigeria");
    }

    private LearnersInfo initializeLearner4(){
        return new LearnersInfo("Bonsue Goldi", "Uganda");
    }
}
