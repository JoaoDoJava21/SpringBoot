package rpg;

public abstract class Personagem {

    private String nome ;
    private int vida ;
    private int ataque;
    private int nivel ;
    private int xp ;

    // Construtor

    // A ORDEM É ESSA AQUI:
    public Personagem(String nome, int vida, int ataque, int nivel, int xp) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.nivel = nivel;
        this.xp = xp;
    }

    // Métodos abstratos

    public abstract void atacar();
    public abstract void subirDeNivel(int valor);


    // Metodo para receber dano

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
                this.vida = 0;
        }

        System.out.println(nome + " recebeu " + dano + " de dano! Vida: " + vida);
    }


    // Metodo para verificar se esta vivo

    public boolean estaVivo() {
        return this.vida > 0;
    }


    // Metodo de ganhar xp
    public void ganharXp(int valor){
        this.xp += valor;

        System.out.println(nome + " ganhou " + valor + " XP!");

        // Para Verificar se deve subir de nível (exemplo  100 XP por nível)

        while (this.xp >= 100){
            subirDeNivel(1);
            this.xp -= 100;
        }
    }

    // Exibir status
    public void status (){
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Nível: " + nivel);
        System.out.println("XP: " + xp);
    }

    // Encapsulamento

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

}
