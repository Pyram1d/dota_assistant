package main.model;

/**
 * Created by den on 21.10.2017.
 */
public class TeamModel {
    private int team_id = 0;
    private int rating = 0;
    private int wins = 0;
    private int losses = 0;
    private int last_match_time = 0;
    private String logo_url = "";
    private String name = "";
    private String tag = "";

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getLast_match_time() {
        return last_match_time;
    }

    public void setLast_match_time(int last_match_time) {
        this.last_match_time = last_match_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
