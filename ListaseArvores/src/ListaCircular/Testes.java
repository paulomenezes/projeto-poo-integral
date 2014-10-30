package ListaCircular;

public final class Testes {

	public static void main(String[] args) {
	
		ListaCircular lista = new ListaCircular();
		
		lista.inserirFim(new IntNoCircular(30));
		lista.inserirFim(new IntNoCircular(34));
		lista.inserirFim(new IntNoCircular(20));
		
		lista.inserirInicio(new IntNoCircular(25));
		
		lista.remover(1);
		lista.inserir(new IntNoCircular(70), 1);
		
		lista.removerFim();
		lista.removerInicio();
		
		System.out.println(lista.listar());

	}

}
