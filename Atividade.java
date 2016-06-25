package gerenciadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Atividade implements AtividadeFactory{
	private static String name;

	public static List<String> listaAtividades = new ArrayList<String>();

	public static Map<String, Atividade> AtividadesConstruidas = new LinkedHashMap<String, Atividade>();

	
	public static String getName() {
		return name;
	}

	public static void setName(String nome) {
		name = nome;
	}
	
	public abstract boolean addListaAtividadeLista(List<String> atividades);
	
	public abstract void makeAtividade(Atividade atividade);

	public static boolean addAtividadeConstruida(String nome, Atividade dig){
		return false;
		
	}

	public static boolean checkConflito(Atividade dig1){
		return false;
		
	}

	public static boolean checkTipoAtividade(String tipo) {
		if (tipo.equals("a") || tipo.equals("d") || tipo.equals("f")) {
			return true;
		}
		return false;
	}
	
	public static Atividade tipoAtividade(){
		boolean ok = false;
		Scanner sc = new Scanner(System.in);
		String atividade = null;
		Atividade atividadeBuilder = null;
		while (ok == false) {
			System.out.println("Escolha o tipo de Atividade: ");
			System.out.println("Analogica, Digital ou Fisica");
			System.out.println("Digite a inicial: (A / D / F)");
			atividade = sc.nextLine();
			atividade = atividade.toLowerCase();
			ok = Atividade.checkTipoAtividade(atividade);
		}
		if (atividade.equals("a")) {
			atividadeBuilder = new AtividadeAnalogica();
		} else if (atividade.equals("d")) {
			atividadeBuilder = new AtividadeDigital();
		} else if (atividade.equals("f")) {
			atividadeBuilder = new AtividadeFisica();
		}
		return atividadeBuilder;
	}

}
