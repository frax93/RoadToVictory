package com.lynden.example.latlong.Model.StatoTurno;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lynden.example.latlong.Giocatore;
import com.lynden.example.latlong.Model.StatoGiocatore.Stato_Giocatore;
import com.lynden.example.latlong.Turno;
//import java.Time;


public interface State_Turno {

	public abstract ArrayList<Giocatore> InizioTurno(ArrayList<Giocatore> g, String nomeMappa, Turno t, Stato_Giocatore gioca) throws Exception;
	public abstract void Fineturno(Giocatore g);
	public abstract ArrayList<Giocatore> OrdinaGiocatori(ArrayList<Giocatore> g);


}