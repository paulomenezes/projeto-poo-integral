package ListaCircular;

public class IntNoCircular {

	private int valor;
	private IntNoCircular prox, ant;

	public IntNoCircular(int valor)
	{
		this.setValor(valor);
		this.setProx(null);
		this.setAnt(null);
	}
	
	public IntNoCircular getAnt() {
		return ant;
	}

	public void setAnt(IntNoCircular ant) {
		this.ant = ant;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public IntNoCircular getProx() {
		return prox;
	}
	public void setProx(IntNoCircular proximo) {
		this.prox = proximo;
	}
}