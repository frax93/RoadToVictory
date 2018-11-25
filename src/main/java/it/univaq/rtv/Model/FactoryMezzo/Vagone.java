package it.univaq.rtv.Model.FactoryMezzo;


import it.univaq.rtv.Model.Giocatore;

public class Vagone implements IMezzo {
		private int id;
		private Giocatore g;
        public Vagone(Giocatore g) {
			this.g=g;
        }

		public void CreaMezzo() {

		}

		public void DammiMezzo() {
		}

}