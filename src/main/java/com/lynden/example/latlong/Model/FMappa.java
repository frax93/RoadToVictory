package com.lynden.example.latlong;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.JsonArray;
import com.lynden.example.latlong.Model.FactoryMezzo.Vagone;
import com.lynden.gmapsfx.javascript.object.LatLong;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.String;

public class FMappa {
	private String Nome;
	private ArrayList<Percorso> p=new ArrayList<Percorso>();

	public FMappa(ArrayList<Giocatore> g, String NomeMappa) throws FileNotFoundException,IOException {
		this.Nome = NomeMappa;

		ArrayList<Citta> c = this.CreaMappa();
		/*int q1=100;
		for (int i=1;i<c.size();i++){
			int j=i-1;
			System.out.println(c.get(i).getNome());
			Percorso p;
			p=new Percorso(q1,c.get(j),c.get(i));
			this.AddPercorso(p);
			q1--;

			}*/
		Percorso p;
		p=new Percorso(1,c.get(13),c.get(11));
		this.AddPercorso(p);
		p=new Percorso(3,c.get(3),c.get(12));
		this.AddPercorso(p);
		p=new Percorso(4,c.get(2),c.get(1));
		this.AddPercorso(p);
		p=new Percorso(5,c.get(15),c.get(3));
		this.AddPercorso(p);
		p=new Percorso(6,c.get(10),c.get(15));
		this.AddPercorso(p);
		p=new Percorso(7,c.get(7),c.get(10));
		this.AddPercorso(p);
		p=new Percorso(8,c.get(4),c.get(7));
		this.AddPercorso(p);
		p=new Percorso(9,c.get(14),c.get(4));
		this.AddPercorso(p);
		p=new Percorso(11,c.get(11),c.get(14));
		this.AddPercorso(p);
		p=new Percorso(13,c.get(0),c.get(6));
		this.AddPercorso(p);
		p=new Percorso(15,c.get(5),c.get(9));
		this.AddPercorso(p);
		p=new Percorso(16,c.get(9),c.get(8));
		this.AddPercorso(p);
		p=new Percorso(17,c.get(6),c.get(2));
		this.AddPercorso(p);
		p=new Percorso(19,c.get(10),c.get(9));
		this.AddPercorso(p);
		p=new Percorso(21,c.get(1),c.get(0));
		this.AddPercorso(p);
		p=new Percorso(22,c.get(11),c.get(8));
		this.AddPercorso(p);
		p=new Percorso(23,c.get(12),c.get(15));
		this.AddPercorso(p);
		p=new Percorso(24,c.get(3),c.get(13));
		this.AddPercorso(p);
		p=new Percorso(25,c.get(5),c.get(8));
		this.AddPercorso(p);
		p=new Percorso(26,c.get(6),c.get(11));
		this.AddPercorso(p);
		p=new Percorso(27,c.get(12),c.get(13));
		this.AddPercorso(p);
		p=new Percorso(28,c.get(3),c.get(1));
		this.AddPercorso(p);
		p=new Percorso(29,c.get(14),c.get(9));
		this.AddPercorso(p);
		p=new Percorso(30,c.get(4),c.get(9));
		this.AddPercorso(p);
		p=new Percorso(31,c.get(2),c.get(3));
		this.AddPercorso(p);
		p=new Percorso(32,c.get(8),c.get(14));
		this.AddPercorso(p);
		p=new Percorso(33,c.get(5),c.get(15));
		this.AddPercorso(p);
		p=new Percorso(34,c.get(0),c.get(2));
		this.AddPercorso(p);
		p=new Percorso(35,c.get(2),c.get(13));
		this.AddPercorso(p);




	}

