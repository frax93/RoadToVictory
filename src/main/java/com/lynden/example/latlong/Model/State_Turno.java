package com.lynden.example.latlong;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.Time;


public interface State_Turno {

	public abstract ArrayList<Giocatore> InizioTurno(ArrayList<Giocatore> g, String nomeMappa, Turno t, Stato_Giocatore gioca) throws Exception;
	public abstract void Fineturno(Giocatore g);
	public abstract ArrayList<Giocatore> OrdinaGiocatori(ArrayList<Giocatore> g);


}