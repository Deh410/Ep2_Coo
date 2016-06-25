package gerenciadores;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Calendar; 

public class Turma {
	
	private int ID;
	
	private String tipoDeAtividade;
	
	private String local;
	
	private int dataDeInicio;
	
	private int duracaoSemanas;

	private Horario horarios;

	private int quantidadeUsuarios;
    
    private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private List<DiaEMes> diasDeAtividade = new ArrayList<DiaEMes>();
	
	

	//SETTERS E GETTERS
	
	public int getDuracaoSemanas() {
		return duracaoSemanas;
	}

	public void setDuracaoSemanas(int duracaoSemanas) {
		this.duracaoSemanas = duracaoSemanas;
	}
	
	public int getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(int dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}
	
	public int getQuantidadeUsuarios() {
		return quantidadeUsuarios;
	}

	public void setQuantidadeUsuarios() {
		this.quantidadeUsuarios++;
	}

	public List<DiaEMes> getDiasDeAtividade() {
		return diasDeAtividade;
	}

	public void setDiasDeAtividade(DiaEMes dia) {
		diasDeAtividade.add(dia);
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTipoDeAtividade() {
		return tipoDeAtividade;
	}

	public void setTipoDeAtividade(String tipoDeAtividade) {
		this.tipoDeAtividade = tipoDeAtividade;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public Horario getHorarios() {
		return horarios;
	}

	public void setHorarios(Horario horarios) {
		this.horarios = horarios;
	}


}
