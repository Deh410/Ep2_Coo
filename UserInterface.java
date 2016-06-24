package gerenciadores;

import java.util.Scanner;

public class UserInterface {

	public boolean menu(Atividade atividadeBuilder) {
		if(atividadeBuilder == null){
			System.out.println("Builder null");
		}
		Scanner sc = new Scanner(System.in);
		String atividade = null;
		String again = null;
		boolean ok = false;
		while (ok == false) {
			System.out.println("Escolha o tipo de Atividade: ");
			System.out.println("Analogica, Digital ou Fisica");
			System.out.println("Digite a inicial: (A / D / F)");
			atividade = sc.nextLine();
			atividade = atividade.toLowerCase();
			ok = checkTipoAtividade(atividade);
		}
		if (atividade.equals("a")) {
			atividadeBuilder = new AtividadeAnalogica();
		} else if (atividade.equals("d")) {
			atividadeBuilder = new AtividadeDigital();
		} else if (atividade.equals("f")) {
			atividadeBuilder = new AtividadeFisica();
		}
		atividadeBuilder.makeAtividade();
		/*
		 * terminar user interface e depois implementar pra usar com o
		 * Gerenciador de atividade Falta corrigir dias e horarios repetidos,
		 * usar antigo?
		 */
		ok = false;
		while (ok == false) {
			System.out.println("Deseja criar outra atividade? [S/N]");
			again = sc.nextLine();
			again = again.toLowerCase();
			if (again.equals("s"))
				return true;
			if (again.equals("n"))
				return false;
			ok = false;
		}
		return false;
	}

	public boolean checkTipoAtividade(String tipo) {
		if (tipo.equals("a") || tipo.equals("d") || tipo.equals("f")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		UserInterface user = new UserInterface();
		Atividade atividadeBuilder = null;
		boolean ok = true;
		while (ok == true) {
			ok = user.menu(atividadeBuilder);
		}
	}
}
