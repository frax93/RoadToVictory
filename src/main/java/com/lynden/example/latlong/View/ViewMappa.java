package com.lynden.example.latlong;

import com.lynden.example.latlong.Percorso;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.event.EventHandlers;
import com.lynden.gmapsfx.javascript.event.GFXEventHandler;
import com.lynden.gmapsfx.javascript.event.UIEventHandler;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import netscape.javascript.JSObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class ViewMappa {
    @FXML
    private GoogleMapView googleMapView;
    private GoogleMap map;
    private Label CartaObiettivo;
    private Label CartaPercorsoPartenza;
    private Label CartaPercorsoArrivo;
    private Label GiocatoreName;
    private Label FinePartita;
    private Button TurnoButton;
    private Label NumeroMezzo;

    public ViewMappa(GoogleMap map, GoogleMapView googleMapView, Label CartaObiettivo,Label CartapercorsoPartenza, Label CartapercorsoArrivo, Label GiocatoreName, Button TurnoButton,Label NumeroMezzo,Label FinePartita) {
        this.googleMapView = googleMapView;
        this.map = map;
        this.GiocatoreName=GiocatoreName;
        this.CartaObiettivo=CartaObiettivo;
        this.CartaPercorsoArrivo=CartapercorsoArrivo;
        this.CartaPercorsoPartenza=CartapercorsoPartenza;
        this.TurnoButton=TurnoButton;
        this.FinePartita=FinePartita;
        this.NumeroMezzo=NumeroMezzo;

    }

    public void Creamappa(ArrayList<Giocatore> giocatoreArrayList, FMappa mappa, Partita p) throws FileNotFoundException, IOException {
        this.setGiocatoreName(giocatoreArrayList.get(0));
        final Polyline[] polyline = {null};
        MapOptions mapOptions = new MapOptions();
        mapOptions.center(new LatLong(45.70618, 10.01953))
                .mapType(MapTypeIdEnum.ROADMAP)
                .zoom(4)
                .scrollWheel(false)
                .maxZoom(5)
                .streetViewControl(false)
                .zoomControl(true)
                .mapTypeControl(false)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false);
        this.map = this.googleMapView.createMap(mapOptions, false);
        this.setCarte(giocatoreArrayList);
        CartaObiettivo CartaObbGioc1 = giocatoreArrayList.get(0).ChiediCartaObiettivo();
        CartaPercorso CartaPercGioc1 = giocatoreArrayList.get(0).ChiediCartaPercorso();

        ArrayList<Percorso> percorsi = new ArrayList<>();
        percorsi = mappa.DammiPercorsi();



        Percorso pe = null;
        this.setMarker(giocatoreArrayList,mappa);
        for(int a=0;a<giocatoreArrayList.size();a++){
            for (int j = 0; j < percorsi.size(); j++) {
                pe = percorsi.get(j);
                ArrayList<Casella> caselle = pe.getCaselle();
                for (int cont = 0; cont < caselle.size(); cont++) {
                    Polyline finalPolyline = polyline[0];
                    if (Math.abs(giocatoreArrayList.get(a).ChiediCartaPercorso().getCittaPartenza().getCoordinate().getLatitude() - caselle.get(cont).getInizio().getLatitude())<0.5 &&
                            Math.abs(giocatoreArrayList.get(a).ChiediCartaPercorso().getCittaPartenza().getCoordinate().getLatitude() - caselle.get(cont).getInizio().getLatitude())>=0 && Math.abs(giocatoreArrayList.get(a).ChiediCartaPercorso().getCittaPartenza().getCoordinate().getLongitude() - caselle.get(cont).getInizio().getLongitude())<0.5 &&
                            Math.abs(giocatoreArrayList.get(a).ChiediCartaPercorso().getCittaPartenza().getCoordinate().getLongitude() - caselle.get(cont).getInizio().getLongitude())>=0
                    )  {
                        LatLong[] Prova1 = {caselle.get(cont).getInizio(), caselle.get(cont).getFine()};
                    PolylineOptions pippo1 = new PolylineOptions();
                    pippo1.path(new MVCArray(Prova1))
                            .clickable(true)
                            .draggable(false)
                            .strokeColor("blue")
                            .strokeWeight(10)
                            .visible(true);
                    polyline[0] = new Polyline(pippo1);
                    map.addMapShape(polyline[0]);
                    finalPolyline = polyline[0];
                    giocatoreArrayList.get(a).setMezzo(1);
                    giocatoreArrayList.get(a).PosizionaMezzo(caselle.get(cont));
                    giocatoreArrayList.get(a).setMossa(pe.CalcolaCaselleVicine(caselle.get(cont)));
                    ArrayList<Percorso> percorsi_vicini = new ArrayList<>();
                    if (caselle.get(cont).getId() == mappa.getPercorsoByCasella(caselle.get(cont)).getCasellaPartenza().getId()){
                        percorsi_vicini = mappa.getViciniPercorsoPartenza(mappa.getPercorsoByCasella(caselle.get(cont)));}

                    else if (caselle.get(cont).getId() == mappa.getPercorsoByCasella(caselle.get(cont)).getCasellaArrivo().getId()){
                        percorsi_vicini = mappa.getViciniPercorsoArrivo(mappa.getPercorsoByCasella(caselle.get(cont)));}

                    if (percorsi_vicini.size() == 0) ;
                    else {
                        ArrayList<Casella> casellaArrayList = mappa.getCaselleVicinePercorsi(percorsi_vicini, caselle.get(cont));
                        casellaArrayList.remove(null);
                        giocatoreArrayList.get(a).setMosse(casellaArrayList);
                    }



                }

            }
            }
        }

        percorsi=mappa.RimuoviDuplicati(percorsi);
        for (int j = 0; j < percorsi.size(); j++) {
            pe = percorsi.get(j);
            ArrayList<Casella> caselle = pe.getCaselle();
            for (int cont = 0; cont < caselle.size(); cont++) {
                Polyline finalPolyline = polyline[0];
                LatLong[] Prova = {caselle.get(cont).getInizio(), caselle.get(cont).getFine()};
                PolylineOptions pippo = new PolylineOptions();
                pippo.path(new MVCArray(Prova))
                    .clickable(true)
                    .draggable(false)
                    .strokeColor("gray")
                    .strokeWeight(6)
                    .visible(true);
            polyline[0] = new Polyline(pippo);
            map.addMapShape(polyline[0]);
            finalPolyline = polyline[0];
            int finalI = cont;
            Polyline finalPolyline1 = finalPolyline;
            Polyline finalPolyline2 = finalPolyline;
            map.addUIEventHandler(polyline[0], UIEventType.click, (JSObject obj) -> {
                try{
                    p.PosizionaMezzo(finalPolyline1, pippo,finalI,caselle);
                }
                catch (Exception f){
                    System.out.println(f);
                }

            });
            }
        }

        }





    public void PosizionaMezzo(int n,Polyline finalPolyline1, PolylineOptions pippo, ArrayList<Giocatore> giocatoreArrayList){
                    giocatoreArrayList.get(0).setMezzo(n);
                    if (giocatoreArrayList.get(0).getMezzi().size() > 0) {
                        this.NumeroMezzo.setText(String.valueOf(giocatoreArrayList.get(0).getMezzi().size()));
                        pippo.strokeColor(giocatoreArrayList.get(0).getColor());
                        finalPolyline1.setVisible(false);
                        Polyline polyline1 = new Polyline(pippo);
                        map.addMapShape(polyline1);
                    }
                    else if (giocatoreArrayList.get(0).getMezzi().size() == 0) {
                        this.NumeroMezzo.setText(String.valueOf(0));
                        pippo.strokeColor(giocatoreArrayList.get(0).getColor());
                        finalPolyline1.setVisible(false);
                        Polyline polyline1 = new Polyline(pippo);
                        this.map.addMapShape(polyline1);
                        this.TurnoButton.setVisible(true);

    }
    }


    public void setTurnoButton(Boolean button){
         this.TurnoButton.setVisible(button);
    }

    public void setCarte(ArrayList<com.lynden.example.latlong.Giocatore> giocatoreArrayList){
        CartaObiettivo CartaObbGioc1 = giocatoreArrayList.get(0).ChiediCartaObiettivo();
        CartaPercorso CartaPercGioc1 = giocatoreArrayList.get(0).ChiediCartaPercorso();

        this.CartaObiettivo.setText("Città obiettivo: " + CartaObbGioc1.getCittaObiettivo().getNome());
        this.CartaPercorsoPartenza.setText("Partenza:" + CartaPercGioc1.getCittaPartenza().getNome());
        this.CartaPercorsoArrivo.setText("Arrivo:" + CartaPercGioc1.getCittaArrivo().getNome());
    }

    public void setMarker(ArrayList<Giocatore> giocatores, FMappa mappa){
        ArrayList<Marker> markers= new ArrayList<>();
        for(int i=0; i<giocatores.size();i++){
            CartaPercorso c= giocatores.get(i).ChiediCartaPercorso();
            for (int j = 0; j < mappa.getCitta().size(); j++) {

                LatLong coorPartenza = mappa.getCitta().get(j).getCoordinate();
                if (mappa.getCitta().get(j).getNome().equals(c.getCittaPartenza().getNome())) {
                    FMezzo fMezzo=new FMezzo();
                    Mezzo mezGioc1= fMezzo.CreaVagone(giocatores.get(i));
                    mappa.getCitta().get(j).setMezzo(mezGioc1);
                    c.getCittaPartenza().setOccupata(true);
                    MarkerOptions MarkerPartenza = new MarkerOptions();
                    MarkerPartenza.position(coorPartenza);
                    MarkerPartenza.visible(Boolean.TRUE);
                    String nome_giocatore=giocatores.get(i).getUsername().substring(0,1);
                    MarkerPartenza.label(nome_giocatore.concat(giocatores.get(i).getUsername().substring(giocatores.get(i).getUsername().length()-1)));
                    Marker m1 = new Marker(MarkerPartenza);
                    markers.add(m1);
                    map.addMarkers(markers);

                }
            }
        }
    }

    public void setGiocatoreName(Giocatore g){
        this.GiocatoreName.setText(g.getUsername());
        this.GiocatoreName.setTextFill(Color.web(g.getColor()));

    }
    public void setObiettivo(ArrayList<com.lynden.example.latlong.Giocatore> giocatoreArrayList){
        if(giocatoreArrayList.get(0).getObiettivo()==true) {
            this.CartaObiettivo.setTextFill(Color.web("green"));
        }
        else this.CartaObiettivo.setTextFill(Color.web("black"));
    }

    public void FinePartita(com.lynden.example.latlong.Giocatore g){
        this.FinePartita.setVisible(true);
        this.FinePartita.setText(g.getUsername()+" HAI VINTO LA PARTITA!!!!!!");
        this.FinePartita.setTextFill(Color.web(g.getColor()));
    }
}

