package it.univaq.rtv.Model.FactoryCitta;

import it.univaq.rtv.Model.FMezzo;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.FactoryMezzo.Mezzo;
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