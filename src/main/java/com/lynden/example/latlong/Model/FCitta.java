package com.lynden.example.latlong.Model;


import com.lynden.example.latlong.Model.FactoryCitta.ICitta;
import com.lynden.example.latlong.Model.FactoryCitta.Rifornimento;
import com.lynden.example.latlong.Model.FactoryCitta.Normale;
import com.lynden.example.latlong.Model.FactoryCitta.Oscura;

/**
 * Created by frankmd93 on 18/10/18.
 */

public class FCitta {

    public static ICitta getCitta(String criteria)
    {
        if ( criteria.equals("Normale") )
            return new Normale();
        else if ( criteria.equals("Oscura") )
            return new Oscura();
        else if ( criteria.equals("Rifornimento") )
            return new Rifornimento();
        else
            return null;
    }
}
