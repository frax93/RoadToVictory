package it.univaq.rtv.Model;
import com.lynden.gmapsfx.javascript.object.LatLong;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;

public class Casella {
    
        private boolean occupata;
        private int id;
        private IMezzo m=null;
        private LatLong inizio;
        private LatLong fine;

    /**
     * @param id
     */
        public Casella(int id){
            this.id=id;
            this.occupata=false;
            this.inizio=null;
            this.fine=null;
        }


    /**
     * @return
     */
    public LatLong getInizio() {
        return inizio;
    }

    /**
     * @return
     */
    public LatLong getFine() {
        return fine;
    }

    /**
     * @param g
     */
    public void posizionaGiocatore(Giocatore g){
            this.m=g.getMezzo().get(g.getMezzo().size()-1);

            this.setOccupata(true);
        }

    /**
     * @param i
     * @param f
     */
    public void impostaCoordinate(LatLong i, LatLong f){
	    this.inizio=i;
	    this.fine=f;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @return
     */
    public boolean checkOccupata(){
            return this.occupata;
        }

    /**
     * @param occupata
     */
    public void setOccupata(boolean occupata) {
        this.occupata = occupata;
    }
}





