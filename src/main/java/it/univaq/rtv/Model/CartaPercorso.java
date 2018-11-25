package it.univaq.rtv.Model;

import it.univaq.rtv.Model.FactoryCitta.ICitta;

public class CartaPercorso{

	private ICitta cittaPartenza;
	private ICitta cittaArrivo;

    public CartaPercorso(ICitta CittaPartenza, ICitta CittaArrivo) {

        this.cittaPartenza =CittaPartenza;
        this.cittaArrivo =CittaArrivo;
    }
    public ICitta getCittaPartenza(){
        return this.cittaPartenza;
    }
    public ICitta getCittaArrivo(){
        return this.cittaArrivo;
    }

}