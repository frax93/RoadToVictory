package it.univaq.rtv.Model;

import it.univaq.rtv.Model.FactoryMappa.America;
import it.univaq.rtv.Model.FactoryMappa.Europa;
import it.univaq.rtv.Model.FactoryMappa.IMappa;

import java.io.IOException;
import java.lang.String;

public class FMappa {

	public static IMappa getMappa(String criteria ) throws IOException{
		if ( criteria.equals("Europa") )
			return new Europa();
		else if ( criteria.equals("America") )
			return new America();
		else
			return null;
	}




}