	/**
	 *
	 * @param Giocatori
	 * @param Nome_Mappa
	 */
	//RITORNA ARRAY SIZE
	public int sizea(){
		return p.size();
	}
	public void AddPercorso(Percorso p1){
		this.p.add(p1);
	}
	public ArrayList<Citta> CreaMappa()throws FileNotFoundException,IOException{
		ArrayList<Citta> c1=new ArrayList<Citta>();
		try {

			FileReader fw = new FileReader("citta.json");
			ObjectMapper objectMapper = new ObjectMapper();
			HashMap<String, LatLong> maplat = new HashMap<>();


			com.google.gson.JsonParser jsonParser = new com.google.gson.JsonParser();
			JsonArray object = (JsonArray) jsonParser.parse(fw);
			LatLong l=null;
			for (int i = 0; i < object.size(); i++) {
				if(object.get(i) != null){
				double latitude= object.get(i).getAsJsonObject().get("latitude").getAsDouble();
				double longitude=object.get(i).getAsJsonObject().get("longitude").getAsDouble();
				l = new LatLong(latitude,longitude);
				maplat.put(object.get(i).getAsJsonObject().get("variableName").toString(), l);
				}

			}

			//Costruzione dei percorsi della mappa DA SPOSTARE IN FUTURO
			for (Map.Entry entry : maplat.entrySet()){
				String nome=(String) entry.getKey();
				String[] nome1 = nome.split(",");
				Citta p= new Citta((String) nome1[0].replace("\"",""));
				p.ImpostaCoordinate((LatLong) entry.getValue());
				c1.add(p);
			}
			return c1;
		}

		catch (FileNotFoundException exc) {
			return c1;
		}

	}

	public ArrayList<Percorso> DammiPercorsi() {

		return this.p;

	}

	/**
	 *
	 * @param Giocatori
	 */
	public void PopolaMappa(ArrayList<Giocatore> giocatores) {
		//DA TESTARE
		for(int i=0; i<giocatores.size();i++){
			Giocatore g=giocatores.get(i);
			FMezzo factory= new FMezzo();
			Vagone v=factory.CreaVagone(g);
			CartaPercorso c1=g.ChiediCartaPercorso();
			for(int j=0;j<this.p.size();j++){
				Percorso p1=p.get(j);
				p1.TrovaPercorso(c1,factory,g);
			}
		}
	}

	/**
	 *
	 * @param Percorso
	 */
	public boolean CheckPercorsiVicini(Percorso p1, Percorso p2) {
		if( p1.getCittapartenza().getNome().equals(p2.getCittapartenza().getNome()) ||
				p1.getCittapartenza().getNome().equals(p2.getCittaArrivo().getNome()) ||
				p1.getCittaArrivo().getNome().equals(p2.getCittaArrivo().getNome()) ||
				p1.getCittaArrivo().getNome().equals(p2.getCittapartenza().getNome()))
			return true;
		else
			return false;
	}


	public ArrayList<Citta> getCitta(){
		ArrayList<Citta> c=new ArrayList<Citta>();
		for(int i=0; i<this.p.size();i++) {
			Percorso percorso = p.get(i);
			Citta citta1=percorso.getCittapartenza();
			Citta citta2=percorso.getCittaArrivo();
			c.add(citta1);
			c.add(citta2);
		}
		java.util.Set setta_citta=new HashSet(c);
		ArrayList<Citta> c1=new ArrayList<Citta>(setta_citta);
		return c1;

	}

	public ArrayList<Percorso> getViciniPercorso(Percorso percorso){
		ArrayList<Percorso> percorsos=new ArrayList<>();
		for (int a = 0; a < this.DammiPercorsi().size(); a++) {
			Percorso per1 = this.DammiPercorsi().get(a);
			if ( percorso.getCittapartenza().getNome().equals(per1.getCittapartenza().getNome())
					||percorso.getCittapartenza().getNome().equals(per1.getCittaArrivo().getNome())
					||percorso.getCittaArrivo().getNome().equals(per1.getCittaArrivo().getNome())
					||percorso.getCittaArrivo().getNome().equals(per1.getCittapartenza().getNome())
					){
				percorsos.add(per1);

			}

		}
		return percorsos;
	}
	public ArrayList<Percorso> getViciniPercorsoPartenza(Percorso percorso){
		ArrayList<Percorso> percorsos=new ArrayList<>();
		for (int a=0; a < this.DammiPercorsi().size(); a++) {
			Percorso per1 = this.DammiPercorsi().get(a);
			if(percorso.getid()==per1.getid());
			else if ( percorso.getCittapartenza().getNome().equals(per1.getCittapartenza().getNome())
					||percorso.getCittapartenza().getNome().equals(per1.getCittaArrivo().getNome())
					){
				percorsos.add(per1);

			}

		}
		return percorsos;
	}
	public ArrayList<Percorso> getViciniPercorsoArrivo(Percorso percorso){
		ArrayList<Percorso> percorsos=new ArrayList<>();
		for (int a=0; a < this.DammiPercorsi().size(); a++) {
			Percorso per1 = this.DammiPercorsi().get(a);
			if(percorso.getid()==per1.getid());
			else if (  percorso.getCittaArrivo().getNome().equals(per1.getCittaArrivo().getNome())
					||percorso.getCittaArrivo().getNome().equals(per1.getCittapartenza().getNome())
					){
				percorsos.add(per1);

			}

		}
		return percorsos;
	}

