import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Calendar; 

public class Dia {
	
	private List<Turma> turmasInscritas = new ArrayList<Turma>();

	private List<Horario> horariosInscritos = new ArrayList<Horario>();
	
        //Checa se horario é valido e adiciona na lista de horarios e a turma na lista de turmas.
        
       public boolean setHorario(int hInicio, int hFim, String salaDeAtividade, Turma turma){
            if(hFim - hInicio < 2){                                                 //tem mais de 2h
                return false;
            }
            int cont = 0;
            for(Horario o : getHorariosInscritos()){
            	
                int auxInicio = o.gethInicio();
                int auxFim = o.gethFim();
                String auxSala = o.getSalaDeAtividade();
                
                
                if(((auxInicio > hInicio) && (auxInicio < hFim)) || ((auxFim > hInicio) && (auxFim < hFim)) || ((auxInicio == hInicio) && (auxFim == hFim))){
                    if(salaDeAtividade.equals(auxSala)){
                        cont++;
                        
                        
                    }
                }
                        
            }
            
          
            if(cont >= 2){
            	
                return false;
            }
            else{
                Horario horario = new Horario();
                horario.sethInicio(hInicio);
                horario.sethFim(hFim);
                horario.setSalaDeAtividade(salaDeAtividade);
                horariosInscritos.add(horario);
                turma.setHorarios(horario);
                setTurmasInscritas(turma);
               
                return true;
            }   
        }
        
      
        
        
        
        
        
	
	public List<Turma> getTurmasInscritas() {
		return turmasInscritas;
	}

	public void setTurmasInscritas(Turma turma) {
		this.turmasInscritas.add(turma);
	}
	
	public int sizeOfTurmaList(){
		System.out.println(this.turmasInscritas.size());
		return this.turmasInscritas.size();
	}
	
	public void getByIndex(int index){
		System.out.println(this.turmasInscritas.get(index));
	}

    /**
     * @return the horariosInscritos
     */
    public List<Horario> getHorariosInscritos() {
        return horariosInscritos;
    }

    
    public void setHorariosInscritos(List<Horario> horariosInscritos) {
        this.horariosInscritos = horariosInscritos;
    }

}
