package main.model;

/**
 * Created by den on 21.10.2017.
 */
public class ProMatchModel {
    private long match_id;
    private int duration;
    private int start_time;
    private long radiant_team_id;
    private String radiant_name;
    private long dire_team_id;
    private String dire_name;
    private long leagueid;
    private String league_name;
    private long series_id;
    private int series_type;
    private int radiant_score;
    private int dire_score;
    private boolean radiant_win;
    private boolean radiant;

    public long getMatch_id() {
        return match_id;
    }

    public void setMatch_id(long match_id) {
        this.match_id = match_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public long getRadiant_team_id() {
        return radiant_team_id;
    }

    public void setRadiant_team_id(long radiant_team_id) {
        this.radiant_team_id = radiant_team_id;
    }

    public String getRadiant_name() {
        return radiant_name;
    }

    public void setRadiant_name(String radiant_name) {
        this.radiant_name = radiant_name;
    }

    public long getDire_team_id() {
        return dire_team_id;
    }

    public void setDire_team_id(long dire_team_id) {
        this.dire_team_id = dire_team_id;
    }

    public String getDire_name() {
        return dire_name;
    }

    public void setDire_name(String dire_name) {
        this.dire_name = dire_name;
    }

    public long getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(long leagueid) {
        this.leagueid = leagueid;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public long getSeries_id() {
        return series_id;
    }

    public void setSeries_id(long series_id) {
        this.series_id = series_id;
    }

    public int getSeries_type() {
        return series_type;
    }

    public void setSeries_type(int series_type) {
        this.series_type = series_type;
    }

    public int getRadiant_score() {
        return radiant_score;
    }

    public void setRadiant_score(int radiant_score) {
        this.radiant_score = radiant_score;
    }

    public int getDire_score() {
        return dire_score;
    }

    public void setDire_score(int dire_score) {
        this.dire_score = dire_score;
    }

    public boolean isRadiant_win() {
        return radiant_win;
    }

    public void setRadiant_win(boolean radiant_win) {
        this.radiant_win = radiant_win;
    }

    public boolean isRadiant() {
        return radiant;
    }

    public void setRadiant(boolean radiant) {
        this.radiant = radiant;
    }

    @Override public String toString() {
        return ("Match id = "+match_id+", radiant team name = "+radiant_name+", dire team name = "+dire_name+", radiant win = "+radiant_win);
    }
}
