package com.lynden.example.latlong.Model.StatoTurno;




import com.lynden.example.latlong.Model.Giocatore;
import com.lynden.example.latlong.Model.StatoGiocatore.Stato_Giocatore;
import com.lynden.example.latlong.Model.Turno;

import java.util.ArrayList;


public interface State_Turno {

	ArrayList<Giocatore> InizioTurno(ArrayList<Giocatore> g, String nomeMappa, Turno t, Stato_Giocatore gioca) throws Exception;
	void Fineturno(Giocatore g);
	ArrayList<Giocatore> OrdinaGiocatori(ArrayList<Giocatore> g);


}