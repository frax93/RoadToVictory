package com.lynden.example.latlong.Model.StatoTurno;

import com.lynden.example.latlong.*;
import com.lynden.example.latlong.FMappa;
import com.lynden.example.latlong.Giocatore;
import com.lynden.example.latlong.MazzoPercorso;
import com.lynden.example.latlong.Model.StatoGiocatore.Stato_Giocatore;
import com.lynden.example.latlong.Turno;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Iniziale implements State_Turno {
	private FMappa mappa;
	@Override
	public ArrayList<Giocatore> InizioTurno(ArrayList<Giocatore> g, String nomeMappa, Turno t, Stato_Giocatore gioca)throws FileNotFoundException,IOException{

		this.mappa=new FMappa(nomeMappa);
		MazzoPercorso m1=new MazzoPercorso();
		m1=m1.getIstance(mappa.DammiPercorsi());
		MazzoObiettivo m2 = new MazzoObiettivo();
		ArrayList<String> CittaUsate= new ArrayList<>();
		m2=m2.getIstance(mappa.getCitta());
		for(int i=0;i<g.size();i++){
			g.get(i).PescaDueCarte();
			System.out.println(g.size());
			while(g.get(i).ChiediCartaObiettivo().getCittaObiettivo().getNome().equals(g.get(i).ChiediCartaPercorso().getCittaPartenza().getNome())||g.get(i).ChiediCartaObiettivo().getCittaObiettivo().getNome().equals(g.get(i).ChiediCartaPercorso().getCittaArrivo().getNome())){
				g.get(i).PescaDueCarte();
			}
			for(int c=0;c<CittaUsate.size();c++){
				if(g.get(i).ChiediCartaObiettivo().getCittaObiettivo().getNome().equals(CittaUsate.get(c))||g.get(i).ChiediCartaPercorso().getCittaPartenza().getNome().equals(CittaUsate.get(c))||g.get(i).ChiediCartaPercorso().getCittaArrivo().getNome().equals(CittaUsate.get(c))){
					g.get(i).PescaDueCarte();
					c=-1;
				}

			}
			CittaUsate.add(g.get(i).ChiediCartaObiettivo().getCittaObiettivo().getNome());
			CittaUsate.add(g.get(i).ChiediCartaPercorso().getCittaPartenza().getNome());
			CittaUsate.add(g.get(i).ChiediCartaPercorso().getCittaArrivo().getNome());

		}
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