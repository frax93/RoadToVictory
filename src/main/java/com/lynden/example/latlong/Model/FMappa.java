package com.lynden.example.latlong.Model;

import com.lynden.example.latlong.Model.FactoryMappa.America;
import com.lynden.example.latlong.Model.FactoryMappa.Europa;
import com.lynden.example.latlong.Model.FactoryMappa.IMappa;

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

