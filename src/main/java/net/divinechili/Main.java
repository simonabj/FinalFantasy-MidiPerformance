package net.divinechili;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Transmitter;
import java.util.List;


public class Main extends Application {

    public static BooleanProperty canHoldNote = new SimpleBooleanProperty(true);

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Try to get MidiTransmitter

        MidiDevice device;
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for(int i = 0; i < infos.length; i++) {
            try{
                device = MidiSystem.getMidiDevice(infos[i]);
                // If this device has a transmitter, add it to the device list
                System.out.println(infos[i]);

                List<Transmitter> transmitters = device.getTransmitters();

                // For each transmitter
                for(int j = 0; j<transmitters.size();j++) {
                    // Create a new receiver
                    transmitters.get(j).setReceiver(
                            // We use our own created Reciever!
                            new MyMidiReceiver(device.getDeviceInfo().toString())
                    );
                }

                Transmitter trans = device.getTransmitter();
                trans.setReceiver(new MyMidiReceiver(device.getDeviceInfo().toString()));

                // Open each device
                device.open();

                // Print Success message if everything was ok
                System.out.println(device.getDeviceInfo() + " was opened!");
            } catch (MidiUnavailableException e) {
                System.out.println("No transmitter available for this device!");
            }
        }

        Parent root = FXMLLoader.load(getClass().getResource("gui/KeyboardConfig.fxml"));
        primaryStage.setOnCloseRequest((request) -> {
            request.consume();

            Platform.exit();
            System.exit(0);
        });
        primaryStage.setTitle("Final Fantasy XIV | MIDI Keyboard Performance Interpreter");
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
