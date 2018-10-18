package com.lynden.example.latlong;

import com.lynden.example.latlong.Model.FactoryCitta.Citta;

public class CartaPercorso extends Carta {

	private Citta CittaPartenza;
	private Citta CittaArrivo;

    public CartaPercorso(int id1, Citta CittaPartenza,Citta CittaArrivo) {
        super(id1);
        this.CittaPartenza=CittaPartenza;
        this.CittaArrivo=CittaArrivo;
    }
    public Citta getCittaPartenza(){return this.CittaPartenza;}
    public Citta getCittaArrivo(){return this.CittaArrivo;}


    public void CreaCarta() {
		// TODO - implement CartaPercorso.CreaCarta
		throw new UnsupportedOperationException();
	}

}