package br.gov.urnaeletronica;

import javax.swing.JOptionPane;

public class Application {

	public static void main(String[] args) {


		//Selecionar Opção
		menuOpcoes(0);

	}

	private static void menuOpcoes(int opcaoSelecionada) {

		if(opcaoSelecionada != 4) {

			do{
				opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem vindo ao Sistema de Gestão da Eleição."
						+ "\n\nEscolha uma opção."
						+ "\n\n'1' para Votar"
						+ "\n'2' para Justificar Ausência"
						+ "\n'3' para SAIR do programa"
						+ "\n\n Informe:"));					

				switch(opcaoSelecionada) {
				case 1:
					System.out.println("Votar");
					
					break;
				case 2:
					System.out.println("Justificar Ausência");

					break;

				case 3:
					JOptionPane.showMessageDialog(null, "Você escolheu sair.");
					System.out.println("Aplicação encerrada.");
					System.exit(0);
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção inválida.");
					System.out.println("Opção inválida.");
					break;
				}
			} while(opcaoSelecionada != 3);

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
				+ "\n\n'1' - SIM \t\t'2' - NÃO"));

		if(proximaAcao == 1) return (0); else return(4);		

	}

}	

