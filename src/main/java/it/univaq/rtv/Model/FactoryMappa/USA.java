package it.univaq.rtv.Model.FactoryMappa;

import it.univaq.rtv.Model.FactoryCitta.ICitta;
import it.univaq.rtv.Model.Percorso;
import java.io.IOException;
import java.util.ArrayList;




public class USA extends AbstractMappa {

    public USA() throws IOException {
        this.nome="USA";
        ArrayList<ICitta> c = this.CreaMappa();
        Percorso p;
        p=new Percorso(2,c.get(14),c.get(10));
        this.AddPercorso(p);
        p=new Percorso(3,c.get(5),c.get(9));
        this.AddPercorso(p);
        p=new Percorso(4,c.get(7),c.get(5));
        this.AddPercorso(p);
        p=new Percorso(5,c.get(9),c.get(7));
        this.AddPercorso(p);
        p=new Percorso(6,c.get(7),c.get(14));
        this.AddPercorso(p);
        p=new Percorso(7,c.get(3),c.get(2));
        this.AddPercorso(p);
        p=new Percorso(8,c.get(7),c.get(6));
        this.AddPercorso(p);
        p=new Percorso(9,c.get(6),c.get(2));
        this.AddPercorso(p);
        p=new Percorso(13,c.get(5),c.get(14));
        this.AddPercorso(p);
        p=new Percorso(15,c.get(9),c.get(0));
        this.AddPercorso(p);
        p=new Percorso(16,c.get(0),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(17,c.get(1),c.get(6));
        this.AddPercorso(p);
        p=new Percorso(19,c.get(1),c.get(17));
        this.AddPercorso(p);
        p=new Percorso(21,c.get(12),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(22,c.get(0),c.get(1));
        this.AddPercorso(p);
        p=new Percorso(23,c.get(0),c.get(7));
        this.AddPercorso(p);
        p=new Percorso(24,c.get(12),c.get(0));
        this.AddPercorso(p);
        p=new Percorso(25,c.get(2),c.get(12));
        this.AddPercorso(p);
        p=new Percorso(26,c.get(8),c.get(4));
        this.AddPercorso(p);
        p=new Percorso(27,c.get(4),c.get(2));
        this.AddPercorso(p);
        p=new Percorso(28,c.get(8),c.get(2));
        this.AddPercorso(p);
        p=new Percorso(29,c.get(4),c.get(11));
        this.AddPercorso(p);
        p=new Percorso(30,c.get(8),c.get(12));
        this.AddPercorso(p);
        p=new Percorso(31,c.get(1),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(32,c.get(13),c.get(6));
        this.AddPercorso(p);
        p=new Percorso(33,c.get(13),c.get(0));
        this.AddPercorso(p);
        p=new Percorso(34,c.get(7),c.get(13));
        this.AddPercorso(p);
        p=new Percorso(35,c.get(5),c.get(15));
        this.AddPercorso(p);
        p=new Percorso(36,c.get(15),c.get(14));
        this.AddPercorso(p);
        p=new Percorso(37,c.get(3),c.get(14));
        this.AddPercorso(p);
        p=new Percorso(38,c.get(7),c.get(3));
        this.AddPercorso(p);
        p=new Percorso(39,c.get(3),c.get(6));
        this.AddPercorso(p);
        p=new Percorso(40,c.get(15),c.get(10));
        this.AddPercorso(p);
        p=new Percorso(41,c.get(10),c.get(16));
        this.AddPercorso(p);
        p=new Percorso(42,c.get(16),c.get(15));
        this.AddPercorso(p);
        p=new Percorso(43,c.get(14),c.get(16));
        this.AddPercorso(p);
        p=new Percorso(44,c.get(0),c.get(17));
        this.AddPercorso(p);
        p=new Percorso(45,c.get(17),c.get(2));
        this.AddPercorso(p);
        p=new Percorso(46,c.get(12),c.get(17));
        this.AddPercorso(p);




    }

  /*  @Override
    public ArrayList<ICitta> CreaMappa()throws FileNotFoundException,IOException{
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

    }*/



}
