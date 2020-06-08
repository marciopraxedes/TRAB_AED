package br.gov.urnaeletronica;

import javax.swing.JOptionPane;

import br.gov.resources.candidato.TabelaHashCandidato;
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


		//Selecionar Op��o
		menuOpcoes(0);

	}

	private static void menuOpcoes(int opcaoSelecionada) {

		if(opcaoSelecionada != 4) {

			do{
				opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem vindo ao Sistema de Gest�o da Elei��o."
						+ "\n\nEscolha uma op��o."
						+ "\n\n'1' para Configurar a Urna"
						+ "\n'2' para Votar"
						+ "\n'3' para Justificar Aus�ncia"
						+ "\n'4' para Justificar Aus�ncia"
						+ "\n'5' para SAIR do programa"
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
					System.out.println("Justificar Aus�ncia");
					break;
					
				case 4:
					System.out.println("Voc� escolheu exportar dados da urna eletronica.");
					
					break;
					
				case 5:
					JOptionPane.showMessageDialog(null, "Voc� escolheu sair.");
					System.out.println("Aplica��o encerrada.");
					System.exit(0);
					break;	

				default:
					JOptionPane.showMessageDialog(null, "Op��o inv�lida.");
					System.out.println("Op��o inv�lida.");
					break;
				}
			} while(opcaoSelecionada != 4);

		}
		
		JOptionPane.showMessageDialog(null, "Voc� escolheu sair.");
		System.out.println("Aplica��o encerrada.");


	}

	private static void configurarUrna() {
		
		UrnaEletronica urnaEletronica = new UrnaEletronica();
		
		urnaEletronica.setMunicipio(JOptionPane.showInputDialog(null, "Configura��o da Urna Eletr�nica"
				+ "\n\nDigite o nome do municipio"));
		urnaEletronica.setZonaEleitoral(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o n�mero da Zona Eleitoral")));
		urnaEletronica.setSecaoEleitoral(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o n�mero da Se��o Eleitoral")));
		
		ImportarDadosUrna importarDados = new ImportarDadosUrna();
		
		configUrnaEletronica = importarDados.importDados(urnaEletronica, "urnasEletronicas");
		
		System.out.println("Urna configurada com sucesso!");
		JOptionPane.showMessageDialog(null, "Urna configurada com sucesso!");
	}

	private static void votar() {
		
		if(configUrnaEletronica != null ) {
			int numeroTitulo = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem vindo � vota��o."
					+ "\n\nInforme o N�mero do T�tulo:"));
			
			if(verificarEleitorVotaAqui(numeroTitulo)){
				
				System.out.println("Eleitor vota nessa Zona e Se��o eleitoral");
				
				if(!verificarSeJaVotou(numeroTitulo, "dadosUrnas\\PresencaEleitores\\" + Integer.toString(configUrnaEletronica.getId()))) {
					System.out.println("Eleitor ainda n�o votou. Liberado para votar");					
					realizarVoto(numeroTitulo);
				}
				else {
					System.out.println("Eleitor j� votou");
					JOptionPane.showInputDialog(null, "Eleitor j� votou");
				}
			}
			else {
				System.out.println("Eleitor N�O vota nessa Zona e Se��o eleitoral");
				int opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(null, "Eleitor N�O vota nessa Zona e Se��o eleitoral"
						+ "\n\nDeseja Justificar Aus�ncia?"
						+ "\n\n'1' SIM  -  '2' N�O"));
				
				if(opcaoSelecionada == 1) {
					justificarAusencia(numeroTitulo);
				}	
			}
		}
		else {
			int opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(null, "A urna n�o foi configurada."
					+ "\n\nDeseja configurar a urna?"
					+ "\n\n'1' SIM  -  '2' N�O"));
			System.out.println("A urna n�o foi configurada.");
			
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
					+ "\n\nDigite o n�mero do candidato"));
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
		
		
		System.out.println("Presen�a do eleitor registrada com sucesso!");
	}
}	

