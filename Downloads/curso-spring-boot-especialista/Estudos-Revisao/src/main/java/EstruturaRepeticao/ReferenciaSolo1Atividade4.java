package EstruturaRepeticao;

import java.util.Scanner;

public class ReferenciaSolo1Atividade4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int contador = 0 ; // Para exibir no final quantas vezes foi digitado
        int validador = 0 ;
        System.out.println("Digite valores entre 0 e 10: ");

        while (validador >= 0 && validador <= 10) {
            System.out.print("Insira o valor: ");
            validador = sc.nextInt();
            contador++;
        }

        System.out.println("Quantidade de vezes digitados: " + contador);
        System.out.println("Você saiu do Loop !");

        // Operação com Boolean

        boolean valorDigitado = false;

        while (!valorDigitado){
            System.out.println("Digite valores entre 0 e 10: ");
            int valorInserido = sc.nextInt();
            if (valorInserido >= 0 && valorInserido <= 10 ){
                System.out.println("Valor inserido com sucesso ! \n");
            }
            else {
                System.out.println("\nValor fora de 0 e 10 . Loop cancelado");
                valorDigitado = true;
            }
        }

        System.out.println("Próxima fase 3\n");

        while(true){
            System.out.println("Digite valores entre 0 e 10");
            int valorDigitado2 = sc.nextInt();

            if (valorDigitado2 >=0 && valorDigitado2 <= 10 ){
                System.out.println("Continue assim está dentro do loop !");
            }
            else {
                System.out.println("Valor fora do Loop!");
                break;
            }
        }




    }
}