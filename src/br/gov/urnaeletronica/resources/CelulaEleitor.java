package br.gov.urnaeletronica.resources;

import br.gov.tre.models.Eleitor;

public class CelulaEleitor {

	Eleitor item;
	CelulaEleitor proximo;
	
	CelulaEleitor(){
		item = new Eleitor(null, null, 0, 0, 0);
		proximo = null;
	}
}
