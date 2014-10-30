package ArvoreAvl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L2Q1{

	
	class No {

		No dir = null, esq = null, pai = null;
		int valor;
		int h = 1 ,hEsq = 0, hDir = 0 , fb = 0 ;

		public No(int valor) {
			this.valor = valor;
		}

	}
	
	class Arvore {

		No raiz = null;
		String saida = "";

		
       //Calcular Fator de Balanceamento
		
		public No calcularFb(No no){
			
			if(no.dir!=null){
				
			   no.hDir = no.dir.h;
				
			}else{
				
				no.hDir = 0;
			}
			
			if(no.esq!=null){
				
				no.hEsq = no.esq.h;
			}else{
				
				no.hEsq = 0;
			}
			
			no.fb = no.hDir - no.hEsq;
			no.h = Math.max(no.hDir, no.hEsq)+1;
		   
			return no;
		}
		
		
		
		//Rotação Direita
		
		public No rotacaoDir(No no){
			
			No aux = no.esq;
			no.esq = aux.dir;
			
			if(no.esq!= null){
				
				no.esq.pai = no;
				
			}
			
			aux.dir = no;
			aux.pai = no.pai;
			no.pai = aux;
			
			 calcularFb(no);
			 calcularFb(aux);
			
			if(aux.pai!=null){
				
				if(aux.valor < aux.pai.valor){
					
					aux.pai.esq = aux; 
				}else{
					
					aux.pai.dir = aux;
				}
				
			}else{
				
				raiz = aux;
			}
			
			return aux;
		}
		
		//Rotação Esquerda
		
		public No rotacaoEsquerda(No no){
			
			No aux = no.dir;
			no.dir = aux.esq;
			
			if(no.dir!= null){
				
				no.dir.pai = no;
			}
			
			aux.esq = no;
			aux.pai = no.pai;
			no.pai = aux;
			
			 calcularFb(no);
			 calcularFb(aux);
			
			if(aux.pai!=null){
				
				if(aux.valor > aux.pai.valor){
					
					aux.pai.dir = aux;
					
				}else{
					
					aux.pai.esq = aux;
				}
			
			}else{
				
				raiz = aux;
			}
			
			return aux;
		}
		
		
		// Busca na Arvore 
		
		public No busca(int chave) {

			No aux = raiz;

			while (aux != null && chave != aux.valor) {

				if (chave < aux.valor) {

					aux = aux.esq;

				} else {

					aux = aux.dir;
				}

			}

			return aux;
		}
		
		
		//Verificar Balanceamento
		
		public No verificarFb(No no){
			
			No aux;
			
			if(no == null){
				
				return null;
			
			}else{
				
			   calcularFb(no);	
			}
			
			if(no.fb < -1 || no.fb > 1){
				
				saida += "no responsavel: "+no.valor+"\n";
				aux = no.pai;
				
				while(aux!=null){
					
					calcularFb(aux);
					
					aux = aux.pai;
				}
				
				imprimir(this.raiz);
				saida += "\n";
				return no;
			
			}else{
				
				return verificarFb(no.pai);
			}
			
		
		}
		
		
		//Inserir na Arvores AVL
		
		public No inserir(No no) {

			No aux = null;
			No aux2 = busca(no.valor);


			if(aux2== null){

				aux2 = raiz; 

				while (aux2 != null) {

					aux = aux2;

					if (no.valor < aux2.valor) {

						aux2 = aux2.esq;
					} else {

						aux2 = aux2.dir;
					}

				}

				no.pai = aux;

				if (aux == null) {

					raiz = no;

				} else if (no.valor < aux.valor) {

					aux.esq = no;

				} else {

					aux.dir = no;
				}
								    
				
			}else{

				no = null;
			}
			
			return no;
		}
         
		
		public void inserirAvl(No no){
		
			
		No aux2 = inserir(no);	
		
		if(aux2!=null){
			
		No aux = verificarFb(aux2.pai); 
		
        if(aux == null){
        	
        	saida+= "arvore ja balanceada.\n";
        	imprimir(this.raiz);
            saida+="\n"+raiz.h+"\n"; 
        	
        }else{
        	
			if(aux.fb == 2){
				if(aux.dir.fb == -1){
					
					 rotacaoDir(aux.dir);
					 saida+= "rotacao esquerda dupla.\n";
					 
				}else{
					
					saida+="rotacao esquerda.\n";
				}
				
				aux = rotacaoEsquerda(aux);
				
			}
			
			if(aux.fb == -2){
				if(aux.esq.fb == 1){
					
					 rotacaoEsquerda(aux.esq);
					 saida += "rotacao direita dupla.\n";
				}else{
					
					saida+= "rotacao direita.\n";
				}
				
				aux = rotacaoDir(aux);
				
			}
			
			verificarFb(aux.pai);
			imprimir(this.raiz);
			saida+="\n"+ raiz.h+ "\n";
		
		  }
        
		}
        
       }
	
		public void imprimir(No no) {

			
			if (no.esq != null) {

				imprimir(no.esq);
			}
			
			saida += no.valor;
			
			if(no.fb>0){
			saida += "(+"+no.fb+") " ; 
			}else{
				
			saida+=	"("+no.fb+") ";
			}
			
			if (no.dir != null) {

				imprimir(no.dir);
			}
		}
		
	}


	 public static void main(String[] args) {

         try {
        	
        	String linha[];
        	File a = new File ("L2Q1.in");
        	File b = new File ("L2Q1.out");
			BufferedReader r = new BufferedReader(new FileReader(a));
			BufferedWriter w = new BufferedWriter(new FileWriter(b,true));
			Arvore arvore;
			String texto = "";

			
			while(r.ready()){
				
			linha = r.readLine().split(" ");	
			arvore = new L2Q1().new Arvore();
			
			for(int i=0;i<linha.length;i++){
				
			    
			    arvore.inserirAvl(new L2Q1(). new No(Integer.parseInt(linha[i])));
			    
				
			}
			
			texto += arvore.saida+"\n";


		}
				
			w.write(texto);
			w.flush();
			
			r.close();
			w.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	    
		}
	}




