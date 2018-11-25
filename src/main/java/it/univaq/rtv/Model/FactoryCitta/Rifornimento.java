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

	/**
	 * 
	 */
	public Rifornimento() {
		this.nome ="";
		this.coordinate=null;
		this.occupata=false;
	}

	/**
	 * @param Nome
	 */
	public Rifornimento(String Nome){
		this.nome =Nome;
		this.coordinate= null;
		this.occupata= false;

	}

	/**
	 * @return
	 */
	@Override
	public String getNome() {
		return null;
	}

	/**
	 * @param occupata
	 */
	@Override
	public void setOccupata(boolean occupata) {

	}

	/**
	 * @return
	 */
	@Override
	public boolean getOccupata(){
		return this.occupata;
	}

	/**
	 * @param l
	 */
	@Override
	public void impostaCoordinate(LatLong l) {

	}

	/**
	 * @param Mezzo
	 * @param g
	 */
	@Override
	public void posizionaGiocatore(FactorMezzo Mezzo, Giocatore g) {

	}

	/**
	 * @return
	 */
	@Override
	public IMezzo getIMezzo() {
		return null;
	}

	/**
	 * @return
	 */
	@Override
	public LatLong getCoordinate() {
		return null;
	}

	/**
	 * @param IMezzo
	 */
	@Override
	public void setIMezzo(IMezzo IMezzo) {

	}

}