package it.univaq.rtv.Model.FactoryCitta;

import it.univaq.rtv.Model.FactorMezzo;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;
import com.lynden.gmapsfx.javascript.object.LatLong;




public interface ICitta {

	/**
	 * @return
	 */
	 String getNome();

	/**
	 * @param occupata
	 */
	 void setOccupata(boolean occupata);

	/**
	 * @return
	 */
	boolean getOccupata();

	/**
	 * @param l
	 */
	 void impostaCoordinate(LatLong l);

	/**
	 * @param Mezzo
	 * @param g
	 */
	 void posizionaGiocatore(FactorMezzo Mezzo, Giocatore g);

	/**
	 * @return
	 */
	 IMezzo getIMezzo();

	/**
	 * @return
	 */
	 LatLong getCoordinate();

	/**
	 * @param IMezzo
	 */
	 void setIMezzo(IMezzo IMezzo);

}