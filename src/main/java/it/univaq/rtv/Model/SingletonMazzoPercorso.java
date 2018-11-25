package it.univaq.rtv.Model;

import it.univaq.rtv.Model.FactoryCitta.ICitta;

import java.util.ArrayList;
import java.util.Random;

public class SingletonMazzoPercorso {
        private static SingletonMazzoPercorso istance = null;
        private ArrayList<CartaPercorso> Carte= new ArrayList<CartaPercorso>();

    /**
     * @param p
     * @return
     */
    public static SingletonMazzoPercorso getIstance(ArrayList<Percorso> p){
        if(istance==null){
            istance = new SingletonMazzoPercorso();
            for(int i=0;i<p.size();i++){
                Percorso percorso= p.get(i);
                ICitta ca= percorso.getCittaArrivo();
                ICitta cp= percorso.getCittaPartenza();
                CartaPercorso c1=new CartaPercorso(cp,ca);
                istance.addCarta(c1);
            }
        }
        return istance;
    }

    /**
     * @return
     */
    public static SingletonMazzoPercorso getIstance1(){
        if(istance==null){
        }
        return istance;
    }

    /**
     *
     */
    public SingletonMazzoPercorso(){

    }

    /**
     * @param c
     */
        public void addCarta(CartaPercorso c){
            this.Carte.add((CartaPercorso) c);
        }


    /**
     * @return
     */
	    public CartaPercorso pescaCarta() {
                int num1=this.mischiaMazzo();
		        CartaPercorso c=this.Carte.get(num1);
                this.Carte.remove(num1);
                return c;
        }

    /**
     * @param c
     */
        public void reinserisciCarta(CartaPercorso c){
            this.Carte.add(c);
        }


    /**
     * @return
     */
	    public int mischiaMazzo() {
               Random r= new Random();
               int num= r.nextInt(this.Carte.size());
               return num;
        }


}