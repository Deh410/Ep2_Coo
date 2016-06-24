package gerenciadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Atividade {
	private String name;
	public static List<String> listaAtividades = new ArrayList<String>();
	public static Map<String, Digital> AtividadesConstruidas = new LinkedHashMap<String, Digital>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean addAtividadeLista() {
		if (listaAtividades.contains(this.name))
			return false;
		listaAtividades.add(this.name);
		return true;
	}

	public abstract void makeAtividade();

	public boolean addAtividadeConstruida(String nome, Digital dig) {
		if (AtividadesConstruidas.containsKey(this.name))
			return false;
		AtividadesConstruidas.put(this.name, dig);
		return true;
	}

	public boolean checkConflito(Digital dig1) {
		Iterator<Digital> it = AtividadesConstruidas.values().iterator();
		while (it.hasNext()) {
			Digital currentDigital = it.next();
			if(dig1.equals(currentDigital)){
				break;
			}
			else if (dig1.getHorarioInicio() == currentDigital.getHorarioInicio()) {
				return false;
			}
		}
		return true;

	}

}
