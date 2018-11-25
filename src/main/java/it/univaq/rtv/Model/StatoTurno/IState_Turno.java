package it.univaq.rtv.Model.StatoTurno;

import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.StatoGiocatore.IStato_Giocatore;
import it.univaq.rtv.Model.Turno;

import java.util.ArrayList;


public interface IState_Turno {

	/**
	 * @param g
	 * @param nomeMappa
	 * @param t
	 * @param gioca
	 * @return
	 * @throws Exception
	 */
	ArrayList<Giocatore> inizioTurno(ArrayList<Giocatore> g, String nomeMappa, Turno t, IStato_Giocatore gioca) throws Exception;

	/**
	 * @param g
	 */
	void fineTurno(Giocatore g);

	/**
	 * @param g
	 * @return
	 */
	ArrayList<Giocatore> ordinaGiocatori(ArrayList<Giocatore> g);


}