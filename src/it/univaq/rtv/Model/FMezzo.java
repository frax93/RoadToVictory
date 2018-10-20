package it.univaq.rtv.Model;


import it.univaq.rtv.Model.FactoryMezzo.Aereo;
import it.univaq.rtv.Model.FactoryMezzo.Vagone;

public class FMezzo {


	public Vagone CreaVagone(Giocatore g) {
		Vagone v=new Vagone(g);
		return v;
	}
	public Aereo CreaAereo(Giocatore g){
		Aereo a=new Aereo(121);
		return a;
	}

}