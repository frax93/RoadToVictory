package com.lynden.example.latlong;

import java.util.ArrayList;
import java.util.Random;

public class MazzoPercorso extends Mazzo {
        private static MazzoPercorso istance = null;
        private ArrayList<CartaPercorso> Carte= new ArrayList<CartaPercorso>();
    public static MazzoPercorso getIstance(ArrayList<Percorso> p){
        if(istance==null){
            istance = new MazzoPercorso();
            for(int i=0;i<p.size();i++){
                Percorso percorso= p.get(i);
                Citta ca= percorso.getCittaArrivo();
                Citta cp= percorso.getCittapartenza();
                CartaPercorso c1=new CartaPercorso(1,cp,ca);
                istance.addCarta((Carta)c1);
            }
        }
        return istance;
    }
    public static MazzoPercorso getIstance1(){
        if(istance==null){
        }
        return istance;
    }
    protected MazzoPercorso(){

    }
        @Override 
        public void addCarta(Carta c){
            this.Carte.add((CartaPercorso) c);
        }
        
        @Override
	    public Carta PescaCarta() {
                int num1=this.MischiaMazzo();
		        Carta c=this.Carte.get(num1);
                this.Carte.remove(num1);
                return c;
        }
        
        @Override
	    public int MischiaMazzo() {
               Random r= new Random();
               int num= r.nextInt(this.Carte.size());
               return num;
        }


}