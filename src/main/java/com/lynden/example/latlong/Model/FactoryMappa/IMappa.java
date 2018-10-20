package com.lynden.example.latlong.Model.FactoryMappa;

import com.lynden.example.latlong.Model.*;
import com.lynden.example.latlong.Model.FactoryCitta.ICitta;
import com.lynden.gmapsfx.javascript.object.LatLong;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by micheletaranta on 18/10/18.
 */
public interface IMappa {
    String getNome();
    void AddPercorso(Percorso p1);
    ArrayList<ICitta> CreaMappa() throws IOException;
     ArrayList<Percorso> DammiPercorsi();
     void PopolaMappa(ArrayList<Giocatore> giocatores);
     boolean CheckPercorsiVicini(Percorso p1, Percorso p2);
     ArrayList<ICitta> getCitta();
     ArrayList<Percorso> getViciniPercorso(Percorso percorso);
     ArrayList<Percorso> getViciniPercorsoPartenza(Percorso percorso);
     ArrayList<Percorso> getViciniPercorsoArrivo(Percorso percorso);
     ArrayList<Casella> getCaselleVicinePercorsi(ArrayList<Percorso> p, Casella c);
    //Funzione che data una casella restituisce il percorso in cui si trova quella casella
    Percorso getPercorsoByCasella(Casella c);
    ArrayList<Percorso> RimuoviDuplicati(ArrayList<Percorso> percorsi);
    //Funzione che calcola il centro della mappa, che viene utilizzato per posizionare la mappa in modo giusto
    LatLong CalcolaCentro();
}
