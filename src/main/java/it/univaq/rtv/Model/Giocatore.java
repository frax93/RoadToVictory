package it.univaq.rtv.Model;

import it.univaq.rtv.Model.StatoGiocatore.Attesa;
import it.univaq.rtv.Model.StatoGiocatore.IStato_Giocatore;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;


import java.util.ArrayList;

public class Giocatore implements Comparable<Giocatore>,Runnable {
	private int id;
	private String username;
	private CartaPercorso cartaP =null;
	private CartaObiettivo cartaO =null;
	private ArrayList<IMezzo> IMezzo =null;
	private IStato_Giocatore IStato_giocatore;
	private String color;
	private ArrayList<Casella> mosse=new ArrayList<>();
	private boolean obiettivo =false;
	private boolean arrivo =false;

	/**
	 * @param state
	 */
	public void setState(IStato_Giocatore state){
		this.IStato_giocatore = state;
	}

	/**
	 * @return
	 */
	public IStato_Giocatore getState(){
		return this.IStato_giocatore;
	}

	/**
	 * @param g
	 * @return
	 */
	@Override
	public int compareTo(Giocatore g){
		int compare=g.getId();
		return this.id-compare;
	}

	/**
	 *
	 */
	@Override
	public void run(){
	}

	/**
	 * @param id
	 * @param u
	 * @param color1
	 */
	public Giocatore(int id, String u,String color1){
		this.color=color1;
		this.id=id;
		this.username=u;
		Attesa attesa=new Attesa();
		attesa.ruolo(this);

	}

	/**
	 * @return
	 */
	public String getColor(){
		return this.color;
	}

	/**
	 * @return
	 */
	public int getId(){
		return this.id;
	}

	/**
	 * @return
	 */
	public ArrayList<IMezzo> getMezzi(){
		return this.IMezzo;
	}

	/**
	 * @return
	 */
	public String getUsername(){
		return this.username;
	}

	/**
	 * @param mossa
	 */
	public void setMossa(Casella mossa) {
		this.mosse.add(mossa);
	}

	/**
	 * @param mosse
	 */
	public void setMosse(ArrayList<Casella> mosse) {
		this.mosse.addAll(mosse);
	}

	/**
	 * @param mossa
	 */
	public void removeMossa(Casella mossa) {
		this.mosse.remove(mossa);
	}

	/**
	 * @return
	 */
	public ArrayList<Casella> getMosse() {
		return this.mosse;
	}

	/**
	 * @return
	 */
	public int lanciaDado() {
		return SingletonDado.getIstance().lancia();
	}

	/**
	 * @param taglia
	 */
	public void setMezzo(int taglia){
		this.IMezzo =new ArrayList<IMezzo>();
		FactorMezzo factorymezzo=new FactorMezzo();
		for(int i=0;i<taglia;i++){
			this.IMezzo.add(factorymezzo.getMezzo("Vagone", this));
		}


	}

	/**
	 * @return
	 */
	public ArrayList<IMezzo> getMezzo() {
		return IMezzo;
	}

	/**
	 *
	 */
	public void pescaDueCarte() {
		SingletonMazzoObiettivo m= new SingletonMazzoObiettivo();
		m=m.getIstance1();
		this.cartaO =m.pescaCarta();
		SingletonMazzoPercorso m1= new SingletonMazzoPercorso();
		m1=m1.getIstance1();
		this.cartaP =m1.pescaCarta();

	}

	/**
	 *
	 */
	public void restituisciCarte(){
		SingletonMazzoObiettivo mo= new SingletonMazzoObiettivo();
		mo=mo.getIstance1();
		SingletonMazzoPercorso mp= new SingletonMazzoPercorso();
		mp=mp.getIstance1();
		mo.reinserisciCarta(this.chiediCartaObiettivo());
		mp.reinserisciCarta(this.chiediCartaPercorso());
	}


	/**
	 * @return
	 */
	public CartaPercorso chiediCartaPercorso() {
		return this.cartaP;
	}

	/**
	 * @return
	 */
	public CartaObiettivo chiediCartaObiettivo() {
		return this.cartaO;
	}


	/**
	 * @param c
	 */
	public void posizionaMezzo(Casella c) {

		int pos=this.IMezzo.size()-1;
		c.posizionaGiocatore(this);
		this.IMezzo.remove(pos);


	}

	/**
	 * @return
	 */
	public boolean getObiettivo() {
		return this.obiettivo;
	}

	/**
	 *
	 */
	public void obiettivoRaggiunto() {
		this.obiettivo =true;
	}

	/**
	 * @return
	 */
	public boolean getArrivo() {
		return this.arrivo;
	}


	/**
	 *
	 */
	public void arrivoRaggiunto() {
		this.arrivo =true;
	}

	/**
	 * @param taglia
	 * @param mezzo
	 */
	public void removeAllMezzi(int taglia, String mezzo){
		this.IMezzo = new ArrayList<IMezzo>();
		FactorMezzo factorMezzo = new FactorMezzo();
		for(int i=taglia;i>=0;i--){
			this.IMezzo.remove(factorMezzo.getMezzo(mezzo, this));
		}
	}

}