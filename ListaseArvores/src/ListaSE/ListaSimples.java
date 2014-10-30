package ListaSE;

public class ListaSimples {

	private No inicio, fim;

	public ListaSimples()
	{
		this.inicio = this.fim = null;
	}

	public void inserirFim(No novo)
	{
		if (this.fim == null && this.inicio == null) this.inicio = this.fim = novo; 
		else
		{
			this.fim.setProx(novo);
			this.fim = novo;
		}
	}

	public void inserirInicio(No novo)
	{
		novo.setProx(this.inicio);
		this.inicio = novo;
	}

	public void removerInicio()
	{
		if(this.inicio != null)
		{
			No temp = this.inicio.getProx();

			this.inicio.setProx(null);
			this.inicio = temp;
		}
	}

	public void removerFim()
	{
		if(this.fim != null)
		{
			No temp = this.inicio;

			while(temp != null)
			{
				if(temp.getProx() == this.fim)
				{
					temp.setProx(null);
					this.fim = temp;
				}

				temp  = temp.getProx();
			}
		}
	}

	public void inserir(No novo, int posicao)
	{	
		No temp = this.inicio;

		int pos = 0;

		while(temp != null)
		{
			if(posicao == pos)
			{
				if(temp == this.inicio)
					this.inserirInicio(novo);
				else if(temp == this.fim)
					this.inserirFim(novo);
			}
			else if(posicao == pos + 1)
			{
				novo.setProx(temp.getProx());
				temp.setProx(novo);
				break;
			}

			temp = temp.getProx();
			pos++;
		}
	}

	public void remover(int posicao)
	{
		No temp = this.inicio;

		int p = 0;

		while(temp != null)
		{
			if(p == posicao)
			{
				if(temp == this.inicio)
					removerInicio();
				else if(temp == this.fim)
					removerFim();
			}
			else if(posicao == p + 1)
			{
				No noDel = temp.getProx().getProx();
				temp.getProx().setProx(null);
				temp.setProx(noDel);
				noDel = null;
				break;
			}

			temp = temp.getProx();
			p++;
		}
	}

	public String listar()
	{
		String result = " ";

		No temp = this.inicio;

		while(temp != null)
		{
			result += " "+ temp.getValor();

			temp = temp.getProx();
		}

		return result;
	}

	public No getInicio() {
		return inicio;
	}

	public No getFim() {
		return fim;
	}
}