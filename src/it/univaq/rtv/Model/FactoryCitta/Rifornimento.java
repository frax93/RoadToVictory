package it.univaq.rtv.Model.FactoryCitta;

import it.univaq.rtv.Model.FMezzo;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.FactoryMezzo.Mezzo;
import com.lynden.gmapsfx.javascript.object.LatLong;

public class Rifornimento implements ICitta {
	private String Nome;
	private LatLong coordinate;
	private boolean occupata;
	private Mezzo mezzo=null;
	public Rifornimento() {
		this.Nome="";
		this.coordinate=null;
		this.occupata=false;
	}
	public Rifornimento(String Nome){
		this.Nome=Nome;
		this.coordinate= null;
		this.occupata= false;

	}

	@Override
	public String getNome() {
		return null;
	}

	@Override
	public void setOccupata(boolean occupata) {

	}

	@Override
	public void ImpostaCoordinate(LatLong l) {

	}

	@Override
	public void PosizionaGiocatore(FMezzo Mezzo, Giocatore g) {

	}

	@Override
	public Mezzo getMezzo() {
		return null;
	}

	@Override
	public LatLong getCoordinate() {
		return null;
	}

	@Override
	public void setMezzo(Mezzo mezzo) {

	}
}