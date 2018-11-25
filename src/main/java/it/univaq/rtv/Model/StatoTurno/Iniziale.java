package it.univaq.rtv.Model.StatoTurno;

import it.univaq.rtv.Utility.Utility;
import it.univaq.rtv.Model.FactorMappa;
import it.univaq.rtv.Model.FactoryMappa.AbstractMappa;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.SingletonMazzoObiettivo;
import it.univaq.rtv.Model.SingletonMazzoPercorso;
import it.univaq.rtv.Model.StatoGiocatore.IStato_Giocatore;
import it.univaq.rtv.Model.Turno;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Iniziale implements IState_Turno {
	private AbstractMappa mappa;

	/**
	 * @param g
	 * @param nomeMappa
	 * @param t
	 * @param gioca
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Override
	public ArrayList<Giocatore> inizioTurno(ArrayList<Giocatore> g, String nomeMappa, Turno t, IStato_Giocatore gioca)throws FileNotFoundException,IOException{
		this.mappa= FactorMappa.getMappa(nomeMappa);
		SingletonMazzoPercorso.getIstance(mappa.dammiPercorsi());
		SingletonMazzoObiettivo.getIstance(mappa.getCitta());
		ArrayList<String> CittaUsate= new ArrayList<>();
		for(int i=0;i<g.size();i++){
			g.get(i).pescaDueCarte();
			for(int c=0;c<CittaUsate.size();c++){
				while(Utility.equalsCitta(g.get(i),CittaUsate.get(c))){
					g.get(i).restituisciCarte();
					g.get(i).pescaDueCarte();
					c=-1;
					break;
				}

			}
			CittaUsate.add(g.get(i).chiediCartaObiettivo().getCittaObiettivo().getNome());
			CittaUsate.add(g.get(i).chiediCartaPercorso().getCittaPartenza().getNome());
			CittaUsate.add(g.get(i).chiediCartaPercorso().getCittaArrivo().getNome());

		}
		mappa.popolaMappa(g);
		t.setState(this);
		return g;

	}

	/**
	 * @param g
	 */
	@Override
	public void fineTurno(Giocatore g) {
		return;
	}

	/**
	 * @param g
	 * @return
	 */
	@Override
	public ArrayList<Giocatore> ordinaGiocatori(ArrayList<Giocatore> g) {
		Collections.sort(g);
		return g;
	}

	/**
	 * @return
	 */
	public AbstractMappa getMappa() {
		return mappa;
	}
}