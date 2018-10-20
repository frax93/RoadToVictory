package com.lynden.example.latlong.Model;

import com.lynden.example.latlong.Model.FactoryCitta.ICitta;

import java.util.ArrayList;
import java.util.Random;

public class MazzoObiettivo extends Mazzo {
    private static MazzoObiettivo istance = null;
    private ArrayList<CartaObiettivo> Carte= new ArrayList<CartaObiettivo>();
    /**
     *
     * @param Cit
     */
    public static MazzoObiettivo getIstance(ArrayList<ICitta> Cit){
        if(istance==null){
            istance = new MazzoObiettivo();
            for(int i=0;i<Cit.size();i++){
                ICitta c= Cit.get(i);
                CartaObiettivo c1;
                c1=new CartaObiettivo(i, c);
                istance.addCarta(c1);
            }
        }
        return istance;
    }
    public static MazzoObiettivo getIstance1(){
        return istance;
    }
    public MazzoObiettivo(){

    }
        @Override
        public void addCarta(Carta c){
            this.Carte.add((CartaObiettivo) c);
        }
        @Override
        public Carta PescaCarta() {
                int num1=this.MischiaMazzo();
		        CartaObiettivo c=this.Carte.get(num1);
                this.Carte.remove(num1);
                return c;
               
	    }

	    public void ReinserisciCarta(CartaObiettivo c){
            this.Carte.add(c);
        }
        @Override
	    public int MischiaMazzo() {
               Random r= new Random();
               int num=0;
               int n=this.Carte.size();
            System.out.println("Questo è n: "+n);
               if(n!=0)num= r.nextInt(n);
               return num;
	    }
	    public int getCarte(){return this.Carte.size();}

	  /* CANCELLARE IN FUTURO
	   public void stampacarte(){
            for(int i=0;i<this.Carte.size();i++){
                String c=this.Carte.get(i).getNome();
                System.out.println(c);
            }
        }*/

}