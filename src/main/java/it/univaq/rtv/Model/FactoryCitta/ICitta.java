package it.univaq.rtv.Model.FactoryCitta;

import it.univaq.rtv.Model.FactorMezzo;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;
import com.lynden.gmapsfx.javascript.object.LatLong;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public interface ICitta {

	 String getNome();

	 void setOccupata(boolean occupata);

	boolean getOccupata();

	 void ImpostaCoordinate(LatLong l);

	 void PosizionaGiocatore(FactorMezzo Mezzo, Giocatore g);

	 IMezzo getIMezzo();

	LatLong getCoordinate();

	 void setIMezzo(IMezzo IMezzo);
	 static EntityManager jpaConnection(){
		 EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-example");
		 return emFactory.createEntityManager();
	 }
}