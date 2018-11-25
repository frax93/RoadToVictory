package it.univaq.rtv.Model.FactoryMappa;

import it.univaq.rtv.Model.FactoryCitta.ICitta;
import it.univaq.rtv.Model.Percorso;
import java.io.IOException;
import java.util.ArrayList;




public class SudAmerica extends AbstractMappa {

    /**
     * @throws IOException
     */
    public SudAmerica() throws IOException {
        this.nome = "SudAmerica";
        ArrayList<ICitta> c = this.creaMappa();
        Percorso p;
        p = new Percorso(1, c.get(5), c.get(17));
        this.addPercorso(p);
        p = new Percorso(3, c.get(5), c.get(14));
        this.addPercorso(p);
        p = new Percorso(4, c.get(17), c.get(16));
        this.addPercorso(p);
        p = new Percorso(5, c.get(12), c.get(17));
        this.addPercorso(p);
        p = new Percorso(6, c.get(14), c.get(16));
        this.addPercorso(p);
        p = new Percorso(7, c.get(0), c.get(16));
        this.addPercorso(p);
        p = new Percorso(8, c.get(12), c.get(0));
        this.addPercorso(p);
        p = new Percorso(9, c.get(0), c.get(14));
        this.addPercorso(p);
        p = new Percorso(10, c.get(14), c.get(3));
        this.addPercorso(p);
        p = new Percorso(11, c.get(15), c.get(12));
        this.addPercorso(p);
        p = new Percorso(12, c.get(2), c.get(15));
        this.addPercorso(p);
        p = new Percorso(13, c.get(3), c.get(0));
        this.addPercorso(p);
        p = new Percorso(14, c.get(15), c.get(10));
        this.addPercorso(p);
        p = new Percorso(15, c.get(3), c.get(1));
        this.addPercorso(p);
        p = new Percorso(16, c.get(1), c.get(18));
        this.addPercorso(p);
        p = new Percorso(17, c.get(3), c.get(15));
        this.addPercorso(p);
        p = new Percorso(18, c.get(18), c.get(11));
        this.addPercorso(p);
        p = new Percorso(19, c.get(11), c.get(1));
        this.addPercorso(p);
        p = new Percorso(20, c.get(13), c.get(18));
        this.addPercorso(p);
        p = new Percorso(22, c.get(2), c.get(8));
        this.addPercorso(p);
        p = new Percorso(23, c.get(13), c.get(2));
        this.addPercorso(p);
        p = new Percorso(24, c.get(11), c.get(13));
        this.addPercorso(p);
        p = new Percorso(25, c.get(2), c.get(7));
        this.addPercorso(p);
        p = new Percorso(26, c.get(7), c.get(9));
        this.addPercorso(p);
        p = new Percorso(27, c.get(10), c.get(1));
        this.addPercorso(p);
        p = new Percorso(28, c.get(11), c.get(10));
        this.addPercorso(p);
        p = new Percorso(29, c.get(4), c.get(7));
        this.addPercorso(p);
        p = new Percorso(30, c.get(13), c.get(4));
        this.addPercorso(p);
        p = new Percorso(31, c.get(8), c.get(7));
        this.addPercorso(p);
        p = new Percorso(32, c.get(4), c.get(9));
        this.addPercorso(p);
        p = new Percorso(33, c.get(6), c.get(9));
        this.addPercorso(p);
        p = new Percorso(33, c.get(4), c.get(6));
        this.addPercorso(p);
        p = new Percorso(34, c.get(6), c.get(8));
        this.addPercorso(p);



    }




}