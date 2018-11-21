package it.univaq.rtv.Model.FactoryCitta;

import javax.persistence.*;

@Entity
@Table(name="normale")
//@NamedQuery(name="listbyparameter",query = "SELECT n FROM normale n WHERE continente = :continente")
public class NormaleDAO {
        @Id
        @Column(name="Nome")
        private String Nome;
        @Column(name="latitude")
        private Double latitude;
        @Column(name="longitude")
        private Double longitude;
        @Column(name="continente")
        private String continente;
        public NormaleDAO(){}

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getNome(){
            return this.Nome;
        }
        public Double getLatitude(){
            return this.latitude;
        }
     public void setLatitude(Double lat){
        this.latitude=lat;
    }
    public Double getLongitude(){
        return this.longitude;
    }
    public void setLongitude(Double longitude){
        this.longitude=longitude;
    }

        public void setNome(String nome){ this.Nome=nome;}
}
