package com.lynden.example.latlong;

import com.lynden.example.latlong.Model.FactoryMezzo.Mezzo;
import com.lynden.example.latlong.Model.StatoGiocatore.Attesa;
import com.lynden.example.latlong.Model.StatoGiocatore.Stato_Giocatore;


import java.util.ArrayList;

public class Giocatore implements Comparable<Giocatore>,Runnable {
	private int id;
	private String username;
	private CartaPercorso c=null;
	private CartaObiettivo c1=null;
	private ArrayList<Mezzo> mezzo=null;
	private Stato_Giocatore stato_giocatore;
	private String color;
	private ArrayList<Casella> mosse=new ArrayList<>();
	private boolean Obiettivo=false;
	private boolean Arrivo=false;

	public void setState(Stato_Giocatore state){
		this.stato_giocatore = state;
	}

	public Stato_Giocatore getState(){
		return this.stato_giocatore;
	}
	@Override
	public int compareTo(Giocatore g){
		int compare=((Giocatore) g).getId();
		return this.id-compare;
	}
	@Override
	public void run(){
		//this.Posizionamezzo();
	}
	public Giocatore(int id, String u,String color1){
		this.color=color1;
		this.id=id;
		this.username=u;
		Attesa attesa=new Attesa();
		attesa.Ruolo(this);

	}
	public String getColor(){
		return this.color;
	}
	public int getId(){
		return this.id;
	}

	public ArrayList<Mezzo> getMezzi(){
		return this.mezzo;
	}

	public String getUsername(){
		return this.username;
	}

	public void setMossa(Casella mossa) {
		this.mosse.add(mossa);
	}
	public void setMosse(ArrayList<Casella> mosse) {
		this.mosse.addAll(mosse);
	}
	public void removeMossa(Casella mossa) {
		this.mosse.remove(mossa);
	}

	public ArrayList<Casella> getMosse() {
		return this.mosse;
	}

	public int LanciaDado() {
		SDado dado=new SDado();
		dado=dado.getIstance();
		return dado.Lancia();

	}
	public void setMezzo(int taglia){
		this.mezzo=new ArrayList<Mezzo>();
		FMezzo factorymezzo=new FMezzo();
		for(int i=0;i<taglia;i++){
			this.mezzo.add(factorymezzo.CreaVagone(this));
		}


	}

	public ArrayList<Mezzo> getMezzo() {
		return mezzo;
	}

	public void PescaDueCarte() {
		MazzoObiettivo m= new MazzoObiettivo();
		m=m.getIstance1();
		this.c1=(CartaObiettivo)m.PescaCarta();
		MazzoPercorso m1= new MazzoPercorso();
		m1=m1.getIstance1();
		this.c=(CartaPercorso)m1.PescaCarta();

	}


	public CartaPercorso ChiediCartaPercorso() {
		return this.c;
	}

	public CartaObiettivo ChiediCartaObiettivo() {
		return this.c1;
	}

	public void ChiediMezzo() {
		// TODO - implement Giocatore.ChiediMezzo
		throw new UnsupportedOperationException();
	}

	public void ChiediCarte() {
		// TODO - implement Giocatore.ChiediCarte
		throw new UnsupportedOperationException();
	}

	public void PosizionaMezzo(Casella c) {

		int pos=this.mezzo.size()-1;
		c.PosizionaGiocatore(this);
		this.mezzo.remove(pos);


	}

	public boolean getObiettivo() {
		return this.Obiettivo;
	}
	public void Obiettivoraggiunto() {
		this.Obiettivo=true;
	}
	public boolean getArrivo() {
		return this.Arrivo;
	}
	public void Arrivoraggiunto() {
		this.Arrivo=true;
	}
}