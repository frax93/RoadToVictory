package it.univaq.rtv.Utility;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import it.univaq.rtv.Model.Casella;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.Percorso;
import javafx.scene.control.Alert;

import javax.swing.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


//Classe di utilità per funzioni di supporto al gioco RTV
public class Utility {

    public static ArrayList<String> colori= new ArrayList<String>() {{
        add("red");
        add("aqua");
        add("orange");
        add("pink");
        add("teal");
        add("white");
    }};

    /**
     * @param colore
     * @return
     */
    public static String colorToRgba(String colore){
        String c = null;
        if(colore=="red")  c="rgba(255,0,0,1)";
        else if(colore=="aqua")  c="rgba(0,255,255,1)";
        else if(colore=="orange")  c="rgba(255,165,0,1)";
        else if(colore=="pink")  c="rgba(255,192,203,1)";
        else if(colore=="green") c="rgba(45,255,13,1)";
        else if(colore=="white") c="rgba(255,255,255,1)";
        else if(colore=="teal") c="rgba(0,128,128,1)";
        else if(colore=="black") c="rgba(0,0,0,1)";
        return c;
    }

    /**
     * @return
     */
    public static String colori(){

        Random num= new Random();
        String colorescelto;
        int n=num.nextInt(colori.size());
        colorescelto=colori.get(n);
        colori.remove(colori.get(n));
        return colorescelto;

    }

    /**
     * @param s
     * @return
     */
    public static int stringToInteger(String s){
        if(s.equals("Uno")) return 1;
        else if(s.equals("Due")) return 2;
        else if(s.equals("Tre")) return 3;
        else if(s.equals("Quattro")) return 4;
        else if(s.equals("Cinque")) return 5;
        else if(s.equals("Sei")) return 6;
        else if(s.equals("Sette")) return 7;
        else if(s.equals("Otto")) return 8;
        else if(s.equals("Nove")) return 9;
        else return 0;


    }

    /**
     * @param nomeMappa
     * @return
     */
    public static CittaDTO[] getRestConnection(String nomeMappa){
        CittaDTO[] cittaDTOS = null;
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create();
        String URL = "http://localhost:8080/RTV_Server_war_exploded/"+nomeMappa.toLowerCase();
        WebResource webResourceGet = client.resource(URL);
        ClientResponse response = webResourceGet.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        else{
            cittaDTOS=response.getEntity(CittaDTO[].class);
        }
        return cittaDTOS;
    }

    /**
     * @param giocatore
     * @param casella
     * @return
     */
    public static boolean isPartenza(Giocatore giocatore, Casella casella){
        if(Math.abs(giocatore.chiediCartaPercorso().getCittaPartenza().getCoordinate().getLatitude() - casella.getInizio().getLatitude())<0.5 && Math.abs(giocatore.chiediCartaPercorso().getCittaPartenza().getCoordinate().getLongitude() - casella.getInizio().getLongitude())<0.5) return true;
        else return false;
    }

    /**
     * @param casella1
     * @param casella2
     * @return
     */
    public static boolean equalsIdCasella(Casella casella1, Casella casella2){
        if(casella1.getId()==casella2.getId())return true;
        else return false;
    }

    /**
     * @param gioc
     * @param cittausate
     * @return
     */
    public static boolean equalsCitta(Giocatore gioc, String cittausate ){
        if(gioc.chiediCartaObiettivo().getCittaObiettivo().getNome().equals(cittausate)||gioc.chiediCartaPercorso().getCittaPartenza().getNome().equals(cittausate)||gioc.chiediCartaPercorso().getCittaArrivo().getNome().equals(cittausate)||gioc.chiediCartaObiettivo().getCittaObiettivo().getNome().equals(gioc.chiediCartaPercorso().getCittaPartenza().getNome()))return true;
        else return false;
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static boolean equalsPartenza(Percorso p1, Percorso p2){
        if((Math.abs(p1.getCasellaPartenza().getInizio().getLatitude() - p2.getCasellaPartenza().getInizio().getLatitude()) < 0.0005
                && Math.abs(p1.getCasellaPartenza().getInizio().getLongitude() - p2.getCasellaPartenza().getInizio().getLongitude()) < 0.005)) return true;
        else return false;
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static boolean equalsPartenzaArrivo(Percorso p1, Percorso p2){
        if((Math.abs(p1.getCasellaPartenza().getInizio().getLatitude() - p2.getCasellaArrivo().getInizio().getLatitude()) < 0.0005
                && Math.abs(p1.getCasellaPartenza().getInizio().getLongitude() - p2.getCasellaArrivo().getInizio().getLongitude()) < 0.005)) return true;
        else return false;
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static boolean equalsArrivoPartenza(Percorso p1, Percorso p2){
        if((Math.abs(p1.getCasellaArrivo().getInizio().getLatitude() - p2.getCasellaPartenza().getInizio().getLatitude()) < 0.0005
                && Math.abs(p1.getCasellaArrivo().getInizio().getLongitude() - p2.getCasellaPartenza().getInizio().getLongitude()) < 0.005)) return true;
        else return false;
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static boolean equalsArrivo(Percorso p1, Percorso p2){
        if((Math.abs(p1.getCasellaArrivo().getInizio().getLatitude() - p2.getCasellaArrivo().getInizio().getLatitude()) < 0.0005
                && Math.abs(p1.getCasellaArrivo().getInizio().getLongitude() - p2.getCasellaArrivo().getInizio().getLongitude()) < 0.005)) return true;
        else return false;
    }

    /**
     * @param title
     * @param text
     * @param type
     */
    public static void setAlertMsg(String title, String text, Alert.AlertType type){
        Alert alert=new Alert(type);
        alert.setTitle(title);
       // alert.setHeaderText("Result :");
        alert.setContentText(text);
        alert.show();
    }
}
