package rpg;

public class Arqueiro extends Personagem {

    // Sistema de precisão que aumenta chance de acertos críticos
    private int precisao;
    private int flechas;

    // Construtor que define arqueiro como classe de dano sustentado à distância
    // Balanceamento entre vida e ataque com foco em velocidade
    public Arqueiro(String nome) {
        super(nome, 100, 40, 1, 0);
        this.precisao = 15;
        this.flechas = 30;
    }

    // Ataque à distância com chance de crítico baseada em precisão
    // Consome flechas e pode executar ataques devastadores
    @Override
    public void atacar() {
        if (flechas > 0) {
            flechas--;

            // Sistema de crítico com 30% de chance base
            boolean critico = Math.random() < 0.30;
            int dano = critico ? getAtaque() * 2 : getAtaque();

            System.out.println("🏹 " + getNome() + " dispara uma flecha!");
            if (critico) {
                System.out.println("🎯 CRÍTICO! Acerto perfeito!");
            }
            System.out.println("💥 Causou " + dano + " de dano!");
            System.out.println("📦 Flechas restantes: " + flechas);
        } else {
            System.out.println("⚠️ " + getNome() + " está sem flechas!");
            System.out.println("👊 Ataque corpo a corpo: " + (getAtaque() / 3) + " de dano");
        }
    }

    // Progressão focada em velocidade de ataque e precisão
    // Arqueiros ganham ataque balanceado e melhor taxa de crítico
    @Override
    public void subirDeNivel(int niveis) {
        setNivel(getNivel() + niveis);
        setVida(getVida() + 15);
        setAtaque(getAtaque() + 8);
        this.precisao += 5;
        this.flechas = 30;

        System.out.println("🎉 " + getNome() + " subiu para nível " + getNivel() + "!");
        System.out.println("📊 Vida: +15 | Ataque: +8 | Precisão: +5");
        System.out.println("📦 Flechas reabastecidas!");
    }

    // Habilidade que dispara múltiplas flechas simultaneamente
    // Alto custo de munição mas dano distribuído devastador
    public void chuvaDeFlechas(Personagem alvo) {
        int flechasNecessarias = 5;

        if (flechas >= flechasNecessarias) {
            int danoTotal = getAtaque() * 4;
            flechas -= flechasNecessarias;

            System.out.println("☔ " + getNome() + " usa CHUVA DE FLECHAS!");
            System.out.println("💥 Múltiplos disparos causam " + danoTotal + " de dano total!");
            alvo.receberDano(danoTotal);
            System.out.println("📦 Flechas restantes: " + flechas);
        } else {
            System.out.println("⚠️ Flechas insuficientes! Necessário: " + flechasNecessarias);
        }
    }

    // Disparo de precisão com dano garantido e chance elevada de crítico
    // Consome munição extra mas ignora parte da defesa do alvo
    public void tiroCarregado(Personagem alvo) {
        if (flechas >= 3) {
            flechas -= 3;
            int danoTotal = (int) (getAtaque() * 2.5);

            System.out.println("⚡ " + getNome() + " prepara um TIRO CARREGADO!");
            System.out.println("🎯 Disparo perfeito de " + danoTotal + " de dano!");
            alvo.receberDano(danoTotal);
            System.out.println("📦 Flechas restantes: " + flechas);
        } else {
            System.out.println("⚠️ Flechas insuficientes para tiro carregado!");
        }
    }

    // Reabastecer munição durante o combate
    // Simula coleta de flechas do campo de batalha
    public void recarregar() {
        int municaoRecuperada = 15;
        flechas += municaoRecuperada;
        if (flechas > 30) flechas = 30;

        System.out.println("📦 " + getNome() + " recarrega " + municaoRecuperada + " flechas");
        System.out.println("📦 Flechas atuais: " + flechas + "/30");
    }

    // Esquiva baseada em agilidade do arqueiro
    // Menor absorção de dano mas maior mobilidade
    @Override
    public void receberDano(int dano) {
        // Chance de 25% de esquivar completamente
        boolean esquivou = Math.random() < 0.25;

        if (esquivou) {
            System.out.println("💨 " + getNome() + " esquivou do ataque!");
        } else {
            setVida(getVida() - dano);
            if (getVida() < 0) setVida(0);
            System.out.println("❤️ " + getNome() + " recebeu " + dano + " de dano. Vida: " + getVida());
        }
    }

    @Override
    public void status() {
        super.status();
        System.out.println("🎯 Precisão: " + precisao);
        System.out.println("📦 Flechas: " + flechas + "/30");
    }

    public int getPrecisao() {
        return precisao;
    }

    public int getFlechas() {
        return flechas;
    }
}