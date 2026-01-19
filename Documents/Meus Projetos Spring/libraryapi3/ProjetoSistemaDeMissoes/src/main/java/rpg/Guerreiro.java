package rpg;

public class Guerreiro extends Personagem {

    // Atributo exclusivo que representa a capacidade defensiva do guerreiro
    private int armadura;

    // Construtor padrão que inicializa um guerreiro com valores balanceados para tank
    // Guerreiros começam com alta vitalidade e armadura moderada
    public Guerreiro(String nome) {
        super(nome, 150, 30, 1, 0);
        this.armadura = 10;
    }

    // Implementação específica do ataque de guerreiro
    // Utiliza armas de corpo a corpo com dano físico direto
    @Override
    public void atacar() {
        System.out.println("⚔️ " + getNome() + " desfere um GOLPE FORTE com a espada!");
        System.out.println("💥 Causou " + getAtaque() + " de dano!");
    }

    // Sistema de progressão focado em resistência e poder físico
    // Guerreiros ganham mais vida que outras classes por nível
    @Override
    public void subirDeNivel(int niveis) {
        setNivel(getNivel() + niveis);
        setVida(getVida() + 20);
        setAtaque(getAtaque() + 5);
        this.armadura += 3;

        System.out.println("🎉 " + getNome() + " subiu para nível " + getNivel() + "!");
        System.out.println("📊 Vida: +20 | Ataque: +5 | Armadura: +3");
    }

    // Habilidade especial que sacrifica defesa por dano massivo
    // Dobra o dano base mas deixa o guerreiro vulnerável temporariamente
    public void investida(Personagem alvo) {
        int danoTotal = getAtaque() * 2;
        System.out.println("🏃 " + getNome() + " usa INVESTIDA!");
        System.out.println("💢 Causa " + danoTotal + " de dano em " + alvo.getNome() + "!");
        alvo.receberDano(danoTotal);
    }

    // Override do sistema de dano para incluir mitigação por armadura
    // A armadura reduz linearmente o dano recebido até um mínimo de zero
    @Override
    public void receberDano(int dano) {
        int danoReduzido = dano - armadura;
        if (danoReduzido < 0) danoReduzido = 0;

        setVida(getVida() - danoReduzido);
        if (getVida() < 0) setVida(0);

        System.out.println("🛡️ " + getNome() + " bloqueou " + armadura + " de dano!");
        System.out.println("❤️ Recebeu " + danoReduzido + " de dano. Vida: " + getVida());
    }

    // Exibe informações completas incluindo o status defensivo
    @Override
    public void status() {
        super.status();
        System.out.println("🛡️ Armadura: " + armadura);
    }

    public int getArmadura() {
        return armadura;
    }
}