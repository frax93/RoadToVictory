package com.lynden.example.latlong.Model.FactoryMappa;

import com.lynden.example.latlong.Model.FactoryCitta.Citta;
import com.lynden.example.latlong.Percorso;
import com.lynden.gmapsfx.javascript.object.LatLong;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by micheletaranta on 18/10/18.
 */
public interface IMappa {
    void AddPercorso(Percorso p1);
    ArrayList<Citta> CreaMappa() throws FileNotFoundException, IOException;
}
