package it.univaq.rtv.Model.FactoryMappa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;

import it.univaq.rtv.Model.*;
import it.univaq.rtv.Model.FactoryCitta.ICitta;
import com.lynden.gmapsfx.javascript.object.LatLong;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by micheletaranta on 18/10/18.
 */
public class Europa extends AbstractMappa {

    public Europa() throws IOException {
        this.nome="Europa";
        ArrayList<ICitta> c = this.CreaMappa();
        Percorso p;
        /*for(int i=0;i<c.size();i++)
            System.out.println("C: "+c.get(i).getNome());*/
        p=new Percorso(1,c.get(13),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(3,c.get(3),c.get(12));
        this.AddPercorso(p);
        p=new Percorso(4,c.get(2),c.get(1));
        this.AddPercorso(p);
        p=new Percorso(5,c.get(15),c.get(3));
        this.AddPercorso(p);
        p=new Percorso(6,c.get(10),c.get(15));
        this.AddPercorso(p);
        p=new Percorso(7,c.get(7),c.get(10));
        this.AddPercorso(p);
        p=new Percorso(8,c.get(4),c.get(7));
        this.AddPercorso(p);
        p=new Percorso(9,c.get(14),c.get(4));
        this.AddPercorso(p);
        p=new Percorso(11,c.get(11),c.get(14));
        this.AddPercorso(p);
        p=new Percorso(13,c.get(0),c.get(6));
        this.AddPercorso(p);
        p=new Percorso(15,c.get(5),c.get(9));
        this.AddPercorso(p);
        p=new Percorso(16,c.get(9),c.get(8));
        this.AddPercorso(p);
        p=new Percorso(17,c.get(6),c.get(2));
        this.AddPercorso(p);
        p=new Percorso(19,c.get(10),c.get(9));
        this.AddPercorso(p);
        p=new Percorso(21,c.get(1),c.get(0));
        this.AddPercorso(p);
        p=new Percorso(22,c.get(11),c.get(8));
        this.AddPercorso(p);
        p=new Percorso(23,c.get(12),c.get(15));
        this.AddPercorso(p);
        p=new Percorso(24,c.get(3),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(25,c.get(5),c.get(8));
        this.AddPercorso(p);
        p=new Percorso(26,c.get(6),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(27,c.get(12),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(28,c.get(3),c.get(1));
        this.AddPercorso(p);
        p=new Percorso(29,c.get(14),c.get(9));
        this.AddPercorso(p);
        p=new Percorso(30,c.get(4),c.get(9));
        this.AddPercorso(p);
        p=new Percorso(31,c.get(2),c.get(3));
        this.AddPercorso(p);
        p=new Percorso(32,c.get(8),c.get(14));
        this.AddPercorso(p);
        p=new Percorso(34,c.get(0),c.get(2));
        this.AddPercorso(p);
        p=new Percorso(35,c.get(2),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(36,c.get(10),c.get(16));
        this.AddPercorso(p);
        p=new Percorso(37,c.get(5),c.get(3));
        this.AddPercorso(p);
        p=new Percorso(38,c.get(3),c.get(16));
        this.AddPercorso(p);
        p=new Percorso(39,c.get(16),c.get(15));
        this.AddPercorso(p);

    }


    @Override
    public ArrayList<ICitta> CreaMappa() throws FileNotFoundException,IOException{
        ArrayList<ICitta> c1 = new ArrayList<ICitta>();
        try {

            FileReader fw = new FileReader("Json/Europa.json");
            ObjectMapper objectMapper = new ObjectMapper();
            HashMap<String, LatLong> maplat = new HashMap<>();


            com.google.gson.JsonParser jsonParser = new com.google.gson.JsonParser();
            JsonArray object = (JsonArray) jsonParser.parse(fw);
            LatLong l = null;
            for (int i = 0; i < object.size(); i++) {
                if (object.get(i) != null) {
                    double latitude = object.get(i).getAsJsonObject().get("latitude").getAsDouble();
                    double longitude = object.get(i).getAsJsonObject().get("longitude").getAsDouble();
                    l = new LatLong(latitude, longitude);
                    maplat.put(object.get(i).getAsJsonObject().get("variableName").toString(), l);
                }

            }

            //Costruzione dei percorsi della mappa DA SPOSTARE IN FUTURO
            for (Map.Entry entry : maplat.entrySet()){
                String nome = (String) entry.getKey();
                String[] nome1 = nome.split(",");
                //Logica di implementazione delle città Oscure e Rifornimento oltre quelle Normali
                ICitta p = FCitta.getCitta("Normale",(String) nome1[0].replace("\"",""));
                p.ImpostaCoordinate((LatLong) entry.getValue());
                c1.add(p);
            }
            return c1;
        } catch (FileNotFoundException exc) {
            return c1;
        }

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
