package it.univaq.rtv.Utility;

import it.univaq.rtv.Model.FacadePartita;
import it.univaq.rtv.controller.ControllerDado;
import it.univaq.rtv.controller.ControllerMappa;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask{

    private Label giocatoreName;
    private Label cartaPercorsoArrivo;
    private Label cartaPercorsoPartenza;
    private Label cartaObiettivo;
    private Label numeroMezzo;
    private Button turnoButton;

    private ControllerMappa controllerMappa;
    private ControllerDado controllerDado;
    private FacadePartita facadePartita;

    /**
     * @param giocatoreName
     * @param cartaPercorsoArrivo
     * @param cartaPercorsoPartenza
     * @param cartaObiettivo
     * @param numeroMezzo
     * @param turnoButton
     * @param controllerMappa
     * @param controllerDado
     * @param facadePartita
     */
    public MyTimerTask(Label giocatoreName, Label cartaPercorsoArrivo, Label cartaPercorsoPartenza, Label cartaObiettivo, Label numeroMezzo, Button turnoButton, ControllerMappa controllerMappa, ControllerDado controllerDado, FacadePartita facadePartita) {
        this.giocatoreName = giocatoreName;
        this.cartaPercorsoArrivo = cartaPercorsoArrivo;
        this.cartaPercorsoPartenza = cartaPercorsoPartenza;
        this.cartaObiettivo = cartaObiettivo;
        this.numeroMezzo = numeroMezzo;
        this.turnoButton= turnoButton;
        this.controllerMappa = controllerMappa;
        this.controllerDado = controllerDado;
        this.facadePartita = facadePartita;
    }

    @Override
    public void run() {
        this.controllerDado.setDadoButton();
        this.controllerDado.setImageDado(false);
        facadePartita.getGiocatori().get(0).removeAllMezzi(facadePartita.getGiocatori().get(facadePartita.getGiocatori().size()-1).getMezzi().size(), "Vagone");
        this.facadePartita.fineTurno();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setGiocatoreName();
                numeroMezzo.setText(String.valueOf(0));
                System.out.println("Prima " + facadePartita.getGiocatori().get(0).getMezzi().size());
                System.out.println("Dopo " + facadePartita.getGiocatori().get(0).getMezzi().size());
                setCarte();
                setObiettivo();
                setArrivo();
                turnoButton.setVisible(false);
            }
        });
        this.cancel();
    }

    /**
     *
     */
    public void setGiocatoreName(){
        giocatoreName.setText(facadePartita.getGiocatori().get(0).getUsername());
        String color= Utility.colorToRgba(controllerMappa.getColoreGiocatore(0));
        String style = "-fx-background-color:"+color;
        giocatoreName.setStyle(style);
    }


    /**
     *
     */
    public void setCarte(){
        cartaObiettivo.setText("Città obiettivo: " + controllerMappa.getNomeCittaObiettivo(0));
        cartaPercorsoPartenza.setText("Partenza:" + controllerMappa.getNomeCPCittaPartenza(0));
        cartaPercorsoArrivo.setText("Arrivo:" + controllerMappa.getNomeCPCittaArrivo(0));
    }

    /**
     *
     */
    public void setObiettivo(){
        if(controllerMappa.getPartita().getGiocatori().get(0).getObiettivo()==true) {
            String style = "-fx-background-color:" + Utility.colorToRgba("green");
            cartaObiettivo.setStyle(style);
        }
        else {
            cartaObiettivo.setTextFill(Color.web("black"));
            String style = "-fx-background-color:"+Utility.colorToRgba("white");
            cartaObiettivo.setStyle(style);
        }
    }


    /**
     *
     */
    public void setArrivo(){
        if(controllerMappa.getPartita().getGiocatori().get(0).getArrivo()==true) {
            String style = "-fx-background-color:" +Utility.colorToRgba("green");
            cartaPercorsoArrivo.setStyle(style);
        }
        else {
            cartaObiettivo.setTextFill(Color.web("black"));
            String style = "-fx-background-color:"+Utility.colorToRgba("white");
            cartaPercorsoArrivo.setStyle(style);
        }
    }




}

