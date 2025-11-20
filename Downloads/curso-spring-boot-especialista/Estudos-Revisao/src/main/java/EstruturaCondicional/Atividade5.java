package EstruturaCondicional;

import java.util.Scanner;

public class Atividade5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("======== SIMULADOR DE PEDIDOS ========");

        System.out.println("1- Hambúrguer");
        System.out.println("2- Pizza");
        System.out.println("3- Salada");
        System.out.println("4- Suco");

        System.out.println("Digite o seu pedido !\n");
        int opcao ;

        switch (opcao = sc.nextInt()){
            case 1 :
                System.out.println("Você escolheu Hambúrguer !");
                break;
            case 2:
                System.out.println("Você escolheu Pizza !");
                break;
            case 3:
                System.out.println("Você escolheu Salada !");
                break;
            case 4:
                System.out.println("Você escolheu Suco !");
                break;
            default:
                System.out.println("Opção inválida !");
                break;
        }
    }
}
