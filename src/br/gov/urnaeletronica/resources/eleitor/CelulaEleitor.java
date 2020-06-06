package br.gov.urnaeletronica.resources.eleitor;

import br.gov.tre.models.Eleitor;

public class CelulaEleitor {

	Eleitor item;
	CelulaEleitor proximo;
	
	CelulaEleitor(){
		item = new Eleitor("", "", 0, 0, 0);
		proximo = null;
	}
}
