package br.gov.tre.resources.urna;

import br.gov.tre.models.UrnaEletronica;

public class CelulaUrnaEletronica {
	UrnaEletronica item;
	CelulaUrnaEletronica proximo;
	
	CelulaUrnaEletronica(){
		item = new UrnaEletronica("", 0, 0);
		proximo = null;
	}
}
