package com.example.jirir.tryout;

public class Standing {
    private String team_name;
    private Integer rank;
    private Integer wins;
    private Integer losses;

    public Standing(String team_name, Integer rank, Integer wins, Integer losses) {
        this.team_name = team_name;
        this.rank = rank;
        this.wins = wins;
        this.losses = losses;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }
}
