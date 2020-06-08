package br.gov.tre;

import javax.swing.JOptionPane;

import br.gov.resources.candidato.TabelaHashCandidato;
import br.gov.tre.resources.eleitor.TabelaHashEleitor;
<<<<<<< HEAD
import br.gov.tre.resources.municipio.ListaMunicipio;
=======

import br.gov.tre.resources.municipio.ListaMunicipio;
import br.gov.tre.resources.partidopolitico.ListaPartidoPolitico;
import br.gov.tre.resources.urna.ListaUrnaEletronica;

>>>>>>> e8d16b102e523b84ab2185bc9b9c2d1ed51afe4a
import br.gov.urnaeletronica.resources.ArquivoTexto;
import br.gov.urnaeletronica.resources.ExportarDadosUrna;

public class Application {

	private static ArquivoTexto bancoDados = new ArquivoTexto();
	
	private static TabelaHashEleitor tabelaEleitores;
	private static ListaPartidoPolitico listaPartidosPoliticos;
	private static ListaMunicipio listaMunicipios;
	private static ListaUrnaEletronica listaUrnasEletronicas;
	private static TabelaHashCandidato tabelaCandidatos;


	private static String arquivoEleitores = "eleitores"; //JOptionPane.showInputDialog(null, "Digite o nome do 'eleitores'");	
	private static String arquivoCandidatos = "candidatos";
	private static String arquivoPartidosPoliticos = "partidosPoliticos";
	private static String arquivoMunicipios = "municipios";
	private static String arquivoUrnasEletronicas = "urnasEletronicas";

	public static void main(String[] args) {


		//Selecionar etapa
		menuEtapas(0);

	}

	private static void menuEtapas(int etapaEleicao) {

		if(etapaEleicao != 4) {

			do{
				etapaEleicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem vindo ao Sistema de Gestão da Eleição."
						+ "\n\nDefina em qual etapa está a eleição."
						+ "\n\n'1' para Preparação da Eleição"
						+ "\n'2' para Durante a Eleição"
						+ "\n'3' para Apuração dos Votos"
						+ "\n'4' para SAIR do programa"
						+ "\n\n Informe:"));					

				switch(etapaEleicao) {
				case 1:
					System.out.println("Etapa de 'Preparação Selecionada'");
					etapaEleicao = etapaPreparacao();
					break;
				case 2:
					System.out.println("Etapa 'Durante a Eleição'");

					break;

				case 3:
					System.out.println("Etapa de 'Apuração dos Votos'");

					break;

				case 4:
					JOptionPane.showMessageDialog(null, "Você escolheu sair.");
					System.out.println("Aplicação encerrada.");
					System.exit(0);
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção inválida.");
					System.out.println("Opção inválida.");
					break;
				}
			} while(etapaEleicao != 4);

		}
		
		JOptionPane.showMessageDialog(null, "Você escolheu sair.");
		System.out.println("Aplicação encerrada.");


	}

	private static int etapaPreparacao() {

		int selecionarAcao = 0;

		if( selecionarAcao != 6 ) {
			selecionarAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Preparação da Eleição."
					+ "\n\nO que deseja fazer?."
					+ "\n\n'1' Cadastro de partidos políticos"
					+ "\n'2' Cadastro de municipios"
					+ "\n'3' Cadastro dos candidatos a prefeito e vereador"
					+ "\n'4' Cadastro dos eleitores"
					+ "\n'5' Cadastro das urnas eletrônicas"
					+ "\n'6' Para SAIR"
					+ "\n\n Informe:"));

			switch(selecionarAcao) {
			case 1:
				System.out.println("Cadastro de partidos políticos");
				bancoDados.abrirArquivo(arquivoPartidosPoliticos+".txt");
				listaPartidosPoliticos = bancoDados.lerDadosPartidoPolitico();
				listaPartidosPoliticos.imprimirTodosDados();
				bancoDados.fecharArquivo();				
				break;

			case 2:
				System.out.println("Cadastro de municipios");
				bancoDados.abrirArquivo(arquivoMunicipios+".txt");
				listaMunicipios = bancoDados.lerDadosMunicipios();
				listaMunicipios.imprimirTodosDados();
				bancoDados.fecharArquivo();			
			
				break;

			case 3:
				bancoDados.abrirArquivo(arquivoCandidatos+".txt");
				tabelaCandidatos = bancoDados.lerDadosCandidatos();	
				tabelaCandidatos.imprimirCandidatosEmLinha();
				bancoDados.fecharArquivo();
				break;

			case 4:
				bancoDados.abrirArquivo(arquivoEleitores+".txt");
				tabelaEleitores = bancoDados.lerDadosEleitores();	
				tabelaEleitores.imprimirEleitoresEmLinha();
				bancoDados.fecharArquivo();
				break;
			case 5:
				bancoDados.abrirArquivo(arquivoUrnasEletronicas+".txt");
				listaUrnasEletronicas = bancoDados.lerDadosUrnasEletronicas();	
				listaUrnasEletronicas.imprimirTodosDados();
				bancoDados.fecharArquivo();
				
				bancoDados.abrirArquivo(arquivoEleitores+".txt");
				tabelaEleitores = bancoDados.lerDadosEleitores();	
				bancoDados.fecharArquivo();
				
				bancoDados.abrirArquivo(arquivoCandidatos+".txt");
				tabelaCandidatos = bancoDados.lerDadosCandidatos();	
				bancoDados.fecharArquivo();
				
				ExportarDadosUrna export = new ExportarDadosUrna();
				export.exportarDados(listaUrnasEletronicas.listaDeUrnas(), tabelaCandidatos.listaCandidatos(), tabelaEleitores.listaEleitores());
				
				break;

			default:

				break;
			}

		}		

		int proximaAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja voltar para menu principal?"
				+ "\n\n'1' - SIM \t\t'2' - NÃO"));

		if(proximaAcao == 1) return (0); else return(4);		

	}

}
