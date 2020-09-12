package com.example.gadsleaderboard;

public final class LearnersInfo {

    private String name;
    private int hours;
    private int score;
    private String country;
    private String badgeUrl;


    public LearnersInfo() {
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getHours() {
        return hours;
    }

    public int getScore() {
        return score;
    }

    public String getBadgeUrl(){
        return badgeUrl;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBadgeUrl(String badgeUrl){
        this.badgeUrl = badgeUrl;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private String getCompareKey() {
        return getName() + "|" + getCountry() + "|" + getHours();
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
