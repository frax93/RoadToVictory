package com.lynden.example.latlong;

import com.lynden.example.latlong.Stato_Giocatore;

public class Attesa implements Stato_Giocatore {
    @Override
    public void Ruolo(Giocatore g){
        g.setState(this);
    }

}