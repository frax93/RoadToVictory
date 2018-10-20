package com.lynden.example.latlong.Model.StatoTurno;




import com.lynden.example.latlong.Model.Giocatore;
import com.lynden.example.latlong.Model.StatoGiocatore.Attesa;
import com.lynden.example.latlong.Model.StatoGiocatore.Stato_Giocatore;
import com.lynden.example.latlong.Model.Turno;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Generale implements State_Turno {
	private Giocatore giocatore;

	@Override
	public ArrayList<Giocatore> InizioTurno(ArrayList<Giocatore> g, String NomeMappa, Turno t, Stato_Giocatore gioca)  {
		g.get(0).setState(gioca);
		t.setState(this);
		this.giocatore=g.get(0);
		return g;
	}
	@Override
	public void Fineturno(Giocatore g) {
	 	Attesa attesa=new Attesa();
	 	g.setState(attesa);
	}
	@Override
	public  ArrayList<Giocatore> OrdinaGiocatori(ArrayList<Giocatore> g){
		return g;
	}

}