package br.gov.urnaeletronica;

import javax.swing.JOptionPane;

import br.gov.tre.models.UrnaEletronica;
import br.gov.urnaeletronica.resources.ArquivoTexto;
import br.gov.urnaeletronica.resources.ConfigUrnaEletronica;
import br.gov.urnaeletronica.resources.ImportarDadosUrna;

public class Application {
	
	private static ArquivoTexto bancoDados = new ArquivoTexto();
	
	private static ConfigUrnaEletronica configUrnaEletronica;

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
						+ "\n'4' para SAIR do programa"
						+ "\n\n Informe:"));					

				switch(opcaoSelecionada) {
				case 1:
					System.out.println("Configurar a Urna");
					configurarUrna();
					
					break;
				case 2:
					System.out.println("Votar");
					

					break;

				case 3:
					System.out.println("Justificar Aus�ncia");
					break;
					
				case 4:
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
		
		JOptionPane.showMessageDialog(null, "Urna configurada com sucesso!");
	}

}	

