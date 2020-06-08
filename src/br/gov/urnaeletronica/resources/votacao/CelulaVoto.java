package br.gov.urnaeletronica.resources.votacao;

import br.gov.urnaeletronica.models.Voto;

public class CelulaVoto {
	Voto item;
	CelulaVoto proximo;
	
	CelulaVoto(){
		item = new Voto("",0,"","",' ', 0);
		proximo = null;
	}
}
