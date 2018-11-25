package it.univaq.rtv.Model.FactoryMappa;

import com.lynden.gmapsfx.javascript.object.LatLong;
import it.univaq.rtv.Model.FactorCitta;
import it.univaq.rtv.Model.FactoryCitta.ICitta;

import it.univaq.rtv.Model.Percorso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Africa extends AbstractMappa {

    public Africa() throws IOException {
        this.nome="Africa";
        ArrayList<ICitta> c = this.CreaMappa();
        Percorso p;
        p=new Percorso(1,c.get(4),c.get(9));
        this.AddPercorso(p);
        p=new Percorso(2,c.get(9),c.get(21));
        this.AddPercorso(p);
        p=new Percorso(3,c.get(10),c.get(3));
        this.AddPercorso(p);
        p=new Percorso(4,c.get(3),c.get(4));
        this.AddPercorso(p);
        p=new Percorso(5,c.get(21),c.get(4));
        this.AddPercorso(p);
        p=new Percorso(6,c.get(18),c.get(21));
        this.AddPercorso(p);
        p=new Percorso(7,c.get(18),c.get(10));
        this.AddPercorso(p);
        p=new Percorso(8,c.get(20),c.get(10));
        this.AddPercorso(p);
        p=new Percorso(9,c.get(20),c.get(3));
        this.AddPercorso(p);
        p=new Percorso(10,c.get(18),c.get(20));
        this.AddPercorso(p);
        p=new Percorso(11,c.get(15),c.get(20));
        this.AddPercorso(p);
        p=new Percorso(12,c.get(0),c.get(18));
        this.AddPercorso(p);
        p=new Percorso(13,c.get(0),c.get(15));
        this.AddPercorso(p);
        p=new Percorso(14,c.get(11),c.get(0));
        this.AddPercorso(p);
        p=new Percorso(15,c.get(15),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(16,c.get(11),c.get(19));
        this.AddPercorso(p);
        p=new Percorso(17,c.get(16),c.get(18));
        this.AddPercorso(p);
        p=new Percorso(18,c.get(2),c.get(16));
        this.AddPercorso(p);
        p=new Percorso(19,c.get(17),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(20,c.get(17),c.get(19));
        this.AddPercorso(p);
        p=new Percorso(21,c.get(7),c.get(17));
        this.AddPercorso(p);
        p=new Percorso(22,c.get(8),c.get(2));
        this.AddPercorso(p);
        p=new Percorso(23,c.get(1),c.get(7));
        this.AddPercorso(p);
        p=new Percorso(24,c.get(1),c.get(22));
        this.AddPercorso(p);
        p=new Percorso(25,c.get(16),c.get(8));
        this.AddPercorso(p);
        p=new Percorso(26,c.get(7),c.get(22));
        this.AddPercorso(p);
        p=new Percorso(27,c.get(1),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(28,c.get(6),c.get(12));
        this.AddPercorso(p);
        p=new Percorso(29,c.get(6),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(30,c.get(12),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(31,c.get(12),c.get(22));
        this.AddPercorso(p);
        p=new Percorso(32,c.get(5),c.get(22));
        this.AddPercorso(p);
        p=new Percorso(33,c.get(22),c.get(14));
        this.AddPercorso(p);
        p=new Percorso(34,c.get(14),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(34,c.get(19),c.get(5));
        this.AddPercorso(p);
        p=new Percorso(34,c.get(5),c.get(7));
        this.AddPercorso(p);
        p=new Percorso(35,c.get(8),c.get(6));
        this.AddPercorso(p);
        p=new Percorso(36,c.get(8),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(37,c.get(14),c.get(12));
        this.AddPercorso(p);
        p=new Percorso(38,c.get(8),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(39,c.get(16),c.get(0));
        this.AddPercorso(p);
        p=new Percorso(40,c.get(6),c.get(1));
        this.AddPercorso(p);
        p=new Percorso(41,c.get(2),c.get(18));
        this.AddPercorso(p);

    }



}