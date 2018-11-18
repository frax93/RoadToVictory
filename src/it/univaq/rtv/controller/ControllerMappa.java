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
        if (this.getPartita().getGiocatori().get(0).getObiettivo()) {
           return true;
        }
        else return false;
    }



    public boolean ControlloArrivo() {
        if (this.getPartita().getGiocatori().get(0).getArrivo()) {
            System.out.println("1");

            return true;
            }
        else return false;
        }



    public boolean ControlloFine( ){
            if (this.ControlloObiettivo() && this.ControlloArrivo()) {
                System.out.println("2");

                return true;
        }
        else return false;

    }

    public String getColoreGiocatore(int i){        System.out.println("3");

        return this.getPartita().getGiocatori().get(i).getColor();
    }

    public String getUsername(int i){
        System.out.println("4");
        return this.getPartita().getGiocatori().get(i).getUsername();
    }


    public String getNomeCPCittaPartenza(int gioc){        System.out.println("5");

        return this.getPartita().getGiocatori().get(gioc).ChiediCartaPercorso().getCittaPartenza().getNome();

    }

    public String getNomeCPCittaArrivo(int gioc){        System.out.println("6");

        return this.getPartita().getGiocatori().get(gioc).ChiediCartaPercorso().getCittaArrivo().getNome();

    }

    public String getNomeCittaObiettivo(int gioc){        System.out.println("7");

        return this.getPartita().getGiocatori().get(gioc).ChiediCartaObiettivo().getCittaObiettivo().getNome();

    }

    public void OccupaCittaPartenza(int i){        System.out.println("8");

        this.getPartita().getGiocatori().get(i).ChiediCartaPercorso().getCittaPartenza().setOccupata(true);
    }

    public void setMezzoGioc(int i, int j, String mezzo){        System.out.println("9");

        this.getPartita().setIMezzoGioc(i,j,mezzo);
    }




    public int getNumGiocatori(){
        System.out.println("10");
        return this.getPartita().getGiocatori().size();
    }

    public int getNumMezzi(int gioc){
        System.out.println("11");
        return this.getPartita().getGiocatori().get(gioc).getMezzi().size();
    }

    /*
    public LatLong getCoordinateCentroMappa(String mappa){
        return FacadePartita.getIstance().AvviaPartita(mappa,FacadePartita.getIstance().getGiocatori()).CalcolaCentro();
    }*/

    public int getNumPercorsiMappa(){
        System.out.println("12");
        return this.getPartita().getMappa().DammiPercorsi().size();
    }

    public int getNumCasellePercorso(int percorso){        System.out.println("13");

        return this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().size();
    }

    public boolean IsPartenza(int gioc, int percorso, int casella){
        System.out.println("14");
        return Utility.IsPartenza(this.getPartita().getGiocatori().get(gioc),this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella));
    }

    public LatLong getInizioCasella(int percorso,int casella){
        System.out.println("15");

        return this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella).getInizio();
    }

    public LatLong getFineCasella(int percorso,int casella){
        System.out.println("16");

        return this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella).getFine();
    }



    public void setMezzo(int gioc,int i){
        System.out.println("17");
        this.getPartita().getGiocatori().get(gioc).setMezzo(i);
    }

    public void PosizionaMezzoGioc(int gioc, int percorso, int casella){
        System.out.println("18");

        this.getPartita().getGiocatori().get(gioc).PosizionaMezzo(FacadePartita.getIstance().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella));
    }

    public void setMossaGioc(int gioc, int percorso, int casella){
        System.out.println("19");

        this.getPartita().getGiocatori().get(gioc).setMossa(FacadePartita.getIstance().getMappa().DammiPercorsi().get(percorso).CalcolaCasellaVicina(FacadePartita.getIstance().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella)));
    }

    public FacadePartita getPartita(){

        System.out.println("getPartita");
        return FacadePartita.getIstance();
    }

    public void setMosseGioc(int gioc,int percorso, int casella){
        System.out.println("20");

        this.getPartita().getGiocatori().get(gioc).setMosse(FacadePartita.getIstance().CaselleVicini(percorso,casella));
    }

    public ArrayList<Percorso> Duplicati(){        System.out.println("21");

        return this.getPartita().getMappa().RimuoviDuplicati(FacadePartita.getIstance().getMappa().DammiPercorsi());
    }

    public boolean PosizionaMezzoPartita(Polyline finalPolyline1, PolylineOptions polylineOptions,int finalI,ArrayList<Casella> caselle) throws IOException {
        System.out.println("22");
        return this.getPartita().PosizionaMezzo(finalPolyline1, polylineOptions,finalI,caselle);
    }
}

