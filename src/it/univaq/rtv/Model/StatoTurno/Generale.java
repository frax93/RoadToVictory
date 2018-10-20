package it.univaq.rtv.Model.StatoTurno;




import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.StatoGiocatore.Attesa;
import it.univaq.rtv.Model.StatoGiocatore.Stato_Giocatore;
import it.univaq.rtv.Model.Turno;

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