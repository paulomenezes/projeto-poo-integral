package ListaDE;

public class ListaDupla {

	private No inicio, fim;

	private static int tamanho = 0;

	public ListaDupla()
	{
		inicio = fim = null;
	}


	public void inserirInicio(No no)
	{
		if(inicio == null) inicio = fim = no;
		else
		{
			inicio.setAnt(no);
			no.setProx(inicio);
			inicio = no;
		}

		tamanho++;
	}

	public void inserirFim(No no)
	{
		if(fim == null) fim = inicio = no;
		else
		{
			fim.setProx(no);
			no.setAnt(fim);
			fim = no;
		}

		tamanho++;
	}

	public void removerInicio()
	{
		if(this.inicio != null)
		{
			No temp = this.inicio.getProx();

			temp.setAnt(null);
			this.inicio.setProx(null);
			this.inicio.setAnt(null);
			this.inicio = temp;

			tamanho--;
		}
	}

	public void removerFim()
	{
		if(this.fim != null)
		{
			No temp = this.fim.getAnt();

			temp.setProx(null);
			this.fim.setProx(null);
			this.fim.setAnt(null);
			this.fim = temp;
//			this.inicio.setAnt(this.fim);//Isso se aplica para lista circular

			tamanho--;
		}
	}

	public void inserir(No novo, int posicao)
	{
		No temp = this.inicio;

		int pos = 0;

		while(temp != null)
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
		No temp = this.inicio;

		int pos = 0;

		while(temp != null)
		{
			if(posicao == 0)
				this.removerInicio();
			else if(posicao == tamanho)
				this.removerFim();
			else if(posicao == pos)
			{
				temp.getProx().setAnt(temp.getAnt());
				temp.getAnt().setProx(temp.getProx());
				temp.setProx(null);
				temp.setAnt(null);
				
				tamanho--;
			}

			temp = temp.getProx();
			pos++;
		}
	}

	public String listarIF()
	{
		No temp = this.inicio;

		String result = " ";

		while(temp != null)
		{
			result += temp.getValor() + " ";

			temp = temp.getProx();
		}

		return result;
	}

	public String listarFI()
	{
		No temp = this.fim;

		String result = " ";

		while(temp != null)
		{
			result += temp.getValor() + " ";

			temp = temp.getAnt();
		}

		return result;
	}
}
