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
    private Label cartaObiettivo;
    private Label cartaPercorsoPartenza;
    private Label cartaPercorsoArrivo;
    private Label giocatoreName;
    private Label finePartita;
    private Button turnoButton;
    private Label numeroMezzo;

    public ControllerMappa(GoogleMapView googleMapView, Label CartaObiettivo, Label CartapercorsoPartenza, Label CartapercorsoArrivo, Label GiocatoreName, Button TurnoButton, Label NumeroMezzo, Label FinePartita) {
        this.googleMapView = googleMapView;
        this.giocatoreName = GiocatoreName;
        this.cartaObiettivo = CartaObiettivo;
        this.cartaPercorsoArrivo = CartapercorsoArrivo;
        this.cartaPercorsoPartenza = CartapercorsoPartenza;
        this.turnoButton = TurnoButton;
        this.finePartita = FinePartita;
        this.numeroMezzo = NumeroMezzo;

    }


    public boolean controlloObiettivo(){
        if (this.getPartita().getGiocatori().get(0).getObiettivo()) {
           return true;
        }
        else return false;
    }



    public boolean controlloArrivo() {
        if (this.getPartita().getGiocatori().get(0).getArrivo()) {


            return true;
            }
        else return false;
        }



    public boolean controlloFine( ){
            if (this.controlloObiettivo() && this.controlloArrivo()) {

                return true;
        }
        else return false;

    }

    public String getColoreGiocatore(int i){

        return this.getPartita().getGiocatori().get(i).getColor();
    }

    public String getUsername(int i){
        return this.getPartita().getGiocatori().get(i).getUsername();
    }


    public String getNomeCPCittaPartenza(int gioc){

        return this.getPartita().getGiocatori().get(gioc).ChiediCartaPercorso().getCittaPartenza().getNome();

    }

    public String getNomeCPCittaArrivo(int gioc){

        return this.getPartita().getGiocatori().get(gioc).ChiediCartaPercorso().getCittaArrivo().getNome();

    }

    public String getNomeCittaObiettivo(int gioc){

        return this.getPartita().getGiocatori().get(gioc).ChiediCartaObiettivo().getCittaObiettivo().getNome();

    }

    public void occupaCittaPartenza(int i){

        this.getPartita().getGiocatori().get(i).ChiediCartaPercorso().getCittaPartenza().setOccupata(true);
    }

    public void setMezzoGioc(int i, int j, String mezzo){

        this.getPartita().setIMezzoGioc(i,j,mezzo);
    }




    public int getNumGiocatori(){
        return this.getPartita().getGiocatori().size();
    }

    public int getNumMezzi(int gioc){
        return this.getPartita().getGiocatori().get(gioc).getMezzi().size();
    }


    public LatLong getCoordinateCentroMappa(String mappa) {
        return getPartita().getMappa().CalcolaCentro();
    }

    public int getNumPercorsiMappa(){
        return this.getPartita().getMappa().DammiPercorsi().size();
    }

    public int getNumCasellePercorso(int percorso){
        return this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().size();
    }

    public boolean isPartenza(int gioc, int percorso, int casella){
        return Utility.IsPartenza(this.getPartita().getGiocatori().get(gioc),this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella));
    }

    public LatLong getInizioCasella(int percorso,int casella){
        return this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella).getInizio();
    }

    public LatLong getFineCasella(int percorso,int casella){
        return this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella).getFine();
    }



    public void setMezzo(int gioc,int i){
        this.getPartita().getGiocatori().get(gioc).setMezzo(i);
    }

    public void posizionaMezzoGioc(int gioc, int percorso, int casella){
        this.getPartita().getGiocatori().get(gioc).PosizionaMezzo(this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella));
    }

    public void setMossaGioc(int gioc, int percorso, int casella){
        this.getPartita().getGiocatori().get(gioc).setMossa(this.getPartita().getMappa().DammiPercorsi().get(percorso).CalcolaCasellaVicina(this.getPartita().getMappa().DammiPercorsi().get(percorso).getCaselle().get(casella)));
    }

    public FacadePartita getPartita(){

        return FacadePartita.getIstance();
    }

    public void setMosseGioc(int gioc,int percorso, int casella){
        this.getPartita().getGiocatori().get(gioc).setMosse(this.getPartita().CaselleVicini(percorso,casella));
    }

    public void duplicati(){
        this.getPartita().getMappa().RimuoviDuplicati(this.getPartita().getMappa().DammiPercorsi());
    }

    public boolean posizionaMezzoPartita(Polyline finalPolyline1, PolylineOptions polylineOptions, int finalI, int j) throws IOException {
        return this.getPartita().PosizionaMezzo(finalPolyline1, polylineOptions,finalI,j);
    }

    public int getNumeroCitta(){
        return this.getPartita().getMappa().getCitta().size();
    }
}

