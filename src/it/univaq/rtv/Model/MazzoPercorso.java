package it.univaq.rtv.Model;

import it.univaq.rtv.Model.FactoryCitta.ICitta;

import java.util.ArrayList;
import java.util.Random;

public class MazzoPercorso{
        private static MazzoPercorso istance = null;
        private ArrayList<CartaPercorso> Carte= new ArrayList<CartaPercorso>();
    public static MazzoPercorso getIstance(ArrayList<Percorso> p){
        if(istance==null){
            istance = new MazzoPercorso();
            for(int i=0;i<p.size();i++){
                Percorso percorso= p.get(i);
                ICitta ca= percorso.getCittaArrivo();
                ICitta cp= percorso.getCittapartenza();
                CartaPercorso c1=new CartaPercorso(cp,ca);
                istance.addCarta(c1);
            }
        }
        return istance;
    }
    public static MazzoPercorso getIstance1(){
        if(istance==null){
        }
        return istance;
    }
    public MazzoPercorso(){

    }
        public void addCarta(CartaPercorso c){
            this.Carte.add((CartaPercorso) c);
        }


	    public CartaPercorso PescaCarta() {
                int num1=this.MischiaMazzo();
		        CartaPercorso c=this.Carte.get(num1);
                this.Carte.remove(num1);
                return c;
        }
        public void ReinserisciCarta(CartaPercorso c){
            this.Carte.add(c);
        }


	    public int MischiaMazzo() {
               Random r= new Random();
               int num= r.nextInt(this.Carte.size());
               return num;
        }


}