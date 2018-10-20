package com.lynden.example.latlong.Model.FactoryMappa;

import com.lynden.example.latlong.Model.FactoryCitta.ICitta;
import com.lynden.example.latlong.Model.Percorso;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by micheletaranta on 18/10/18.
 */
public interface IMappa {
    void AddPercorso(Percorso p1);
    ArrayList<ICitta> CreaMappa() throws IOException;
}
