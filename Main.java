import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Calendar; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Calendar; 

public class Main {
	
 
	public boolean matricularTurma(Agenda agenda, Map<Integer, Mes> calendarioAno, Mes meses, int diaI, Turma novaTurma, int[] diasSemana, int duracao, int hInicio, int hFim, int mes){
		
		int turmaID = agenda.getNrTurmas() + 1;
		agenda.setNrTurmas(turmaID);
		
		
		
		novaTurma.setID(turmaID);
		
		
		novaTurma.setTipoDeAtividade("ANALOGICOS");
		
		if(novaTurma.getTipoDeAtividade().equals("FISICOS")){
			novaTurma.setLocal("QUADRA");
		} else {
			novaTurma.setLocal("SALA DE ATIVIDADES");
		}
		
                novaTurma.setDataDeInicio(diaI);
                
                novaTurma.setDuracaoSemanas(duracao);
                
                String salaAt = novaTurma.getLocal();
                
                for(int i = 0 ; i < diasSemana.length ; i++){
                	
                adicionaTurmaNosDias(i, novaTurma, duracao, diaI, mes, diasSemana, calendarioAno, hInicio, hFim, salaAt);
                	
                }
                return true;
	}
	
	   public boolean adicionaTurmaNosDias(int i ,Turma turma, int duracaoSemanas, int dia, int mes, int[] diasSemana, Map<Integer, Mes> calendarioAno,int hInicio, int hFim, String salaDeAtividades){
           if(i != 0){
               dia = dia + (diasSemana[i] - diasSemana[i-1]);
               
           }
           int diaant;
           Calendar c = Calendar.getInstance();
            c.set(Calendar.MONTH , mes);
            c.set(Calendar.DAY_OF_MONTH, dia);
           boolean aux = false;
               for(int j = duracaoSemanas ; j > 0 ; j--){
                       DiaEMes data = new DiaEMes(dia, mes);
                        
                       switch(mes){
                   case 1 : 
                       aux = calendarioAno.get(2015).janeiro.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);
                       break;
                   case 2 : 
                       
                       aux =calendarioAno.get(2015).fevereiro.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);
                       break;
                   case 3 : 
               
                       aux =calendarioAno.get(2015).marco.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);
                       break;
                   case 4 : 
                       aux =calendarioAno.get(2015).abril.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);
                       break;
                   case 5 : 
                       aux =calendarioAno.get(2015).maio.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);    
                       break;
                   case 6 : 
                       aux =calendarioAno.get(2015).junho.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);
                       break;
                   case 7 : 
                       aux =calendarioAno.get(2015).julho.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);
                       break;
                   case 8 : 
                       aux =calendarioAno.get(2015).agosto.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);
                       break;
                   case 9 : 
                       aux =calendarioAno.get(2015).setembro.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);
                       break;
                   case 10 : 
                       aux =calendarioAno.get(2015).outubro.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);
                       break;
                   case 11 : 
                       aux =calendarioAno.get(2015).novembro.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);
                       break;
                   case 12 : 
                       aux =calendarioAno.get(2015).dezembro.get(dia).setHorario(hInicio, hFim, salaDeAtividades, turma);
                       break;
                       }
                       
                 if(aux == false){
                     
                     return false;
                 }     
                 turma.setDiasDeAtividade(data);
                 
                diaant = dia;
                 
                 mes = c.get(Calendar.MONTH);
                 
                 c.add(Calendar.DAY_OF_MONTH, 7);
                 dia = c.get(Calendar.DAY_OF_MONTH);
                  
                 if(diaant > dia){
                     mes = mes+1;
                 }
                  
                  
       }
       return true;
}
	
	
	
	
	
        
   public boolean matriculaAluno(String nome, Turma turma, Agenda agenda, Usuario usuario){
	   usuario.setNome(nome);
	   boolean aux = usuario.adicionaTurma(turma);
	   if(aux == false){
		   return false;
	   }
	  
	   agenda.setNrUsuarios(agenda.getNrUsuarios() + 1);
	   usuario.setId(agenda.getNrUsuarios());
	   agenda.setUsuarios(usuario);
	   return true;
	   
   }
         
        
	public void inicializarCalendario(Mes meses, Map<Integer, Mes> calendarioAno){  //--------OK
		
		calendarioAno.put(2015, meses);
		
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.janeiro.put(i, diaStart);
		}
		
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.fevereiro.put(i, diaStart);
		}
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.marco.put(i, diaStart);
		}
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.abril.put(i, diaStart);
		}
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.maio.put(i, diaStart);
		}
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.junho.put(i, diaStart);
		}
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.julho.put(i, diaStart);
		}
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.agosto.put(i, diaStart);
		}
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.setembro.put(i, diaStart);
		}
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.outubro.put(i, diaStart);
		}
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.novembro.put(i, diaStart);
		}
		for(int i = 1; i < 32; i++){
			Dia diaStart = new Dia();
			meses.dezembro.put(i, diaStart);
		}
		
		
	}
	
	public static void imprimeCalendario(int mes,Map<Integer, Mes> calendarioAno ){ // ------ ok
		List<Horario> aux = new ArrayList<Horario>();
		for(int i = 0; i<= 30; i++){
			aux.add(null);
		}
		for (int i = 1; i<32; i++){
			List <Horario> horarios; 
			
		 switch(mes){
         case 1 : 
        	 horarios = calendarioAno.get(2015).janeiro.get(i).getHorariosInscritos();
        	 for(Horario h : horarios){
        		 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na " + h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }
             break;
             
         case 2 : 
             
             horarios = calendarioAno.get(2015).fevereiro.get(i).getHorariosInscritos();
             
             for(Horario h : horarios){
            	 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na " + h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }
             
             break;
         case 3 : 
             
             horarios = calendarioAno.get(2015).marco.get(i).getHorariosInscritos();
             
             for(Horario h : horarios){
            	 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na " + h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }             
             break;
             
         case 4 : 
             horarios = calendarioAno.get(2015).abril.get(i).getHorariosInscritos();
             for(Horario h : horarios){
            	 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na "+ h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }
             
             break;
         case 5 : 
             horarios = calendarioAno.get(2015).maio.get(i).getHorariosInscritos();
             for(Horario h : horarios){
            	 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na "+ h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }
             break;
             
         case 6 : 
             horarios = calendarioAno.get(2015).junho.get(i).getHorariosInscritos();
             for(Horario h : horarios){
            	 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na "+ h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }
             break;
             
         case 7 : 
             horarios = calendarioAno.get(2015).julho.get(i).getHorariosInscritos();
             for(Horario h : horarios){
            	 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na " + h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }
             break;
             
         case 8 : 
             horarios = calendarioAno.get(2015).agosto.get(i).getHorariosInscritos();
             for(Horario h : horarios){
            	 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na " + h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }
             break;
             
         case 9 : 
             horarios = calendarioAno.get(2015).setembro.get(i).getHorariosInscritos();
             for(Horario h : horarios){
            	 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na " + h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }
             break;
             
         case 10 : 
             horarios = calendarioAno.get(2015).outubro.get(i).getHorariosInscritos();
             for(Horario h : horarios){
            	 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na " + h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }
             break;
             
         case 11 : 
             horarios = calendarioAno.get(2015).novembro.get(i).getHorariosInscritos();
             for(Horario h : horarios){
            	 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na " + h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }
             break;
             
         case 12 : 
             horarios = calendarioAno.get(2015).dezembro.get(i).getHorariosInscritos();
             for(Horario h : horarios){
            	 aux.add(h.gethInicio(), h);
        		 System.out.println("No dia: "+ i + "/" + mes + " na " + h.getSalaDeAtividade() + " das " + h.gethInicio() + " ate " + h.gethFim() );
        		 
        	 }
             break;
		 }
		 for(int j = 8; j<= 22; j++){
				if(aux.get(j) == null){
					System.out.println("No dia: "+ i + "/" + mes + " o horario " + j + " esta vago ");
				}
				else{
					j = aux.get(j).gethFim();
				}
		}
		
		}
		
	}
	
	public Usuario achaORei(List<Usuario> usuarios){
		int maxPontos = 0;
		Usuario campeao = null;
		for(Usuario o : usuarios){
			if(o.getPontuacao() > maxPontos){
				maxPontos = o.getPontuacao();
				campeao = o;
			}
		}
		return campeao;
	}
	
	public Equipe achaAEquipeRei(List<Equipe> equipes){
		int maxPontos = 0;
		Equipe equipeCampea = null;
		for(Equipe o : equipes){
			if(o.getPontuacao() > maxPontos){
				maxPontos = o.getPontuacao();
				equipeCampea = o;
			}
		}
		return equipeCampea;
	}
	
	
	
}