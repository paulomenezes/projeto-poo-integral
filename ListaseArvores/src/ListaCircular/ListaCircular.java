package ListaCircular;

public class ListaCircular {

	private IntNoCircular inicio, fim;

	private static int tamanho = 0;

	public ListaCircular()
	{
		inicio = fim = null;
	}

	public void inserirInicio(IntNoCircular novo) 
	{
		if(inicio == null)
		{
			fim = inicio = novo;
			fim.setProx(inicio);
			inicio.setAnt(fim);
		}
		else
		{
			novo.setProx(inicio);
			novo.setAnt(fim);
			inicio.setAnt(novo);
			fim.setProx(novo);
			inicio = novo;
		}

		tamanho++;
	}

	public void inserirFim(IntNoCircular novo)
	{
		if(fim == null)
		{
			fim = inicio = novo;
			novo.setProx(inicio);
			this.inicio.setAnt(novo);
		}
		else
		{
			fim.setProx(novo);
			novo.setAnt(fim);
			novo.setProx(inicio);
			fim = novo;
			inicio.setAnt(fim);
		}

		tamanho++;
	}

	public void removerFim()
	{

		if (this.fim != null) 
		{
			IntNoCircular temp = this.fim.getAnt();

			temp.setProx(inicio);
			this.fim.setProx(null);
			this.fim.setAnt(null);
			this.fim = temp;
			this.inicio.setAnt(this.fim);

			tamanho--;
		}

	}

	public void removerInicio()
	{
		if(this.inicio != null)
		{
			IntNoCircular temp = this.inicio.getProx();

			temp.setAnt(fim);
			this.inicio.setProx(null);
			this.inicio.setAnt(null);
			this.inicio = temp;
			this.fim.setProx(inicio);

			tamanho--;
		}

	}

	public void inserir(IntNoCircular novo, int posicao) 
	{
		IntNoCircular temp = this.inicio;

		int pos = 0;

		while(temp.getProx() != inicio)
		{
			if(posicao == 0)
				this.inserirInicio(novo);
			else if(posicao == tamanho)
				this.inserirFim(novo);
			else if(posicao == pos)
			{
				novo.setProx(temp);
				temp.getAnt().setProx(novo);
				novo.setAnt(temp.getAnt());
				temp.setAnt(novo);

				tamanho++;
			}

			temp = temp.getProx();
			pos++;
		}
	}

	public void remover(int posicao)
	{
		IntNoCircular temp = this.inicio;

		int pos = 0;

		while(pos < tamanho)
		{
			if(posicao == 0)
				this.removerInicio();
			else if(posicao == tamanho)
				this.removerFim();
			else if(posicao == pos)
			{
				temp.getProx().setAnt(temp.getAnt());
				temp.getAnt().setProx(temp.getProx());
				temp = null;

				tamanho--;
				
				break;
			}

			temp = temp.getProx();
			pos++;
		}
	}

	public String listar()
	{
		String result = " ";

		IntNoCircular temp = inicio;

		if(inicio != null)
		{
			do
			{
				result += temp.getValor() + " ";
				temp = temp.getProx();
			}
			while(temp != inicio);
		}

		return result;
	}
}
