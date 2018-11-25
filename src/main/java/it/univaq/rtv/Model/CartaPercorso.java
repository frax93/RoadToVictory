package it.univaq.rtv.Model;

import it.univaq.rtv.Model.FactoryCitta.ICitta;

public class CartaPercorso{

	private ICitta cittaPartenza;
	private ICitta cittaArrivo;

    /**
     * @param CittaPartenza
     * @param CittaArrivo
     */
    public CartaPercorso(ICitta CittaPartenza, ICitta CittaArrivo) {

        this.cittaPartenza =CittaPartenza;
        this.cittaArrivo =CittaArrivo;
    }

    /**
     * @return
     */
    public ICitta getCittaPartenza(){
        return this.cittaPartenza;
    }

    /**
     * @return
     */
    public ICitta getCittaArrivo(){
        return this.cittaArrivo;
    }

}