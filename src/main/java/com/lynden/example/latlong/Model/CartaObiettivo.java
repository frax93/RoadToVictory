package com.lynden.example.latlong;

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