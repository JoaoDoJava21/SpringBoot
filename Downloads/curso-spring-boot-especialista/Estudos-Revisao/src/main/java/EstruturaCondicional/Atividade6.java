package EstruturaCondicional;

import java.util.Scanner;

public class Atividade6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        // Entrada de dados

        System.out.print("Digite o seu salário bruto: ");
        double salarioBruto = sc.nextDouble();

        System.out.print("Digite o percentual de ajuste a ser aplicado: ");
        double percentualReajuste = sc.nextDouble();

        System.out.print("Digite o percentual de desconto de impostos: ");
        double percentualDesconto = sc.nextDouble();


        // Cálculos aritméticos

        double valorDoAumento = salarioBruto * percentualReajuste;

        double novoSalarioBruto = salarioBruto + valorDoAumento;

        double valorDesconto = novoSalarioBruto * percentualDesconto;

        double salarioLiquido = novoSalarioBruto - valorDesconto;


        // Formatação de saída

        System.out.printf("Salário Bruto inicial: %.2f" , salarioBruto);
        System.out.println();

        System.out.printf("Valor do Aumento: %.2f" , valorDoAumento);
        System.out.println();

        System.out.printf("Novo Salário Bruto: %.2f" , novoSalarioBruto);
        System.out.println();

        System.out.printf("Salário Líquido final: %.2f" , salarioLiquido);
        System.out.println();

    }
}
