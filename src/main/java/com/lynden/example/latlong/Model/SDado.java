package com.lynden.example.latlong.Model;
import java.util.Random;

public class SDado {
    private static SDado istance = null;
	private Random Numero;
    private int lati;
        
    public static SDado getIstance(){
        if(istance==null){
            istance = new SDado();
            istance.Numero= new Random();
            istance.lati=6;
        }
        return istance;
    }
    protected SDado(){

    }
        
	public int Lancia() {
            int n=1+this.Numero.nextInt(this.lati);
            return n;
	}

}