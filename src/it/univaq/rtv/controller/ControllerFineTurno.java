package it.univaq.rtv.controller;
import it.univaq.rtv.Model.FacadePartita;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerFineTurno {
    private Button TurnoButton;

    public void ControllerMappa(Button TurnoButton) {
        this.TurnoButton = TurnoButton;
    }

    public void FinisciTurno(){
        System.out.println("Sei in finisci turno");
        FacadePartita.getIstance().setGiocatori(FacadePartita.getIstance().FineTurno());

    }

}
