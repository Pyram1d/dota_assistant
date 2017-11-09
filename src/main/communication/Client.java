package main.communication;

import main.model.ProMatchModel;
import main.model.TeamMatchesModel;
import main.model.MatchModel;
import main.model.TeamModel;
import okhttp3.*;
import java.io.IOException;
import java.util.*;

import org.codehaus.jackson.map.ObjectMapper;

public class Client {

    private MatchModel match;
    private List<TeamMatchesModel> teamMatchesList;
    private List<TeamModel> teamsList;
    private List<ProMatchModel> proMatchesList = new ArrayList<>();
    private int maxProMatchesNumber;

    public Client(int maxProMatchesNumber) {
        this.maxProMatchesNumber = maxProMatchesNumber;
    }

    public void execute(String command) throws IOException {

        String serviceAddress = "https://api.opendota.com/api";
        String baseUrl = serviceAddress + command;
        Response response = getResponse(baseUrl);
        mapResponse(response, command);
    }

    public MatchModel getMatch() {
        return match;
    }

    public List<TeamMatchesModel> getTeamMatchesList() {
        return teamMatchesList;
    }

    public List<TeamModel> getTeamsList() {
        return teamsList;
    }

    public List<ProMatchModel> getProMatchesList() {
        return proMatchesList;
    }

    private Response getResponse(String baseUrl) {
        Response response = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(baseUrl)
                .get()
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private void mapResponse(Response response, String command) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String responseJsonString = response.body().string();
        try {
            if ((command.contains("/teams"))&&(command.contains("/matches"))) {
                if (teamMatchesList != null) {
                    teamMatchesList.clear();
                }
                teamMatchesList = mapper.readValue(responseJsonString, mapper.getTypeFactory().constructCollectionType(List.class, TeamMatchesModel.class));
            } else
            if (command.contains("/proMatches")) {
                proMatchesList.addAll(mapper.readValue(responseJsonString, mapper.getTypeFactory().constructCollectionType(List.class, ProMatchModel.class)));
                if ((proMatchesList.size() < maxProMatchesNumber)&&(proMatchesList.size() != 0)) {
                    command = command.substring(0,command.indexOf("=")+1)+proMatchesList.get(proMatchesList.size()-1).getMatch_id();
                    Thread.sleep(3300);
                    this.execute(command);
                }
            } else
            if (command.contains("/matches")) {
                match = null;
                match = mapper.readValue(responseJsonString, MatchModel.class);
            }
            if (command.contains("/teams")) {
                if (teamsList != null) {
                    teamsList.clear();
                }
                teamsList = mapper.readValue(responseJsonString, mapper.getTypeFactory().constructCollectionType(List.class, TeamModel.class));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
