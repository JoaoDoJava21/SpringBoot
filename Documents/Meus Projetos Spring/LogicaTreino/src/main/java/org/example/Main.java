package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("----- Sistema de Cadastro de produto -----");
            System.out.println("Digite a sua opção: ");
            System.out.println("1- Cadastrar produto");
            System.out.println("2- Listar produtos");
            System.out.println("3- Buscar produto por nome");
            System.out.println("4- Remover produto por ID");
            System.out.println("5- Sair");
            System.out.print("Digite a sua opção: ");
            opcao = sc.nextInt();
            sc.nextLine();  // Para limpar o buffer após os nextInt


            switch (opcao) {
                case 1:
                    System.out.println("----- Cadastro de produto -----");
                    System.out.println("Digite o seu id: ");
                    int id = sc.nextInt();
                    System.out.println("Digite o seu nome: ");
                    String nome = sc.next();
                    System.out.println("Digite o preço do produto: ");
                    double preco = sc.nextDouble();
                    System.out.println("Digite a quantidade do produto: ");
                    int quantidade = sc.nextInt();
                    produtos.add(new Produto(id,nome,preco,quantidade));
                    System.out.println("Produto cadastrado com sucesso ! ");
                    break;

                case 2:
                    System.out.println("----- Listar Produto -----");
                    for(Produto p : produtos){
                        System.out.println("Produtos cadastrados: " + p);
                    }
                    break;
                case 3:
                    System.out.println("----- Buscar produto por nome -----");
                    String busca = sc.nextLine(); // É a String digitada pelo usuário
                    for(Produto p : produtos ){
                        if(p.getNome().equalsIgnoreCase(busca)){ // Se no nome o usuário digitar "arroz" ou "Arroz" vai reconhecer como igual .
                            System.out.println("Nome do produto encontrado: " + busca);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Digite o ID para remover");
                    int removerId = sc.nextInt();
                    produtos.removeIf(p -> p.getId() == removerId); // é cada produto da lista (um por vez). -> significa: “para cada produto p, faça essa verificação”.
                    // p.id == idRemove é a condição. Se for true, esse produto é removido.
                    System.out.println("Produto removido com sucesso !" + produtos);
                    break;
            }

        }while (opcao != 5);
        System.out.println("Sistema fechado . Muito obrigado por testar !");
    }
}