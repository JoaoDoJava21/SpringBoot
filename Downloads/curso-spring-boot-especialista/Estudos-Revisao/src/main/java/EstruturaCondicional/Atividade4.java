package EstruturaCondicional;

import java.util.Scanner;

public class Atividade4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o seu login para logar no sistema! \n");

        System.out.print("Digite o seu usuário: ");
        String usuario = sc.next();
        System.out.print("Digite a sua senha: ");
        int senha = sc.nextInt();


        if(usuario.equals("admin") && senha == 1234){
            System.out.println("Bem vindo ao sistema !");
        }
        else {
            System.out.println("Acesso negado !");
        }
    }
}
