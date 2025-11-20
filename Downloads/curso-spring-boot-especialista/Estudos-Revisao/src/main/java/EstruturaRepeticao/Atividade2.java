package EstruturaRepeticao;

import java.util.Scanner;

public class Atividade2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean valorValido = false;

        while (!valorValido){
            System.out.println("Digite um valor entre 0 e 10 para continuar o Loop: ");
            int valorDigitado = sc.nextInt();
            if(valorDigitado >= 0 && valorDigitado <= 10){
                System.out.println("Digite novamente para continuar o Loop !");

            }
            else {
                System.out.println("Valor inválido . Loop Encerrado !");
                valorValido = true;
            }
        }


        // While True

        while (true){
            System.out.println("Digite um valor entre 0 e 10 para continuar o Loop: ");
            int valorDigitado = sc.nextInt();
            if(valorDigitado < 0 || valorDigitado > 10){
                System.out.println("Valor fora do Loop ! Loop cancelado");
                break;
            }
            else {
                System.out.println("Valor dentro do Loop . Digite novamente !");
            }

        }

    }
}
