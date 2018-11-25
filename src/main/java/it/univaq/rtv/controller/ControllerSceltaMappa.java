package it.univaq.rtv.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class ControllerSceltaMappa {
    private Label sceltaMappa;
    private Button europa;
    private Button usa;
    private Button africa;
    private Button sudAmerica;
    private Button asia;
    private Label sceltaGiocatori;
    private Label inizioPartita;
    private AnchorPane menu;
    private Label scrittaGiocatori;





    public ControllerSceltaMappa(Label SceltaMappa, Button Europa, Button USA, Button Africa, Button Sud_America, Button Asia, Label SceltaGiocatori, Label InizioPartita, AnchorPane menu, Label ScrittaGiocatori){
        this.sceltaMappa =SceltaMappa;
        this.sceltaGiocatori =SceltaGiocatori;
        this.europa =Europa;
        this.usa =USA;
        this.africa =Africa;
        this.sudAmerica =Sud_America;
        this.asia =Asia;
        this.inizioPartita =InizioPartita;
        this.menu=menu;
        this.scrittaGiocatori =ScrittaGiocatori;
        this.europa.setVisible(false);
        this.usa.setVisible(false);
        this.africa.setVisible(false);
        this.sudAmerica.setVisible(false);
        this.asia.setVisible(false);
        this.sceltaMappa.setVisible(false);
        this.sceltaGiocatori.setVisible(false);
        this.inizioPartita.setVisible(false);
        this.menu.setVisible(true);
        this.scrittaGiocatori.setVisible(false);

    }


}