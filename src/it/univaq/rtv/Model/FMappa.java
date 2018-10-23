package it.univaq.rtv.Model;

import it.univaq.rtv.Model.FactoryMappa.*;

import java.io.IOException;
import java.lang.String;

public class FMappa {

	public static IMappa getMappa(String criteria ) throws IOException{
		if ( criteria.equals("Europa") )
			return new Europa();
		else if ( criteria.equals("USA") )
			return new USA();
		else if ( criteria.equals("Africa") )
			return new Africa();
		else if ( criteria.equals("Sud_America") )
			return new Sud_America();
		else
			return null;
	}




}

