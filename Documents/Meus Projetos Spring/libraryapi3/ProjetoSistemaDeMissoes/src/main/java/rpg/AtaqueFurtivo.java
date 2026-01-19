package rpg;

public class AtaqueFurtivo implements Habilidade {

    private int danoBase;
    private double multiplicadorFurtividade;

    // Construtor que escala com atributos de furtividade da classe
    public AtaqueFurtivo(int danoBase, double multiplicadorFurtividade) {
        this.danoBase = danoBase;
        this.multiplicadorFurtividade = multiplicadorFurtividade;
    }

    // Habilidade signature de assassinos com dano devastador
    // Requer setup estratégico para máxima eficiência
    @Override
    public void usar(Personagem alvo) {
        int danoFurtivo = (int) (danoBase * multiplicadorFurtividade);

        System.out.println("🗡️ Um ATAQUE FURTIVO vindo das sombras!");
        System.out.println("💀 Dano crítico de " + danoFurtivo + " em " + alvo.getNome() + "!");
        alvo.receberDano(danoFurtivo);
    }
}