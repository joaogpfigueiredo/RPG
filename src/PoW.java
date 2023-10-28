import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Personagem.*;
import Personagem.Classes.Guerreiro;
import Personagem.Classes.Mago;
import Personagem.Classes.Mercenario;

public class PoW {
    public static void main(String[] args) {
        ArrayList<Personagem> personagens = new ArrayList<>();
        criarPersonagens(personagens);

        Scanner sc = new Scanner(System.in);
        int escolha = 0;

        while (escolha != 6) {
            imprimirMenu();
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    imprimirPersonagens(personagens);
                    break;
                case 2:
                    nivelSuperior(personagens);
                    break;
                case 3:
                    personagensComItens(personagens);
                    break;
                case 4:
                    estatisticasPersonagem(personagens);
                    break;
                case 5:
                    subirNivel(personagens);
                    break;
                case 6:
                    System.out.println("\nAté à próxima!");
                    break;
            }
        }
    }

    private static int nivelRandom(int max) {
        return new Random().nextInt(max) + 1;
    }

    private static void criarPersonagens(ArrayList<Personagem> personagens) {
        for (int i = 1; i <= 5; i++) {
            personagens.add(new Guerreiro("Guerreiro " + i, nivelRandom(25), armaGuerreiro(), (int) (Math.random() * 2) == 1));
            personagens.add(new Mago("Mago " + i, nivelRandom(25)));
            personagens.add(new Mercenario("Mercenário " + i, nivelRandom(25), armaLongaMercenario(), (int) (Math.random() * 20) + 5));
        }
    }

    private static String armaGuerreiro() {
        int item = (int) (Math.random() * 3);
        return switch (item) {
            case 0 -> "Espada";
            case 1 -> "Faca";
            case 2 -> "Machado";
            default -> null;
        };
    }

    private static String armaLongaMercenario() {
        int item = (int) (Math.random() * 3);
        return switch (item) {
            case 0 -> "Pedras";
            case 1 -> "Arco";
            case 2 -> "Pistola";
            default -> null;
        };
    }

    private static void imprimirMenu() {
        System.out.println("--------------------- Menu ---------------------");
        System.out.println("1 → Visualizar todas as personagens existentes;");
        System.out.println("2 → Visualizar todas as personagens com nível superior a 10;");
        System.out.println("3 → Visualizar todos os Guerreiros com Armadura, Magos com sementes de abóbora e Mercenários com arcos;");
        System.out.println("4 → Visualizar estatísticas de um personagem;");
        System.out.println("5 → Fazer um dos personagens subir de nível;");
        System.out.println("6 → Fechar o jogo.");
        System.out.print("> ");
    }

    private static void imprimirPersonagens(ArrayList<Personagem> personagens) {
        System.out.println("\nTodos os personagens:");
        for (Personagem personagem : personagens) {
            System.out.println(personagem + "\n");
        }
    }

    private static void nivelSuperior(ArrayList<Personagem> personagens) {
        System.out.println("\nPersonagens com nível superior a 10:");
        for (Personagem personagem : personagens) {
            if (personagem.getNivel() > 10) {
                System.out.println(personagem + "\n");
            }
        }
    }

    private static void personagensComItens(ArrayList<Personagem> personagens) {
        System.out.println("\nGuerreiros com armadura, Magos com sementes de abóbora, Mercenários com arcos:");
        for (Personagem personagem : personagens) {
            switch (personagem) {
                case Guerreiro guerreiro -> {
                    if (guerreiro.temArmadura()) {
                        System.out.println(guerreiro + "\n");
                    }
                } case Mago mago -> {
                    if (mago.temItemNaMochila("Sementes de Abóbora")) {
                        System.out.println(mago + "\n");
                    }
                } case Mercenario mercenario -> {
                    if (mercenario.temArma("Arco")) {
                        System.out.println(mercenario + "\n");
                        }
                    }
                default -> {}
            }
        }
    }

    private static void estatisticasPersonagem(ArrayList<Personagem> personagens) {
        Personagem personagem = encontrarPersonagem(personagens);

        if(personagem != null) {
            System.out.printf("\nEstatísticas de %s:\nNível: %d\nForça: %.2f\nAgilidade: %.2f\nInteligência: %.2f\n",personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
        }else {
            System.out.println("\nPersonagem não encontrado!\n");
        }
    }

    private static  void subirNivel(ArrayList<Personagem> personagens) {
        Personagem personagem = encontrarPersonagem(personagens);

        if (personagem != null) {
            System.out.printf("\nPersonagem Antes de Subir de Nível:\nNível: %d\nForça: %.2f\nAgilidade: %.2f\nInteligência: %.2f\n", personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
            switch (personagem) {
                case Guerreiro guerreiro -> {
                    guerreiro.setForca(guerreiro.getForca() * 1.2);
                    guerreiro.setAgilidade(guerreiro.getAgilidade() * 1.1);
                    guerreiro.setInteligencia(guerreiro.getInteligencia() * 1.05);
                } case Mago mago -> {
                    mago.setForca(mago.getForca() * 1.05);
                    mago.setAgilidade(mago.getAgilidade() * 1.1);
                    mago.setInteligencia(mago.getInteligencia() * 1.2);
                } case Mercenario mercenario -> {
                    mercenario.setForca(mercenario.getForca() * 1.08);
                    mercenario.setAgilidade(mercenario.getAgilidade() * 1.2);
                    mercenario.setInteligencia(mercenario.getInteligencia() * 1.08);
                }
                default -> {}
            }

            personagem.setNivel(personagem.getNivel() + 1);
            System.out.printf("\nPersonagem Antes de Subir de Nível:\nNível: %d\nForça: %.2f\nAgilidade: %.2f\nInteligência: %.2f\n", personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
        }else {
            System.out.println("\nPersonagem não encontrado!\n");
        }
    }

    private static Personagem encontrarPersonagem(ArrayList<Personagem> personagens)  {
        Scanner sn = new Scanner(System.in);
        System.out.print("\nIndique o nome do Personagem: ");
        String nome = sn.nextLine();

        Personagem personagem = null;

        for (Personagem p: personagens) {
            if(p.getNome().equals(nome)) {
                personagem = p;
                break;
            }
        }
        return personagem;
    }
}