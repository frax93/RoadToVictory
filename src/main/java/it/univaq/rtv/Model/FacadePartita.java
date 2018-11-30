package it.univaq.rtv.Model;

import it.univaq.rtv.Model.FactoryMappa.AbstractMappa;
import it.univaq.rtv.Model.FactoryMezzo.IMezzo;
import it.univaq.rtv.Model.StatoGiocatore.Attesa;
import it.univaq.rtv.Model.StatoGiocatore.Gioca;
import it.univaq.rtv.Model.StatoGiocatore.Vincente;
import it.univaq.rtv.Model.StatoTurno.Generale;
import it.univaq.rtv.Model.StatoTurno.Iniziale;
import it.univaq.rtv.Utility.Utility;
import com.lynden.gmapsfx.javascript.object.*;
import java.io.IOException;
import java.util.*;
import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import java.lang.*;
import java.io.*;


public class FacadePartita {

    private ArrayList<Giocatore> giocatori =new ArrayList<>();
    private AbstractMappa mappa;
    private Generale general;
    private Gioca gioca=new Gioca();
    private Vincente vincente= new Vincente();
    private static FacadePartita istance = null;

    /**
     * @return
     */
    public static FacadePartita getIstance(){
        if(istance==null){
            istance = new FacadePartita();
        }
        return istance;
    }

    /**
     *
     */
    protected FacadePartita(){

    }


    /**
     * @param Nome_mappa
     * @param giocatoriArrayList
     * @return
     */
    public AbstractMappa avviaPartita(String Nome_mappa, ArrayList<Giocatore> giocatoriArrayList){
        Turno t= new Turno();
        Iniziale i=new Iniziale();
        try{
            ArrayList<Giocatore> giocatori_ordinati=i.ordinaGiocatori(giocatoriArrayList);
            Attesa attesa=new Attesa();
            giocatori_ordinati=i.inizioTurno(giocatori_ordinati,Nome_mappa,t, attesa);
            giocatoriArrayList=giocatori_ordinati;
            this.general=new Generale();
            this.mappa =i.getMappa();
            this.giocatori =this.general.inizioTurno(giocatori_ordinati,Nome_mappa,t, this.gioca);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return this.mappa;
        }


    }


    /**
     * @param giocatoreArrayList
     * @return
     */
    public int lanciaDado(ArrayList<Giocatore> giocatoreArrayList) {
       int n = giocatoreArrayList.get(0).lanciaDado();
       giocatoreArrayList.get(0).setMezzo(n);
       return n;
    }

