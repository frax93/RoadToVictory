package it.univaq.rtv.Model;


import it.univaq.rtv.Model.FactoryCitta.ICitta;
import it.univaq.rtv.Model.FactoryCitta.Rifornimento;
import it.univaq.rtv.Model.FactoryCitta.Normale;
import it.univaq.rtv.Model.FactoryCitta.Oscura;



public class FactorCitta {

    /**
     * @param criteria
     * @param nomeCitta
     * @return
     */
    public static ICitta getCitta(String criteria, String nomeCitta )
    {
        if ( criteria.equals("Normale") )
            return new Normale(nomeCitta);
        else if ( criteria.equals("Oscura") )
            return new Oscura(nomeCitta);
        else if ( criteria.equals("Rifornimento") )
            return new Rifornimento(nomeCitta);
        else
            return null;
    }
}
