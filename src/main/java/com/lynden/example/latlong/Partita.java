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
    public Button dadoButton;
    public Label NumberDado;
    public Label NumeroMezzo;
    public Label ErroreDado;
    public ImageView DadoImage;  //per impostare immagine dado
    public Label CartaObiettivo;
    public Label CartaPercorsoPartenza;
    public Label CartaPercorsoArrivo;
    public Label GiocatoreName;
    public Button TurnoButton;
    private ArrayList<Giocatore> Giocatori=new ArrayList<>();
    private FMappa mappa;
    private ViewMappa viewMappa;
    private ViewDado viewDado;
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
        Giocatore giocatore1=new Giocatore(3,"Giocatore2","red");
        Giocatore giocatore2=new Giocatore(4,"Giocatore3","yellow");
        Giocatore giocatore =new Giocatore(1,"Giocatore1","orange");
        this.Giocatori.add(giocatore);
        this.Giocatori.add(giocatore1);
        //this.Giocatori.add(giocatore2);
        this.AvviaPartita("Europa");


    }

    public void AvviaPartita(String Nome_mappa)  {
        try{

            Turno t= new Turno();
            Iniziale i=new Iniziale();
            ArrayList<Giocatore> giocatori_ordinati=i.OrdinaGiocatori(this.Giocatori);
            Attesa attesa=new Attesa();
            giocatori_ordinati=i.InizioTurno(giocatori_ordinati,Nome_mappa,t, (Stato_Giocatore) attesa);
            this.Giocatori=giocatori_ordinati;
            /*for(int g=0;g<giocatori_ordinati.size();g++){
                System.out.println("Giocatore: "+giocatori_ordinati.get(g)+" Citta obiettivo: "+giocatori_ordinati.get(g).ChiediCartaObiettivo().getCittaObiettivo().getNome()+" Citta Partenza: "+ giocatori_ordinati.get(g).ChiediCartaPercorso().getCittaPartenza().getNome()+" Citta Arrivo: "+giocatori_ordinati.get(g).ChiediCartaPercorso().getCittaArrivo().getNome());
            }*/
            this.mappa=i.getMappa();
            this.viewMappa=new ViewMappa(map,googleMapView,CartaObiettivo,CartaPercorsoPartenza,CartaPercorsoArrivo,GiocatoreName,TurnoButton,NumeroMezzo);
            this.viewMappa.Creamappa(this.Giocatori,this.mappa,this);
            this.general=new Generale();
            this.Giocatori=this.general.InizioTurno(giocatori_ordinati,Nome_mappa,t,(Stato_Giocatore) this.gioca);
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
       this.viewDado =new ViewDado(dadoButton, NumeroMezzo,NumberDado,DadoImage,n);

    }

    public void PosizionaMezzo(Polyline finalPolyline1, PolylineOptions pippo, int finalI,ArrayList<Casella> caselle) throws FileNotFoundException,IOException {

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
            boolean vista = false;
            if ((LongCasellaInizio.getLatitude() == Lat && LongCasellaInizio.getLongitude() == Long) ||
                    (LongCasellaFine.getLatitude() == Lat && LongCasellaFine.getLongitude() == Long)) {

                Percorso PercorsoPremuto = null;
                PercorsoPremuto = this.mappa.getPercorsoByCasella(Casella_premuta);
                System.out.println("Id casella Arrivo: "+PercorsoPremuto.getCasellaArrivo().getId());
                System.out.println("Id casella Partenza: "+PercorsoPremuto.getCasellaPartenza().getId());
                System.out.println("Casella premuta: "+Casella_premuta.getId());
                //CODICE per scovare ed occupare le caselle gemelle
                if (Casella_premuta.getId() == PercorsoPremuto.getCasellaArrivo().getId() || Casella_premuta.getId() == PercorsoPremuto.getCasellaPartenza().getId()) {
                    System.out.println("Casella P/A");
                    ArrayList<Percorso> AllPercorsi = this.mappa.DammiPercorsi();
                    for (int g = 0; g < AllPercorsi.size(); g++) {
                        ArrayList<Casella> CasellePercorsi = AllPercorsi.get(g).getCaselle();
                        boolean vista2=false;
                        for (int g1 = 0; g1 < CasellePercorsi.size(); g1++) {

                            if (Math.abs(Casella_premuta.getInizio().getLatitude() - CasellePercorsi.get(g1).getInizio().getLatitude()) < 0.0005
                                    && Math.abs(Casella_premuta.getInizio().getLongitude() - CasellePercorsi.get(g1).getInizio().getLongitude()) < 0.05
                                    && CasellePercorsi.get(g1).getId() != Casella_premuta.getId()) {

                                for (int g2 = 0; g2 < this.Giocatori.get(0).getMosse().size(); g2++) {
                                    //aggiungi caselle dei percorsi vicini


                                    //PROBABILMENTE qui bisogna modificare perchè con 3 percorsi in alcuni casi raddoppia il numero di mezzi messi e persiste il problema (solo nel caso 3 percorsi se no va bene)
                                    if (Casella_premuta.getId() == this.Giocatori.get(0).getMosse().get(g2).getId()&&vista==false) {
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
                                        this.Giocatori.get(0).setMossa(AllPercorsi.get(g).CalcolaCaselleVicine(CasellePercorsi.get(g1)));
                                        this.Giocatori.get(0).setMossa(PercorsoPremuto.CalcolaCaselleVicine(Casella_premuta));
                                        CasellePercorsi.get(g1).PosizionaGiocatore(this.Giocatori.get(0));
                                        Casella_premuta.PosizionaGiocatore(this.Giocatori.get(0));
                                        System.out.println("gemelli");
                                        this.Giocatori.get(0).PosizionaMezzo(Casella_premuta);
                                        this.Giocatori.get(0).PosizionaMezzo(CasellePercorsi.get(g1));
                                        this.viewMappa.PosizionaMezzo(this.Giocatori.get(0).getMezzi().size(), finalPolyline1, pippo, this.Giocatori);
                                        this.Giocatori.get(0).removeMossa(Casella_premuta);
                                        vista=true;

                                    }  //problema da risolvere: nelle citta con 2 caselle devi cliccare 2 volte.
                                    else if(CasellePercorsi.get(g1).getId() == this.Giocatori.get(0).getMosse().get(g2).getId()&&vista2==false){
                                        ArrayList<Percorso> percorsi_vicini = new ArrayList<>();
                                        if (CasellePercorsi.get(g1).getId() == mappa.getPercorsoByCasella(CasellePercorsi.get(g1)).getCasellaPartenza().getId())
                                            percorsi_vicini = this.mappa.getViciniPercorsoPartenza(mappa.getPercorsoByCasella(CasellePercorsi.get(g1)));

                                        else if (CasellePercorsi.get(g1).getId() == mappa.getPercorsoByCasella(CasellePercorsi.get(g1)).getCasellaArrivo().getId())
                                            percorsi_vicini = this.mappa.getViciniPercorsoArrivo(mappa.getPercorsoByCasella(CasellePercorsi.get(g1)));

                                        if (percorsi_vicini.size() == 0) ;
                                        else {
                                            ArrayList<Casella> casellaArrayList = this.mappa.getCaselleVicinePercorsi(percorsi_vicini, CasellePercorsi.get(g1));
                                            casellaArrayList.remove(null);
                                            this.Giocatori.get(0).setMosse(casellaArrayList);
                                        }
                                        this.Giocatori.get(0).setMossa(AllPercorsi.get(g).CalcolaCaselleVicine(CasellePercorsi.get(g1)));

                                            CasellePercorsi.get(g1).PosizionaGiocatore(this.Giocatori.get(0));
                                        this.Giocatori.get(0).removeMossa(CasellePercorsi.get(g1));
                                            System.out.println("gemelli else if");


                                            if(vista==false){
                                                this.Giocatori.get(0).setMezzo(this.Giocatori.get(0).getMezzi().size()+1);
                                                this.Giocatori.get(0).PosizionaMezzo(CasellePercorsi.get(g1));
                                           // this.viewMappa.PosizionaMezzo(this.Giocatori.get(0).getMezzi().size(), finalPolyline1, pippo, this.Giocatori);
                                                vista=true;
                                            }

                                        vista2=true;



                                    }

                                }

                            }
                            else for(int g4=0; g4<this.Giocatori.get(0).getMosse().size(); g4++) {
                                if(Casella_premuta.getId()==this.Giocatori.get(0).getMosse().get(g4).getId()&&vista==false) {
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
                                    System.out.println("mezzo messo");
                                    vista=true;

                                }


                            }

                        }
                    }
                } else {
                    for (int d = 0; d < this.Giocatori.get(0).getMosse().size(); d++) {
                        if (Casella_premuta.getId() == this.Giocatori.get(0).getMosse().get(d).getId()) {
                            this.Giocatori.get(0).setMossa(PercorsoPremuto.CalcolaCaselleVicine(Casella_premuta));
                            this.Giocatori.get(0).PosizionaMezzo(Casella_premuta);
                            System.out.println("Casella normale");
                            this.viewMappa.PosizionaMezzo(this.Giocatori.get(0).getMezzi().size(), finalPolyline1, pippo, this.Giocatori);
                            this.Giocatori.get(0).removeMossa(Casella_premuta);
                        }
                    }
                }
            }
            System.out.println("Giocatore: "+this.Giocatori.get(0).getUsername());
        for (int g3 = 0; g3 < this.Giocatori.get(0).getMosse().size(); g3++) {

            System.out.println("Elenco Mosse:"+this.Giocatori.get(0).getMosse().get(g3).getId());}
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
                this.general.InizioTurno(this.Giocatori, "Europa", t, this.gioca);
                this.viewMappa.setCarte(this.Giocatori);
                this.viewMappa.setTurnoButton(false);
                this.viewMappa.setGiocatoreName(this.Giocatori.get(0));
            }
            catch (Exception e){
                System.out.println("Eccezione FineTurno");
            }


    }







}
