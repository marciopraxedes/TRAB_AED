package br.gov.urnaeletronica.resources;

import br.gov.resources.candidato.TabelaHashCandidato;
import br.gov.tre.models.UrnaEletronica;
import br.gov.tre.resources.eleitor.TabelaHashEleitor;
import br.gov.tre.resources.urna.ListaUrnaEletronica;

public class ImportarDadosUrna {
	
	private static ArquivoTexto bancoDados = new ArquivoTexto();
	private static ListaUrnaEletronica listaUrnasEletronicas;
	private static TabelaHashCandidato tabelaCandidatos;
	private static TabelaHashEleitor tabelaEleitores;
	
	public ConfigUrnaEletronica importDados (UrnaEletronica urnaEletronica, String arquivoUrnasEletronicas) {
				
		ConfigUrnaEletronica configUrnaEletronica = new ConfigUrnaEletronica();
		
		try {
			
			//Abrir o arquivo das urnas eletronicas e obter a lista de urnas
			bancoDados.abrirArquivo(arquivoUrnasEletronicas+".txt");
			listaUrnasEletronicas = bancoDados.lerDadosUrnasEletronicas();	
			bancoDados.fecharArquivo();
			
			//obter o indice da urna selecionada que também é o mesmo nome dos arquivos de configuração Eleitor e Candidato
			String nomeArquivo = Integer.toString(listaUrnasEletronicas.retornarIndiceItem(urnaEletronica)) + ".txt";
			
			bancoDados.abrirArquivo("configUrnas\\eleitores\\" + nomeArquivo);
			tabelaEleitores = bancoDados.lerDadosEleitores();	
			bancoDados.fecharArquivo();
			
			bancoDados.abrirArquivo("configUrnas\\Candidatos\\" + nomeArquivo);
			tabelaCandidatos = bancoDados.lerDadosCandidatos();	
			bancoDados.fecharArquivo();
			
			configUrnaEletronica.setMunicipio(urnaEletronica.getMunicipio());
			configUrnaEletronica.setZonaEleitoral(urnaEletronica.getZonaEleitoral());
			configUrnaEletronica.setSecaoEleitoral(urnaEletronica.getSecaoEleitoral());
			configUrnaEletronica.setTabelaCandidatos(tabelaCandidatos);
			configUrnaEletronica.setTabelaEleitores(tabelaEleitores);
			
			return configUrnaEletronica;
			
		}
		catch (Exception e) {
			System.out.println("Arquivo não encontrado");
		}
		
		return null;
	}
}
