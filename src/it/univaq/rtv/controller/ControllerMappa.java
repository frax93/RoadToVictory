package it.univaq.rtv.controller;

import it.univaq.rtv.Model.FacadePartita;


import it.univaq.rtv.Utility.Utility;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;

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


    public LatLong getCoordinateCentroMappa(String mappa) {
        System.out.println("CalcolaCentro");
        return getPartita().getMappa().CalcolaCentro();
    }

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

        this.getPartita().getGiocatori().get(gioc).PosizionaMezzo(this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella));
    }

    public void setMossaGioc(int gioc, int percorso, int casella){
        System.out.println("19");

        this.getPartita().getGiocatori().get(gioc).setMossa(this.getPartita().getMappa().DammiPercorsi().get(percorso).CalcolaCasellaVicina(this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella)));
    }

    public FacadePartita getPartita(){

        System.out.println("getPartita");
        return FacadePartita.getIstance();
    }

    public void setMosseGioc(int gioc,int percorso, int casella){
        System.out.println("20");

        this.getPartita().getGiocatori().get(gioc).setMosse(this.getPartita().CaselleVicini(percorso,casella));
    }

    public void Duplicati(){        System.out.println("21");

        this.getPartita().getMappa().RimuoviDuplicati(this.getPartita().getMappa().DammiPercorsi());
    }

    public boolean PosizionaMezzoPartita(Polyline finalPolyline1, PolylineOptions polylineOptions,int finalI,int j) throws IOException {
        System.out.println("22");
        return this.getPartita().PosizionaMezzo(finalPolyline1, polylineOptions,finalI,j);
    }

    public int getNumeroCitta(){
        return this.getPartita().getMappa().getCitta().size();
    }
}

