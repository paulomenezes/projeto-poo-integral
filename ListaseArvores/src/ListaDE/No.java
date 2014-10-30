package ListaDE;

public class No {

	private No prox, ant;
	private int valor;
	
	public No(int valor)
	{
		this.setValor(valor);
		this.setProx(null);
		this.setAnt(null);
	}
	
	public No getProx() {
		return prox;
	}
	public void setProx(No prox) {
		this.prox = prox;
	}
	public No getAnt() {
		return ant;
	}
	public void setAnt(No ant) {
		this.ant = ant;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
}
