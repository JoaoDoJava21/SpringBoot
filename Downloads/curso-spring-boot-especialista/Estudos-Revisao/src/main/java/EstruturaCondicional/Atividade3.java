package EstruturaCondicional;

import java.util.Scanner;

public class Atividade3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a sua nota 1 : ");
        int nota1 = sc.nextInt();

        System.out.println("Digite a sua nota 2 : ");
        int nota2 = sc.nextInt();

        System.out.println("Digite a sua nota 3 : ");
        int nota3 = sc.nextInt();

        int media = (nota1 + nota2 + nota3) / 3;

        if (media >= 7){
            System.out.println("Você foi aprovado !");
        }

        else if (media > 5 ) {
            System.out.println("Você está de recuperação");
        }

        else {
            System.out.println("Você foi reprovado");
        }

    }
}
