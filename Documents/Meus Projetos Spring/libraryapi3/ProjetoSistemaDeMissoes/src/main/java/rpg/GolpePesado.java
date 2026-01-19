package rpg;

public class GolpePesado implements Habilidade {

    private int danoBase;
    private double chanceCritico;

    // Construtor com parâmetros de balanceamento de dano e RNG
    public GolpePesado(int danoBase, double chanceCritico) {
        this.danoBase = danoBase;
        this.chanceCritico = chanceCritico;
    }

    // Ataque físico pesado com mecânica de crítico probabilístico
    // Apropriado para classes corpo a corpo como guerreiro
    @Override
    public void usar(Personagem alvo) {
        boolean critico = Math.random() < chanceCritico;
        int danoFinal = critico ? danoBase * 2 : danoBase;

        System.out.println("⚔️ Um GOLPE PESADO é desferido!");
        if (critico) {
            System.out.println("💢 CRÍTICO! Dano dobrado!");
        }
        System.out.println("💥 Causa " + danoFinal + " de dano em " + alvo.getNome() + "!");
        alvo.receberDano(danoFinal);
    }
}