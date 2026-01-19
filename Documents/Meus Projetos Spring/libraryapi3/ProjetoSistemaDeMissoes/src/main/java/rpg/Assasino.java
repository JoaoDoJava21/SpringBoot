package rpg;

public class Assassino extends Personagem {

    // Sistema de furtividade que potencializa ataques surpresa
    private int furtividade;
    private boolean emCamuflagem;

    // Construtor que define assassino como classe de alto risco e recompensa
    // Extremamente frágil mas com potencial de dano explosivo
    public Assassino(String nome) {
        super(nome, 70, 45, 1, 0);
        this.furtividade = 20;
        this.emCamuflagem = false;
    }

    // Ataque que varia drasticamente baseado no estado de camuflagem
    // Punição severa por exposição mas recompensa massiva por stealth
    @Override
    public void atacar() {
        if (emCamuflagem) {
            int danoFurtivo = getAtaque() * 3;
            System.out.println("🗡️ " + getNome() + " ataca das sombras!");
            System.out.println("💀 ATAQUE FURTIVO! " + danoFurtivo + " de dano crítico!");
            emCamuflagem = false;
            System.out.println("👁️ Saiu da camuflagem");
        } else {
            System.out.println("🗡️ " + getNome() + " ataca com adagas!");
            System.out.println("💥 Causou " + getAtaque() + " de dano!");
        }
    }

    // Progressão focada em dano burst e capacidade de infiltração
    // Menor ganho de vida compensado por furtividade aprimorada
    @Override
    public void subirDeNivel(int niveis) {
        setNivel(getNivel() + niveis);
        setVida(getVida() + 8);
        setAtaque(getAtaque() + 12);
        this.furtividade += 7;

        System.out.println("🎉 " + getNome() + " subiu para nível " + getNivel() + "!");
        System.out.println("📊 Vida: +8 | Ataque: +12 | Furtividade: +7");
    }

    // Mecânica central da classe que habilita combos devastadores
    // Requer posicionamento estratégico e timing preciso
    public void camuflar() {
        if (!emCamuflagem) {
            emCamuflagem = true;
            System.out.println("🌫️ " + getNome() + " entra em CAMUFLAGEM!");
            System.out.println("👤 Próximo ataque terá dano triplo");
        } else {
            System.out.println("⚠️ Já está camuflado!");
        }
    }

    // Habilidade de execução com limiar de vida do alvo
    // Instakill em alvos enfraquecidos ou dano massivo em alvos saudáveis
    public void golpeLetal(Personagem alvo) {
        int vidaLimite = 30;

        if (alvo.getVida() <= vidaLimite) {
            System.out.println("💀 " + getNome() + " executa GOLPE LETAL!");
            System.out.println("⚰️ " + alvo.getNome() + " foi EXECUTADO!");
            alvo.setVida(0);
        } else {
            int dano = getAtaque() * 2;
            System.out.println("🗡️ " + getNome() + " tenta GOLPE LETAL!");
            System.out.println("💥 Causou " + dano + " de dano (alvo muito resistente)");
            alvo.receberDano(dano);
        }
    }

    // Combo de múltiplos ataques rápidos em sequência
    // Simula a velocidade característica da classe
    public void rajadaDeLaminas(Personagem alvo) {
        int numeroAtaques = 4;
        int danoTotal = 0;

        System.out.println("⚔️ " + getNome() + " usa RAJADA DE LÂMINAS!");

        for (int i = 1; i <= numeroAtaques; i++) {
            int dano = getAtaque() / 2;
            danoTotal += dano;
            System.out.println("🗡️ Ataque " + i + ": " + dano + " de dano");
        }

        System.out.println("💥 Dano total: " + danoTotal);
        alvo.receberDano(danoTotal);
    }

    // Dash que concede camuflagem temporária
    // Mecânica de mobilidade e reposicionamento tático
    public void passoDasSombras() {
        System.out.println("💨 " + getNome() + " usa PASSO DAS SOMBRAS!");
        System.out.println("🌫️ Teleporta e entra em camuflagem");
        emCamuflagem = true;
    }

    // Sistema defensivo baseado em evasão completa
    // Extremamente frágil quando atingido diretamente
    @Override
    public void receberDano(int dano) {
        // Chance de 35% de esquiva baseada em furtividade
        double chanceEsquiva = 0.35 + (furtividade * 0.01);
        boolean esquivou = Math.random() < chanceEsquiva;

        if (esquivou) {
            System.out.println("💨 " + getNome() + " desviou nas sombras!");
        } else {
            // Assassinos recebem 20% mais dano por serem frágeis
            int danoAumentado = (int) (dano * 1.2);
            setVida(getVida() - danoAumentado);
            if (getVida() < 0) setVida(0);

            System.out.println("❤️ " + getNome() + " recebeu " + danoAumentado + " de dano. Vida: " + getVida());

            // Perde camuflagem ao ser atingido
            if (emCamuflagem) {
                emCamuflagem = false;
                System.out.println("👁️ Camuflagem foi quebrada!");
            }
        }
    }

    @Override
    public void status() {
        super.status();
        System.out.println("🌫️ Furtividade: " + furtividade);
        System.out.println("👤 Camuflado: " + (emCamuflagem ? "Sim" : "Não"));
    }

    public int getFurtividade() {
        return furtividade;
    }

    public boolean isEmCamuflagem() {
        return emCamuflagem;
    }
}