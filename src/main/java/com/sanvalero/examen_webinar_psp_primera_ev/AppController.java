package com.sanvalero.examen_webinar_psp_primera_ev;

import com.sanvalero.examen_webinar_psp_primera_ev.util.AlertUtils;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

/**
 * Creado por @ author: Pedro Orós
 * el 22/01/2021
 */
public class AppController {
    public TextField tfValorInicial;
    public TextField tfValorFinal;
    public ProgressBar pbProgreso;
    public Label lContador;
    public Label lPorcentaje;
    public Label lEstado;
    public Button bPausar;
    private Tarea tarea;

    @FXML
    public void iniciar() {

        int valorInit = Integer.parseInt(tfValorInicial.getText());
        int valorFin = Integer.parseInt(tfValorFinal.getText());

        tarea = new Tarea(valorInit, valorFin);

        pbProgreso.progressProperty().unbind();
        pbProgreso.progressProperty().bind(tarea.progressProperty());

        tarea.messageProperty().addListener((observableValue, oldValue, newValue) -> lContador.setText(newValue));
        //tarea.messageProperty().addListener((observableValue, oldValue, newValue) -> lPorcentaje.setText(newValue));

        new Thread(tarea).start();

        tarea.stateProperty().addListener((observableValue, state, newState) -> {
            if(newState == Worker.State.SUCCEEDED) {
                AlertUtils.mostrarInformacion("La cuenta ha finalizado");
            }
        });
    }

    @FXML
    public void pausar() {
        tarea.pausar();
        if(bPausar.getText().equals("Pausar")) {
            bPausar.setText("Continuar");
            lEstado.setText("Cuenta en pausa");
        }
        else if(bPausar.getText().equals("Continuar")) {
            bPausar.setText("Pausar");
            lEstado.setText("");
        }

    }

    @FXML
    public void detener() {
        if(tarea != null) tarea.cancel();
    }
}
