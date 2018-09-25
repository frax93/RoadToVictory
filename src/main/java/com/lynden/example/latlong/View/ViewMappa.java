package com.lynden.example.latlong;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
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

    public void Creamappa(ArrayList<Giocatore> giocatoreArrayList) throws FileNotFoundException, IOException {
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

        giocatoreArrayList.get(0).setMezzo(100);




        /********* Impostare Carta Percorso e Obiettivo *******/
        FMappa mappap = new FMappa(giocatoreArrayList, "Europa");
        mappap.CreaMappa();
        MazzoPercorso m1 = new MazzoPercorso();
        m1 = m1.getIstance(mappap.DammiPercorsi());
        MazzoObiettivo m2 = new MazzoObiettivo();
        m2 = m2.getIstance(mappap.getCitta());
        for (int i = 0; i < giocatoreArrayList.size(); i++)
            giocatoreArrayList.get(i).PescaDueCarte();
        CartaObiettivo CartaObbGioc1 = giocatoreArrayList.get(0).ChiediCartaObiettivo();
        CartaPercorso CartaPercGioc1 = giocatoreArrayList.get(0).ChiediCartaPercorso();

        this.CartaObiettivo.setText("Città obiettivo: " + CartaObbGioc1.getCittaObiettivo().getNome());
        this.CartaPercorsoPartenza.setText("Partenza:" + CartaPercGioc1.getCittaPartenza().getNome());
        this.CartaPercorsoArrivo.setText("Arrivo:" + CartaPercGioc1.getCittaArrivo().getNome());

        ArrayList<Percorso> percorsi = new ArrayList<>();
        percorsi = mappap.DammiPercorsi();



        Percorso pe = null;
        this.setMarker(giocatoreArrayList,mappap);
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
                    if (caselle.get(cont).getId() == mappap.getPercorsoByCasella(caselle.get(cont)).getCasellaPartenza().getId())
                        percorsi_vicini = mappap.getViciniPercorsoPartenza(mappap.getPercorsoByCasella(caselle.get(cont)));

                    else if (caselle.get(cont).getId() == mappap.getPercorsoByCasella(caselle.get(cont)).getCasellaArrivo().getId())
                        percorsi_vicini = mappap.getViciniPercorsoArrivo(mappap.getPercorsoByCasella(caselle.get(cont)));

                    if (percorsi_vicini.size() == 0) ;
                    else {
                        ArrayList<Casella> casellaArrayList = mappap.getCaselleVicinePercorsi(percorsi_vicini, caselle.get(cont));
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

                        MVCArray path = finalPolyline1.getPath();
                        pippo.path(path);
                        /****** per trovare la casella nella mappa******/
                        String coordinata = String.valueOf(path.getAt(0));
                        String[] LatLinea = coordinata.split(",");
                        com.lynden.example.latlong.CartaPercorso c = giocatoreArrayList.get(0).ChiediCartaPercorso();
                        ArrayList<com.lynden.example.latlong.Percorso> per_vicini = new ArrayList<>();
                        ArrayList<Percorso> per_vicini_partenza = new ArrayList<>();
                        ArrayList<Percorso> per_vicini_arrivo = new ArrayList<>();
                        double Lat = Double.valueOf(LatLinea[0].replace("(", ""));
                        double Long = Double.valueOf(LatLinea[1].replace(")", ""));
                        Casella casella_attuale = new com.lynden.example.latlong.Casella(1);
                        ArrayList<Percorso> ricercapercorso = mappap.DammiPercorsi();
                        for (int t = 0; t < ricercapercorso.size(); t++) {
                            ArrayList<Casella> ricerca_casella = ricercapercorso.get(t).getCaselle();
                            for (int r = 0; r < ricerca_casella.size(); r++) {
                                /**** SISTEMARE RICERCA CASELLA PREMUTA ****/
                                Casella casella_puntata = ricerca_casella.get(r);
                                if (casella_puntata.getInizio().getLatitude() == Lat && casella_puntata.getInizio().getLongitude() == Long)
                                    casella_attuale = casella_puntata;


                            }
                        }
                        LatLong LongCasellaInizio = caselle.get(finalI).getInizio();
                        LatLong LongCasellaFine = caselle.get(finalI).getFine();
                        Casella Casella_premuta = caselle.get(finalI);


                        if ((LongCasellaInizio.getLatitude() == Lat && LongCasellaInizio.getLongitude() == Long) ||
                                (LongCasellaFine.getLatitude() == Lat && LongCasellaFine.getLongitude() == Long)) {


                            Percorso PercorsoPremuto = null;
                            PercorsoPremuto = mappap.getPercorsoByCasella(Casella_premuta);

                            giocatoreArrayList.get(0).setMezzo(100);
                            com.lynden.example.latlong.Casella CasArrivoPremuto = PercorsoPremuto.getCasellaArrivo();
                            per_vicini = mappap.getViciniPercorso(mappap.getPercorsoByCasella(Casella_premuta));
                            per_vicini_partenza = mappap.getViciniPercorsoPartenza(mappap.getPercorsoByCasella(Casella_premuta));
                            per_vicini_arrivo = mappap.getViciniPercorsoArrivo(mappap.getPercorsoByCasella(Casella_premuta));
                            for (int d = 0; d < this.Stato_attuale.size(); d++) {

                                if (Casella_premuta.getId()==this.Stato_attuale.get(d).getId()) {
                                    this.Stato_attuale.add(PercorsoPremuto.CalcolaCaselleVicine(Casella_premuta));
                                    this.Stato_attuale.remove(Casella_premuta);
                                    ArrayList<Percorso> percorsi_vicini=new ArrayList<>();
                                    if(Casella_premuta.getId()==PercorsoPremuto.getCasellaPartenza().getId())
                                        percorsi_vicini=mappap.getViciniPercorsoPartenza(PercorsoPremuto);

                                    else if(Casella_premuta.getId()==PercorsoPremuto.getCasellaArrivo().getId())
                                        percorsi_vicini = mappap.getViciniPercorsoArrivo(PercorsoPremuto);

                                    if(percorsi_vicini.size()==0);
                                    else {ArrayList<Casella> casellaArrayList=mappap.getCaselleVicinePercorsi(percorsi_vicini,Casella_premuta);
                                        casellaArrayList.remove(null);
                                        this.Stato_attuale.addAll(casellaArrayList);
                                    }
                                    giocatoreArrayList.get(0).PosizionaMezzo(Casella_premuta);
                                    if (giocatoreArrayList.get(0).getMezzi() == null) {
                                        //NumeroMezzo.setText(String.valueOf(0));
                                        pippo.strokeColor("red");
                                        finalPolyline2.setVisible(false);
                                        Polyline polyline1 = new Polyline(pippo);
                                        map.addMapShape(polyline1);
                                        TurnoButton.setVisible(true);
                                    } else if (giocatoreArrayList.get(0).getMezzi().size() > 0) {
                                        //NumeroMezzo.setText(String.valueOf(giocatore.getMezzi().size()));
                                        pippo.strokeColor("red");
                                        finalPolyline2.setVisible(false);
                                        Polyline polyline1 = new Polyline(pippo);
                                        map.addMapShape(polyline1);
                                    }

                                }


                            }
                        }

                    });
                }
            }
        }
    }





        /********* Impostare i Percorsi della Mappa *******/
            /*for (int j = 0; j < percorsi.size(); j++) {
                Percorso pe = percorsi.get(j);

                ArrayList<Casella> caselle = pe.getCaselle();
                for (int i = 0; i < caselle.size(); i++) {
                    Polyline finalPolyline = polyline[0];

                    LatLong[] Prova1 = {caselle.get(i).getInizio(), caselle.get(i).getFine()};
                    //p.CheckSuiVicini(caselle.get(i));
                    PolylineOptions pippo1 = new PolylineOptions();
                    pippo1.path(new MVCArray(Prova1))
                            .clickable(true)
                            .draggable(false)
                            .strokeColor("blue")
                            .strokeWeight(10)
                            .visible(true);
                    polyline[0] = new Polyline(pippo1);
                    map.addMapShape(polyline[0]);
                    //Polyline finalPolyline = polyline[0];
                    giocatore.setMezzo(1);
                    giocatore.PosizionaMezzo(caselle.get(i));
                    this.Stato_attuale.add(pe.CalcolaCaselleVicine(caselle.get(i)));
                    ArrayList<Percorso> percorsi_vicini1 = new ArrayList<>();
                    if (caselle.get(i).getId() == mappap.getPercorsoByCasella(caselle.get(i)).getCasellaPartenza().getId())
                        percorsi_vicini1 = mappap.getViciniPercorsoPartenza(mappap.getPercorsoByCasella(caselle.get(i)));

                    else if (caselle.get(i).getId() == mappap.getPercorsoByCasella(caselle.get(i)).getCasellaArrivo().getId())
                        percorsi_vicini1 = mappap.getViciniPercorsoArrivo(mappap.getPercorsoByCasella(caselle.get(i)));

                    if (percorsi_vicini1.size() == 0) ;
                    else {
                        ArrayList<Casella> casellaArrayList = mappap.getCaselleVicinePercorsi(percorsi_vicini1, caselle.get(i));
                        casellaArrayList.remove(null);
                        this.Stato_attuale.addAll(casellaArrayList);


                        LatLong[] Prova = {caselle.get(i).getInizio(), caselle.get(i).getFine()};
                        //p.CheckSuiVicini(caselle.get(i));
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
                        int finalI = i;
                        Polyline finalPolyline1 = finalPolyline;
                        map.addUIEventHandler(polyline[0], UIEventType.click, (JSObject obj) -> {

                            MVCArray path = finalPolyline1.getPath();
                            pippo.path(path);
                            /****** per trovare la casella nella mappa******/
                           /* String coordinata = String.valueOf(path.getAt(0));
                            String[] LatLinea = coordinata.split(",");
                            CartaPercorso c = giocatore.ChiediCartaPercorso();
                            ArrayList<Percorso> per_vicini = new ArrayList<>();
                            ArrayList<Percorso> per_vicini_partenza = new ArrayList<>();
                            ArrayList<Percorso> per_vicini_arrivo = new ArrayList<>();

                            //TROVA PERCORSI ADIACENTI A PARTENZA
                          /*  for (int a = 0; a < mappap.DammiPercorsi().size(); a++) {
                                per_vicini=mappap.getViciniPercorso(mappap.DammiPercorsi().get(a));

                            }*/


                           /* double Lat = Double.valueOf(LatLinea[0].replace("(", ""));
                            double Long = Double.valueOf(LatLinea[1].replace(")", ""));
                            Casella casella_attuale = new com.lynden.example.latlong.Casella(1);
                            ArrayList<Percorso> ricercapercorso = mappap.DammiPercorsi();
                            for (int t = 0; t < ricercapercorso.size(); t++) {
                                ArrayList<Casella> ricerca_casella = ricercapercorso.get(t).getCaselle();
                                for (int r = 0; r < ricerca_casella.size(); r++) {
                                    /**** SISTEMARE RICERCA CASELLA PREMUTA ****
                                    Casella casella_puntata = ricerca_casella.get(r);
                                    if (casella_puntata.getInizio().getLatitude() == Lat && casella_puntata.getInizio().getLongitude() == Long)
                                        casella_attuale = casella_puntata;


                                }
                            }
                            LatLong LongCasellaInizio = caselle.get(finalI).getInizio();
                            LatLong LongCasellaFine = caselle.get(finalI).getFine();
                            Casella Casella_premuta = caselle.get(finalI);


                            if ((LongCasellaInizio.getLatitude() == Lat && LongCasellaInizio.getLongitude() == Long) ||
                                    (LongCasellaFine.getLatitude() == Lat && LongCasellaFine.getLongitude() == Long)) {



                                Percorso PercorsoPremuto = null;
                                PercorsoPremuto = mappap.getPercorsoByCasella(Casella_premuta);

                                //Casella CasPartenzaPremuto = PercorsoPremuto.getCasellaPartenza();
                                Casella CasArrivoPremuto = PercorsoPremuto.getCasellaArrivo();

                                /* Percorsi utilizzati per stabilire chi è vicino di chi, in base alla prorpia direzione *****
                                per_vicini = mappap.getViciniPercorso(mappap.getPercorsoByCasella(Casella_premuta));
                                per_vicini_partenza = mappap.getViciniPercorsoPartenza(mappap.getPercorsoByCasella(Casella_premuta));
                                per_vicini_arrivo = mappap.getViciniPercorsoArrivo(mappap.getPercorsoByCasella(Casella_premuta));





                                /******** ORA LE CASELLE SI PREMONO TUTTE!!! CREARE LA VIEW E USARE CONTROLLER PARTITA *******
                                /******** CREARE TURNO CONTINUATIVO PER UN UTENTE E COLORI DIVERSI PERCORSI *******
                                /******** PROBLEMA PERCORSI CON DOPPIA PARTENZA O ARRIVO *******
                                ArrayList<Casella> casellaArrayList1=new ArrayList<>();
                                for (int d = 0; d < this.Stato_attuale.size(); d++) {

                                    if (Casella_premuta.getId() == this.Stato_attuale.get(d).getId()) {

                                        this.Stato_attuale.add(PercorsoPremuto.CalcolaCaselleVicine(Casella_premuta));
                                        this.Stato_attuale.remove(Casella_premuta);
                                        ArrayList<com.lynden.example.latlong.Percorso> percorsi_vicini = new ArrayList<>();
                                        if (Casella_premuta.getId() == PercorsoPremuto.getCasellaPartenza().getId())
                                            percorsi_vicini = mappap.getViciniPercorsoPartenza(PercorsoPremuto);

                                        else if (Casella_premuta.getId() == PercorsoPremuto.getCasellaArrivo().getId())
                                            percorsi_vicini = mappap.getViciniPercorsoArrivo(PercorsoPremuto);

                                        if (percorsi_vicini.size() == 0) ;
                                        else {
                                            casellaArrayList1 = mappap.getCaselleVicinePercorsi(percorsi_vicini, Casella_premuta);
                                            casellaArrayList1.remove(null);
                                            this.Stato_attuale.addAll(casellaArrayList1);
                                        }
                                        //ArrayList<Percorso> percorsi_vicini=new ArrayList<>();
                                        if (Casella_premuta.getId() == mappap.getPercorsoByCasella(Casella_premuta).getCasellaPartenza().getId())
                                            percorsi_vicini = mappap.getViciniPercorsoPartenza(mappap.getPercorsoByCasella(Casella_premuta));
                                        else if (Casella_premuta.getId() == mappap.getPercorsoByCasella(Casella_premuta).getCasellaArrivo().getId())
                                            percorsi_vicini = mappap.getViciniPercorsoArrivo(mappap.getPercorsoByCasella(Casella_premuta));
                                            casellaArrayList1 = mappap.getCaselleVicinePercorsi(percorsi_vicini, Casella_premuta);
                                        if (!casellaArrayList1.isEmpty()) {
                                            casellaArrayList1.remove(null);
                                            this.Stato_attuale.addAll(casellaArrayList1);
                                        }
                                        //this.Stato_precedente.add(Casella_premuta);
                                        if (PercorsoPremuto.CalcolaCaselleVicine(Casella_premuta) != null)
                                            this.Stato_attuale.add(PercorsoPremuto.CalcolaCaselleVicine(Casella_premuta));
                                        giocatore.PosizionaMezzo(Casella_premuta);


                                        //Per settare la città occupata, in caso premo su una città
                                           /* if(Casella_premuta.getId()==PercorsoPremuto.getCaselle().get(0).getId() && Casella_premuta.getId()==CasPartenzaPremuto.getId()){
                                                PercorsoPremuto.getCittapartenza().setOccupata(true);
                                            }
                                            else if(Casella_premuta.getId()==PercorsoPremuto.getCaselle().get(PercorsoPremuto.getCaselle().size()-1).getId() && Casella_premuta.getId()==CasArrivoPremuto.getId()){
                                                PercorsoPremuto.getCittaArrivo().setOccupata(true);
                                            }*/


                                        /*if (giocatore.getMezzo() == null) {
                                            NumeroMezzo.setText(String.valueOf(0));
                                            pippo.strokeColor("red");
                                            finalPolyline1.setVisible(false);
                                            //giocatore.PosizionaMezzo(giocatore.getMezzo().get(i));
                                            Polyline polyline1 = new Polyline(pippo);
                                            map.addMapShape(polyline1);
                                            TurnoButton.setVisible(true);
                                        } else if (giocatore.getMezzo().size() > 0) {
                                            NumeroMezzo.setText(String.valueOf(giocatore.getMezzo().size()));
                                            pippo.strokeColor("red");
                                            finalPolyline1.setVisible(false);
                                            //giocatore.PosizionaMezzo(giocatore.getMezzo().get(i));
                                            Polyline polyline1 = new Polyline(pippo);
                                            map.addMapShape(polyline1);
                                        }

                                    }


                                }//fine for


                            }
                        });*/






                /******* Controllo sulla contiguità delle caselle nel posizionamento **********/











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
}
