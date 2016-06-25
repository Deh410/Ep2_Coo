package gerenciadores;

import java.util.Scanner;

public class UserInterface {

	public static void displayMenu() {
		System.out.println("\n1.Cadastrar nova atividade");
		System.out.println("2.Visualizar todas Atividades");
		System.out.println("3.Remover Atividade");
		System.out.println("4.Sair");
	}

	public static void main(String[] args) {
		boolean ok = false;
		boolean ok2 = false;
		String nome;
		Scanner sc = new Scanner(System.in);
		GerenciadorAtividade<Atividade> novo = new GerenciadorAtividade<Atividade>();
		int opcao = -1;

		while (ok == false) {
			displayMenu();
			opcao = sc.nextInt();
			if (opcao < 0 || opcao > 4) {
				System.out.println("Opcao invalidade. Try again.");
				ok = false;
			}
			switch (opcao) {
			case 1:
				novo.cadastrarAtividade();
				break;
			case 2:
				novo.visualizarTodasAtividades();
				break;
			case 3:
				while (ok2 == false) {
					System.out
							.println("Digite o nome da atividade a ser removida:");
					nome = sc.nextLine();
					nome = nome.toLowerCase();

					/*
					 * Corrigir essa bagaça E todas bagaças vermelhas
					 */

					if (Atividade.AtividadesConstruidas.containsKey(nome) == false) {
						System.out.println("Nome nao existe. Tente Novamente");
					} else {
						novo.removerAtividade(nome);
						System.out.println("Atividade " + nome
								+ " removida com sucesso");
						ok2 = true;
					}
				}
			default:
				return;
			}
		}
	}
}
