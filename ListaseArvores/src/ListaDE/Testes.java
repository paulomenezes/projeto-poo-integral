package ListaDE;

public class Testes {

	public static void main(String[] args) {
		
		ListaDupla lista = new ListaDupla();
		
		lista.inserirFim(new No(20));
		lista.inserirFim(new No(19));
		
		lista.inserirInicio(new No(35));
		lista.inserirInicio(new No(40));
		
		System.out.println(lista.listarIF());
		
		lista.inserir(new No(45), 1);
		
		lista.removerFim();
		lista.removerInicio();
		
		System.out.println(lista.listarIF());
		
		lista.remover(1);
		
		System.out.println(lista.listarIF());
		
		System.out.println(lista.listarFI());
	}

}
