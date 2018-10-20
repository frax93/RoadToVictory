package com.lynden.example.latlong.Model.FactoryCitta;

import com.lynden.example.latlong.Model.FMezzo;
import com.lynden.example.latlong.Model.Giocatore;
import com.lynden.example.latlong.Model.FactoryMezzo.Mezzo;
import com.lynden.gmapsfx.javascript.object.LatLong;


public interface ICitta {

	public String getNome();

	public void setOccupata(boolean occupata);

	public boolean getOccupata();

	public void ImpostaCoordinate(LatLong l);

	public void PosizionaGiocatore(FMezzo Mezzo, Giocatore g);
	public Mezzo getMezzo();

	public boolean CheckOccupata();

	public LatLong getCoordinate();


	public void setMezzo(Mezzo mezzo);
}