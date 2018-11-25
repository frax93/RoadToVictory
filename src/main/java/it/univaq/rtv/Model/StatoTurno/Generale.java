package it.univaq.rtv.Model.StatoTurno;




import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.StatoGiocatore.Attesa;
import it.univaq.rtv.Model.StatoGiocatore.IStato_Giocatore;
import it.univaq.rtv.Model.Turno;

import java.util.ArrayList;

public class Generale extends Thread implements IState_Turno {
	private Giocatore giocatore;


	@Override
	public ArrayList<Giocatore> inizioTurno(ArrayList<Giocatore> g, String NomeMappa, Turno t, IStato_Giocatore gioca) throws Exception {
		g.get(0).setState(gioca);
		t.setState(this);
		this.giocatore=g.get(0);
		return g;
	}

	@Override
	public void fineTurno(Giocatore g) {
	 	Attesa attesa=new Attesa();
	 	g.setState(attesa);
	}

	@Override
	public  ArrayList<Giocatore> ordinaGiocatori(ArrayList<Giocatore> g){
		return g;
	}

	public void interrupt(){
		this.interrupt();
	}

}