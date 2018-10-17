package com.lynden.example.latlong;


import com.lynden.example.latlong.Model.FactoryMezzo.Aereo;
import com.lynden.example.latlong.Model.FactoryMezzo.Vagone;

public class FMezzo {


	public Vagone CreaVagone(Giocatore g) {
		Vagone v=new Vagone(g);
		return v;
	}
	public Aereo CreaAereo(Giocatore g){
		Aereo a=new Aereo(121);
		return a;
	}
	public void DammiMezzo() {
		// TODO - implement FMezzo.DammiMezzo
		throw new UnsupportedOperationException();
	}

}