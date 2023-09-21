package LinkedListt;

public class ListaEncadeada {
	private Celula primeira, ultima;
	private int totalDeElementos;

	public void adicionarComeco(Object elemento) {
		Celula nova = new Celula(primeira, elemento,null);
		this.primeira = nova;
		if (totalDeElementos == 0)
			ultima = primeira;
		else
			primeira.getProxima().setAnterior(primeira);
		totalDeElementos++;
	}


	public void adicionar(Object elemento) {
		if (totalDeElementos == 0) {
			adicionarNoComeco(elemento);
		} else {
			Celula nova = new Celula(null, elemento, ultima);
			ultima.setProxima(nova);
			ultima = nova;
			totalDeElementos++;
		}
	}

	public void adicionar(int posicao, Object elemento) {
		if (posicao < 0 || posicao > totalDeElementos) {
			throw new IllegalArgumentException("Posicao não existe");
		}

		if (posicao == 0) {
			adicionarNoComeco(elemento);
		} else if (posicao == totalDeElementos) {
			adicionar(elemento);
		} else {
			Celula anterior = retornarCelula(posicao - 1);
			Celula nova = new Celula(anterior.getProxima(), elemento, anterior);
			anterior.setProxima(nova);
			totalDeElementos++;
		}
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < totalDeElementos;
	}

	public void removerDoComeco() {
		if (!posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posicao não existe");
		}

		primeira = primeira.getProxima();
		totalDeElementos--;

		if (totalDeElementos == 0) {
			ultima = null;
		}
	}

	public void removerDoFim() {
		if (!posicaoOcupada(totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posicao não existe");
		}

		if (totalDeElementos == 1) {
			primeira = ultima = null;
		} else {
			Celula penultima = retornarCelula(totalDeElementos - 2);
			penultima.setProxima(null);
			ultima = penultima;
		}

		totalDeElementos--;
	}

	public void remover(int posicao) {
    	if(!this.posicaoOcupada(posicao)) {
    		throw new IllegalArgumentException("Posicao não existe");
    	}
    	if (posicao == 0) {
    			this.removerDoComeco();

    	} else if (posicao == this.totalDeElementos - 1) {
    			this.removerDoFim();

    	} else {
    			Celula anterior = this.retornarCelula(posicao - 1);
    			Celula atual = anterior.getProxima();
    			Celula proxima = atual .getProxima();
    			anterior.setProxima(proxima);
    			proxima.setAnterior(anterior);
    			this.totalDeElementos--;
    	}

    }

	public Object retornarElemento(int posicao) {
		return retornarCelula(posicao).getElemento();
	}

	private Celula retornarCelula(int posicao) {
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao não existe");
		}

		Celula atual = primeira;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProxima();
		}

		return atual;
	}

	public String toString() {
		if (totalDeElementos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		Celula atual = primeira;
		while (atual != null) {
			builder.append(atual.getElemento());
			if (atual.getProxima() != null) {
				builder.append(", ");
			}
			atual = atual.getProxima();
		}
		builder.append("]");
		return builder.toString();
	}
}
