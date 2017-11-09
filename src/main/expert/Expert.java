package main.expert;

import main.MainController;
import main.model.ProMatchModel;
import java.util.ArrayList;
import java.util.List;

public class Expert {

    private List<ProMatchModel> selectedProMatchesList = new ArrayList<>();
    private int commonMatchesNumber;

    public void predictMatchResult(List<ProMatchModel> proMatchesList, String firstTeam, String secondTeam, double indexFirstTeam, double indexSecondTeam) {
        commonMatchesNumber = findCommonMatches(firstTeam, secondTeam, proMatchesList).size();
        if ((firstTeam == null)||(secondTeam == null)) {
            MainController.setMessage("Please, complete missing information");
        } else
        if (commonMatchesNumber < 3) {
            setResult(0,0,0,0, "More statistics needed");
        } else {
            double firstTeamWinRateDouble = countFirstTeamWinRate(firstTeam, secondTeam);
            implementTheSimplestStrategy(indexFirstTeam, indexSecondTeam, firstTeamWinRateDouble);
        }
    }

    private List<ProMatchModel> findCommonMatches(String firstTeam, String secondTeam, List<ProMatchModel> proMatchesList) {
        selectedProMatchesList.clear();
        for (ProMatchModel proMatch: proMatchesList) {
            if ((proMatch.getDire_name() != null)&&(proMatch.getRadiant_name() != null)&&(selectedProMatchesList.size() < 10)) {
                if ((proMatch.getDire_name().equals(firstTeam)) && (proMatch.getRadiant_name().equals(secondTeam))) {
                    selectedProMatchesList.add(proMatch);
                } else if ((proMatch.getDire_name().equals(secondTeam)) && (proMatch.getRadiant_name().equals(firstTeam))) {
                    selectedProMatchesList.add(proMatch);
                }
            }
        }
        return selectedProMatchesList;
    }

    private double countFirstTeamWinRate(String firstTeam, String secondTeam) {
        int numberOfFirstTeamWins = 0;
        for (ProMatchModel proMatch: selectedProMatchesList) {
            if ((proMatch.getRadiant_name().equals(firstTeam)&&(proMatch.isRadiant_win()))||(proMatch.getRadiant_name().equals(secondTeam)&&(!proMatch.isRadiant_win()))) {
                numberOfFirstTeamWins++;
            }
        }
        return (double) (numberOfFirstTeamWins) / (double) (selectedProMatchesList.size());
    }

    private void setResult(double firstTeamROI, double secondTeamROI, int firstTeamWinRate, int secondTeamWinRate, String message) {
        MainController.setFirstTeamROI(firstTeamROI);
        MainController.setSecondTeamROI(secondTeamROI);
        MainController.setFirstTeamWinRate(firstTeamWinRate);
        MainController.setSecondTeamWinRate(secondTeamWinRate);
        MainController.setMessage(message);
    }

    private void implementTheSimplestStrategy(double indexFirstTeam, double indexSecondTeam, double firstTeamWinRateDouble) {
        double firstTeamROI = firstTeamWinRateDouble * (indexFirstTeam - 1) - (1 - firstTeamWinRateDouble);
        double secondTeamROI = (1 - firstTeamWinRateDouble) * (indexSecondTeam - 1) - firstTeamWinRateDouble;
        int secondTeamWinRate = (int) ((1 - firstTeamWinRateDouble) * 100);
        int firstTeamWinRate = (int) (firstTeamWinRateDouble * 100);
        setResult(firstTeamROI, secondTeamROI, firstTeamWinRate, secondTeamWinRate, commonMatchesNumber + " matches analyzed");
    }
}
