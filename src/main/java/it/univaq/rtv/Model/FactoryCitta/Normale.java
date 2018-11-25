package it.univaq.rtv.Model.FactoryCitta;

import com.lynden.gmapsfx.javascript.object.LatLong;
import it.univaq.rtv.Model.FactorMezzo;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;
import it.univaq.rtv.Model.Giocatore;

public class Normale implements ICitta{
    private String nome;
    private Double latitude;
    private Double longitude;
    private boolean occupata;
    private IMezzo IMezzo =null;
    public Normale(){}
    public Normale(String Nome){
        this.nome =Nome;
        this.latitude= null;
        this.longitude= null;
        this.occupata= false;

    }
    @Override
    public String getNome(){
        return this.nome;
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
    public void impostaCoordinate(LatLong l){
        this.latitude=l.getLatitude();
        this.longitude=l.getLongitude();
    }
    @Override
    public void posizionaGiocatore(FactorMezzo Mezzo, Giocatore g) {
        this.IMezzo =Mezzo.getMezzo("Vagone", g);
    }

    @Override
    public IMezzo getIMezzo(){
        return this.IMezzo;
    }

    @Override
    public LatLong getCoordinate() {
        return new LatLong(this.latitude,this.longitude);
    }

    @Override
    public void setIMezzo(IMezzo IMezzo) {
        this.IMezzo = IMezzo;
    }


    public void setNome(String nome){
        this.nome =nome;
    }

}