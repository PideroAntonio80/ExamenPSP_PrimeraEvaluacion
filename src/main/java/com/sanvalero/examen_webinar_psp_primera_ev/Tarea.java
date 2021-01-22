package com.sanvalero.examen_webinar_psp_primera_ev;

import javafx.concurrent.Task;

/**
 * Creado por @ author: Pedro Orós
 * el 22/01/2021
 */
public class Tarea extends Task {

    private boolean pausado;
    private int inicio;
    private int fin;

    public void pausar() {
        if(pausado) {
            pausado = false;
        } else {
            pausado = true;
        }
    }

    public Tarea(int inicio, int fin) {
        this.pausado = false;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Object call() throws Exception {
        double i;
        if(inicio < fin) {
            for( i = inicio; i <= fin; i++) {
                Thread.sleep(1000);
                updateProgress(i, fin);
                updateMessage(((int) i) + " de " + fin + "             " + (int)((i / fin) * 100) + "%");

                while(pausado) {
                    Thread.sleep(1000);
                }
            }
            return i;
        }
        else if(inicio > fin) {
            for( i = inicio; i >= fin; i--) {
                Thread.sleep(1000);
                updateProgress(i, fin);
                updateMessage(((int) i - fin) + " para " + fin + "             " + (int)((fin/ i) * 100) + "%");

                while(pausado) {
                    Thread.sleep(1000);
                }
            }
            return i;
        }
        return null;
    }
}
