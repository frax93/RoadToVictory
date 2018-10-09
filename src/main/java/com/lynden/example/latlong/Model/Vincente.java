package com.lynden.example.latlong.Model;
import com.lynden.example.latlong.Giocatore;
import com.lynden.example.latlong.Stato_Giocatore;

public class Vincente implements Stato_Giocatore {
    @Override
    public void Ruolo(Giocatore g) {
        g.setState(this);

    }
}