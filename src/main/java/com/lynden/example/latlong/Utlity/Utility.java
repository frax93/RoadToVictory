package com.lynden.example.latlong.Utlity;


/**
 * Created by micheletaranta on 17/10/18.
 */

//Classe di utilità per funzioni di supporto al gioco RTV
public class Utility {

    public static String ColorToRgba(String colore){
        String c = null;
        if(colore=="red")  c="rgba(255,0,0,1)";
        else if(colore=="aqua")  c="rgba(0,255,255,1)";
        else if(colore=="orange")  c="rgba(255,165,0,1)";
        else if(colore=="pink")  c="rgba(255,192,203,1)";
        else if(colore=="green") c="rgba(45,255,13,1)";
        else if(colore=="black") c="rgba(255,255,255,1)";
        return c;
    }
}
