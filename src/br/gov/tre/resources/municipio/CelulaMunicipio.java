package br.gov.tre.resources.municipio;

import br.gov.tre.models.Municipio;

public class CelulaMunicipio {
	Municipio item;
	CelulaMunicipio proximo;
	
	CelulaMunicipio(){
		item = new Municipio("", "", 0, 0);
		proximo = null;
	}
}
