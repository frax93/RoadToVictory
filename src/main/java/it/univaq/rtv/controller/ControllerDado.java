package it.univaq.rtv.controller;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import it.univaq.rtv.Model.FacadePartita;


public class ControllerDado {
    private Button dadoButton;
    boolean Primo = true;
    public ImageView dadoImage;
    private int numDado;

    public ControllerDado(Button dadoButton,ImageView DadoImage){
        this.dadoButton=dadoButton;
        this.dadoImage =DadoImage;
        this.numDado=FacadePartita.getIstance().lanciaDado(FacadePartita.getIstance().getGiocatori());
    }

    public void lancia(int n){

        if(Primo==true) {
            if(n==1) {
                Image dado= new Image("http://oi64.tinypic.com/2dluf4p.jpg");
                this.dadoImage.setImage(dado);
            }
            else if (n==2){
                Image dado= new Image("http://oi67.tinypic.com/652xxw.jpg");
                this.dadoImage.setImage(dado);
            }
            else if (n==3){
                Image dado= new Image("http://oi64.tinypic.com/1z1wyki.jpg");
                this.dadoImage.setImage(dado);
            }
            else if (n==4){
                Image dado= new Image("http://oi64.tinypic.com/2qthbgp.jpg");
                this.dadoImage.setImage(dado);
            }
            else if (n==5){
                Image dado= new Image("http://oi66.tinypic.com/261km5s.jpg");
                this.dadoImage.setImage(dado);
            }
            else if (n==6){
                Image dado= new Image("http://oi63.tinypic.com/2ccphzb.jpg");
                this.dadoImage.setImage(dado);
            }
            Primo=false;
        }
        this.dadoButton.setDisable(true);
    }

    public int getNumDado(){
        return this.numDado;
    }

    public void setDadoButton() {
        this.dadoButton.setDisable(false);
    }
}
