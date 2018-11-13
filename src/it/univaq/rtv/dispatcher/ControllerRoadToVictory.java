package it.univaq.rtv.dispatcher;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import it.univaq.rtv.Model.FactoryMappa.AbstractMappa;
import it.univaq.rtv.Model.Giocatore;
import it.univaq.rtv.Model.StatoGiocatore.Gioca;
import it.univaq.rtv.Model.StatoGiocatore.Vincente;
import it.univaq.rtv.Model.StatoTurno.Generale;
import it.univaq.rtv.Model.FacadePartita;
import it.univaq.rtv.Utility.Utility;
import it.univaq.rtv.controller.ViewDado;
import it.univaq.rtv.controller.ViewMappa;
import it.univaq.rtv.controller.ViewNumGiocatori;
import it.univaq.rtv.controller.ViewSceltaMappa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerRoadToVictory  implements Initializable, MapComponentInitializedListener {
    @FXML
    public GoogleMapView googleMapView;
    public GoogleMap map;
    public Label SceltaGiocatori;
    public Label SceltaMappa;
    public Button Europa;
    public Button USA;
    public Button Africa;
    public Button Sud_America;
    public Button Asia;
    private String nomemappa="";
    public Button Uno;
    public Button Due;
    public Button Tre;
    public Button Quattro;
    public Button Cinque;
    public Label InizioPartita;
    public AnchorPane menu;
    public Label ScrittaGiocatori;
    public Button dadoButton;
    public Label NumberDado;
    public Label NumeroMezzo;
    public Label ErroreDado;
    public ImageView DadoImage;  //per impostare immagine dado
    public Label CartaObiettivo;
    public Label CartaPercorsoPartenza;
    public Label CartaPercorsoArrivo;
    public Label GiocatoreName;
    public Label FinePartita;
    public Button TurnoButton;
    private ArrayList<Giocatore> Giocatori=new ArrayList<>();
    private ViewMappa viewMappa;
    private ViewDado viewDado;
    private AbstractMappa mappa;
    private Generale general;
    private Gioca gioca=new Gioca();
    private Vincente vince= new Vincente();
    private ViewNumGiocatori ngioc;
    private ViewSceltaMappa scmapp;
    private String Numero="";
    private Timestamp timestamp;
    private FacadePartita p=new FacadePartita();
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //googleMapView.addMapInializedListener(this);
    }
    @Override
    public void mapInitialized(){
        if(this.Numero!=""){
            for(int i = 1; i<= Utility.StringtoInteger(this.Numero); i++){
                Giocatore giocatore = new Giocatore(i,"Giocatore"+i, Utility.Colori());
                this.Giocatori.add(giocatore);
            }
        }
        if(this.nomemappa!=""){
            this.viewMappa=new ViewMappa(googleMapView, CartaObiettivo, CartaPercorsoPartenza,CartaPercorsoArrivo,GiocatoreName,TurnoButton,NumeroMezzo,FinePartita);

            try {
                this.viewMappa.Creamappa(this.Giocatori,p.AvviaPartita(nomemappa,this.Giocatori),this.p);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @FXML
    private void SetMappa(final ActionEvent event){
        event.consume();
        this.nomemappa=event.getTarget().toString().replace("Button[id=","").replaceAll(", styleClass=button]","");
        int pos=this.nomemappa.indexOf("'");
        this.nomemappa=this.nomemappa.substring(0,pos);
        this.mapInitialized();
        this.scmapp=new ViewSceltaMappa(SceltaMappa,Europa,USA,Africa,Sud_America,Asia,SceltaGiocatori,InizioPartita,menu,ScrittaGiocatori);
    }
    @FXML
    private void Setgiocatore(final ActionEvent event){
        event.consume();
        this.Numero=event.getTarget().toString().replace("Button[id=","").replace(", styleClass=button]''","");
        this.ngioc=new ViewNumGiocatori(SceltaGiocatori,Uno,Due,Tre,Quattro,Cinque,InizioPartita,menu,SceltaMappa,Europa,USA,Africa,Sud_America,Asia,ScrittaGiocatori);
    }

    @FXML
    public void LanciaDado(final ActionEvent event){
        event.consume();
        this.viewDado =new ViewDado(dadoButton, NumeroMezzo,NumberDado,DadoImage,p.LanciaDado(this.Giocatori));


    }

    @FXML
    public void FineTurno(final ActionEvent event){
        event.consume();
        p.FineTurno();

    }


}
