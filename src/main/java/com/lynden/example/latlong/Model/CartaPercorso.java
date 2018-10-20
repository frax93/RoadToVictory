package com.lynden.example.latlong.Model;

import com.lynden.example.latlong.Model.FactoryCitta.ICitta;

public class CartaPercorso extends Carta {

	private ICitta CittaPartenza;
	private ICitta CittaArrivo;

    public CartaPercorso(int id1, ICitta CittaPartenza, ICitta CittaArrivo) {
        super(id1);
        this.CittaPartenza=CittaPartenza;
        this.CittaArrivo=CittaArrivo;
    }
    public ICitta getCittaPartenza(){return this.CittaPartenza;}
    public ICitta getCittaArrivo(){return this.CittaArrivo;}


}