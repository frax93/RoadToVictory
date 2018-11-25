package it.univaq.rtv.Model.StatoGiocatore;
import it.univaq.rtv.Model.Giocatore;

public class Vincente implements IStato_Giocatore {

    @Override
    public void ruolo(Giocatore g) {
        g.setState(this);

    }
}