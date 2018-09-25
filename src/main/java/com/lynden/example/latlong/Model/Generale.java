package com.lynden.example.latlong;




import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Generale implements State_Turno {
	@Override
	public void InizioTurno(ArrayList<Giocatore> g, Giocatore g1,String NomeMappa, Turno t) throws FileNotFoundException,IOException {
		Gioca gioca=new Gioca();
		g1.setState(gioca);
		t.setState(this);
		this.Fineturno(g1);



	}
	@Override
	public void Fineturno(Giocatore g) {
	 	Attesa attesa=new Attesa();
	 	g.setState(attesa);
	}
	@Override
	public  ArrayList<Giocatore> OrdinaGiocatori(ArrayList<Giocatore> g){
		// TO Implement
		return g;
	}

}