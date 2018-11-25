package it.univaq.rtv.Model.FactoryCitta;

import com.lynden.gmapsfx.javascript.object.LatLong;
import it.univaq.rtv.Model.FactorMezzo;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;
import it.univaq.rtv.Model.Giocatore;

public class Rifornimento implements ICitta {
	private String nome;
	private LatLong coordinate;
	private boolean occupata;
	private IMezzo IMezzo =null;
	public Rifornimento() {
		this.nome ="";
		this.coordinate=null;
		this.occupata=false;
	}
	public Rifornimento(String Nome){
		this.nome =Nome;
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
	public boolean getOccupata(){
		return this.occupata;
	}

	@Override
	public void impostaCoordinate(LatLong l) {

	}

	@Override
	public void posizionaGiocatore(FactorMezzo Mezzo, Giocatore g) {

	}

	@Override
	public IMezzo getIMezzo() {
		return null;
	}

	@Override
	public LatLong getCoordinate() {
		return null;
	}

	@Override
	public void setIMezzo(IMezzo IMezzo) {

	}

}