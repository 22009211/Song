package com.myapplicationdev.android.song;

public class Song {

    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(String title, String singers, int year, int stars){
    this.title = title;
    this.singers =singers;
    this.year = year;
    this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public void setStar(int stars) {
        this.stars = stars;
    }
}