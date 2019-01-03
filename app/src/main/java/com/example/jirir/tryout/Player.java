package com.example.jirir.tryout;

public class Player {
    private String name;
    private String sirname;
    private String number;
    private String pos;
    private String team_name;
    private Double points;
    private Double assists;
    private Double rebounds;

    public Player(String name, String sirname, String number, String pos, String team_name, Double points, Double assists, Double rebounds) {
        this.name = name;
        this.sirname = sirname;
        this.number = number;
        this.pos = pos;
        this.team_name = team_name;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSirname() {
        return sirname;
    }

    public void setSirname(String sirname) {
        this.sirname = sirname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Double getAssists() {
        return assists;
    }

    public void setAssists(Double assists) {
        this.assists = assists;
    }

    public Double getRebounds() {
        return rebounds;
    }

    public void setRebounds(Double rebounds) {
        this.rebounds = rebounds;
    }
}
