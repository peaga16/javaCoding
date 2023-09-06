package Exercicio2;

public class Vetor2 {

	private Carro[] carros;
	private int contadordeCarros = 0;

	public Vetor2(int tamanho) {
		carros = new Carro[tamanho];
	}

	public void adicionar(Carro obj) {
		carros[contadordeCarros] = obj;
		contadordeCarros++;
	}

	public void adicionar(int posicao, Carro obj) {
		if (!posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Invalida!");
		}
		for (int i = contadordeCarros - 1; i >= posicao; i -= 1) {
			carros[i + 1] = carros[i];
			carros[posicao] = obj;
			contadordeCarros++;
		}
	}

	public boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= contadordeCarros;
	}

	public Carro obter(int posicao) {
		if (!posicaoOcupada(posicao))
			throw new IllegalArgumentException("Posicao Invalida!");
		return carros[posicao];
	}

	public boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < contadordeCarros;
	}

	public void remover(int posicao) {
		if (!posicaoOcupada(posicao))
			throw new IllegalArgumentException("Posicao Invalida!");
		for (int i = posicao; i < contadordeCarros - 1; i++)
			carros[i] = carros[i + 1];
		contadordeCarros--;
	}

	public boolean contains(Carro obj) {
		for (int i = 0; i < contadordeCarros; i++) {
			if (obj.equals(carros[i]))
				return true;
		}
		return false;
	}

	public int tamanho() {
		return contadordeCarros;
	}

	public int limite() {
		return carros.length;
	}

	public String toString() {
		if (contadordeCarros == 0)
			return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < contadordeCarros - 1; i++)
			sb.append(carros[i] + ", ");
		sb.append(carros[contadordeCarros - 1] + "]");
		return sb.toString();

	}
}
