
package main.model;


/**
 * Created by den on 18.10.2017.
 */
public class MatchModel {
    private long match_id = 0;
    private long barracks_status_dire = 0;
    private long barracks_status_radiant = 0;
    private long cluster = 0;
    private long dire_score = 0;
    private long duration = 0;
    private long engine = 0;
    private long first_blood_time = 0;
    private long game_mode = 0;
    private int human_players = 0;
    private long leagueid = 0;
    private long lobby_type = 0;
    private long match_seq_num = 0;
    private long negative_votes = 0;
    private long positive_votes = 0;
    private int radiant_score = 0;
    private boolean radiant_win = false;
    private long start_time;
    private int patch = 0;
    private int region = 0;
    private int loss;
    private String replay_url = "";

    public long getMatch_id() {
        return match_id;
    }

    public void setMatch_id(long match_id) {
        this.match_id = match_id;
    }

    public long getBarracks_status_dire() {
        return barracks_status_dire;
    }

    public void setBarracks_status_dire(long barracks_status_dire) {
        this.barracks_status_dire = barracks_status_dire;
    }

    public long getBarracks_status_radiant() {
        return barracks_status_radiant;
    }

    public void setBarracks_status_radiant(long barracks_status_radiant) {
        this.barracks_status_radiant = barracks_status_radiant;
    }

    public long getCluster() {
        return cluster;
    }

    public void setCluster(long cluster) {
        this.cluster = cluster;
    }

    public long getDire_score() {
        return dire_score;
    }

    public void setDire_score(long dire_score) {
        this.dire_score = dire_score;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getEngine() {
        return engine;
    }

    public void setEngine(long engine) {
        this.engine = engine;
    }

    public long getFirst_blood_time() {
        return first_blood_time;
    }

    public void setFirst_blood_time(long first_blood_time) {
        this.first_blood_time = first_blood_time;
    }

    public long getGame_mode() {
        return game_mode;
    }

    public void setGame_mode(long game_mode) {
        this.game_mode = game_mode;
    }

    public int getHuman_players() {
        return human_players;
    }

    public void setHuman_players(int human_players) {
        this.human_players = human_players;
    }

    public long getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(long leagueid) {
        this.leagueid = leagueid;
    }

    public long getLobby_type() {
        return lobby_type;
    }

    public void setLobby_type(long lobby_type) {
        this.lobby_type = lobby_type;
    }

    public long getMatch_seq_num() {
        return match_seq_num;
    }

    public void setMatch_seq_num(long match_seq_num) {
        this.match_seq_num = match_seq_num;
    }

    public long getNegative_votes() {
        return negative_votes;
    }

    public void setNegative_votes(long negative_votes) {
        this.negative_votes = negative_votes;
    }

    public long getPositive_votes() {
        return positive_votes;
    }

    public void setPositive_votes(long positive_votes) {
        this.positive_votes = positive_votes;
    }

    public int getRadiant_score() {
        return radiant_score;
    }

    public void setRadiant_score(int radiant_score) {
        this.radiant_score = radiant_score;
    }

    public boolean isRadiant_win() {
        return radiant_win;
    }

    public void setRadiant_win(boolean radiant_win) {
        this.radiant_win = radiant_win;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public int getPatch() {
        return patch;
    }

    public void setPatch(int patch) {
        this.patch = patch;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public String getReplay_url() {
        return replay_url;
    }

    public void setReplay_url(String replay_url) {
        this.replay_url = replay_url;
    }
}
