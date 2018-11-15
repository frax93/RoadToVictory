package it.univaq.rtv.dispatcher;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import it.univaq.rtv.controller.*;
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
    public ControllerMappa controllerMappa;
    public ControllerDado controllerDado;
    public ControllerFineTurno controllerFineTurno;
    private ControllerNumGiocatori ngioc;
    private ViewSceltaMappa scmapp;
    private String Numero="";
    private Timestamp timestamp;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //googleMapView.addMapInializedListener(this);
    }
    @Override
    public void mapInitialized(){
        if(this.Numero!=""){
            ngioc.SettaNumGiocatori(this.Numero);
        }
        if(this.nomemappa!=""){
            this.controllerMappa =new ControllerMappa(googleMapView, CartaObiettivo, CartaPercorsoPartenza,CartaPercorsoArrivo,GiocatoreName,TurnoButton,NumeroMezzo,FinePartita);

            try {
                this.controllerMappa.Creamappa(nomemappa);

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
        this.ngioc=new ControllerNumGiocatori(SceltaGiocatori,Uno,Due,Tre,Quattro,Cinque,InizioPartita,menu,SceltaMappa,Europa,USA,Africa,Sud_America,Asia,ScrittaGiocatori);
    }

    @FXML
    public void LanciaDado(final ActionEvent event){
        event.consume();
        this.controllerDado =new ControllerDado(dadoButton, NumeroMezzo,NumberDado,DadoImage);


    }

    @FXML
    public void FineTurno(final ActionEvent event){
        event.consume();
        this.controllerDado.setDadoButton();
        this.controllerMappa.FinisciTurno();
        this.controllerMappa.setCarte();
        this.controllerMappa.setObiettivo();
        this.controllerMappa.setArrivo();
        this.controllerMappa.setTurnoButton(false);
        this.controllerMappa.setGiocatoreName();

    }


}
