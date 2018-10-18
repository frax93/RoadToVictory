package com.lynden.example.latlong;

import com.lynden.example.latlong.Model.FactoryCitta.Citta;

public class CartaObiettivo extends Carta {

	private Citta CittaObiettivo;

        public CartaObiettivo(int id1, Citta CittaObiettivo) {
            super(id1);
            this.CittaObiettivo=CittaObiettivo;
            
        }
        public Citta getCittaObiettivo(){
            return this.CittaObiettivo;
        }

	public void CreaCarta() {
		// TODO - implement CartaObiettivo.CreaCarta
		throw new UnsupportedOperationException();
	}

}