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

    /**
     * @param googleMapView
     * @param CartaObiettivo
     * @param CartapercorsoPartenza
     * @param CartapercorsoArrivo
     * @param GiocatoreName
     * @param TurnoButton
     * @param NumeroMezzo
     * @param FinePartita
     */
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


    /**
     * @return
     */
    public boolean controlloObiettivo(){
        if (this.getPartita().getGiocatori().get(0).getObiettivo()) {
           return true;
        }
        else return false;
    }


    /**
     * @return
     */
    public boolean controlloArrivo() {
        if (this.getPartita().getGiocatori().get(0).getArrivo()) {


            return true;
            }
        else return false;
        }


    /**
     * @return
     */
    public boolean controlloFine( ){
            if (this.controlloObiettivo() && this.controlloArrivo()) {

                return true;
        }
        else return false;

    }

    /**
     * @param i
     * @return
     */
    public String getColoreGiocatore(int i){

        return this.getPartita().getGiocatori().get(i).getColor();
    }

    /**
     * @param i
     * @return
     */
    public String getUsername(int i){
        return this.getPartita().getGiocatori().get(i).getUsername();
    }


    /**
     * @param gioc
     * @return
     */
    public String getNomeCPCittaPartenza(int gioc){

        return this.getPartita().getGiocatori().get(gioc).chiediCartaPercorso().getCittaPartenza().getNome();

    }

    /**
     * @param gioc
     * @return
     */
    public String getNomeCPCittaArrivo(int gioc){

        return this.getPartita().getGiocatori().get(gioc).chiediCartaPercorso().getCittaArrivo().getNome();

    }

    /**
     * @param gioc
     * @return
     */
    public String getNomeCittaObiettivo(int gioc){

        return this.getPartita().getGiocatori().get(gioc).chiediCartaObiettivo().getCittaObiettivo().getNome();

    }

    /**
     * @param i
     */
    public void occupaCittaPartenza(int i){

        this.getPartita().getGiocatori().get(i).chiediCartaPercorso().getCittaPartenza().setOccupata(true);
    }

    /**
     * @param i
     * @param j
     * @param mezzo
     */
    public void setMezzoGioc(int i, int j, String mezzo){

        this.getPartita().setIMezzoGioc(i,j,mezzo);
    }


    /**
     * @return
     */
    public int getNumGiocatori(){
        return this.getPartita().getGiocatori().size();
    }

    /**
     * @param gioc
     * @return
     */
    public int getNumMezzi(int gioc){
        return this.getPartita().getGiocatori().get(gioc).getMezzi().size();
    }


    /**
     * @param mappa
     * @return
     */
    public LatLong getCoordinateCentroMappa(String mappa) {
        return getPartita().getMappa().calcolaCentro();
    }

    /**
     * @return
     */
    public int getNumPercorsiMappa(){
        return this.getPartita().getMappa().dammiPercorsi().size();
    }

    /**
     * @param percorso
     * @return
     */
    public int getNumCasellePercorso(int percorso){
        return this.getPartita().getMappa().dammiPercorsi().get(percorso).getCaselle().size();
    }

    /**
     * @param gioc
     * @param percorso
     * @param casella
     * @return
     */
    public boolean isPartenza(int gioc, int percorso, int casella){
        return Utility.isPartenza(this.getPartita().getGiocatori().get(gioc),this.getPartita().getMappa().dammiPercorsi().get(percorso).getCaselle().get(casella));
    }

    /**
     * @param percorso
     * @param casella
     * @return
     */
    public LatLong getInizioCasella(int percorso,int casella){
        return this.getPartita().getMappa().dammiPercorsi().get(percorso).getCaselle().get(casella).getInizio();
    }

    /**
     * @param percorso
     * @param casella
     * @return
     */
    public LatLong getFineCasella(int percorso,int casella){
        return this.getPartita().getMappa().dammiPercorsi().get(percorso).getCaselle().get(casella).getFine();
    }


    /**
     * @param gioc
     * @param i
     */
    public void setMezzo(int gioc,int i){
        this.getPartita().getGiocatori().get(gioc).setMezzo(i);
    }

    /**
     * @param gioc
     * @param percorso
     * @param casella
     */
    public void posizionaMezzoGioc(int gioc, int percorso, int casella){
        this.getPartita().getGiocatori().get(gioc).posizionaMezzo(this.getPartita().getMappa().dammiPercorsi().get(percorso).getCaselle().get(casella));
    }

    /**
     * @param gioc
     * @param percorso
     * @param casella
     */
    public void setMossaGioc(int gioc, int percorso, int casella){
        this.getPartita().getGiocatori().get(gioc).setMossa(this.getPartita().getMappa().dammiPercorsi().get(percorso).calcolaCasellaVicina(this.getPartita().getMappa().dammiPercorsi().get(percorso).getCaselle().get(casella)));
    }

    /**
     * @return
     */
    public FacadePartita getPartita(){

        return FacadePartita.getIstance();
    }

    /**
     * @param gioc
     * @param percorso
     * @param casella
     */
    public void setMosseGioc(int gioc,int percorso, int casella){
        this.getPartita().getGiocatori().get(gioc).setMosse(this.getPartita().casellePercorsiVicini(percorso,casella));
    }

    /**
     *
     */
    public void duplicati(){
        this.getPartita().getMappa().rimuoviDuplicati(this.getPartita().getMappa().dammiPercorsi());
    }

    /**
     * @param finalPolyline1
     * @param polylineOptions
     * @param finalI
     * @param j
     * @return
     * @throws IOException
     */
    public boolean posizionaMezzoPartita(Polyline finalPolyline1, PolylineOptions polylineOptions, int finalI, int j) throws IOException {
        return this.getPartita().posizionaMezzo(finalPolyline1, polylineOptions,finalI,j);
    }

    /**
     * @return
     */
    public int getNumeroCitta(){
        return this.getPartita().getMappa().getCitta().size();
    }
}

