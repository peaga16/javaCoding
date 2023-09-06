package Exercicio2;

public class CarroTeste {

	public static void main(String[] args) {
		
		Vetor2 vetor = new Vetor2(50);

		System.out.println(vetor);
		vetor.adicionar(new Carro("Fiat","FastBack" , 2023, 120000));
		System.out.println(vetor);
		vetor.adicionar(new Carro("Chevrolet","Onix" , 2023, 87000));
		System.out.println(vetor);
		vetor.adicionar(new Carro("Chevrolet","Celta" , 2006, 25000));
		System.out.println(vetor);

		System.out.println(vetor.tamanho());
		System.out.println(vetor.limite());

		System.out.println(vetor.obter(0));
		System.out.println(vetor.obter(1));
		System.out.println(vetor.obter(2));

		System.out.println(vetor);
		vetor.adicionar(0, new Carro("Fiat","Argo", 2023, 62000));
		System.out.println(vetor);
		vetor.adicionar(4, new Carro("Wolksvagen","Golf GTI", 2023, 120000));
		System.out.println(vetor);
		vetor.adicionar(2, new Carro("Lamborghini","Urus", 2023, 2999000));
		System.out.println(vetor);

		System.out.println(vetor.contains(new Carro("Chevrolet","Celta" , 2006, 25000)));
		System.out.println(vetor.contains(new Carro("RAM","3500 Exclusive",2022,340000)));

		vetor.remover(5);
		System.out.println(vetor);
		vetor.remover(0);
		System.out.println(vetor);
		vetor.remover(1);
		System.out.println(vetor);

		System.out.println(vetor.tamanho());
		System.out.println(vetor.limite());
	}

}
