package br.gov.urnaeletronica.resources;

import java.util.ArrayList;

import br.gov.resources.candidato.TabelaHashCandidato;
import br.gov.tre.models.Candidato;
import br.gov.tre.models.Eleitor;
import br.gov.tre.models.UrnaEletronica;
import br.gov.tre.resources.apuracao.ListaVencedores;
import br.gov.tre.resources.municipio.ListaMunicipio;
import br.gov.tre.resources.urna.ListaUrnaEletronica;
import br.gov.urnaeletronica.models.Voto;
import br.gov.urnaeletronica.resources.votacao.ListaVoto;

public class ResultadosEleicao {

	private static ArquivoTexto bancoDados = new ArquivoTexto();
	private static ArrayList<Candidato> arrayListCandidatos = new ArrayList<Candidato>();
	private static ArrayList<Voto> arrayListVotos = new ArrayList<Voto>();
	private static int qtdEleitoresMunicipio = 0;
	private static ListaVencedores listaVencedores;
	private static int votosPrefeito = 0;
	private static int votosPrefeitoSegundo = 0;
	private static int maisVotatoPrefeito = 0;
	private static Candidato prefeitoVencedor;	

	private static String arquivoUrnasEletronicas = "urnasEletronicas";

	public ArrayList<Candidato> processarPrefeiroVencedor(String nomeMunicipio) {

		
		ArrayList<Candidato> resultadoEleicao = new ArrayList<Candidato>();
		
		bancoDados.abrirArquivo(arquivoUrnasEletronicas);
		ArrayList<UrnaEletronica> arrayListUrnas = bancoDados.lerDadosUrnasEletronicas().listaDeUrnas();
		bancoDados.fecharArquivo();

		for (int i = 0; i < arrayListUrnas.size(); i++) {

			String indiceArquivo = Integer.toString(i);

			if (arrayListUrnas.get(i).getMunicipio().contains(nomeMunicipio)) {

				bancoDados.abrirArquivo("dadosUrnas\\Votos\\" + indiceArquivo);
				ArrayList<Voto> vototemp = bancoDados.lerDadosVotos().listaVotos();
				arrayListVotos.addAll(vototemp);
			
				
				bancoDados.fecharArquivo();
			}
			if (i == 0) {
				bancoDados.abrirArquivo("dadosUrnas\\Candidatos\\" + indiceArquivo);
				arrayListCandidatos = bancoDados.lerDadosCandidatos().listaCandidatos();
				bancoDados.fecharArquivo();
			}

		}
		
		//Contabilizar quantidade de eleitores que votaram
		for(int i = 0; i < arrayListVotos.size(); i ++ ) {
			qtdEleitoresMunicipio++;
		}
		
		for(int i = 0 ; i < arrayListCandidatos.size() ; i ++) {			
			
			for(int j = 0 ; j < arrayListVotos.size(); j ++) {
				
				if(arrayListCandidatos.get(i).getCargo() == 'P') {
					
					if(arrayListCandidatos.get(i).getNumero() == arrayListVotos.get(j).getNumero()) {
						votosPrefeito += arrayListVotos.get(j).getQuantidadeVotos();
					}
				}				
				
			}
			
			if( i > 0) {
				if(votosPrefeito > maisVotatoPrefeito) {
					prefeitoVencedor = arrayListCandidatos.get(i);
					arrayListCandidatos.get(i).setQtdVotos(votosPrefeito);
					maisVotatoPrefeito = votosPrefeito;
				}	
			}
			else {
				prefeitoVencedor = arrayListCandidatos.get(i);				
				maisVotatoPrefeito = votosPrefeito;
			}
			
		}
		
		if(verificaMaisVotadoAcima50Perc(maisVotatoPrefeito)) {
			resultadoEleicao.add(prefeitoVencedor);			
		}
		else {
			resultadoEleicao.add(prefeitoVencedor);
			resultadoEleicao.add(segundoMaisVotado());
		}		
		return resultadoEleicao;
	}
	
	
	private boolean verificaMaisVotadoAcima50Perc(int maisVotado) {
		
		if((qtdEleitoresMunicipio / 2) < maisVotado) {
			return true;
		}
		return false;
		
	}

	private Candidato segundoMaisVotado() {
		
		Candidato segundoMaisVotado = null;
		
		for(int i = 0 ; i < arrayListCandidatos.size() ; i ++) {			
			
			for(int j = 0 ; j < arrayListVotos.size(); j ++) {
				
				if(arrayListCandidatos.get(i).getCargo() == 'P') {
					
					if(arrayListCandidatos.get(i).getNumero() == arrayListVotos.get(j).getNumero()) {
						votosPrefeito += arrayListVotos.get(j).getQuantidadeVotos();
					}
				}				
				
			}
			if( i > 0) {
				if(maisVotatoPrefeito > votosPrefeitoSegundo && votosPrefeitoSegundo > votosPrefeito ) {
					segundoMaisVotado = arrayListCandidatos.get(i);	
					arrayListCandidatos.get(i).setQtdVotos(votosPrefeito);
					votosPrefeitoSegundo = votosPrefeito;
				}	
			}
			else if(maisVotatoPrefeito != votosPrefeito) {
				segundoMaisVotado = arrayListCandidatos.get(i);
				arrayListCandidatos.get(i).setQtdVotos(votosPrefeito);
				votosPrefeitoSegundo = votosPrefeito;
			}
			else {
				segundoMaisVotado = arrayListCandidatos.get(i);
			}
			
		}
		
		return segundoMaisVotado;
	}
}
