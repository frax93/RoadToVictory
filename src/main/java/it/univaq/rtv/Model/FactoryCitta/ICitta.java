package it.univaq.rtv.Model.FactoryCitta;

import it.univaq.rtv.Model.FactorMezzo;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;
import com.lynden.gmapsfx.javascript.object.LatLong;




public interface ICitta {

	 String getNome();

	 void setOccupata(boolean occupata);

	boolean getOccupata();

	 void impostaCoordinate(LatLong l);

	 void posizionaGiocatore(FactorMezzo Mezzo, Giocatore g);

	 IMezzo getIMezzo();

	 LatLong getCoordinate();

	 void setIMezzo(IMezzo IMezzo);

}