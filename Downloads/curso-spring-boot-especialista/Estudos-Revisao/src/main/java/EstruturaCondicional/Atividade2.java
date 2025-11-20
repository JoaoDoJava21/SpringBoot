package EstruturaCondicional;

import java.util.Scanner;

public class Atividade2 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        System.out.println("Digite o seu número 1: ");

        int numero = sc.nextInt();

        System.out.println("Digite o seu número: ");

        int numero2 = sc.nextInt();

        if(numero > numero2){
            System.out.println("Seu primeiro número 1 é maior que o 2 !");
        }
        else {
            System.out.println("Seu número 2 é maior que o primeiro !");
        }
    }
}
