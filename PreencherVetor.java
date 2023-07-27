import java.util.Scanner;

public class PreencherVetor {
    public static void main(String[] args) {
        int[] vetor = new int[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            try {
                System.out.print("Digite o valor a ser inserido: ");
                String valorDigitado = scanner.nextLine();
          
                int valor = Integer.parseInt(valorDigitado);
                System.out.print("Digite a posição (índice) no vetor (0 a 9): ");
                int posicao = Integer.parseInt(scanner.nextLine());

                if (posicao < 0 || posicao >= 10) {
                    System.out.println("Posição inexistente no vetor. Insira um valor entre 0 e 9.");
                } else {
                    vetor[posicao] = valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Valor informado não é um número inteiro válido.");
                i--; 
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Erro: Posição inexistente no vetor.");
                i--; 
            }
        }

     
        System.out.println("Vetor preenchido:");
        for (int valor : vetor) {
            System.out.print(valor + " ");
        }

        scanner.close();
    }
}
