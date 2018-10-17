package com.lynden.example.latlong.Model.FactoryMezzo;


import com.lynden.example.latlong.Giocatore;
import com.lynden.example.latlong.Mezzo;

public class Vagone implements Mezzo {
		private int id;
		private Giocatore g;
        public Vagone(Giocatore g) {
			this.g=g;
        }

	public void CreaMezzo() {
		// TODO - implement Vagone.CreaMezzo
		throw new UnsupportedOperationException();
	}

	public void DammiMezzo() {
		// TODO - implement Vagone.DammiMezzo
		throw new UnsupportedOperationException();
	}

}