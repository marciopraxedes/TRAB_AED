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
		
		JOptionPane.showMessageDialog(null, "Urna configurada com sucesso!");
	}

}	

