package EstruturaCondicional;

import java.util.Scanner;

public class Atividade1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a sua idade: ");

        int idade = sc.nextInt();

        if(idade < 16){
            System.out.println("Você não pode votar !");
        } else if (idade > 16 && idade < 18) {
            System.out.println("Voto opcional !");
        }
        else{
            System.out.println("Voto obrigatório");
        }

    }
    }
