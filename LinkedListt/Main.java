package LinkedListt;

public class Main {

	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();

		lista.adicionarNoComeco("Estrogonoffe");
		lista.adicionarNoComeco("Pedro");

		lista.removerDoComeco();
		lista.removerDoComeco();
		System.out.println(lista.toString());
	}
}
