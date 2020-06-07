package br.gov.tre.resources.partidopolitico;
import br.gov.tre.models.PartidoPolitico;

public class CelulaPartidoPolitico {

	PartidoPolitico item;
	CelulaPartidoPolitico proximo;
	
	CelulaPartidoPolitico(){
		item = new PartidoPolitico("", "");
		proximo = null;
	}
}
