package org.example;

public class Cadastro {
    private String nome;
    private int idade;
    private double nota;


    public Cadastro(){

    }

    public Cadastro(int idade, String nome, double nota) {
        this.idade = idade;
        this.nome = nome;
        this.nota = nota;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }


    public String mediaNotas(){
        return "Nome: " + nome + " | Idade: " + idade + " | Nota: " + nota;
    }
}
