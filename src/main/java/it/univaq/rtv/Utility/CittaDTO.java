package it.univaq.rtv.Utility;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mappa")
public class CittaDTO {


        private String Nome;

        private Double latitude;

        private Double longitude;

        public CittaDTO(){

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

        public void setNome(String nome){
            this.Nome=nome;}
}
