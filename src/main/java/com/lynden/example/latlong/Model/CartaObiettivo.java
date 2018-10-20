package com.lynden.example.latlong.Model;

import com.lynden.example.latlong.Model.FactoryCitta.ICitta;

public class CartaObiettivo extends Carta {

	private ICitta CittaObiettivo;

        public CartaObiettivo(int id1, ICitta CittaObiettivo) {
            super(id1);
            this.CittaObiettivo=CittaObiettivo;
            
        }
        public ICitta getCittaObiettivo(){
            return this.CittaObiettivo;
        }


}