package com.lynden.example.latlong;

import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class NumeroGiocatori {
    private Label SceltaGiocatori;
    private Button Uno;
    private Button Due;
    private Button Tre;
    private Button Quattro;





    public NumeroGiocatori( Label SceltaGiocatori,Button Uno,Button Due,Button Tre,Button Quattro){
        this.SceltaGiocatori=SceltaGiocatori;
        this.Uno=Uno;
        this.Due=Due;
        this.Tre=Tre;
        this.Quattro=Quattro;
        this.Uno.setVisible(false);
        this.Due.setVisible(false);
        this.Tre.setVisible(false);
        this.Quattro.setVisible(false);
        this.SceltaGiocatori.setVisible(false);




    }
    public void Scegli(){
        }
}
