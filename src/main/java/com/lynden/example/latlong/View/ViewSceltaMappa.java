package com.lynden.example.latlong;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class ViewSceltaMappa {
    private Label SceltaMappa;
    private Button Europa;
    private Button America;
    private Label SceltaGiocatori;
    private Label InizioPartita;
    private AnchorPane menu;





    public ViewSceltaMappa(Label SceltaMappa, Button Europa, Button America, Label SceltaGiocatori,Label InizioPartita, AnchorPane menu){
        this.SceltaMappa=SceltaMappa;
        this.SceltaGiocatori=SceltaGiocatori;
        this.Europa=Europa;
        this.America=America;
        this.InizioPartita=InizioPartita;
        this.menu=menu;
        this.Europa.setVisible(false);
        this.America.setVisible(false);
        this.SceltaMappa.setVisible(false);
        this.SceltaGiocatori.setVisible(false);
        this.InizioPartita.setVisible(false);
        this.menu.setVisible(true);

    }

    public void Scegli(){
    }
}