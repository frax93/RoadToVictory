package com.lynden.example.latlong;

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
    private Button TurnoButton;
    private ArrayList<Casella> Stato_attuale = new ArrayList<>();

    public ViewMappa(GoogleMap map, GoogleMapView googleMapView, Label CartaObiettivo,Label CartapercorsoPartenza, Label CartapercorsoArrivo, Label GiocatoreName) {
        this.googleMapView = googleMapView;
        this.map = map;
        this.GiocatoreName=GiocatoreName;
        this.CartaObiettivo=CartaObiettivo;
        this.CartaPercorsoArrivo=CartapercorsoArrivo;
        this.CartaPercorsoPartenza=CartapercorsoPartenza;

    }

    public void Creamappa(ArrayList<Giocatore> giocatoreArrayList, FMappa mappa, Partita p) throws FileNotFoundException, IOException {
        this.GiocatoreName.setText(giocatoreArrayList.get(0).getUsername());
        this.GiocatoreName.setTextFill(Color.web("red"));
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

        CartaObiettivo CartaObbGioc1 = giocatoreArrayList.get(0).ChiediCartaObiettivo();
        CartaPercorso CartaPercGioc1 = giocatoreArrayList.get(0).ChiediCartaPercorso();

        this.CartaObiettivo.setText("Città obiettivo: " + CartaObbGioc1.getCittaObiettivo().getNome());
        this.CartaPercorsoPartenza.setText("Partenza:" + CartaPercGioc1.getCittaPartenza().getNome());
        this.CartaPercorsoArrivo.setText("Arrivo:" + CartaPercGioc1.getCittaArrivo().getNome());

        ArrayList<Percorso> percorsi = new ArrayList<>();
        percorsi = mappa.DammiPercorsi();



        Percorso pe = null;
        this.setMarker(giocatoreArrayList,mappa);
        for (int j = 0; j < percorsi.size(); j++) {
            pe = percorsi.get(j);
            ArrayList<Casella> caselle = pe.getCaselle();
            for (int cont = 0; cont < caselle.size(); cont++) {
                Polyline finalPolyline = polyline[0];
                if (CartaPercGioc1.getCittaPartenza().getCoordinate().getLatitude() == caselle.get(cont).getInizio().getLatitude()
                        &&
                        CartaPercGioc1.getCittaPartenza().getCoordinate().getLongitude() == caselle.get(cont).getInizio().getLongitude()) {
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
                    giocatoreArrayList.get(0).setMezzo(1);
                    giocatoreArrayList.get(0).PosizionaMezzo(caselle.get(cont));
                    this.Stato_attuale.add(pe.CalcolaCaselleVicine(caselle.get(cont)));
                    ArrayList<Percorso> percorsi_vicini = new ArrayList<>();
                    if (caselle.get(cont).getId() == mappa.getPercorsoByCasella(caselle.get(cont)).getCasellaPartenza().getId())
                        percorsi_vicini = mappa.getViciniPercorsoPartenza(mappa.getPercorsoByCasella(caselle.get(cont)));

                    else if (caselle.get(cont).getId() == mappa.getPercorsoByCasella(caselle.get(cont)).getCasellaArrivo().getId())
                        percorsi_vicini = mappa.getViciniPercorsoArrivo(mappa.getPercorsoByCasella(caselle.get(cont)));

                    if (percorsi_vicini.size() == 0) ;
                    else {
                        ArrayList<Casella> casellaArrayList = mappa.getCaselleVicinePercorsi(percorsi_vicini, caselle.get(cont));
                        casellaArrayList.remove(null);
                        this.Stato_attuale.addAll(casellaArrayList);
                    }
                } else {

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
                            p.PosizionaMezzo(finalPolyline1, pippo,finalI,this.Stato_attuale,caselle);
                        }
                       catch (Exception f){
                            System.out.println(f);
                       }

                    });
                }
            }
        }
    }




    public void PosizionaMezzo(int n,Polyline finalPolyline1, PolylineOptions pippo, ArrayList<Giocatore> giocatoreArrayList){
                    giocatoreArrayList.get(0).setMezzo(n);
                    if (giocatoreArrayList.get(0).getMezzi() == null) {
                        pippo.strokeColor("red");
                        finalPolyline1.setVisible(false);
                        Polyline polyline1 = new Polyline(pippo);
                        this.map.addMapShape(polyline1);
                        TurnoButton.setVisible(true);
                    } else if (giocatoreArrayList.get(0).getMezzi().size() > 0) {
                        pippo.strokeColor("red");
                        finalPolyline1.setVisible(false);
                        Polyline polyline1 = new Polyline(pippo);
                        map.addMapShape(polyline1);
                    }

    }






    public void setMarker(ArrayList<com.lynden.example.latlong.Giocatore> giocatores, FMappa mappa){
        ArrayList<Marker> markers= new ArrayList<>();
        for(int i=0; i<giocatores.size();i++){
            CartaPercorso c= giocatores.get(i).ChiediCartaPercorso();
            for (int j = 0; j < mappa.getCitta().size(); j++) {

                LatLong coorPartenza = mappa.getCitta().get(j).getCoordinate();
                if (mappa.getCitta().get(j).getNome().equals(c.getCittaPartenza().getNome())) {
                    FMezzo fMezzo=new FMezzo();
                    Mezzo mezGioc1= fMezzo.CreaVagone(giocatores.get(i));
                    mappa.getCitta().get(j).setMezzo(mezGioc1);

                    //Per settare che la città sia occupata
                    c.getCittaPartenza().setOccupata(true);

                    MarkerOptions MarkerPartenza = new MarkerOptions();
                    MarkerPartenza.position(coorPartenza);
                    MarkerPartenza.visible(Boolean.TRUE);
                    Marker m1 = new Marker(MarkerPartenza);
                    markers.add(m1);
                    map.addMarkers(markers);




                }
            }
        }
    }

    public void setGiocatoreName(Giocatore g){
        this.GiocatoreName.setText(g.getUsername());

    }
}
