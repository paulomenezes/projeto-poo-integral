package ListaSE;

public class Testes 
{
	public static void main(String[] args)
	{
		ListaSimples l = new ListaSimples();
		
		l.inserirFim(new No(19));
		l.inserirFim(new No(20));
		
		l.inserirInicio(new No(21));
		l.inserirInicio(new No(18));
		
//		l.inserir(new No(35), 2);
		
		System.out.println(l.listar());
		
		l.remover(2);
		
		System.out.println(l.listar());
		
		l.inserirFim(new No(40));
		
		System.out.println(l.listar());
	}
}
