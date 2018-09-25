package com.lynden.example.latlong;
/****** TUTTO STO COSO DIVENTA PARTITA E FACCIAMO UNA VIEW SEPARATA *****/
import com.lynden.example.latlong.Giocatore;
import com.lynden.example.latlong.Percorso;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;

import java.io.IOException;
import java.net.URL;

import java.util.*;

import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import com.lynden.gmapsfx.service.geocoding.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import java.lang.*;


import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import netscape.javascript.JSObject;
//import sun.tools.tree.BooleanExpression;


import java.io.*;

public class Partita implements Initializable,MapComponentInitializedListener{


    @FXML
    private GoogleMapView googleMapView;
    private GoogleMap map;
    private Giocatore giocatore =new Giocatore(1,"Giocatore1");
    public Button dadoButton;
    public Label NumberDado;
    public Label NumeroMezzo;
    public Label ErroreDado;
    public ImageView DadoImage;  //per impostare immagine dado
    public Label CartaObiettivo;
    public Label CartaPercorsoPartenza;
    public Label CartaPercorsoArrivo;
    public Label GiocatoreName;
    private ArrayList<Giocatore> Giocatori=new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle rb){
        googleMapView.addMapInializedListener(this);



    }
    @Override
    public void mapInitialized(){
        ArrayList<Giocatore> giocatoreArrayList = new ArrayList<Giocatore>();
        Giocatore giocatore1=new Giocatore(3,"Giocatore2");
        this.Giocatori.add(giocatore);
        this.Giocatori.add(giocatore1);
        this.AvviaPartita("Europa");


    }

    public void AvviaPartita(String Nome_mappa)  {
        try{
            ViewMappa viewMappa=new ViewMappa(map,googleMapView,CartaObiettivo,CartaPercorsoPartenza,CartaPercorsoArrivo,GiocatoreName);
            viewMappa.Creamappa(this.Giocatori);
            Turno t= new Turno();
            Iniziale i=new Iniziale();
            ArrayList<Giocatore> giocatori_ordinati=i.OrdinaGiocatori(this.Giocatori);
            i.InizioTurno(giocatori_ordinati,giocatori_ordinati.get(0),Nome_mappa,t);
            Generale g =new Generale();
            for(int a=0;a<giocatori_ordinati.size();a++){
                g.InizioTurno(giocatori_ordinati,giocatori_ordinati.get(a),Nome_mappa,t);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }



    }



    /**********   Funzione per lanciare il Dado    ************/
    @FXML
    private void LanciaDado(final ActionEvent event) {
        event.consume();
       int n = giocatore.LanciaDado();
       giocatore.setMezzo(n);
       ViewDado viewDado =new ViewDado(dadoButton, NumeroMezzo,NumberDado,DadoImage,n);

    }




    /**********   Funzione calcolo randomico della Carta Obiettivo del Giocatore   ************/
    @FXML
    private void CartaObiettivo(final ActionEvent event) {
        /*event.consume();
        Random run = new Random();
        int n = run.nextInt(3)+1;
        if(n==1) {
            CartaObiettivo.setText("Città Obiettivo: Roma");
        }
        else if (n==2){
            CartaObiettivo.setText("Città Obiettivo: Parigi");
        }
        else if (n==3){
            CartaObiettivo.setText("Città Obiettivo: Milano");
        }
        CartaObiettivo.setTextFill(Color.web("white"));*/

    }







}
