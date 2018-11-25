package it.univaq.rtv.Model;

import it.univaq.rtv.Model.FactoryMappa.*;
import java.io.IOException;
import java.lang.String;

public class FactorMappa {

	/**
	 * @param criteria
	 * @return
	 * @throws IOException
	 */
	public static AbstractMappa getMappa(String criteria ) throws IOException{
		if ( criteria.equals("Europa") )
			return new Europa();
		else if ( criteria.equals("USA") )
			return new USA();
		else if ( criteria.equals("Africa") )
			return new Africa();
		else if ( criteria.equals("Sud_America") )
			return new SudAmerica();
		else if ( criteria.equals("Asia") )
			return new Asia();
		else
			return null;
	}




}

