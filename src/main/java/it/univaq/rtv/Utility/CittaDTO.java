package it.univaq.rtv.Utility;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mappa")
public class CittaDTO {


        private String Nome;

        private Double latitude;

        private Double longitude;

        public CittaDTO(){

        }

        /**
         * @return
         */
        public String getNome(){
            return this.Nome;
        }

        /**
         * @return
         */
        public Double getLatitude(){
            return this.latitude;
        }

        /**
         * @param lat
         */
        public void setLatitude(Double lat){
        this.latitude=lat;
         }

        /**
         * @return
         */
         public Double getLongitude(){
                return this.longitude;
        }

        /**
         * @param longitude
         */
        public void setLongitude(Double longitude){
        this.longitude=longitude;
        }

        /**
         * @param nome
         */
        public void setNome(String nome){
            this.Nome=nome;}
}
