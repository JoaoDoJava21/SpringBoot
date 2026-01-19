package rpg;

public interface Habilidade {
    // Contrato que define comportamento padrão de habilidades especiais
    // Permite polimorfismo e criação de sistemas de combate modulares
    void usar(Personagem alvo);
}