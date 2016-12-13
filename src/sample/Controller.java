package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
//Comments 

    @FXML
    private TextArea scoreMe;

    @FXML
    private TextArea scoreOrdi;

    @FXML
    private TextField winner;

    private String me;
    private String ordi;

    private int calculScoreMe;
    private int calculeScoreOrdi;

    private int random() {
        return (int) (1 + Math.random() * 3);
    }

    private void choiseOrdi(int x) {
        switch (x) {
            case 1:
                ordi = "pierre";
                break;
            case 2:
                ordi = "feuille";
                break;
            case 3:
                ordi = "ciseau";
                break;
        }
    }

    @FXML
    private void jeu(ActionEvent event) {

        me = ((Button) event.getSource()).getText();
        choiseOrdi(random());

        if (me.equals(ordi)) {
            winner.setText("null");
        } else {
            if (me.equals("feuille") && ordi.equals("pierre")) {
                calculScoreMe++;
                winner.setText("me");
            } else {
                if (me.equals("pierre") && ordi.equals("feuille")) {
                    calculeScoreOrdi++;
                    winner.setText("ordi");
                } else {
                    if (me.equals("ciseau") && ordi.equals("pierre")) {
                        calculeScoreOrdi++;
                        winner.setText("ordi");
                    } else {
                        if (me.equals("pierre") && ordi.equals("ciseau")) {
                            calculScoreMe++;
                            winner.setText("me");
                        } else {
                            if (me.equals("ciseau") && ordi.equals("feuille")) {
                                calculeScoreOrdi++;
                                winner.setText("ordi");
                            } else {
                                calculScoreMe++;
                                winner.setText("me");
                            }


                        }
                    }

                }

            }


        }


        scoreMe.setText(String.valueOf(calculScoreMe));
        scoreOrdi.setText(String.valueOf(calculeScoreOrdi));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Restart();

    }

    public void Restart(){
        calculeScoreOrdi=0;
        calculScoreMe=0;
        scoreMe.setText("0");
        scoreOrdi.setText("0");


    }

}
