package com.lynden.example.latlong.Model.StatoGiocatore;

import com.lynden.example.latlong.Model.Giocatore;


public class Gioca implements Stato_Giocatore {
    @Override
    public  void Ruolo(Giocatore g){
            g.setState(this);
    }

}
