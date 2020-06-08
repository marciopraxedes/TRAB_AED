package br.gov.urnaeletronica.resources;

import java.util.ArrayList;

import br.gov.tre.models.Candidato;
import br.gov.tre.models.Eleitor;
import br.gov.tre.models.UrnaEletronica;

public class ExportarDadosUrna {

	private static ArquivoTexto bancoDados = new ArquivoTexto();

	public void exportarDadosParaUrnas(ArrayList<UrnaEletronica> listaDeUrnas, ArrayList<Candidato> listaCandidatos,
			ArrayList<Eleitor> listaEleitores) {

		exportarEleitoresUrna(listaEleitores, listaDeUrnas);
		exportarCandidatosUrna(listaCandidatos, listaDeUrnas);
		criarArquivoVotos(listaCandidatos, listaDeUrnas);

	}

	private void exportarEleitoresUrna(ArrayList<Eleitor> listaEleitores, ArrayList<UrnaEletronica> listaDeUrnas) {

		for (int i = 0; i < listaDeUrnas.size(); i++) {

			bancoDados.criarArquivo("dadosUrnas\\Eleitores\\" + Integer.toString(i));

			for (int j = 0; j < listaEleitores.size(); j++) {

				if (listaEleitores.get(j).getSecaoEleitoral() == listaDeUrnas.get(i).getSecaoEleitoral() 
						&& listaEleitores.get(j).getZonaEleitoral() == listaDeUrnas.get(i).getZonaEleitoral() ) {
					
					String entradaArquivo = listaEleitores.get(j).getNome() + ";" + listaEleitores.get(j).getNumeroTitulo() + ";"
							+ listaDeUrnas.get(i).getMunicipio() + ";" + listaEleitores.get(j).getZonaEleitoral() + ";" 
							+ listaEleitores.get(j).getSecaoEleitoral();
					bancoDados.escrever(entradaArquivo);
				}
			}

			bancoDados.fecharArquivo();
		}
	}

	private void exportarCandidatosUrna(ArrayList<Candidato> listaCandidatos, ArrayList<UrnaEletronica> listaDeUrnas) {

		for (int i = 0; i < listaDeUrnas.size(); i++) {

			bancoDados.criarArquivo("dadosUrnas\\candidatos\\" + Integer.toString(i));

			for (int j = 0; j < listaCandidatos.size(); j++) {
				
				if (listaCandidatos.get(j).getMunicipio().contains(listaDeUrnas.get(i).getMunicipio())) {
					
					String entradaArquivo = listaCandidatos.get(j).getNome() + ";" + listaCandidatos.get(j).getNumero() + ";"
							+ listaCandidatos.get(j).getMunicipio() + ";" + listaCandidatos.get(j).getPartidoPolitico() + ";" 
							+ listaCandidatos.get(j).getCargo();
					bancoDados.escrever(entradaArquivo);
				}
			}

			bancoDados.fecharArquivo();
		}
	}
	
	private void criarArquivoVotos(ArrayList<Candidato> listaCandidatos, ArrayList<UrnaEletronica> listaDeUrnas) {

		for (int i = 0; i < listaDeUrnas.size(); i++) {

			bancoDados.criarArquivo("dadosUrnas\\Votos\\" + Integer.toString(i));

			for (int j = 0; j < listaCandidatos.size(); j++) {
				
				if (listaCandidatos.get(j).getMunicipio().contains(listaDeUrnas.get(i).getMunicipio())) {
					
					String entradaArquivo = listaCandidatos.get(j).getNome() + ";" + listaCandidatos.get(j).getNumero() + ";"
							+ listaCandidatos.get(j).getMunicipio() + ";" + listaCandidatos.get(j).getPartidoPolitico() + ";" 
							+ listaCandidatos.get(j).getCargo() + ";0";
					bancoDados.escrever(entradaArquivo);
				}
			}

			bancoDados.fecharArquivo();
		}
	}

}
