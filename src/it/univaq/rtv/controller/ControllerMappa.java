package it.univaq.rtv.controller;

import it.univaq.rtv.Model.FacadePartita;

import it.univaq.rtv.Model.*;
import it.univaq.rtv.Model.FactoryMappa.AbstractMappa;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;
import it.univaq.rtv.Model.StatoGiocatore.Vincente;
import it.univaq.rtv.Utility.Utility;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import netscape.javascript.JSObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerMappa {
    private Vincente vincente= new Vincente();

    @FXML
    private GoogleMapView googleMapView;
    private GoogleMap map;
    private Label CartaObiettivo;
    private Label CartaPercorsoPartenza;
    private Label CartaPercorsoArrivo;
    private Label GiocatoreName;
    private Label FinePartita;
    private Button TurnoButton;
    private Label NumeroMezzo;

    public ControllerMappa(GoogleMapView googleMapView, Label CartaObiettivo, Label CartapercorsoPartenza, Label CartapercorsoArrivo, Label GiocatoreName, Button TurnoButton, Label NumeroMezzo, Label FinePartita) {
        this.googleMapView = googleMapView;
        this.GiocatoreName = GiocatoreName;
        this.CartaObiettivo = CartaObiettivo;
        this.CartaPercorsoArrivo = CartapercorsoArrivo;
        this.CartaPercorsoPartenza = CartapercorsoPartenza;
        this.TurnoButton = TurnoButton;
        this.FinePartita = FinePartita;
        this.NumeroMezzo = NumeroMezzo;

    }


    public boolean ControlloObiettivo(){
        if (FacadePartita.getIstance().getGiocatori().get(0).getObiettivo()) {
           return true;
        }
        else return false;
    }



    public boolean ControlloArrivo() {
        if (FacadePartita.getIstance().getGiocatori().get(0).getArrivo()) {
            return true;
            }
        else return false;
        }



    public boolean ControlloFine( ){
            if (this.ControlloObiettivo() && this.ControlloArrivo()) {
                return true;
        }
        else return false;

    }

        public Giocatore getGioc(){
                return FacadePartita.getIstance().getGiocatori().get(0);
        }

        public String getColoreGiocatore(){
        return FacadePartita.getIstance().getGiocatori().get(0).getColor();
        }

        public String getUsername(){
        return FacadePartita.getIstance().getGiocatori().get(0).getUsername();
        }






}

