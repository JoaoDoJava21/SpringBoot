package rpg;

public class Missao {

    private String nome;
    private int dificuldade;
    private int recompensaXP;

    // Construtor que define parâmetros da missão
    // Dificuldade determina força do inimigo gerado
    public Missao(String nome, int dificuldade, int recompensaXP) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.recompensaXP = recompensaXP;
    }

    // Sistema de combate turn-based simplificado
    // Simula batalha completa com inimigo gerado proceduralmente
    public void executar(Personagem jogador) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║   🎯 MISSÃO: " + nome);
        System.out.println("║   ⚡ Dificuldade: " + dificuldade);
        System.out.println("╚════════════════════════════════════╝\n");

        // Gera inimigo com stats baseados na dificuldade
        Personagem inimigo = gerarInimigo();

        System.out.println("⚠️ " + inimigo.getNome() + " apareceu!");
        inimigo.status();

        // Loop de combate até um dos lados cair
        int turno = 1;
        while (jogador.getVida() > 0 && inimigo.getVida() > 0) {
            System.out.println("\n--- TURNO " + turno + " ---");

            // Turno do jogador
            System.out.println("\n🎮 Turno de " + jogador.getNome() + ":");
            jogador.atacar();
            inimigo.receberDano(jogador.getAtaque());

            if (inimigo.getVida() <= 0) {
                break;
            }

            // Turno do inimigo
            System.out.println("\n👹 Turno de " + inimigo.getNome() + ":");
            inimigo.atacar();
            jogador.receberDano(inimigo.getAtaque());

            turno++;
        }

        // Resultado da batalha
        System.out.println("\n╔════════════════════════════════════╗");
        if (jogador.getVida() > 0) {
            System.out.println("║   ✅ VITÓRIA!");
            System.out.println("║   🎉 " + jogador.getNome() + " derrotou " + inimigo.getNome());
            System.out.println("╚════════════════════════════════════╝");
            jogador.ganharXp(recompensaXP);
        } else {
            System.out.println("║   ❌ DERROTA!");
            System.out.println("║   💀 " + jogador.getNome() + " foi derrotado");
            System.out.println("╚════════════════════════════════════╝");
        }
    }

    // Geração procedural de inimigos baseada em dificuldade
    // Cria desafio escalável para diferentes níveis de jogador
    private Personagem gerarInimigo() {
        String[] nomes = {"Goblin", "Orc", "Troll", "Dragão", "Demônio"};
        String nomeInimigo = nomes[Math.min(dificuldade - 1, nomes.length - 1)];

        // Inimigo genérico que escala com dificuldade
        return new Personagem(nomeInimigo,
                50 + (dificuldade * 20),    // vida
                15 + (dificuldade * 10),    // ataque
                dificuldade,                // nivel
                0) {                        // xp

            @Override
            public void atacar() {
                System.out.println("👹 " + getNome() + " ataca ferozmente!");
            }

            @Override
            public void subirDeNivel(int niveis) {
                // Inimigos não sobem de nível
            }
        };
    }

    public String getNome() {
        return nome;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public int getRecompensaXP() {
        return recompensaXP;
    }
}