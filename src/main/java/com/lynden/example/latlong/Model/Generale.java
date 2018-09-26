package com.lynden.example.latlong;




import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Generale implements State_Turno {
	private Giocatore giocatore;
	@Override
	public ArrayList<Giocatore> InizioTurno(ArrayList<Giocatore> g, Giocatore g1,String NomeMappa, Turno t,Stato_Giocatore gioca) throws FileNotFoundException,IOException {
		g1.setState(gioca);
		t.setState(this);
		this.giocatore=g1;
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