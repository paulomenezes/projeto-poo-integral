package ArvoreAvl;



public class L2Q2 {
	
	
	class No {

		No dir = null, esq = null, pai = null;
		int valorMaximo,valorAtualizar;
		int nivel = 1 ;

		public No(int valor) {
			this.valorMaximo = valor;
			this.valorAtualizar = valor;
		}
	
	}
	
	
	class Arvore {

		No raiz = null;
		String saida = "";


		//Busca nó
		public No busca(int chave) {

			No aux = raiz;

			while (aux != null && chave != aux.valorMaximo) {

				if (chave < aux.valorMaximo) {

					aux = aux.esq;

				} else {

					aux = aux.dir;
				}

			}

			return aux;
		}
		
		
		//INSERIR NO
		
		public void inserir(No no) {

			No aux = null;
			No aux2 = busca(no.valorMaximo);
            
			if(aux2== null){

				aux2 = raiz; 

				while (aux2 != null) {

					aux = aux2;

					if (no.valorMaximo < aux2.valorMaximo) {

						aux2 = aux2.esq;
					} else {

						aux2 = aux2.dir;
					}

				}

				no.pai = aux;

				if (aux == null) {

					raiz = no;

				} else if (no.valorMaximo < aux.valorMaximo) {

					aux.esq = no;

				} else {

					aux.dir = no;
				}
				
				if(no.pai!=null){
					
					no.nivel = no.pai.nivel+1;
				}
								    
			
			}else{

				System.out.println("Nó já existe.");;
			}
			
		}

		//MINIMO
		public No minimo(No no){	
			
			while(no.esq!=null){
			
				no = no.esq;
			  	
			}
			
			return no;
		}
		
		//ATUALIZAR VALOR
		public void atualizar(No no){
		
            
			if(no.esq!=null){
				
				atualizar(no.esq);
			}
			
			 no.valorAtualizar--;
			
			 if(no.valorAtualizar < 1){
			
				 if(no.dir!=null){

					 atualizar(no.dir);
				 }

				 if(no.esq!=null){

					 atualizar(no.esq);
				 }
				 
				 removerNo(no);
				 
			 }

			if(no.dir!=null){
				
				atualizar(no.dir);
			}
		}
		
		
		
		//SUCESSOR
		public No sucessor(No no){
			
			No aux;
			No aux2 = no;
			
			if(aux2.dir!= null){
				
				return minimo(aux2.dir);
			}
			
			aux = aux2.pai;
			
			while(aux!=null && aux2.valorMaximo == aux.dir.valorMaximo){
				
				aux2 = aux;
				aux = aux.pai;
			}
			
			return aux;
		
		}
		
		//Remover nó
		public No removerNo(No no){
			
			No aux;
			No aux2 = null;
			No aux3 = null;
			
			
			aux = busca(no.valorMaximo);
			
			if(aux == null){
				
				System.out.println("Elemento já existe.");
				aux2 = aux;
			
			//REMOÇÃO FOLHA	
				
			}else if(aux.dir == null && aux.esq == null){
				
				
				if(aux == this.raiz){
					
					this.raiz = null;
					
				}else{
				
				
				if(aux.pai.esq == aux){
					
					aux.pai.esq = null;
				
				}else{
					
					aux.pai.dir = null;
				}
				
				aux.pai = null;
				aux2 = aux;
				
				}
				
			//REMOÇÃO NÓ COM GRAU 1	
				
			}else if( (aux.esq!=null && aux.dir == null) || (aux.esq == null && aux.dir != null)){
				
				
				if(aux.pai == null){
					
					
					if(aux.dir!=null){
						
						this.raiz = aux.dir;
						aux.dir = null;
						
					}else{
						
						this.raiz = aux.esq;
						aux.esq = null;
					}
					
					
				}else{
				
				
				if(aux.pai.dir == aux){
					
					
					if(aux.dir != null){
						
						aux.pai.dir = aux.dir;
						aux.dir.pai = aux.pai;
						aux.dir = null;
						
				
					}else{
						
						aux.pai.dir = aux.esq;
						aux.esq.pai = aux.pai;
						aux.esq = null;
					}
					
			
				}else{
					
					
					if(aux.dir!= null){
						
						aux.pai.esq = aux.dir;
						aux.dir.pai = aux.pai;
						aux.dir = null;
						
					}else{
						
						aux.pai.esq = aux.esq;
						aux.esq.pai = aux.pai;
						aux.esq = null;
					}
					
				  }
				
				}
				
				aux2 = aux;
				
			  }else{
				  
				  aux2 = sucessor(aux);
					  	 
	                  aux3 = aux2;
					   
					  aux2.dir = aux.dir;
					  aux2.esq = aux.esq;
					  aux2.pai = aux.pai;
					  aux2.nivel = aux.nivel;
					  
					  
					  if(aux.pai == null){

						  this.raiz = aux2;
					  
					  }else{
						  
					  if(aux.pai.esq == aux){
						  
						  aux.pai.esq = aux2;
						  
					  }else{
						  
						  aux.pai.dir = aux2;
						  
					  }
					  
					  if(aux.pai==null){
						  
						  this.raiz = aux2;
					  }
					  
					  }
					  
					  aux.dir = null;
					  aux.esq = null;
					  aux.pai = null;
					  aux = null;
					  
					  removerNo(aux3);
				
   				 }
			

			  return aux2;
			  
			 }	 
			
		
		//IMPRIMIR ARVORE

		public void imprimir(No no) {


			if (no.esq != null) {

				imprimir(no.esq);
			}
            
			System.out.println(no.valorMaximo+"("+no.nivel+","+no.valorAtualizar+") ");
			
			
			if (no.dir != null) {

				imprimir(no.dir);
				
			}
		}

	}
	
	public static void main(String[]args){
		
		Arvore arvore= new L2Q2().new Arvore();
		
		arvore.inserir(new L2Q2(). new No(6));
		arvore.inserir(new L2Q2(). new No(9));
		arvore.inserir(new L2Q2(). new No(7));
		arvore.inserir(new L2Q2(). new No(8));
		arvore.inserir(new L2Q2(). new No(5));
		arvore.inserir(new L2Q2(). new No(4));
		
		No no, no2;
		
		no = arvore.busca(5);
		no2 = arvore.busca(4);
		
		no.pai.esq = no2;
		no.esq =null;
		
		arvore.imprimir(arvore.raiz);
		System.out.println(arvore.raiz.valorMaximo);

		
		
		
	}

  } 
	

