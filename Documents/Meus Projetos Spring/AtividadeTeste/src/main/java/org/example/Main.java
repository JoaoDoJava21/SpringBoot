package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner sc = new Scanner(System.in);

        ArrayList<Cadastro> cadastros = new ArrayList<>();
        int opcao = 3;

        for (int i = 0 ; i < opcao; i++){
            System.out.println("Digite a sua idade " + (i+1) + " : ");
            int idade = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite o seu nome " + (i+1) + " : ");
            String nome = sc.next();

            System.out.println("Digite a sua nota " + (i+1) + " : ");
            double nota = sc.nextDouble();

            cadastros.add(new Cadastro(idade,nome,nota));
        }

        System.out.println("\n--- Alunos cadastrados ---");
        for(Cadastro c : cadastros){
            System.out.println(c.mediaNotas());
        }

        // Calcula média das notas

        double soma = 0;
        for(Cadastro c : cadastros){
            soma+= c.getNota();
        }
        double media = soma / cadastros.size();

        System.out.printf("\n  Média das notas: -> %.2f \n " , media);

        sc.close();
    }
}