	public ArrayList<Casella> getCaselleVicinePercorsi(ArrayList<Percorso> p, Casella c){
		ArrayList<Casella> casellas= new ArrayList<>();
		for(int i=0; i<p.size();i++)
			casellas.add(p.get(i).getCasellaPerVicino(c));
		return casellas;

	}




	//Funzione che data una casella restituisce il percorso in cui si trova quella casella
	public Percorso getPercorsoByCasella(Casella c){
		ArrayList<Percorso> percorsi = this.DammiPercorsi();
		boolean esci=false;
		int i;
		ArrayList<Casella> caselle = new ArrayList<>();
		for (i=0; i <percorsi.size();i++){
			caselle= percorsi.get(i).getCaselle();
			for(int j=0;j<caselle.size();j++) {
				if (c.getId() ==caselle.get(j).getId()) {
					esci=true;
					break;}
			}
			if(esci==true) break;
		}
		return percorsi.get(i);

	}
	public ArrayList<Percorso> RimuoviDuplicati(ArrayList<com.lynden.example.latlong.Percorso> percorsi){
		ArrayList<com.lynden.example.latlong.Percorso> percorso_no_s=percorsi;
		for(int i=0;i<percorsi.size();i++){
			com.lynden.example.latlong.Percorso percorso=percorsi.get(i);
			for(int j=0;j<percorsi.size();j++){
				com.lynden.example.latlong.Percorso percorso1=percorsi.get(j);
				if(percorso.getid()!=percorso1.getid()) {
					if ((Math.abs(percorso1.getCasellaPartenza().getInizio().getLatitude() - percorso.getCasellaPartenza().getInizio().getLatitude()) < 0.0005
							&& Math.abs(percorso1.getCasellaPartenza().getInizio().getLongitude() - percorso.getCasellaPartenza().getInizio().getLongitude()) < 0.005)) {
						percorso1.removeCasella(percorso1.getCasellaPartenza());
						percorso_no_s.remove(percorso1);
						percorso_no_s.add(percorso1);
					} else if ((Math.abs(percorso1.getCasellaPartenza().getInizio().getLatitude() - percorso.getCasellaArrivo().getInizio().getLatitude()) < 0.0005
							&& Math.abs(percorso1.getCasellaPartenza().getInizio().getLongitude() - percorso.getCasellaArrivo().getInizio().getLongitude()) < 0.005)) {
						percorso1.removeCasella(percorso1.getCasellaPartenza());
						percorso_no_s.remove(percorso1);
						percorso_no_s.add(percorso1);
					} else if ((Math.abs(percorso1.getCasellaArrivo().getInizio().getLatitude() - percorso.getCasellaPartenza().getInizio().getLatitude()) < 0.0005
							&& Math.abs(percorso1.getCasellaArrivo().getInizio().getLongitude() - percorso.getCasellaPartenza().getInizio().getLongitude()) < 0.005)) {
						percorso1.removeCasella(percorso1.getCasellaArrivo());
						percorso_no_s.remove(percorso1);
						percorso_no_s.add(percorso1);
					} else if ((Math.abs(percorso1.getCasellaArrivo().getInizio().getLatitude() - percorso.getCasellaArrivo().getInizio().getLatitude()) < 0.0005
							&& Math.abs(percorso1.getCasellaArrivo().getInizio().getLongitude() - percorso.getCasellaArrivo().getInizio().getLongitude()) < 0.005)) {
						percorso1.removeCasella(percorso1.getCasellaArrivo());
						percorso_no_s.remove(percorso1);
						percorso_no_s.add(percorso1);
					}

				}
			}
		}
		return percorso_no_s;

	}



}

