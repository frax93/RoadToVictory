package com.lynden.example.latlong.Model.FactoryCitta;

import com.lynden.example.latlong.Model.FMezzo;
import com.lynden.example.latlong.Model.Giocatore;
import com.lynden.example.latlong.Model.FactoryMezzo.Mezzo;
import com.lynden.gmapsfx.javascript.object.LatLong;

public class Normale implements ICitta {
    private String Nome;
    private LatLong coordinate;
    private boolean occupata;
    private Mezzo mezzo=null;
    public Normale() {
        this.Nome="";
        this.coordinate=null;
        this.occupata=false;
    }
    public Normale(String Nome){
        this.Nome=Nome;
        this.coordinate= null;
        this.occupata= false;

    }
    @Override
    public String getNome(){
        return this.Nome;
    }
    @Override
    public void setOccupata(boolean occupata) {
        this.occupata = occupata;
    }
    @Override
    public boolean getOccupata(){
        return this.occupata;
    }
    @Override
    public void ImpostaCoordinate(LatLong l){
        this.coordinate=l;
    }
    @Override
    public void PosizionaGiocatore(FMezzo Mezzo, Giocatore g) {
        this.mezzo=Mezzo.CreaVagone(g);
    }
    @Override
    public Mezzo getMezzo(){
        return this.mezzo;
    }
    @Override
    public boolean CheckOccupata() {
        if(this.mezzo==null) return false;
        else return true;
    }
    @Override
    public LatLong getCoordinate() {
        return coordinate;
    }
    @Override
    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }
}