    /**
     * @param finalPolyline1
     * @param polylineOptions
     * @param finalI
     * @param j
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean posizionaMezzo(Polyline finalPolyline1, PolylineOptions polylineOptions, int finalI, int j) throws FileNotFoundException,IOException {
            Casella casella = this.getMappa().dammiPercorsi().get(j).getCaselle().get(finalI);
            MVCArray path = finalPolyline1.getPath();
            polylineOptions.path(path);
            String coordinata = String.valueOf(path.getAt(0));
            String[] LatLinea = coordinata.split(",");
            double Lat = Double.valueOf(LatLinea[0].replace("(", ""));
            double Long = Double.valueOf(LatLinea[1].replace(")", ""));
            LatLong LongCasellaInizio = casella.getInizio();
            LatLong LongCasellaFine = casella.getFine();
            Casella Casella_premuta = casella;


            if ((LongCasellaInizio.getLatitude() == Lat && LongCasellaInizio.getLongitude() == Long) ||
                    (LongCasellaFine.getLatitude() == Lat && LongCasellaFine.getLongitude() == Long)) {

                Percorso PercorsoPremuto = null;
                PercorsoPremuto = mappa.getPercorsoByCasella(Casella_premuta);

                                for (int g2 = 0; g2 < this.giocatori.get(0).getMosse().size(); g2++) {
                                    if (Casella_premuta.getId() == this.giocatori.get(0).getMosse().get(g2).getId()) {
                                        ArrayList<Percorso> percorsi_vicini = new ArrayList<>();
                                        if (Casella_premuta.getId() == PercorsoPremuto.getCasellaPartenza().getId())
                                            percorsi_vicini = this.mappa.getViciniPercorsoPartenza(PercorsoPremuto);

                                        else if (Casella_premuta.getId() == PercorsoPremuto.getCasellaArrivo().getId())
                                            percorsi_vicini = this.mappa.getViciniPercorsoArrivo(PercorsoPremuto);

                                        if (percorsi_vicini.size() == 0) ;
                                        else {
                                            ArrayList<Casella> casellaArrayList = this.mappa.getCaselleVicinePercorsi(percorsi_vicini, Casella_premuta);
                                            casellaArrayList.remove(null);
                                            this.giocatori.get(0).setMosse(casellaArrayList);
                                        }
                                        this.giocatori.get(0).setMossa(PercorsoPremuto.calcolaCasellaVicina(Casella_premuta));
                                        this.giocatori.get(0).posizionaMezzo(Casella_premuta);
                                        this.giocatori.get(0).removeMossa(Casella_premuta);
                                        if(Math.abs(Casella_premuta.getInizio().getLatitude()-this.giocatori.get(0).chiediCartaObiettivo().getCittaObiettivo().getCoordinate().getLatitude())<0.005){
                                            this.giocatori.get(0).obiettivoRaggiunto();
                                        }
                                        if(Math.abs(Casella_premuta.getInizio().getLatitude()-this.giocatori.get(0).chiediCartaPercorso().getCittaArrivo().getCoordinate().getLatitude())<0.005){
                                            this.giocatori.get(0).arrivoRaggiunto();
                                        }
                                        if(this.giocatori.get(0).getObiettivo()==true && this.giocatori.get(0).getArrivo()==true) {
                                            this.giocatori.get(0).setState(vincente);
                                        }
                                        return true;


                                    }


                                    }

                                }
                return false;

    }


    /**
     * @return
     */
    public ArrayList<Giocatore> fineTurno() {
            try{
                Turno t = new Turno();
                Giocatore giocatore_backup = this.giocatori.get(0);
                this.giocatori.remove(giocatore_backup);
                this.giocatori.add(this.giocatori.size(), giocatore_backup);

                this.general.inizioTurno(this.giocatori, this.mappa.getNome(), t, this.gioca);
                this.general.fineTurno(this.giocatori.get(0));

            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                return this.giocatori;
            }

    }

    /**
     * @param giocatorearraylist
     */
    public void setGiocatori(ArrayList<Giocatore> giocatorearraylist){
        this.giocatori = giocatorearraylist;
    }

    /**
     * @return
     */
    public ArrayList<Giocatore> getGiocatori(){
        return this.giocatori;
    }

    /**
     * @param n
     */
    public void creaGiocatori(String n){
        for(int i = 1; i<= Utility.stringToInteger(n); i++){
            Giocatore giocatore = new Giocatore(i,"Giocatore"+i, Utility.colori());
            this.giocatori.add(giocatore);
        }
    }

    /**
     * @return
     */
    public AbstractMappa getMappa(){
        return this.mappa;
    }

    /**
     * @param gioc
     * @param j
     * @param mezzo
     */
    public void setIMezzoGioc(int gioc, int j,String mezzo){
        FactorMezzo factorMezzo =new FactorMezzo();
        IMezzo mezGioc1= factorMezzo.getMezzo(mezzo,FacadePartita.getIstance().getGiocatori().get(gioc));
        mappa.getCitta().get(j).setIMezzo(mezGioc1);
    }

    /**
     * @param percorso
     * @param casella
     * @return
     */
    public ArrayList<Casella> casellePercorsiVicini(int percorso, int casella) {
        ArrayList<Percorso> percorsi_vicini = new ArrayList<>();
        Casella cas = this.getMappa().dammiPercorsi().get(percorso).getCaselle().get(casella);
        if (Utility.equalsIdCasella(cas, this.getMappa().getPercorsoByCasella(cas).getCasellaPartenza())) {
            percorsi_vicini = mappa.getViciniPercorsoPartenza(mappa.getPercorsoByCasella(cas));
        } else if (Utility.equalsIdCasella(cas, mappa.getPercorsoByCasella(cas).getCasellaArrivo())) {
            percorsi_vicini = mappa.getViciniPercorsoArrivo(mappa.getPercorsoByCasella(cas));
        }

        if (percorsi_vicini.size() == 0) ;
        else {
            ArrayList<Casella> casellaArrayList = mappa.getCaselleVicinePercorsi(percorsi_vicini, cas);
            casellaArrayList.remove(null);
            return casellaArrayList;
        }
        return null;
    }

}
