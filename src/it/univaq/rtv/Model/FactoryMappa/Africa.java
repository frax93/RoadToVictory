package it.univaq.rtv.Model.FactoryMappa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import it.univaq.rtv.Model.*;
import it.univaq.rtv.Model.FactoryCitta.ICitta;

import it.univaq.rtv.Model.FactoryMezzo.Vagone;
import com.lynden.gmapsfx.javascript.object.LatLong;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;



public class Africa implements IMappa {
    private String nome;
    private ArrayList<Percorso> p=new ArrayList<Percorso>();
    public Africa() throws IOException {
        this.nome="Africa";
        ArrayList<ICitta> c = this.CreaMappa();
        for(int i=0;i<c.size();i++)
            System.out.println("C: "+c.get(i).getNome());
        Percorso p;
        p=new Percorso(1,c.get(4),c.get(9));
        this.AddPercorso(p);
        p=new Percorso(2,c.get(9),c.get(21));
        this.AddPercorso(p);
        p=new Percorso(3,c.get(10),c.get(3));
        this.AddPercorso(p);
        p=new Percorso(4,c.get(3),c.get(4));
        this.AddPercorso(p);
        p=new Percorso(5,c.get(21),c.get(4));
        this.AddPercorso(p);
        p=new Percorso(6,c.get(18),c.get(21));
        this.AddPercorso(p);
        p=new Percorso(7,c.get(18),c.get(10));
        this.AddPercorso(p);
        p=new Percorso(8,c.get(20),c.get(10));
        this.AddPercorso(p);
        p=new Percorso(9,c.get(20),c.get(3));
        this.AddPercorso(p);
        p=new Percorso(10,c.get(18),c.get(20));
        this.AddPercorso(p);
        p=new Percorso(11,c.get(15),c.get(20));
        this.AddPercorso(p);
        p=new Percorso(12,c.get(0),c.get(18));
        this.AddPercorso(p);
        p=new Percorso(13,c.get(0),c.get(15));
        this.AddPercorso(p);
        p=new Percorso(14,c.get(11),c.get(0));
        this.AddPercorso(p);
        p=new Percorso(15,c.get(15),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(16,c.get(11),c.get(19));
        this.AddPercorso(p);
        p=new Percorso(17,c.get(16),c.get(18));
        this.AddPercorso(p);
        p=new Percorso(18,c.get(2),c.get(16));
        this.AddPercorso(p);
        p=new Percorso(19,c.get(17),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(20,c.get(17),c.get(19));
        this.AddPercorso(p);
        p=new Percorso(21,c.get(7),c.get(17));
        this.AddPercorso(p);
        p=new Percorso(22,c.get(8),c.get(2));
        this.AddPercorso(p);
        p=new Percorso(23,c.get(1),c.get(7));
        this.AddPercorso(p);
        p=new Percorso(24,c.get(1),c.get(22));
        this.AddPercorso(p);
        p=new Percorso(25,c.get(16),c.get(8));
        this.AddPercorso(p);
        p=new Percorso(26,c.get(7),c.get(22));
        this.AddPercorso(p);
        p=new Percorso(27,c.get(1),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(28,c.get(6),c.get(12));
        this.AddPercorso(p);
        p=new Percorso(29,c.get(6),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(30,c.get(12),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(31,c.get(12),c.get(22));
        this.AddPercorso(p);
        p=new Percorso(32,c.get(5),c.get(22));
        this.AddPercorso(p);
        p=new Percorso(33,c.get(22),c.get(14));
        this.AddPercorso(p);
        p=new Percorso(34,c.get(14),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(34,c.get(19),c.get(5));
        this.AddPercorso(p);
        p=new Percorso(34,c.get(5),c.get(7));
        this.AddPercorso(p);
        p=new Percorso(35,c.get(8),c.get(6));
        this.AddPercorso(p);
        p=new Percorso(36,c.get(8),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(37,c.get(14),c.get(12));
        this.AddPercorso(p);
        p=new Percorso(38,c.get(8),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(39,c.get(16),c.get(0));
        this.AddPercorso(p);
        p=new Percorso(40,c.get(6),c.get(1));
        this.AddPercorso(p);






    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void AddPercorso(Percorso p1){
        this.p.add(p1);
    }
    @Override
    public ArrayList<ICitta> CreaMappa()throws FileNotFoundException,IOException{
        ArrayList<ICitta> c1=new ArrayList<ICitta>();
        try {

            FileReader fw = new FileReader("Africa.json");
            ObjectMapper objectMapper = new ObjectMapper();
            HashMap<String, LatLong> maplat = new HashMap<>();


            com.google.gson.JsonParser jsonParser = new com.google.gson.JsonParser();
            JsonArray object = (JsonArray) jsonParser.parse(fw);
            LatLong l=null;
            for (int i = 0; i < object.size(); i++) {
                if(object.get(i) != null){
                    double latitude= object.get(i).getAsJsonObject().get("latitude").getAsDouble();
                    double longitude=object.get(i).getAsJsonObject().get("longitude").getAsDouble();
                    l = new LatLong(latitude,longitude);
                    maplat.put(object.get(i).getAsJsonObject().get("variableName").toString(), l);
                }

            }

            //Costruzione dei percorsi della mappa DA SPOSTARE IN FUTURO
            for (Map.Entry entry : maplat.entrySet()){
                String nome=(String) entry.getKey();
                String[] nome1 = nome.split(",");
                //Logica per città oscure e rifornimento oltre a quelle normali
                ICitta p = FCitta.getCitta("Normale",(String) nome1[0].replace("\"",""));
                p.ImpostaCoordinate((LatLong) entry.getValue());
                c1.add(p);
            }
            return c1;
        }

        catch (FileNotFoundException exc) {
            return c1;
        }

    }

    @Override
    public ArrayList<Percorso> DammiPercorsi() {

        return this.p;

    }
    @Override
    public boolean CheckPercorsiVicini(Percorso p1, Percorso p2) {
        if( p1.getCittapartenza().getNome().equals(p2.getCittapartenza().getNome()) ||
                p1.getCittapartenza().getNome().equals(p2.getCittaArrivo().getNome()) ||
                p1.getCittaArrivo().getNome().equals(p2.getCittaArrivo().getNome()) ||
                p1.getCittaArrivo().getNome().equals(p2.getCittapartenza().getNome()))
            return true;
        else
            return false;
    }

    /**
     *
     * @param Giocatori
     */
    public void PopolaMappa(ArrayList<Giocatore> giocatores) {
        for(int i=0; i<giocatores.size();i++){
            Giocatore g=giocatores.get(i);
            FMezzo factory= new FMezzo();
            Vagone v=factory.CreaVagone(g);
            CartaPercorso c1=g.ChiediCartaPercorso();
            for(int j=0;j<this.p.size();j++){
                Percorso p1=p.get(j);
                p1.TrovaPercorso(c1,factory,g);
            }
        }
    }

    @Override
    public ArrayList<ICitta> getCitta(){
        ArrayList<ICitta> c=new ArrayList<ICitta>();
        for(int i=0; i<this.p.size();i++) {
            Percorso percorso = p.get(i);
            ICitta citta1=percorso.getCittapartenza();
            ICitta citta2=percorso.getCittaArrivo();
            c.add(citta1);
            c.add(citta2);
        }
        java.util.Set setta_citta=new HashSet(c);
        ArrayList<ICitta> c1=new ArrayList<ICitta>(setta_citta);
        return c1;

    }
    @Override
    public ArrayList<Percorso> getViciniPercorso(Percorso percorso){
        ArrayList<Percorso> percorsos=new ArrayList<>();
        for (int a = 0; a < this.DammiPercorsi().size(); a++) {
            Percorso per1 = this.DammiPercorsi().get(a);
            if ( percorso.getCittapartenza().getNome().equals(per1.getCittapartenza().getNome())
                    ||percorso.getCittapartenza().getNome().equals(per1.getCittaArrivo().getNome())
                    ||percorso.getCittaArrivo().getNome().equals(per1.getCittaArrivo().getNome())
                    ||percorso.getCittaArrivo().getNome().equals(per1.getCittapartenza().getNome())
            ){
                percorsos.add(per1);

            }

        }
        return percorsos;
    }
    @Override
    public ArrayList<Percorso> getViciniPercorsoPartenza(Percorso percorso){
        ArrayList<Percorso> percorsos=new ArrayList<>();
        for (int a=0; a < this.DammiPercorsi().size(); a++) {
            Percorso per1 = this.DammiPercorsi().get(a);
            if(percorso.getid()==per1.getid());
            else if ( percorso.getCittapartenza().getNome().equals(per1.getCittapartenza().getNome())
                    ||percorso.getCittapartenza().getNome().equals(per1.getCittaArrivo().getNome())
            ){
                percorsos.add(per1);

            }

        }
        return percorsos;
    }
    @Override
    public ArrayList<Percorso> getViciniPercorsoArrivo(Percorso percorso){
        ArrayList<Percorso> percorsos=new ArrayList<>();
        for (int a=0; a < this.DammiPercorsi().size(); a++) {
            Percorso per1 = this.DammiPercorsi().get(a);
            if(percorso.getid()==per1.getid());
            else if (  percorso.getCittaArrivo().getNome().equals(per1.getCittaArrivo().getNome())
                    ||percorso.getCittaArrivo().getNome().equals(per1.getCittapartenza().getNome())
            ){
                percorsos.add(per1);

            }

        }
        return percorsos;
    }
    @Override
    public ArrayList<Casella> getCaselleVicinePercorsi(ArrayList<Percorso> p, Casella c){
        ArrayList<Casella> casellas= new ArrayList<>();
        for(int i=0; i<p.size();i++)
            casellas.add(p.get(i).getCasellaPerVicino(c));
        return casellas;

    }




    @Override
    public Percorso getPercorsoByCasella(Casella c){
        ArrayList<Percorso> percorsi = this.DammiPercorsi();
        boolean esci=false;
        int i;
        ArrayList<Casella> caselle = new ArrayList<>();
        for (i=0; i <percorsi.size();i++){
            caselle= percorsi.get(i).getCaselle();
            for(int j=0;j<caselle.size();j++) {
                if (c.getId() ==caselle.get(j).getId()) {
                    esci=true;
                    break;}
            }
            if(esci==true) break;
        }
        return percorsi.get(i);

    }
    @Override
    public ArrayList<Percorso> RimuoviDuplicati(ArrayList<Percorso> percorsi){
        ArrayList<Percorso> percorso_no_s=percorsi;
        for(int i=0;i<percorsi.size();i++){
            Percorso percorso=percorsi.get(i);
            for(int j=0;j<percorsi.size();j++){
                Percorso percorso1=percorsi.get(j);
                if(percorso.getid()!=percorso1.getid()) {
                    if ((Math.abs(percorso1.getCasellaPartenza().getInizio().getLatitude() - percorso.getCasellaPartenza().getInizio().getLatitude()) < 0.0005
                            && Math.abs(percorso1.getCasellaPartenza().getInizio().getLongitude() - percorso.getCasellaPartenza().getInizio().getLongitude()) < 0.005)) {
                        percorso1.removeCasella(percorso1.getCasellaPartenza());
                        percorso_no_s.remove(percorso1);
                        percorso_no_s.add(percorso1);
                    } else if ((Math.abs(percorso1.getCasellaPartenza().getInizio().getLatitude() - percorso.getCasellaArrivo().getInizio().getLatitude()) < 0.0005
                            && Math.abs(percorso1.getCasellaPartenza().getInizio().getLongitude() - percorso.getCasellaArrivo().getInizio().getLongitude()) < 0.005)) {
                        percorso1.removeCasella(percorso1.getCasellaPartenza());
                        percorso_no_s.remove(percorso1);
                        percorso_no_s.add(percorso1);
                    } else if ((Math.abs(percorso1.getCasellaArrivo().getInizio().getLatitude() - percorso.getCasellaPartenza().getInizio().getLatitude()) < 0.0005
                            && Math.abs(percorso1.getCasellaArrivo().getInizio().getLongitude() - percorso.getCasellaPartenza().getInizio().getLongitude()) < 0.005)) {
                        percorso1.removeCasella(percorso1.getCasellaArrivo());
                        percorso_no_s.remove(percorso1);
                        percorso_no_s.add(percorso1);
                    } else if ((Math.abs(percorso1.getCasellaArrivo().getInizio().getLatitude() - percorso.getCasellaArrivo().getInizio().getLatitude()) < 0.0005
                            && Math.abs(percorso1.getCasellaArrivo().getInizio().getLongitude() - percorso.getCasellaArrivo().getInizio().getLongitude()) < 0.005)) {
                        percorso1.removeCasella(percorso1.getCasellaArrivo());
                        percorso_no_s.remove(percorso1);
                        percorso_no_s.add(percorso1);
                    }

                }
            }
        }
        return percorso_no_s;

    }


    @Override
    public LatLong CalcolaCentro(){
        ArrayList<ICitta> cittas=new ArrayList<ICitta>();
        cittas=this.getCitta();

        LatLong l=null;
        double inizioLat=cittas.get(0).getCoordinate().getLatitude();
        double inizioLong=cittas.get(0).getCoordinate().getLongitude();
        double lat_min=inizioLat,lat_max=inizioLat,long_min=inizioLong, long_max=inizioLong, lat, longi;

        for (int i=1; i<cittas.size();i++){
            if(cittas.get(i).getCoordinate().getLatitude()>lat_max) lat_max=cittas.get(i).getCoordinate().getLatitude();
            if(cittas.get(i).getCoordinate().getLatitude()<lat_min) lat_min=cittas.get(i).getCoordinate().getLatitude();
            if(cittas.get(i).getCoordinate().getLongitude()>long_max) long_max=cittas.get(i).getCoordinate().getLongitude();
            if(cittas.get(i).getCoordinate().getLongitude()<long_min) long_min=cittas.get(i).getCoordinate().getLongitude();
        }
        lat=(lat_max+lat_min)/2;
        longi=(long_max+long_min)/2;
        l=new LatLong(lat,longi);
        return l;
    }
}