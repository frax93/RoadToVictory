package it.univaq.rtv.View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewDado {
    private Button dadoButton;
    private Label NumeroMezzo;
    private Label NumberDado;
    boolean Primo = true;
    public ImageView DadoImage;

    public ViewDado(Button dadoButton, Label NumeroMezzo, Label NumberDado, ImageView DadoImage, int NumeroMezzi){
        this.dadoButton=dadoButton;
        this.NumeroMezzo=NumeroMezzo;
        this.NumberDado=NumberDado;
        this.DadoImage=DadoImage;
        this.Lancia(NumeroMezzi);
    }

    public void Lancia(int n){

        this.NumeroMezzo.setText(String.valueOf(n));


        /****** Controllo su lancio dado doppio *****/
        if(Primo==true) {

            /****** Set Immagine dado*****/
            if(n==1) {
                Image dado= new Image("http://oi64.tinypic.com/2dluf4p.jpg");
                this.DadoImage.setImage(dado);
            }
            else if (n==2){
                Image dado= new Image("http://oi67.tinypic.com/652xxw.jpg");
                this.DadoImage.setImage(dado);
            }
            else if (n==3){
                Image dado= new Image("http://oi64.tinypic.com/1z1wyki.jpg");
                this.DadoImage.setImage(dado);
            }
            else if (n==4){
                Image dado= new Image("http://oi64.tinypic.com/2qthbgp.jpg");
                this.DadoImage.setImage(dado);
            }
            else if (n==5){
                Image dado= new Image("http://oi66.tinypic.com/261km5s.jpg");
                this.DadoImage.setImage(dado);
            }
            else if (n==6){
                Image dado= new Image("http://oi63.tinypic.com/2ccphzb.jpg");
                this.DadoImage.setImage(dado);
            }
            Primo=false;
        }
        this.dadoButton.setDisable(true);
    }

    public void setDadoButton() {
        this.dadoButton.setDisable(false);
    }
}
