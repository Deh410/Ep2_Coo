import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Calendar; 

public class Usuario {
	
	private String nome; // Cleber Menino
	
	private int id;
	
	private int pontuacao;
	
	private List<Turma> turmas = new ArrayList<Turma>();
	
	//---------------------------------------------------------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public List<Turma> getTurmas(){
		return this.turmas;
	}
	
	public boolean adicionaTurma(Turma turma){		//nao esqueça de adiocionar o usuario à turma; na main;
		if((checkDuasTurmasDia(turma)) && (checkHorario(turma))){
			turmas.add(turma);
			turma.setQuantidadeUsuarios();
			return true;
		}
		return false;
		}
	
	public boolean checkDuasTurmasDia(Turma turma){
		
		List<DiaEMes> datasAux;
		datasAux = turma.getDiasDeAtividade();
		for(DiaEMes o : datasAux){									//percorre os dias da turma que quero entrar
			int cont = 0;
			for(Turma t : turmas){									//percorre a lista das turmas que estou
				List<DiaEMes> datasAuxT;
				datasAuxT = t.getDiasDeAtividade();
				for(DiaEMes d : datasAuxT){							//percorre os dias de cada turma que ja estou
					if((o.dia == d.dia) && (o.mes == d.mes)){
						cont++;
					}
					if(cont>1){
						return false;
				}
				
				}
			}
			
		}
		return true;
		
		
	}
	
	public boolean checkHorario(Turma turma){
		int hIni = turma.getHorarios().gethInicio();
		int hFim = turma.getHorarios().gethFim();
		List<DiaEMes> datasAux;
		datasAux = turma.getDiasDeAtividade();
		for(DiaEMes o : datasAux){									//percorre os dias da turma que quero entrar
			for(Turma t : turmas){									//percorre a lista das turmas que estou
				Horario auxHorario = t.getHorarios();
				int auxHIni = auxHorario.gethInicio();
				int auxHFim = auxHorario.gethFim();
				List<DiaEMes> datasAuxT;
				datasAuxT = t.getDiasDeAtividade();
				for(DiaEMes d : datasAuxT){							//percorre os dias de cada turma que ja estou
					if((o.dia == d.dia) && (o.mes == d.mes) && ((hIni >= auxHIni) && (hIni < auxHFim) || (hFim > auxHIni) && (hFim < auxHFim))){
						return false;
				}
				
				}
			}
			
		}
		return true;
		
		
	}
}

