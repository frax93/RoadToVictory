package com.lynden.example.latlong;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.sun.org.apache.bcel.internal.generic.FLOAD;


public class Citta {

	private String Nome;
	private double distanza;
	private LatLong coordinate;
	private boolean occupata;
	private com.lynden.example.latlong.Mezzo mezzo=null;
        public Citta() {
           this.Nome="";
           this.distanza=0;
           this.coordinate=null;
           this.occupata=false;
        }
        public Citta(String Nome,int dist){
            this.Nome=Nome;
            this.distanza=dist;
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

		/**** Algoritmo per calcolare la distanza tra le Città **********/
		double R = 6372.795477598;  //Con errore dello 0.3%

		double k= 2* 3.14/360;

		this.distanza = R* Math.acos(Math.sin(this.coordinate.getLatitude()*k) * Math.sin(53.3498053*k) +
				Math.cos(this.coordinate.getLatitude()*k) * Math.cos(53.3498053*k) * Math.cos(this.coordinate.getLongitude()*k-(-6.260309699999993*k)));



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

	public double getDistanza(){
		return this.distanza;
	}

	public void setMezzo(Mezzo mezzo) {
		this.mezzo = mezzo;
	}
}