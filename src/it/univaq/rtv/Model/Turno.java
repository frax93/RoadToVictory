package it.univaq.rtv.Model;

import it.univaq.rtv.Model.StatoTurno.State_Turno;

public class Turno {
    private State_Turno s;

    public Turno(){
            s = null;
    }

    public void setState(State_Turno state){
            this.s = state;
    }

    public State_Turno getState(){
            return s;
    }
}