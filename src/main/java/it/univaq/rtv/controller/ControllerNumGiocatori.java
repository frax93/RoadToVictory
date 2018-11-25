package it.univaq.rtv.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import it.univaq.rtv.Model.FacadePartita;


public class ControllerNumGiocatori {
    private Label sceltaGiocatori;
    private Button uno;
    private Button due;
    private Button tre;
    private Button quattro;
    private Button cinque;
    private Label scrittaGiocatori;
    private Label inizioPartita;
    private AnchorPane menu;
    private Label sceltaMappa;
    private Button europa;
    private Button america;
    private Button africa;
    private Button sudAmerica;
    private Button asia;





    public ControllerNumGiocatori(Label SceltaGiocatori, Button Uno, Button Due, Button Tre, Button Quattro, Button Cinque, Label InizioPartita, AnchorPane menu, Label SceltaMappa, Button Europa, Button America, Button Africa, Button Sud_America, Button Asia, Label ScrittaGiocatore){
        this.sceltaGiocatori =SceltaGiocatori;
        this.uno =Uno;
        this.due =Due;
        this.tre =Tre;
        this.quattro =Quattro;
        this.cinque =Cinque;
        this.inizioPartita =InizioPartita;
        this.menu=menu;
        this.scrittaGiocatori =ScrittaGiocatore;
        this.sceltaMappa =SceltaMappa;
        this.europa =Europa;
        this.america =America;
        this.africa =Africa;
        this.sudAmerica =Sud_America;
        this.asia =Asia;
        this.europa.setVisible(true);
        this.america.setVisible(true);
        this.africa.setVisible(true);
        this.sudAmerica.setVisible(true);
        this.asia.setVisible(true);
        this.sceltaMappa.setVisible(true);
        this.uno.setVisible(false);
        this.due.setVisible(false);
        this.tre.setVisible(false);
        this.quattro.setVisible(false);
        this.cinque.setVisible(false);
        this.sceltaGiocatori.setVisible(false);
        this.inizioPartita.setVisible(false);
        this.scrittaGiocatori.setVisible(false);
    }
    public void bornAgain(){
        this.uno.setVisible(true);
        this.due.setVisible(true);
        this.tre.setVisible(true);
        this.quattro.setVisible(true);
        this.cinque.setVisible(true);
        this.sceltaGiocatori.setVisible(true);
        this.inizioPartita.setVisible(true);
        this.scrittaGiocatori.setVisible(true);

    }
    public void setNumGiocatori(String n){
        FacadePartita.getIstance().CreaGiocatori(n);
        }

}

