package com.lynden.example.latlong;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Iniziale implements State_Turno {
	private FMappa mappa;
	@Override
	public ArrayList<Giocatore> InizioTurno(ArrayList<Giocatore> g, Giocatore g1, String nomeMappa, Turno t, Stato_Giocatore gioca)throws FileNotFoundException,IOException{

		this.mappa=new FMappa(g,nomeMappa);
		MazzoPercorso m1=new MazzoPercorso();
		m1=m1.getIstance(mappa.DammiPercorsi());
		MazzoObiettivo m2 = new MazzoObiettivo();
		m2=m2.getIstance(mappa.getCitta());
		for(int i=0;i<g.size();i++)
			g.get(i).PescaDueCarte();
		mappa.PopolaMappa(g);
		t.setState(this);
		return g;

	}
	@Override
	public void Fineturno(Giocatore g) {
		return;
	}
	@Override
	public ArrayList<Giocatore> OrdinaGiocatori(ArrayList<Giocatore> g) {
		Collections.sort(g);
		return g;
	}

	public FMappa getMappa() {
		return mappa;
	}
}