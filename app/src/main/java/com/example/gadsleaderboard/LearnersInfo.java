package com.example.gadsleaderboard;

public final class LearnersInfo {

    private final String mName;
    private int mHoursWatched;
    private int mIQScore;
    private final String mCountry;


    public LearnersInfo(String mName, String mCountry) {
        this.mName = mName;
        this.mCountry = mCountry;
    }

    public String getmName() {
        return mName;
    }

    public String getmCountry() {
        return mCountry;
    }

    public int getmHoursWatched() {
        return mHoursWatched;
    }

    public int getmIQScore() {
        return mIQScore;
    }

    public void setmHoursWatched(int hours){
        this.mHoursWatched = hours;
    }

    public void setmIQScore(int mIQScore) {
        this.mIQScore = mIQScore;
    }

    private String getCompareKey() {
        return getmName() + "|" + getmCountry() + "|" + getmHoursWatched();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LearnersInfo that = (LearnersInfo) o;

        return getCompareKey().equals(that.getCompareKey());
    }

    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }

    @Override
    public String toString() {
        return getCompareKey();
    }
}
