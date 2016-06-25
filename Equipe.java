package gerenciadores;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Calendar; 

public class Equipe {
	
	ArrayList<Usuario> integrantes = new ArrayList<Usuario> ();
    
    private int pontuacao = 0;
    
    private int id;
    
    String modalidade;
   
    
   public void adicionaIntegrante(Usuario usuario){//Sera passado como parametro o nome dos integrantes da equipe
   
    if(integrantes.contains(usuario) == true){ 
       
       System.out.println("Este usuário ja está na equipe");
       
   }else{
       integrantes.add(usuario);
    }
   
   
   }
   
   public int getPontuacao(){
	   return this.pontuacao;
   }
   
   
   public void adicionaPontuacao(int pontuacao){//Pontuação a ser adicionada e o numero da equipe
   	if(modalidade == "Quadra"){
   		pontuacao = pontuacao*2;
   	}
   	
       
       
       if(pontuacao<0){
           
       System.out.println("Pontuação invalida");
       return;
       
   }
       this.pontuacao = this.pontuacao + pontuacao;

   
   }

}
