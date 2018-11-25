package it.univaq.rtv.Model;

import it.univaq.rtv.Model.StatoGiocatore.Attesa;
import it.univaq.rtv.Model.StatoGiocatore.IStato_Giocatore;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;


import java.util.ArrayList;

public class Giocatore implements Comparable<Giocatore>,Runnable {
	private int id;
	private String username;
	private CartaPercorso c=null;
	private CartaObiettivo c1=null;
	private ArrayList<IMezzo> IMezzo =null;
	private IStato_Giocatore IStato_giocatore;
	private String color;
	private ArrayList<Casella> mosse=new ArrayList<>();
	private boolean obiettivo =false;
	private boolean arrivo =false;

	public void setState(IStato_Giocatore state){
		this.IStato_giocatore = state;
	}

	public IStato_Giocatore getState(){
		return this.IStato_giocatore;
	}
	@Override
	public int compareTo(Giocatore g){
		int compare=g.getId();
		return this.id-compare;
	}

	@Override
	public void run(){
	}

	public Giocatore(int id, String u,String color1){
		this.color=color1;
		this.id=id;
		this.username=u;
		Attesa attesa=new Attesa();
		attesa.ruolo(this);

	}
	public String getColor(){
		return this.color;
	}
	public int getId(){
		return this.id;
	}

	public ArrayList<IMezzo> getMezzi(){
		return this.IMezzo;
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

	public int lanciaDado() {
		return SingletonDado.getIstance().lancia();
	}

	public void setMezzo(int taglia){
		this.IMezzo =new ArrayList<IMezzo>();
		FactorMezzo factorymezzo=new FactorMezzo();
		for(int i=0;i<taglia;i++){
			this.IMezzo.add(factorymezzo.getMezzo("Vagone", this));
		}


	}

	public ArrayList<IMezzo> getMezzo() {
		return IMezzo;
	}

	public void pescaDueCarte() {
		SingletonMazzoObiettivo m= new SingletonMazzoObiettivo();
		m=m.getIstance1();
		this.c1=m.pescaCarta();
		SingletonMazzoPercorso m1= new SingletonMazzoPercorso();
		m1=m1.getIstance1();
		this.c=m1.pescaCarta();

	}

	public void restituisciCarte(){
		SingletonMazzoObiettivo mo= new SingletonMazzoObiettivo();
		mo=mo.getIstance1();
		SingletonMazzoPercorso mp= new SingletonMazzoPercorso();
		mp=mp.getIstance1();
		mo.reinserisciCarta(this.chiediCartaObiettivo());
		mp.reinserisciCarta(this.chiediCartaPercorso());
	}


	public CartaPercorso chiediCartaPercorso() {
		return this.c;
	}

	public CartaObiettivo chiediCartaObiettivo() {
		return this.c1;
	}


	public void posizionaMezzo(Casella c) {

		int pos=this.IMezzo.size()-1;
		c.posizionaGiocatore(this);
		this.IMezzo.remove(pos);


	}

	public boolean getObiettivo() {
		return this.obiettivo;
	}
	public void obiettivoRaggiunto() {
		this.obiettivo =true;
	}
	public boolean getArrivo() {
		return this.arrivo;
	}
	public void arrivoRaggiunto() {
		this.arrivo =true;
	}
}