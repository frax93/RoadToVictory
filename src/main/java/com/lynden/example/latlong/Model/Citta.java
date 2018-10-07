package com.lynden.example.latlong;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.sun.org.apache.bcel.internal.generic.FLOAD;


public class Citta {

	private String Nome;
	private LatLong coordinate;
	private boolean occupata;
	private com.lynden.example.latlong.Mezzo mezzo=null;
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