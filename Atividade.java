package gerenciadores;

import java.util.ArrayList;
import java.util.List;

public abstract class Atividade {
	private String name;
	public static List<String> listaAtividades = new ArrayList<String>();
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public boolean addAtividadeLista(){
		if(listaAtividades.contains(this.name)) return false;
		listaAtividades.add(this.name);
		return true;
	}
	public abstract void makeAtividade();
	
}
