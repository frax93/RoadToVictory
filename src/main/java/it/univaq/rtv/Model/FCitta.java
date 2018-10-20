package it.univaq.rtv.Model;


import it.univaq.rtv.Model.FactoryCitta.ICitta;
import it.univaq.rtv.Model.FactoryCitta.Rifornimento;
import it.univaq.rtv.Model.FactoryCitta.Normale;
import it.univaq.rtv.Model.FactoryCitta.Oscura;

/**
 * Created by frankmd93 on 18/10/18.
 */

public class FCitta {

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
