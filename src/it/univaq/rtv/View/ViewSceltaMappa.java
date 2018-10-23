package it.univaq.rtv.View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class ViewSceltaMappa {
    private Label SceltaMappa;
    private Button Europa;
    private Button USA;
    private Button Africa;
    private Button Sud_America;
    private Label SceltaGiocatori;
    private Label InizioPartita;
    private AnchorPane menu;
    private Label ScrittaGiocatori;





    public ViewSceltaMappa(Label SceltaMappa, Button Europa, Button USA,Button Africa,Button Sud_America, Label SceltaGiocatori,Label InizioPartita, AnchorPane menu, Label ScrittaGiocatori){
        this.SceltaMappa=SceltaMappa;
        this.SceltaGiocatori=SceltaGiocatori;
        this.Europa=Europa;
        this.USA =USA;
        this.Africa=Africa;
        this.Sud_America=Sud_America;
        this.InizioPartita=InizioPartita;
        this.menu=menu;
        this.ScrittaGiocatori=ScrittaGiocatori;
        this.Europa.setVisible(false);
        this.USA.setVisible(false);
        this.Africa.setVisible(false);
        this.Sud_America.setVisible(false);
        this.SceltaMappa.setVisible(false);
        this.SceltaGiocatori.setVisible(false);
        this.InizioPartita.setVisible(false);
        this.menu.setVisible(true);
        this.ScrittaGiocatori.setVisible(false);

    }

    public void Scegli(){
    }
}