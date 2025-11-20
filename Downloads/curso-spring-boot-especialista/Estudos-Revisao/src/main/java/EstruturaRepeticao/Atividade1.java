package EstruturaRepeticao;

import java.util.Scanner;

public class Atividade1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int senha = 1234 ;

        while(true){
            System.out.println("Digite a senha válida");
            int senha_digitada = sc.nextInt();
            if (senha_digitada == senha){
                System.out.println("Acesso permitido !");
                break;
            }
            else {
                System.out.println("Senha inválida !");
            }
        }


        // Com While Condição

        boolean acessoLiberado = false;

        while (!acessoLiberado){
            System.out.print("Digite a sua senha: ");
            int senha_digitada = sc.nextInt();

            if(senha_digitada == senha){
                System.out.println("Acesso permitido ");
                acessoLiberado = true;
            }
            else {
                System.out.println("Acesso negado !");
            }
        }


    }
}
