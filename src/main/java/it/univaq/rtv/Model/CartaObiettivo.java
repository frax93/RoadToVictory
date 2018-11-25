package it.univaq.rtv.Model;

import it.univaq.rtv.Model.FactoryCitta.ICitta;

public class CartaObiettivo{

	private ICitta cittaObiettivo;
	private int id;

        public CartaObiettivo(int id1, ICitta CittaObiettivo) {
            this.id=id1;
            this.cittaObiettivo =CittaObiettivo;
            
        }
        public ICitta getCittaObiettivo(){
            return this.cittaObiettivo;
        }


}