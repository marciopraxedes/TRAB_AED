package br.gov.urnaeletronica;

import javax.swing.JOptionPane;

import br.gov.tre.models.Eleitor;
import br.gov.tre.models.UrnaEletronica;
import br.gov.tre.resources.eleitor.TabelaHashEleitor;
import br.gov.urnaeletronica.resources.ArquivoTexto;
import br.gov.urnaeletronica.resources.ConfigUrnaEletronica;
import br.gov.urnaeletronica.resources.ImportarDadosUrna;
import br.gov.urnaeletronica.resources.votacao.ListaVoto;

public class Application {
	
	private static ArquivoTexto bancoDados = new ArquivoTexto();
	
	private static ConfigUrnaEletronica configUrnaEletronica = null;

	public static void main(String[] args) {


		//Selecionar Opção
		menuOpcoes(0);

	}

	private static void menuOpcoes(int opcaoSelecionada) {

		if(opcaoSelecionada != 4) {

			do{
				opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem vindo ao Sistema de Gestão da Eleição."
						+ "\n\nEscolha uma opção."
						+ "\n\n'1' para Configurar a Urna"
						+ "\n'2' para Votar"
						+ "\n'3' para Justificar Ausência"
						+ "\n'4' para SAIR do programa"
						+ "\n\n Informe:"));					

				switch(opcaoSelecionada) {
				case 1:
					System.out.println("Configurar a Urna");
					configurarUrna();
					
					break;
				case 2:
					System.out.println("Votar");
					votar();					

					break;

				case 3:
					System.out.println("Justificar Ausência");
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
			} while(opcaoSelecionada != 4);

		}
		
		JOptionPane.showMessageDialog(null, "Você escolheu sair.");
		System.out.println("Aplicação encerrada.");


	}

	private static void configurarUrna() {
		
		UrnaEletronica urnaEletronica = new UrnaEletronica();
		
		urnaEletronica.setMunicipio(JOptionPane.showInputDialog(null, "Configuração da Urna Eletrônica"
				+ "\n\nDigite o nome do municipio"));
		urnaEletronica.setZonaEleitoral(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da Zona Eleitoral")));
		urnaEletronica.setSecaoEleitoral(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da Seção Eleitoral")));
		
		ImportarDadosUrna importarDados = new ImportarDadosUrna();
		
		configUrnaEletronica = importarDados.importDados(urnaEletronica, "urnasEletronicas");
		
		System.out.println("Urna configurada com sucesso!");
		JOptionPane.showMessageDialog(null, "Urna configurada com sucesso!");
	}

	private static void votar() {
		
		if(configUrnaEletronica != null ) {
			int numeroTitulo = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem vindo à votação."
					+ "\n\nInforme o Número do Título:"));
			
			if(verificarEleitorVotaAqui(numeroTitulo)){
				
				System.out.println("Eleitor vota nessa Zona e Seção eleitoral");
				
				if(!verificarSeJaVotou(numeroTitulo, "dadosUrnas\\PresencaEleitores\\" + Integer.toString(configUrnaEletronica.getId()))) {
					System.out.println("Eleitor ainda não votou. Liberado para votar");					
					realizarVoto(numeroTitulo);
				}
				else {
					System.out.println("Eleitor já votou");
					JOptionPane.showInputDialog(null, "Eleitor já votou");
				}
			}
			else {
				System.out.println("Eleitor NÃO vota nessa Zona e Seção eleitoral");
				int opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(null, "Eleitor NÃO vota nessa Zona e Seção eleitoral"
						+ "\n\nDeseja Justificar Ausência?"
						+ "\n\n'1' SIM  -  '2' NÃO"));
				
				if(opcaoSelecionada == 1) {
					justificarAusencia(numeroTitulo);
				}	
			}
		}
		else {
			int opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(null, "A urna não foi configurada."
					+ "\n\nDeseja configurar a urna?"
					+ "\n\n'1' SIM  -  '2' NÃO"));
			System.out.println("A urna não foi configurada.");
			
			if(opcaoSelecionada == 1) {
				configurarUrna();
				votar();
			}			
		}
	}
	
	private static boolean verificarEleitorVotaAqui(long numeroTitulo) {
		if(configUrnaEletronica.getTabelaEleitores().pesquisarEleitor(numeroTitulo) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static boolean verificarSeJaVotou(long numeroTitulo, String arquivoPresenca) {

		bancoDados.abrirArquivo(arquivoPresenca);
		TabelaHashEleitor tabelaHashEleitores = bancoDados.lerDadosEleitores();
		Eleitor eleitor = tabelaHashEleitores.pesquisarEleitor(numeroTitulo);
		
		if(eleitor != null ) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	private static void justificarAusencia(long numeroTitulo) {
		
	}
	
	private static void realizarVoto(long numeroTitulo) {
		
		boolean candidatoValido;
		int numeroCandidato;
		
		do {
			numeroCandidato = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha do candidato."
					+ "\n\nDigite o número do candidato"));
			candidatoValido = verificaCadidatoValido(numeroCandidato);			
			
		} while(!candidatoValido);
		
		//abrir arquivo de votos
		bancoDados.abrirArquivo("dadosUrnas\\Votos\\" + Integer.toString(configUrnaEletronica.getId()));
		//instanciar a lista de votos
		ListaVoto listaVotos = bancoDados.lerDadosVotos();
		
		bancoDados.fecharArquivo();
		
		if(listaVotos.atualizarVotosCandidato(numeroCandidato)) {
			
			bancoDados.criarArquivo("dadosUrnas\\Votos\\" + Integer.toString(configUrnaEletronica.getId()));
			bancoDados.atualizarVotos(listaVotos);
			bancoDados.fecharArquivo();
			
			registrarPresencaEleitor(numeroTitulo);				
			
			System.out.println("Voto realizado com sucesso!");
			JOptionPane.showMessageDialog(null, "Voto realizado com sucesso!");
		}
		else {
			System.out.println("Erro ao realizar voto. Tente novamente");
			JOptionPane.showMessageDialog(null, "Erro ao realizar voto. Tente novamente");
		}		
		
	}
	
	private static boolean verificaCadidatoValido(int numeroCandidato) {
		if(configUrnaEletronica.getTabelaCandidatos().pesquisarCandidato(numeroCandidato) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static void registrarPresencaEleitor(long numeroTitulo) {
		
		bancoDados.abrirCriarArquivo("dadosUrnas\\PresencaEleitores\\" + configUrnaEletronica.getId());
		String eleitor = configUrnaEletronica.getTabelaEleitores().pesquisarEleitor(numeroTitulo).getNome() + ";"
				+configUrnaEletronica.getTabelaEleitores().pesquisarEleitor(numeroTitulo).getNumeroTitulo() + ";"
				+configUrnaEletronica.getTabelaEleitores().pesquisarEleitor(numeroTitulo).getMunicipio() + ";"
				+configUrnaEletronica.getTabelaEleitores().pesquisarEleitor(numeroTitulo).getZonaEleitoral() + ";"
				+configUrnaEletronica.getTabelaEleitores().pesquisarEleitor(numeroTitulo).getSecaoEleitoral();
		bancoDados.escrever(eleitor);
		bancoDados.fecharArquivo();
		
		
		System.out.println("Presença do eleitor registrada com sucesso!");
	}
}