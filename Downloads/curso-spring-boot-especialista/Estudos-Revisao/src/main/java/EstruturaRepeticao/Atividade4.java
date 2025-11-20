package EstruturaRepeticao;

import java.util.Scanner;

public class Atividade4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int digito = 0;      // variável usada na condição do while
        int contador = 0;

        // O WHILE roda enquanto o número estiver entre 0 e 10
        while (digito >= 0 && digito <= 10) {
            System.out.println("Digite um valor entre 0 e 10: ");
            digito = sc.nextInt();

            if (digito >= 0 && digito <= 10) {
                System.out.println("Valor correto! Digite novamente.");
                contador++;
            }
        }

        // Quando sai do WHILE, significa que digitou valor inválido
        System.out.println("Valor fora do intervalo! Loop encerrado.");
        System.out.println("Quantidade de valores corretos digitados: " + contador);
    }
}
