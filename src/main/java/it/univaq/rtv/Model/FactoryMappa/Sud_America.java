package it.univaq.rtv.Model.FactoryMappa;

import com.lynden.gmapsfx.javascript.object.LatLong;
import it.univaq.rtv.Model.FactorCitta;
import it.univaq.rtv.Model.FactoryCitta.ICitta;
import it.univaq.rtv.Model.FactoryCitta.NormaleDAO;
import it.univaq.rtv.Model.Percorso;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Sud_America extends AbstractMappa {

    public Sud_America() throws IOException {
        this.nome = "Sud_America";
        ArrayList<ICitta> c = this.CreaMappa();
        Percorso p;
        p = new Percorso(1, c.get(5), c.get(17));
        this.AddPercorso(p);
        p = new Percorso(3, c.get(5), c.get(14));
        this.AddPercorso(p);
        p = new Percorso(4, c.get(17), c.get(16));
        this.AddPercorso(p);
        p = new Percorso(5, c.get(12), c.get(17));
        this.AddPercorso(p);
        p = new Percorso(6, c.get(14), c.get(16));
        this.AddPercorso(p);
        p = new Percorso(7, c.get(0), c.get(16));
        this.AddPercorso(p);
        p = new Percorso(8, c.get(12), c.get(0));
        this.AddPercorso(p);
        p = new Percorso(9, c.get(0), c.get(14));
        this.AddPercorso(p);
        p = new Percorso(10, c.get(14), c.get(3));
        this.AddPercorso(p);
        p = new Percorso(11, c.get(15), c.get(12));
        this.AddPercorso(p);
        p = new Percorso(12, c.get(2), c.get(15));
        this.AddPercorso(p);
        p = new Percorso(13, c.get(3), c.get(0));
        this.AddPercorso(p);
        p = new Percorso(14, c.get(15), c.get(10));
        this.AddPercorso(p);
        p = new Percorso(15, c.get(3), c.get(1));
        this.AddPercorso(p);
        p = new Percorso(16, c.get(1), c.get(18));
        this.AddPercorso(p);
        p = new Percorso(17, c.get(3), c.get(15));
        this.AddPercorso(p);
        p = new Percorso(18, c.get(18), c.get(11));
        this.AddPercorso(p);
        p = new Percorso(19, c.get(11), c.get(1));
        this.AddPercorso(p);
        p = new Percorso(20, c.get(13), c.get(18));
        this.AddPercorso(p);
        p = new Percorso(22, c.get(2), c.get(8));
        this.AddPercorso(p);
        p = new Percorso(23, c.get(13), c.get(2));
        this.AddPercorso(p);
        p = new Percorso(24, c.get(11), c.get(13));
        this.AddPercorso(p);
        p = new Percorso(25, c.get(2), c.get(7));
        this.AddPercorso(p);
        p = new Percorso(26, c.get(7), c.get(9));
        this.AddPercorso(p);
        p = new Percorso(27, c.get(10), c.get(1));
        this.AddPercorso(p);
        p = new Percorso(28, c.get(11), c.get(10));
        this.AddPercorso(p);
        p = new Percorso(29, c.get(4), c.get(7));
        this.AddPercorso(p);
        p = new Percorso(30, c.get(13), c.get(4));
        this.AddPercorso(p);
        p = new Percorso(31, c.get(8), c.get(7));
        this.AddPercorso(p);
        p = new Percorso(32, c.get(4), c.get(9));
        this.AddPercorso(p);
        p = new Percorso(33, c.get(6), c.get(9));
        this.AddPercorso(p);
        p = new Percorso(33, c.get(4), c.get(6));
        this.AddPercorso(p);
        p = new Percorso(34, c.get(6), c.get(8));
        this.AddPercorso(p);



    }


    @Override
    public ArrayList<ICitta> CreaMappa() throws FileNotFoundException, IOException {
        ArrayList<ICitta> c1 = new ArrayList<ICitta>();
        try {

            EntityManager em = ICitta.jpaConnection();
            em.getTransaction()
                    .begin();

            List<NormaleDAO> normaleDAOList=em.createQuery("SELECT n FROM NormaleDAO n WHERE continente=:continente").setParameter("continente",this.nome).getResultList();
            for (NormaleDAO entry : normaleDAOList) {
                ICitta c = FactorCitta.getCitta("Normale",entry.getNome());
                c.ImpostaCoordinate(new LatLong(entry.getLatitude(),entry.getLongitude()));
                c1.add(c);
            }

            em.getTransaction()
                    .commit();
            em.close();
            return c1;
        } catch (Exception exc) {
            return c1;
        }

    }



}