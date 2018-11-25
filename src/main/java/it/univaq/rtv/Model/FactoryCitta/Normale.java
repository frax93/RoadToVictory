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

    /**
     *
     */
    public Normale(){}

    /**
     * @param Nome
     */
    public Normale(String Nome){
        this.nome =Nome;
        this.latitude= null;
        this.longitude= null;
        this.occupata= false;

    }

    /**
     * @return
     */
    @Override
    public String getNome(){
        return this.nome;
    }

    /**
     * @param occupata
     */
    @Override
    public void setOccupata(boolean occupata) {
        this.occupata = occupata;
    }

    /**
     * @return
     */
    @Override
    public boolean getOccupata(){
        return this.occupata;
    }

    /**
     * @param l
     */
    @Override
    public void impostaCoordinate(LatLong l){
        this.latitude=l.getLatitude();
        this.longitude=l.getLongitude();
    }

    /**
     * @param Mezzo
     * @param g
     */
    @Override
    public void posizionaGiocatore(FactorMezzo Mezzo, Giocatore g) {
        this.IMezzo =Mezzo.getMezzo("Vagone", g);
    }

    /**
     * @return
     */
    @Override
    public IMezzo getIMezzo(){
        return this.IMezzo;
    }

    /**
     * @return
     */
    @Override
    public LatLong getCoordinate() {
        return new LatLong(this.latitude,this.longitude);
    }

    /**
     * @param IMezzo
     */
    @Override
    public void setIMezzo(IMezzo IMezzo) {
        this.IMezzo = IMezzo;
    }


    /**
     * @param nome
     */
    public void setNome(String nome){
        this.nome =nome;
    }

}