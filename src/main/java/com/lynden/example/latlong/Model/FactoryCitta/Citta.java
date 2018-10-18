package com.lynden.example.latlong.Model.FactoryCitta;

import com.lynden.example.latlong.FMezzo;
import com.lynden.example.latlong.Giocatore;
import com.lynden.example.latlong.Model.FactoryMezzo.Mezzo;
import com.lynden.gmapsfx.javascript.object.LatLong;


public class Citta {

	private String Nome;
	private LatLong coordinate;
	private boolean occupata;
	private Mezzo mezzo=null;
        public Citta() {
           this.Nome="";
           this.coordinate=null;
           this.occupata=false;
        }
        public Citta(String Nome){
            this.Nome=Nome;
            this.coordinate= null;
            this.occupata= occupata;

        }
        public String getNome(){
            return this.Nome;
        }

	public void setOccupata(boolean occupata) {
		this.occupata = occupata;
	}

	public boolean getOccupata(){
        	return this.occupata;
	}

	/******* DA INSERIRE IN VP ********/
	public void ImpostaCoordinate(LatLong l){
		this.coordinate=l;
	}

	public void DammiCittàPartenza() {
		// TODO - implement Citta.DammiCittàPartenza
		throw new UnsupportedOperationException();
	}

	public void DammiCittàArrivo() {
		// TODO - implement Citta.DammiCittàArrivo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Mezzo
	 */
	public void PosizionaGiocatore(FMezzo Mezzo, Giocatore g) {
		this.mezzo=Mezzo.CreaVagone(g);
	}
	public Mezzo getMezzo(){
		return this.mezzo;
	}

	public boolean CheckOccupata() {
		if(this.mezzo==null) return false;
		else return true;
	}

	public LatLong getCoordinate() {
		return coordinate;
	}


	public void setMezzo(Mezzo mezzo) {
		this.mezzo = mezzo;
	}
}