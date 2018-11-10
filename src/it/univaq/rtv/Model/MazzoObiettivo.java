package it.univaq.rtv.Model;

import it.univaq.rtv.Model.FactoryCitta.ICitta;

import java.util.ArrayList;
import java.util.Random;

public class MazzoObiettivo{
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

        public void addCarta(CartaObiettivo c){
            this.Carte.add((CartaObiettivo) c);
        }

        public CartaObiettivo PescaCarta() {
                int num1=this.MischiaMazzo();
		        CartaObiettivo c=this.Carte.get(num1);
                this.Carte.remove(num1);
                return c;
               
	    }

	    public void ReinserisciCarta(CartaObiettivo c){
            this.Carte.add(c);
        }

	    public int MischiaMazzo() {
               Random r= new Random();
               int num=0;
               int n=this.Carte.size();
               if(n!=0)num= r.nextInt(n);
               return num;
	    }


}