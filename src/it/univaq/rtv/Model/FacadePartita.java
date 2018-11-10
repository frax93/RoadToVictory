package it.univaq.rtv.Model;

import it.univaq.rtv.Model.Casella;
import it.univaq.rtv.Model.FactoryMappa.AbstractMappa;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.Percorso;
import it.univaq.rtv.Model.StatoGiocatore.Attesa;
import it.univaq.rtv.Model.StatoGiocatore.Gioca;
import it.univaq.rtv.Model.StatoGiocatore.Vincente;
import it.univaq.rtv.Model.StatoTurno.Generale;
import it.univaq.rtv.Model.StatoTurno.Iniziale;
import it.univaq.rtv.Model.Turno;
import it.univaq.rtv.Utility.Utility;
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

public class FacadePartita {


    @FXML
    private GoogleMapView googleMapView;
    private GoogleMap map;
    public Label SceltaGiocatori;
    public Label SceltaMappa;
    public Button Europa;
    public Button USA;
    public Button Africa;
    public Button Sud_America;
    public Button Asia;
    private String nomemappa="";
    public Button Uno;
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
    //public Label CartaPercorsoPartenza;
    //public Label CartaPercorsoArrivo;
    public Label GiocatoreName;
    public Label FinePartita;
    public Button TurnoButton;
    private ArrayList<Giocatore> Giocatori=new ArrayList<>();
    private ViewMappa viewMappa;
    private ViewDado viewDado;
    private AbstractMappa mappa;
    private Generale general;
    private Gioca gioca=new Gioca();
    private Vincente vince= new Vincente();
    //private ArrayList<Casella> Stato_attuale = new ArrayList<>();
    private ViewNumGiocatori ngioc;
    private ViewSceltaMappa scmapp;
    private String Numero="";
    private Timestamp timestamp;




    public void AvviaPartita(String Nome_mappa, GoogleMapView googleMapView, ArrayList<Giocatore> giocatoriArrayList,Label CartaObiettivo,Label CartapercorsoPartenza, Label CartapercorsoArrivo, Label GiocatoreName, Button TurnoButton,Label NumeroMezzo,Label FinePartita)  {
        try{

            Turno t= new Turno();
            Iniziale i=new Iniziale();
            ArrayList<Giocatore> giocatori_ordinati=i.OrdinaGiocatori(giocatoriArrayList);
            Attesa attesa=new Attesa();
            giocatori_ordinati=i.InizioTurno(giocatori_ordinati,Nome_mappa,t, attesa);
            giocatoriArrayList=giocatori_ordinati;
            this.mappa=i.getMappa();
            this.viewMappa=new ViewMappa(googleMapView, CartaObiettivo, CartapercorsoPartenza,CartapercorsoArrivo,GiocatoreName,TurnoButton,NumeroMezzo,FinePartita);
            this.viewMappa.Creamappa(giocatoriArrayList,this.mappa,this);
            this.general=new Generale();
            this.Giocatori=this.general.InizioTurno(giocatori_ordinati,Nome_mappa,t, this.gioca);
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }




    public void LanciaDado(Button dadoButton, Label NumeroMezzo, Label NumberDado, ImageView DadoImage, ArrayList<Giocatore> giocatoreArrayList) {
       int n = giocatoreArrayList.get(0).LanciaDado();
       giocatoreArrayList.get(0).setMezzo(n);
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



    public void FineTurno() {
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
