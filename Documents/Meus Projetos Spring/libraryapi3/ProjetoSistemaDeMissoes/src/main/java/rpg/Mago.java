package rpg;

public class Mago extends Personagem {

    // Sistema de recurso mágico para balancear o alto poder destrutivo
    private int mana;
    private int manaMaxima;

    // Construtor que define o mago como uma classe de vidro com alto dano
    // Baixa vitalidade compensada por ataques devastadores
    public Mago(String nome) {
        super(nome, 80, 50, 1, 0);
        this.mana = 100;
        this.manaMaxima = 100;
    }

    // Ataque básico que consome mana para causar dano mágico
    // Quando sem mana, realiza um ataque físico enfraquecido
    @Override
    public void atacar() {
        if (mana >= 10) {
            System.out.println("🔮 " + getNome() + " conjura um MÍSSIL MÁGICO!");
            System.out.println("✨ Causou " + getAtaque() + " de dano mágico!");
            mana -= 10;
            System.out.println("💙 Mana restante: " + mana + "/" + manaMaxima);
        } else {
            System.out.println("⚠️ " + getNome() + " está sem mana!");
            System.out.println("👊 Ataque físico fraco: " + (getAtaque() / 2) + " de dano");
        }
    }

    // Progressão focada em poder mágico e capacidade de conjuração
    // Restaura mana ao subir de nível para recompensar a evolução
    @Override
    public void subirDeNivel(int niveis) {
        setNivel(getNivel() + niveis);
        setVida(getVida() + 10);
        setAtaque(getAtaque() + 15);
        this.manaMaxima += 20;
        this.mana = this.manaMaxima;

        System.out.println("🎉 " + getNome() + " subiu para nível " + getNivel() + "!");
        System.out.println("📊 Vida: +10 | Ataque: +15 | Mana: +20");
    }

    // Habilidade ultimate com custo elevado e dano triplo
    // Requer gestão estratégica de mana durante o combate
    public void bolaDeFogo(Personagem alvo) {
        int custoMana = 30;

        if (mana >= custoMana) {
            int danoTotal = getAtaque() * 3;
            System.out.println("🔥 " + getNome() + " lança uma BOLA DE FOGO!");
            System.out.println("💥 Explosão massiva de " + danoTotal + " de dano!");
            alvo.receberDano(danoTotal);
            mana -= custoMana;
            System.out.println("💙 Mana restante: " + mana + "/" + manaMaxima);
        } else {
            System.out.println("⚠️ Mana insuficiente! Necessário: " + custoMana);
        }
    }

    // Mecânica de recuperação de recursos fora de combate
    // Adiciona profundidade estratégica ao gerenciamento de mana
    public void meditar() {
        int regeneracao = 40;
        mana += regeneracao;
        if (mana > manaMaxima) mana = manaMaxima;

        System.out.println("🧘 " + getNome() + " medita e recupera " + regeneracao + " de mana");
        System.out.println("💙 Mana atual: " + mana + "/" + manaMaxima);
    }

    // Habilidade defensiva que compensa a baixa vitalidade
    // Escudo temporário com custo moderado de mana
    public void escudoMagico() {
        int custoMana = 25;

        if (mana >= custoMana) {
            System.out.println("🛡️✨ " + getNome() + " conjura um ESCUDO MÁGICO!");
            System.out.println("🔵 Proteção arcana ativada");
            mana -= custoMana;
            System.out.println("💙 Mana restante: " + mana + "/" + manaMaxima);
        } else {
            System.out.println("⚠️ Mana insuficiente para escudo!");
        }
    }

    // Override que adiciona informações sobre o recurso mágico
    @Override
    public void status() {
        super.status();
        System.out.println("💙 Mana: " + mana + "/" + manaMaxima);
    }

    public int getMana() {
        return mana;
    }

    public int getManaMaxima() {
        return manaMaxima;
    }
}