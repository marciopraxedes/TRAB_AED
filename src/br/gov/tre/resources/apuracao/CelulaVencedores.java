package br.gov.tre.resources.apuracao;

import br.gov.tre.models.Vencedores;

public class CelulaVencedores {
	Vencedores item;
	CelulaVencedores proximo;
	
	CelulaVencedores(){
		item = new Vencedores(null, null, null);
		proximo = null;
	}
}
