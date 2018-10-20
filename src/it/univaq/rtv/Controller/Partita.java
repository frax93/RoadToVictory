package it.univaq.rtv.Controller;

import it.univaq.rtv.Model.Casella;
import it.univaq.rtv.Model.FactoryMappa.IMappa;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.Percorso;
import it.univaq.rtv.Model.StatoGiocatore.Attesa;
import it.univaq.rtv.Model.StatoGiocatore.Gioca;
import it.univaq.rtv.Model.StatoGiocatore.Vincente;
import it.univaq.rtv.Model.StatoTurno.Generale;
import it.univaq.rtv.Model.StatoTurno.Iniziale;
import it.univaq.rtv.Model.Turno;
import it.univaq.rtv.View.ViewDado;
import it.univaq.rtv.View.ViewMappa;
import it.univaq.rtv.View.ViewNumGiocatori;
import it.univaq.rtv.View.ViewSceltaMappa;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;

import java.io.IOException;
import java.net.URL;

import java.sql.Timestamp;
import java.util.*;

import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import java.lang.*;


import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.*;


import java.io.*;

public class Partita implements Initializable,MapComponentInitializedListener{


    @FXML
    private GoogleMapView googleMapView;
    private GoogleMap map;
    public Label SceltaGiocatori;
    public Label SceltaMappa;
    public Button Europa;
    public Button America;
    private String nomemappa;
    public Button Sei;
    public Button Due;
    public Button Tre;
    public Button Quattro;
    public Button Cinque;
    public Label InizioPartita;
    public AnchorPane menu;
    public Label ScrittaGiocatori;
    public Button dadoButton;
    public Label NumberDado;
    public Label NumeroMezzo;
    public Label ErroreDado;
    public ImageView DadoImage;  //per impostare immagine dado
    public Label CartaObiettivo;
    public Label CartaPercorsoPartenza;
    public Label CartaPercorsoArrivo;
    public Label GiocatoreName;
    public Label FinePartita;
    public Button TurnoButton;
    private ArrayList<Giocatore> Giocatori=new ArrayList<>();
    private ViewMappa viewMappa;
    private ViewDado viewDado;
    private IMappa mappa;
    private Generale general;
    private Gioca gioca=new Gioca();
    private Vincente vince= new Vincente();
    //private ArrayList<Casella> Stato_attuale = new ArrayList<>();
    private ViewNumGiocatori ngioc;
    private ViewSceltaMappa scmapp;
    private int Numero=0;
    private Timestamp timestamp;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        //googleMapView.addMapInializedListener(this);



    }
    @Override
    public void mapInitialized(){
        if(this.Numero!=0){
            switch(this.Numero){
                case 2:
                    Giocatore giocatore1 = new Giocatore(1, "Giocatore1", "red");
                    Giocatore giocatore2 = new Giocatore(2, "Giocatore2", "aqua");
                    this.Giocatori.add(giocatore1);
                    this.Giocatori.add(giocatore2);
                case 3:
                    giocatore1 = new Giocatore(1, "Giocatore1", "red");
                    giocatore2 = new Giocatore(2, "Giocatore2", "aqua");
                    Giocatore giocatore3 = new Giocatore(3, "Giocatore3", "orange");
                    this.Giocatori.add(giocatore1);
                    this.Giocatori.add(giocatore2);
                    this.Giocatori.add(giocatore3);
                case 4:
                    giocatore1 = new Giocatore(1, "Giocatore1", "red");
                    giocatore2 = new Giocatore(2, "Giocatore2", "aqua");
                    giocatore3 = new Giocatore(3, "Giocatore3", "orange");
                    Giocatore giocatore4 = new Giocatore(4, "Giocatore4", "pink");
                    this.Giocatori.add(giocatore1);
                    this.Giocatori.add(giocatore2);
                    this.Giocatori.add(giocatore3);
                    this.Giocatori.add(giocatore4);
                case 5:
                    giocatore1 = new Giocatore(1, "Giocatore1", "red");
                    giocatore2 = new Giocatore(2, "Giocatore2", "aqua");
                    giocatore3 = new Giocatore(3, "Giocatore3", "orange");
                    giocatore4 = new Giocatore(4, "Giocatore4", "pink");
                    Giocatore giocatore5 = new Giocatore(5, "Giocatore5", "teal");
                    this.Giocatori.add(giocatore1);
                    this.Giocatori.add(giocatore2);
                    this.Giocatori.add(giocatore3);
                    this.Giocatori.add(giocatore4);
                    this.Giocatori.add(giocatore5);
                case 6:
                    giocatore1 = new Giocatore(1, "Giocatore1", "red");
                    giocatore2 = new Giocatore(2, "Giocatore2", "aqua");
                    giocatore3 = new Giocatore(3, "Giocatore3", "orange");
                    giocatore4 = new Giocatore(4, "Giocatore4", "pink");
                    giocatore5 = new Giocatore(5, "Giocatore5", "teal");
                    Giocatore giocatore6 = new Giocatore(6, "Giocatore6", "black");
                    this.Giocatori.add(giocatore1);
                    this.Giocatori.add(giocatore2);
                    this.Giocatori.add(giocatore3);
                    this.Giocatori.add(giocatore4);
                    this.Giocatori.add(giocatore5);
                    this.Giocatori.add(giocatore6);
            }
        }
        if(this.nomemappa!=null){
            this.AvviaPartita(nomemappa);}
        //this.wait(1000);
        //this.viewMappa.setTurnoButton(false);

    }

    public void AvviaPartita(String Nome_mappa)  {
        try{

            Turno t= new Turno();
            Iniziale i=new Iniziale();
            ArrayList<Giocatore> giocatori_ordinati=i.OrdinaGiocatori(this.Giocatori);
            Attesa attesa=new Attesa();
            giocatori_ordinati=i.InizioTurno(giocatori_ordinati,Nome_mappa,t, attesa);
            this.Giocatori=giocatori_ordinati;
            this.mappa=i.getMappa();
            this.viewMappa=new ViewMappa(map,googleMapView,CartaObiettivo,CartaPercorsoPartenza,CartaPercorsoArrivo,GiocatoreName,TurnoButton,NumeroMezzo,FinePartita);
            this.viewMappa.Creamappa(this.Giocatori,this.mappa,this);
            this.general=new Generale();
            this.Giocatori=this.general.InizioTurno(giocatori_ordinati,Nome_mappa,t, this.gioca);
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }

    @FXML
    private void Europa(final ActionEvent event){
        event.consume();
        this.nomemappa="Europa";
        this.mapInitialized();
        this.scmapp=new ViewSceltaMappa(SceltaMappa,Europa,America,SceltaGiocatori,InizioPartita,menu,ScrittaGiocatori);
    }
    @FXML
    private void America(final ActionEvent event){
        event.consume();
        this.nomemappa="America";
        this.mapInitialized();
        this.scmapp=new ViewSceltaMappa(SceltaMappa,Europa,America,SceltaGiocatori,InizioPartita,menu,ScrittaGiocatori);
    }
    @FXML
    private void N2(final ActionEvent event){
        event.consume();
        this.Numero=2;
        this.ngioc=new ViewNumGiocatori(SceltaGiocatori,Due,Tre,Quattro,Cinque,Sei,InizioPartita,menu,SceltaMappa,Europa,America,ScrittaGiocatori);
    }
    @FXML
    private void N3(final ActionEvent event) {
        event.consume();
        this.Numero=3;
        this.ngioc=new ViewNumGiocatori(SceltaGiocatori,Due,Tre,Quattro,Cinque,Sei,InizioPartita,menu,SceltaMappa,Europa,America,ScrittaGiocatori);
    } @FXML
    private void N4(final ActionEvent event) {
        event.consume();
        this.Numero=4;
        this.ngioc=new ViewNumGiocatori(SceltaGiocatori,Due,Tre,Quattro,Cinque,Sei,InizioPartita,menu,SceltaMappa,Europa,America,ScrittaGiocatori);
    } @FXML
    private void N5(final ActionEvent event) {
        event.consume();
        this.Numero=5;
        this.ngioc=new ViewNumGiocatori(SceltaGiocatori,Due,Tre,Quattro,Cinque,Sei,InizioPartita,menu,SceltaMappa,Europa,America,ScrittaGiocatori);
    }
    @FXML
    private void N6(final ActionEvent event) {
        event.consume();
        this.Numero=6;
        this.ngioc=new ViewNumGiocatori(SceltaGiocatori,Due,Tre,Quattro,Cinque,Sei,InizioPartita,menu,SceltaMappa,Europa,America,ScrittaGiocatori);
    }

    /**********   Funzione per lanciare il Dado    ************/
    @FXML
    private void LanciaDado(final ActionEvent event) {
        event.consume();
       int n = this.Giocatori.get(0).LanciaDado();
       this.Giocatori.get(0).setMezzo(n);
       this.viewDado =new ViewDado(dadoButton, NumeroMezzo,NumberDado,DadoImage,n);
       //this.timestamp = new Timestamp(System.currentTimeMillis());

    }

    public void PosizionaMezzo(Polyline finalPolyline1, PolylineOptions pippo, int finalI,ArrayList<Casella> caselle) throws FileNotFoundException,IOException {
System.out.println("Aspettiamo: "+System.currentTimeMillis());
//possibilità di fare il controllo sul tempo ma va ovviamente sistemato perchè serve un coontrollo sulle mosse finite e sul tempo di inattività
//if(System.currentTimeMillis() - this.timestamp.getTime()>1000){this.viewMappa.setTurnoButton(true);}
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

        //System.out.println(Casella_premuta.getInizio().getLatitude());
            if ((LongCasellaInizio.getLatitude() == Lat && LongCasellaInizio.getLongitude() == Long) ||
                    (LongCasellaFine.getLatitude() == Lat && LongCasellaFine.getLongitude() == Long)) {

                Percorso PercorsoPremuto = null;
                PercorsoPremuto = mappa.getPercorsoByCasella(Casella_premuta);
                //System.out.println("Id casella Arrivo: "+PercorsoPremuto.getCasellaArrivo().getId());
                //System.out.println("Id casella Partenza: "+PercorsoPremuto.getCasellaPartenza().getId());
                //System.out.println("Casella premuta: "+Casella_premuta.getId());

                                for (int g2 = 0; g2 < this.Giocatori.get(0).getMosse().size(); g2++) {
                                    //aggiungi caselle dei percorsi vicini
                                    if (Casella_premuta.getId() == this.Giocatori.get(0).getMosse().get(g2).getId()) {
                                        ArrayList<Percorso> percorsi_vicini = new ArrayList<>();
                                        if (Casella_premuta.getId() == PercorsoPremuto.getCasellaPartenza().getId())
                                            percorsi_vicini = this.mappa.getViciniPercorsoPartenza(PercorsoPremuto);

                                        else if (Casella_premuta.getId() == PercorsoPremuto.getCasellaArrivo().getId())
                                            percorsi_vicini = this.mappa.getViciniPercorsoArrivo(PercorsoPremuto);

                                        if (percorsi_vicini.size() == 0) ;
                                        else {
                                            ArrayList<Casella> casellaArrayList = this.mappa.getCaselleVicinePercorsi(percorsi_vicini, Casella_premuta);
                                            casellaArrayList.remove(null);
                                            this.Giocatori.get(0).setMosse(casellaArrayList);
                                        }
                                        this.Giocatori.get(0).setMossa(PercorsoPremuto.CalcolaCaselleVicine(Casella_premuta));
                                        this.Giocatori.get(0).PosizionaMezzo(Casella_premuta);
                                        this.viewMappa.PosizionaMezzo(this.Giocatori.get(0).getMezzi().size(), finalPolyline1, pippo, this.Giocatori);
                                        this.Giocatori.get(0).removeMossa(Casella_premuta);
                                        if(Math.abs(Casella_premuta.getInizio().getLatitude()-this.Giocatori.get(0).ChiediCartaObiettivo().getCittaObiettivo().getCoordinate().getLatitude())<0.005){
                                            this.Giocatori.get(0).Obiettivoraggiunto();
                                            this.viewMappa.setObiettivo(this.Giocatori);
                                        }
                                        if(Math.abs(Casella_premuta.getInizio().getLatitude()-this.Giocatori.get(0).ChiediCartaPercorso().getCittaArrivo().getCoordinate().getLatitude())<0.005){
                                            this.Giocatori.get(0).Arrivoraggiunto();
                                            this.viewMappa.setArrivo(this.Giocatori);
                                        }
                                        if(this.Giocatori.get(0).getObiettivo()==true && this.Giocatori.get(0).getArrivo()==true) {
                                            this.Giocatori.get(0).setState(vince);
                                            this.viewMappa.FinePartita(this.Giocatori.get(0));
                                        }
                                        break;


                                    }


                                    }

                                }

                            }















    /**********   Funzione calcolo randomico della Carta Obiettivo del Giocatore   ************/
    @FXML
    private void FineTurno(final ActionEvent event) {
            try{
                Turno t = new Turno();
                Giocatore giocatore_backup = this.Giocatori.get(0);
                this.Giocatori.remove(giocatore_backup);
                this.Giocatori.add(this.Giocatori.size(), giocatore_backup);
                this.viewDado.setDadoButton();
                this.general.InizioTurno(this.Giocatori, this.mappa.getNome(), t, this.gioca);
                this.general.Fineturno(this.Giocatori.get(0));
                this.viewMappa.setCarte(this.Giocatori);
                this.viewMappa.setObiettivo(this.Giocatori);
                this.viewMappa.setArrivo(this.Giocatori);
                this.viewMappa.setTurnoButton(false);
                this.viewMappa.setGiocatoreName(this.Giocatori.get(0));
            }
            catch (Exception e){
                e.printStackTrace();
            }


    }









}
