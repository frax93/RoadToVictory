package it.univaq.rtv.Model.FactoryCitta;

import it.univaq.rtv.Model.FactorMezzo;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;
import com.lynden.gmapsfx.javascript.object.LatLong;

public class Oscura implements ICitta {
    private String Nome;
    private LatLong coordinate;
    private boolean occupata;
    private IMezzo IMezzo =null;
    public Oscura() {
        this.Nome="";
        this.coordinate=null;
        this.occupata=false;
    }
    public Oscura(String Nome){
        this.Nome=Nome;
        this.coordinate= null;
        this.occupata= false;

    }

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public void setOccupata(boolean occupata) {

    }
    @Override
    public void ImpostaCoordinate(LatLong l) {

    }

    @Override
    public void PosizionaGiocatore(FactorMezzo Mezzo, Giocatore g) {

    }

    @Override
    public IMezzo getIMezzo() {
        return null;
    }

    @Override
    public LatLong getCoordinate() {
        return null;
    }

    @Override
    public void setIMezzo(IMezzo IMezzo) {

    }
}