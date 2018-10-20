package com.lynden.example.latlong.Model.StatoTurno;




import com.lynden.example.latlong.Model.Giocatore;
import com.lynden.example.latlong.Model.StatoGiocatore.Stato_Giocatore;
import com.lynden.example.latlong.Model.Turno;

import java.util.ArrayList;
//import java.Time;


public interface State_Turno {

	public abstract ArrayList<Giocatore> InizioTurno(ArrayList<Giocatore> g, String nomeMappa, Turno t, Stato_Giocatore gioca) throws Exception;
	public abstract void Fineturno(Giocatore g);
	public abstract ArrayList<Giocatore> OrdinaGiocatori(ArrayList<Giocatore> g);


}