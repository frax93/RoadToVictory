package com.lynden.example.latlong;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Iniziale implements State_Turno {
	@Override
	public void InizioTurno(ArrayList<Giocatore> g,Giocatore g1, String nomeMappa, Turno t)throws FileNotFoundException,IOException{

			FMappa m= new FMappa(g,nomeMappa);
		MazzoPercorso m1=new MazzoPercorso();
		m1=m1.getIstance(m.DammiPercorsi());
		MazzoObiettivo m2 = new MazzoObiettivo();
		m2=m2.getIstance(m.getCitta());
		for(int i=0;i<g.size();i++)
			g.get(i).PescaDueCarte();
		m.PopolaMappa(g);
		t.setState(this);
		this.Fineturno(g1);

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

}