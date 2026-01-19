package rpg;

public class BolaDeFogo implements Habilidade {

    private int danoBase;

    // Construtor que permite customização do poder da habilidade
    public BolaDeFogo(int danoBase) {
        this.danoBase = danoBase;
    }

    // Implementação de magia de área com dano explosivo
    // Ideal para magos e classes com afinidade elemental
    @Override
    public void usar(Personagem alvo) {
        System.out.println("🔥 Uma BOLA DE FOGO é conjurada!");
        System.out.println("💥 Explosão causa " + danoBase + " de dano em " + alvo.getNome() + "!");
        alvo.receberDano(danoBase);
    }
}