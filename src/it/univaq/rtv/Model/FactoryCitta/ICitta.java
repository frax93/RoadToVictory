package it.univaq.rtv.Model.FactoryCitta;

import it.univaq.rtv.Model.FactorMezzo;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;
import com.lynden.gmapsfx.javascript.object.LatLong;


public interface ICitta {

	public String getNome();

	public void setOccupata(boolean occupata);

	public void ImpostaCoordinate(LatLong l);

	public void PosizionaGiocatore(FactorMezzo Mezzo, Giocatore g);

	public IMezzo getIMezzo();

	public LatLong getCoordinate();

	public void setIMezzo(IMezzo IMezzo);
}