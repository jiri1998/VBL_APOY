package com.example.jirir.tryout;

import android.widget.ImageView;

import java.util.Date;

public class Game {
    private String date;
    private String home_team_name;
    private String away_team_name;
    private Integer home_team_score;
    private Integer away_team_score;

    public Game(String date, String home_team_name, String away_team_name, Integer home_team_score, Integer away_team_score) {
        this.date = date;
        this.home_team_name = home_team_name;
        this.away_team_name = away_team_name;
        this.home_team_score = home_team_score;
        this.away_team_score = away_team_score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHome_team_name() {
        return home_team_name;
    }

    public void setHome_team_name(String home_team_name) {
        this.home_team_name = home_team_name;
    }

    public String getAway_team_name() {
        return away_team_name;
    }

    public void setAway_team_name(String away_team_name) {
        this.away_team_name = away_team_name;
    }

    public Integer getHome_team_score() { return home_team_score; }

    public void setHome_team_score(Integer home_team_score) { this.home_team_score = home_team_score; }

    public Integer getAway_team_score() { return away_team_score; }

    public void setAway_team_score(Integer away_team_score) { this.away_team_score = away_team_score; }
}
