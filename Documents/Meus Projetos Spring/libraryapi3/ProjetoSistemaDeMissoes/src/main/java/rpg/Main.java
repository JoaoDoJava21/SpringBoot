package rpg;

public class Main {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     🎮 RPG SYSTEM - DEMONSTRAÇÃO    ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        // Criação dos personagens
        System.out.println("⚔️ === CRIAÇÃO DE PERSONAGENS ===\n");

        Guerreiro aragorn = new Guerreiro("Aragorn");
        Mago gandalf = new Mago("Gandalf");
        Arqueiro legolas = new Arqueiro("Legolas");
        Assassino ezio = new Assassino("Ezio");

        // Status inicial
        System.out.println("📊 Status iniciais:\n");
        aragorn.status();
        gandalf.status();
        legolas.status();
        ezio.status();

        // Demonstração de habilidades
        System.out.println("\n⚔️ === DEMONSTRAÇÃO DE HABILIDADES ===\n");

        // Criar habilidades
        Habilidade bolaDeFogo = new BolaDeFogo(80);
        Habilidade golpePesado = new GolpePesado(60, 0.4);
        Habilidade ataqueFurtivo = new AtaqueFurtivo(70, 2.5);

        // Guerreiro usando habilidade
        System.out.println("--- Guerreiro testando habilidades ---");
        golpePesado.usar(gandalf);
        aragorn.investida(gandalf);

        // Mago usando habilidades
        System.out.println("\n--- Mago testando habilidades ---");
        gandalf.meditar();
        bolaDeFogo.usar(aragorn);
        gandalf.bolaDeFogo(aragorn);

        // Arqueiro usando habilidades
        System.out.println("\n--- Arqueiro testando habilidades ---");
        legolas.atacar();
        legolas.tiroCarregado(aragorn);
        legolas.chuvaDeFlechas(aragorn);

        // Assassino usando habilidades
        System.out.println("\n--- Assassino testando habilidades ---");
        ezio.camuflar();
        ezio.atacar();
        ataqueFurtivo.usar(legolas);
        ezio.rajadaDeLaminas(legolas);

        // Resetar vida dos personagens
        aragorn.setVida(150);
        gandalf.setVida(80);
        legolas.setVida(100);
        ezio.setVida(70);

        // Sistema de missões
        System.out.println("\n\n🎯 === SISTEMA DE MISSÕES ===\n");

        Missao missao1 = new Missao("Limpar a Masmorra", 1, 50);
        Missao missao2 = new Missao("Derrotar o Chefe Orc", 2, 100);
        Missao missao3 = new Missao("Enfrentar o Dragão", 3, 200);

        // Aragorn em missões
        missao1.executar(aragorn);
        aragorn.status();

        // Gandalf em missões
        missao2.executar(gandalf);
        gandalf.status();

        // Legolas em missões
        missao1.executar(legolas);
        legolas.recarregar();
        legolas.status();

        // Ezio em missões
        ezio.camuflar();
        missao2.executar(ezio);
        ezio.status();

        // Demonstração de evolução
        System.out.println("\n\n📈 === EVOLUÇÃO DE PERSONAGENS ===\n");

        System.out.println("--- Aragorn ganhando XP ---");
        aragorn.ganharXp(150);
        aragorn.status();

        System.out.println("\n--- Gandalf ganhando XP ---");
        gandalf.ganharXp(200);
        gandalf.status();

        System.out.println("\n--- Legolas ganhando XP ---");
        legolas.ganharXp(100);
        legolas.status();

        System.out.println("\n--- Ezio ganhando XP ---");
        ezio.ganharXp(250);
        ezio.status();

        // Combate final épico
        System.out.println("\n\n⚔️ === BATALHA FINAL ÉPICA ===\n");
        Missao missaoFinal = new Missao("O Senhor das Trevas", 5, 500);
        missaoFinal.executar(aragorn);

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║        FIM DA DEMONSTRAÇÃO           ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
}