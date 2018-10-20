package it.univaq.rtv.View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class ViewNumGiocatori {
    private Label SceltaGiocatori;
    private Button Uno;
    private Button Due;
    private Button Tre;
    private Button Quattro;
    private Button Cinque;
    private Label ScrittaGiocatori;
    private Label InizioPartita;
    private AnchorPane menu;
    private Label SceltaMappa;
    private Button Europa;
    private Button America;





    public ViewNumGiocatori(Label SceltaGiocatori, Button Uno, Button Due, Button Tre, Button Quattro,Button Cinque, Label InizioPartita, AnchorPane menu,Label SceltaMappa,Button Europa,Button America, Label ScrittaGiocatore){
        this.SceltaGiocatori=SceltaGiocatori;
        this.Uno=Uno;
        this.Due=Due;
        this.Tre=Tre;
        this.Quattro=Quattro;
        this.Cinque=Cinque;
        this.InizioPartita=InizioPartita;
        this.menu=menu;
        this.ScrittaGiocatori=ScrittaGiocatore;
        this.SceltaMappa=SceltaMappa;
        this.Europa=Europa;
        this.America=America;
        this.Europa.setVisible(true);
        this.America.setVisible(true);
        this.SceltaMappa.setVisible(true);
        this.Uno.setVisible(false);
        this.Due.setVisible(false);
        this.Tre.setVisible(false);
        this.Quattro.setVisible(false);
        this.Cinque.setVisible(false);
        this.SceltaGiocatori.setVisible(false);
        this.InizioPartita.setVisible(false);
        this.ScrittaGiocatori.setVisible(false);
    }

    public void Scegli(){
        }
}