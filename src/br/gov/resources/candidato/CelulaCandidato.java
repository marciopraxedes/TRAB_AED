package br.gov.resources.candidato;

import br.gov.tre.models.Candidato;

public class CelulaCandidato {
	Candidato item;
	CelulaCandidato proximo;
	
	CelulaCandidato(){
		item = new Candidato("", 0,"", "", 'P');
		proximo = null;
	}
}
