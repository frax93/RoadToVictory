package com.lynden.example.latlong;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class ViewNumGiocatori {
    private Label SceltaGiocatori;
    private Button Uno;
    private Button Due;
    private Button Tre;
    private Button Quattro;
    private Label InizioPartita;
    private AnchorPane menu;





    public ViewNumGiocatori(Label SceltaGiocatori, Button Uno, Button Due, Button Tre, Button Quattro, Label InizioPartita, AnchorPane menu){
        this.SceltaGiocatori=SceltaGiocatori;
        this.Uno=Uno;
        this.Due=Due;
        this.Tre=Tre;
        this.Quattro=Quattro;
        this.InizioPartita=InizioPartita;
        this.menu=menu;
        this.Uno.setVisible(false);
        this.Due.setVisible(false);
        this.Tre.setVisible(false);
        this.Quattro.setVisible(false);
        this.SceltaGiocatori.setVisible(false);
        this.InizioPartita.setVisible(false);
        this.menu.setVisible(true);
    }

    public void Scegli(){
        }
}
