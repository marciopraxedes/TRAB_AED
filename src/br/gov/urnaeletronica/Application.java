package br.gov.urnaeletronica;

import javax.swing.JOptionPane;

public class Application {

	public static void main(String[] args) {


		//Selecionar Op��o
		menuOpcoes(0);

	}

	private static void menuOpcoes(int opcaoSelecionada) {

		if(opcaoSelecionada != 4) {

			do{
				opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem vindo ao Sistema de Gest�o da Elei��o."
						+ "\n\nEscolha uma op��o."
						+ "\n\n'1' para Votar"
						+ "\n'2' para Justificar Aus�ncia"
						+ "\n'3' para SAIR do programa"
						+ "\n\n Informe:"));					

				switch(opcaoSelecionada) {
				case 1:
					System.out.println("Votar");
					
					break;
				case 2:
					System.out.println("Justificar Aus�ncia");

					break;

				case 3:
					JOptionPane.showMessageDialog(null, "Voc� escolheu sair.");
					System.out.println("Aplica��o encerrada.");
					System.exit(0);
					break;

				default:
					JOptionPane.showMessageDialog(null, "Op��o inv�lida.");
					System.out.println("Op��o inv�lida.");
					break;
				}
			} while(opcaoSelecionada != 3);

		}
		
		JOptionPane.showMessageDialog(null, "Voc� escolheu sair.");
		System.out.println("Aplica��o encerrada.");


	}

	private static int etapaPreparacao() {

		int selecionarAcao = 0;

		if( selecionarAcao != 6 ) {
			selecionarAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Prepara��o da Elei��o."
					+ "\n\nO que deseja fazer?."
					+ "\n\n'1' Cadastro de partidos pol�ticos"
					+ "\n'2' Cadastro de municipios"
					+ "\n'3' Cadastro dos candidatos a prefeito e vereador"
					+ "\n'4' Cadastro dos eleitores"
					+ "\n'5' Cadastro das urnas eletr�nicas"
					+ "\n'6' Para SAIR"
					+ "\n\n Informe:"));

			switch(selecionarAcao) {
			case 1:
				System.out.println("Cadastro de partidos pol�ticos");
		
				break;

			case 2:
				System.out.println("Cadastro de municipios");
	
			
				break;

			case 3:


				break;

			case 4:


				break;
			case 5:

				
				break;

			default:

				break;
			}

		}		

		int proximaAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja voltar para menu principal?"
				+ "\n\n'1' - SIM \t\t'2' - N�O"));

		if(proximaAcao == 1) return (0); else return(4);		

	}

}	

