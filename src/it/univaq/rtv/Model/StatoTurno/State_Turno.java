package it.univaq.rtv.Model.StatoTurno;




import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.StatoGiocatore.Stato_Giocatore;
import it.univaq.rtv.Model.Turno;

import java.util.ArrayList;


public interface State_Turno {

	ArrayList<Giocatore> InizioTurno(ArrayList<Giocatore> g, String nomeMappa, Turno t, Stato_Giocatore gioca) throws Exception;
	void Fineturno(Giocatore g);
	ArrayList<Giocatore> OrdinaGiocatori(ArrayList<Giocatore> g);


}