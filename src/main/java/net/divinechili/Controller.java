package net.divinechili;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Button C1;
    @FXML private Button D1;
    @FXML private Button E1;
    @FXML private Button F1;
    @FXML private Button G1;
    @FXML private Button A1;
    @FXML private Button B1;
    @FXML private Button C2;
    @FXML private Button D2;
    @FXML private Button E2;
    @FXML private Button F2;
    @FXML private Button G2;
    @FXML private Button A2;
    @FXML private Button B2;
    @FXML private Button C3;
    @FXML private Button D3;
    @FXML private Button E3;
    @FXML private Button F3;
    @FXML private Button G3;
    @FXML private Button A3;
    @FXML private Button B3;
    @FXML private Button C4;

    @FXML private Button Cs1;
    @FXML private Button Eb1;
    @FXML private Button Fs1;
    @FXML private Button Gs1;
    @FXML private Button Bb1;
    @FXML private Button Cs2;
    @FXML private Button Eb2;
    @FXML private Button Fs2;
    @FXML private Button Gs2;
    @FXML private Button Bb2;
    @FXML private Button Cs3;
    @FXML private Button Eb3;
    @FXML private Button Fs3;
    @FXML private Button Gs3;
    @FXML private Button Bb3;

    @FXML private Button startButton;
    @FXML private ChoiceBox devices;
    @FXML private CheckBox immidiateRelease;

    public static Robot robot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        immidiateRelease.selectedProperty().bindBidirectional(Main.canHoldNote);

        /*
        C2.setOnAction(event -> {
            try {
                GlobalScreen.registerNativeHook();
                System.out.println("Return key is: " + KeyPressUtil.GetKeyPress(""));
            } catch (NativeHookException e) { e.printStackTrace(); }
        });
        */
    }
}
