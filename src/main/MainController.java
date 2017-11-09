package main;

import java.io.*;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import main.communication.Client;
import main.expert.Expert;
import main.model.ProMatchModel;
import main.model.TeamModel;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;

public class MainController implements Initializable {

    private static List<ProMatchModel> proMatchesList;
    private static Client client;
    private static Expert expert;
    private static String message;

    @FXML
    private ComboBox<String> firstTeamNameValue, secondTeamNameValue;

    private static double secondTeamROI, firstTeamROI;
    private static int firstTeamWinRate, secondTeamWinRate;

    @FXML
    private Slider firstTeamOddsSlider, secondTeamOddsSlider;

    @FXML
    private Label lbl_firstTeamROI, lbl_firstTeamWinRate, lbl_secondTeamWinRate, lbl_secondTeamOdds,
            lbl_firstTeamOdds, lbl_hint, lbl_secondTeamROI, lbl_calculate;


    @FXML
    private ImageView btn_predict, btn_list, btn_statistics, btn_exit;

    @FXML
    private AnchorPane h_predict, h_list, h_statistics;

    @FXML
    private Button btn_calculate;

    @FXML
    private void updateFirstTeamOdds() {
        lbl_firstTeamOdds.textProperty().bind(Bindings.format("%.3f", firstTeamOddsSlider.valueProperty()));
    }

    @FXML
    private void updateSecondTeamOdds() {
        lbl_secondTeamOdds.textProperty().bind(Bindings.format("%.3f", secondTeamOddsSlider.valueProperty()));
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
        if (event.getTarget() == btn_exit) {
            System.exit(0);
        } else
        if (event.getTarget() == btn_predict) {
            showTab(h_predict, btn_predict);
        } else
        if (event.getTarget() == btn_list) {
            showTab(h_list, btn_list);
        } else
        if (event.getTarget() == btn_statistics) {
            showTab(h_statistics, btn_statistics);
        } else
        if ((event.getTarget() == btn_calculate)||(event.getTarget() == lbl_calculate)) {
            expert.predictMatchResult(proMatchesList, firstTeamNameValue.getValue(), secondTeamNameValue.getValue(), firstTeamOddsSlider.getValue(), secondTeamOddsSlider.getValue());
            showResult();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_predict.setEffect(new Glow(1));
        client = new Client(100);
        expert = new Expert();
        getData();
        List<String> teamNamesList = new ArrayList<>();
        BufferedReader reader;
        String teamName;
        try {
            initializeDatabase();
            reader = new BufferedReader(new FileReader("res/teamList.txt"));
            while ((teamName = reader.readLine()) != null) {
                teamNamesList.add(teamName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(teamNamesList);
        firstTeamNameValue.setItems(FXCollections.observableArrayList(teamNamesList));
        secondTeamNameValue.setItems(FXCollections.observableArrayList(teamNamesList));
    }

    private static void initializeDatabase() throws IOException {
        client.execute("/proMatches?less_than_match_id=1000000000000");
        client.execute("/teams");
    }

    private static void getData() {
        proMatchesList = client.getProMatchesList();
        List<TeamModel> teamsList = client.getTeamsList();
    }

    public static void setFirstTeamROI(double firstTeamROI) {
        MainController.firstTeamROI = firstTeamROI;
    }

    public static void setSecondTeamROI(double secondTeamROI) {
        MainController.secondTeamROI = secondTeamROI;
    }

    public static void setFirstTeamWinRate(int firstTeamWinRate) {
        MainController.firstTeamWinRate = firstTeamWinRate;
    }

    public static void setSecondTeamWinRate(int secondTeamWinRate) {
        MainController.secondTeamWinRate = secondTeamWinRate;
    }

    public static void setMessage(String message) {
        MainController.message = message;
    }

    private void showTab(AnchorPane anchorPane, ImageView button) {
        Glow glowOn = new Glow(1);
        Glow glowOff = new Glow(0);
        h_predict.setVisible(false);
        h_list.setVisible(false);
        h_statistics.setVisible(false);
        btn_predict.setEffect(glowOff);
        btn_list.setEffect(glowOff);
        btn_statistics.setEffect(glowOff);
        anchorPane.setVisible(true);
        button.setEffect(glowOn);
    }

    private void showResult() {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        lbl_firstTeamROI.setText(String.valueOf(formatter.format(firstTeamROI*100))+'%');
        lbl_secondTeamROI.setText(String.valueOf(formatter.format(secondTeamROI*100))+'%');
        lbl_firstTeamWinRate.setText(String.valueOf(firstTeamWinRate)+'%');
        lbl_secondTeamWinRate.setText(String.valueOf(secondTeamWinRate)+'%');
        if ((Objects.equals(message, "More statistics needed"))||(Objects.equals(message, "Please, complete missing information"))) {
            lbl_hint.setTextFill(Color.RED);
        } else {
            lbl_hint.setTextFill(Color.GREEN);
        }
        lbl_hint.setText(message);
    }
}
