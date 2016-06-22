import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Calendar; 

public class Horario {
	
    private int hInicio;
    
    private int hFim;
    
    private String salaDeAtividade;
    

	public int gethInicio(){
        return hInicio;
    }
    
    public void sethInicio(int hInicio) {
        this.hInicio = hInicio;
    }

   
    public int gethFim() {
        return hFim;
    }

   
    public void sethFim(int hFim) {
        this.hFim = hFim;
    }

 
    public String getSalaDeAtividade() {
        return salaDeAtividade;
    }

  
    public void setSalaDeAtividade(String salaDeAtividade) {
        this.salaDeAtividade = salaDeAtividade;
    }

}
