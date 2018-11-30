package it.univaq.rtv.Model;
import java.util.Random;

public class SingletonDado {
    private static SingletonDado istance = null;
	private Random numero;
    private int lati;

    /**
     * @return
     */
    public static SingletonDado getIstance(){
        if(istance==null){
            istance = new SingletonDado();
            istance.numero = new Random();
            istance.lati=6;
        }
        return istance;
    }

    /**
     *
     */
    protected SingletonDado(){

    }

    /**
     * @return
     */
	public int lancia() {
            int n=1+this.numero.nextInt(this.lati);
            return n;
	}

}