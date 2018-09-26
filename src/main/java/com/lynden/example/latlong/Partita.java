package com.lynden.example.latlong;
/****** TUTTO STO COSO DIVENTA PARTITA E FACCIAMO UNA VIEW SEPARATA *****/
import com.lynden.example.latlong.Gioca;
import com.lynden.example.latlong.Giocatore;
import com.lynden.example.latlong.Percorso;

import com.lynden.example.latlong.State_Turno;
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


import javax.swing.plaf.nimbus.State;
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
    private FMappa mappa;
    private ViewMappa viewMappa;
    private Generale general;
    private Gioca gioca=new Gioca();
    private ArrayList<Casella> Stato_attuale = new ArrayList<>();


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

            Turno t= new Turno();
            Iniziale i=new Iniziale();
            ArrayList<Giocatore> giocatori_ordinati=i.OrdinaGiocatori(this.Giocatori);
            Attesa attesa=new Attesa();
            giocatori_ordinati=i.InizioTurno(giocatori_ordinati,giocatori_ordinati.get(0),Nome_mappa,t, (Stato_Giocatore) attesa);
            this.Giocatori=giocatori_ordinati;
            this.mappa=i.getMappa();
            this.viewMappa=new ViewMappa(map,googleMapView,CartaObiettivo,CartaPercorsoPartenza,CartaPercorsoArrivo,GiocatoreName);
            this.viewMappa.Creamappa(this.Giocatori,this.mappa,this);
            this.Giocatori=this.general.InizioTurno(giocatori_ordinati,giocatori_ordinati.get(0),Nome_mappa,t,(Stato_Giocatore) this.gioca);

        }
        catch (Exception e) {
            System.out.println(e);
        }



    }



    /**********   Funzione per lanciare il Dado    ************/
    @FXML
    private void LanciaDado(final ActionEvent event) {
        event.consume();
       int n = this.Giocatori.get(0).LanciaDado();
       this.Giocatori.get(0).setMezzo(n);
       ViewDado viewDado =new ViewDado(dadoButton, NumeroMezzo,NumberDado,DadoImage,n);

    }

    public void PosizionaMezzo(Polyline finalPolyline1, PolylineOptions pippo, int finalI, ArrayList<Casella> casellas,ArrayList<Casella> caselle) throws FileNotFoundException,IOException{
        if(this.Giocatori.get(0).getMezzi()==null){
            Turno t= new Turno();
            Giocatore giocatore_backup=this.Giocatori.get(0);
            System.out.println(this.Giocatori.get(0));
            this.Giocatori.remove(giocatore_backup);
            System.out.println(this.Giocatori.get(0));
            this.Giocatori.add(this.Giocatori.size()-1,giocatore_backup);
            this.general.InizioTurno(this.Giocatori,this.Giocatori.get(0),"Europa",t,this.gioca);
            //this.viewMappa.setGiocatoreName(this.Giocatori.get(0));
        }
        else{
        this.Stato_attuale=casellas;
        this.viewMappa.setGiocatoreName(this.Giocatori.get(0));
        MVCArray path = finalPolyline1.getPath();
        pippo.path(path);
        String coordinata = String.valueOf(path.getAt(0));
        String[] LatLinea = coordinata.split(",");
        double Lat = Double.valueOf(LatLinea[0].replace("(", ""));
        double Long = Double.valueOf(LatLinea[1].replace(")", ""));
        LatLong LongCasellaInizio = caselle.get(finalI).getInizio();
        LatLong LongCasellaFine = caselle.get(finalI).getFine();
        Casella Casella_premuta = caselle.get(finalI);


        if ((LongCasellaInizio.getLatitude() == Lat && LongCasellaInizio.getLongitude() == Long) ||
                (LongCasellaFine.getLatitude() == Lat && LongCasellaFine.getLongitude() == Long)) {


            Percorso PercorsoPremuto = null;
            PercorsoPremuto = this.mappa.getPercorsoByCasella(Casella_premuta);

            for (int d = 0; d < this.Stato_attuale.size(); d++) {

                if (Casella_premuta.getId() == this.Stato_attuale.get(d).getId()) {
                    this.Stato_attuale.add(PercorsoPremuto.CalcolaCaselleVicine(Casella_premuta));
                    this.Stato_attuale.remove(Casella_premuta);
                    ArrayList<Percorso> percorsi_vicini = new ArrayList<>();
                    if (Casella_premuta.getId() == PercorsoPremuto.getCasellaPartenza().getId())
                        percorsi_vicini = this.mappa.getViciniPercorsoPartenza(PercorsoPremuto);

                    else if (Casella_premuta.getId() == PercorsoPremuto.getCasellaArrivo().getId())
                        percorsi_vicini = this.mappa.getViciniPercorsoArrivo(PercorsoPremuto);

                    if (percorsi_vicini.size() == 0) ;
                    else {
                        ArrayList<Casella> casellaArrayList = this.mappa.getCaselleVicinePercorsi(percorsi_vicini, Casella_premuta);
                        casellaArrayList.remove(null);
                        this.Stato_attuale.addAll(casellaArrayList);
                    }
                    this.Giocatori.get(0).PosizionaMezzo(Casella_premuta);
                    this.viewMappa.PosizionaMezzo(this.Giocatori.get(0).getMezzi().size(),finalPolyline1, pippo, this.Giocatori);
                    }
                }
            }
        }
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
