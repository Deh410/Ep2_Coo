package gerenciadores;

import java.util.*;

public class Mes {

	Map<Integer, Dia> janeiro = new HashMap<Integer, Dia>();

	Map<Integer, Dia> fevereiro = new HashMap<Integer, Dia>();

	Map<Integer, Dia> marco = new HashMap<Integer, Dia>();

	Map<Integer, Dia> abril = new HashMap<Integer, Dia>();

	Map<Integer, Dia> maio = new HashMap<Integer, Dia>();

	Map<Integer, Dia> junho = new HashMap<Integer, Dia>();

	Map<Integer, Dia> julho = new HashMap<Integer, Dia>();

	Map<Integer, Dia> agosto = new HashMap<Integer, Dia>();

	Map<Integer, Dia> setembro = new HashMap<Integer, Dia>();

	Map<Integer, Dia> outubro = new HashMap<Integer, Dia>();

	Map<Integer, Dia> novembro = new HashMap<Integer, Dia>();

	Map<Integer, Dia> dezembro = new HashMap<Integer, Dia>();

	public boolean checkMes(int mes) {
		if (mes < 1 || mes > 12) {
			System.out.println("Insira um mes entre 1 e 12");
			return false;
		}
		return true;
	}
	
	
}
