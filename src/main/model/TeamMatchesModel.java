package main.model;


public class TeamMatchesModel {
    private long match_id;
    private int duration;
    private int start_time;
    private long leagueid;
    private String league_name;
    private Boolean radiant_win;
    private Boolean radiant;
    private int cluster;



    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

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

    public Boolean getRadiant_win() {
        return radiant_win;
    }

    public void setRadiant_win(Boolean radiant_win) {
        this.radiant_win = radiant_win;
    }

    public Boolean getRadiant() {
        return radiant;
    }

    public void setRadiant(Boolean radiant) {
        this.radiant = radiant;
    }

    @Override
    public String toString() {
        return ("Match id: " + match_id + "; duration: " + duration + "; Start time: " + start_time + "; League id: " + leagueid + "; League name: " + league_name + "; Radiant win: " + radiant_win + "; Team is radiant: " + radiant + "; Cluster:" + cluster);
    }
}
