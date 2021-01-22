package com.sanvalero.examen_webinar_psp_primera_ev;

import com.sanvalero.examen_webinar_psp_primera_ev.util.R;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Creado por @ author: Pedro Orós
 * el 22/01/2021
 */
public class App extends Application {
    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(R.getUI("examen_psp.fxml"));
        loader.setController(new AppController());
        VBox vBox = loader.load();

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}
