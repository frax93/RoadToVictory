package it.univaq.rtv.Model;

import it.univaq.rtv.Model.FactoryCitta.ICitta;

public class CartaObiettivo{

	private ICitta cittaObiettivo;
	private int id;

    /**
     * @param id1
     * @param CittaObiettivo
     */
        public CartaObiettivo(int id1, ICitta CittaObiettivo) {
            this.id=id1;
            this.cittaObiettivo =CittaObiettivo;
            
        }

    /**
     * @return
     */
        public ICitta getCittaObiettivo(){
            return this.cittaObiettivo;
        }


}