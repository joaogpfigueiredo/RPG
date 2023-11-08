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
        char escolha;
            do {
                imprimirMenu();
                escolha = sc.next().charAt(0);

                switch (escolha) {
                    case '1':
                        imprimirPersonagens(personagens);
                        break;
                    case '2':
                        nivelSuperior(personagens);
                        break;
                    case '3':
                        personagensComItens(personagens);
                        break;
                    case '4':
                        estatisticasPersonagem(personagens);
                        break;
                    case '5':
                        subirNivelPersonagens(personagens, sc);
                        break;
                    case '6':
                        System.out.println("\nAté à próxima!");
                        break;
                    default:
                        System.out.println("\nOpção inválida, tente novamente.\n");
                        break;
                }
            }while(escolha != '6');
        }

    private static int nivelRandom(int max) {
        return new Random().nextInt(max) + 1;
    }

    private static void criarPersonagens(ArrayList<Personagem> personagens) {
        for (int i = 1; i <= 5; i++) {
            personagens.add(new Guerreiro("Guerreiro " + i, nivelRandom(25), new String[] {"Espada", "Machado", "Faca"}, (int) (Math.random() * 2) == 1));
            personagens.add(new Mago("Mago " + i, nivelRandom(25)));
            personagens.add(new Mercenario("Mercenário " + i, nivelRandom(25), new String[] {"Arco", "Pistola", "Pedras"}, (int) (Math.random() * 20) + 5));
        }
    }

    private static void imprimirMenu() {
        System.out.println("--------------------- Menu ---------------------");
        System.out.println("1 → Visualizar todas as personagens existentes;");
        System.out.println("2 → Visualizar todas as personagens com nível superior a 10;");
        System.out.println("3 → Visualizar todos os Guerreiros com Armadura, Magos com sementes de abóbora e Mercenários com arcos;");
        System.out.println("4 → Visualizar estatísticas de um personagem;");
        System.out.println("5 → Subir níveis de personagens;");
        System.out.println("6 → Fechar o jogo.");
        System.out.print("> ");
    }

    private static void imprimirPersonagens(ArrayList<Personagem> personagens) {
        System.out.println("\n------------------------------------ Tabela de Personagens ------------------------------------");
        System.out.printf("| %-16s | %-15s | %-16s | %-16s | %-16s |\n", "Nome", "Nível", "Força", "Agilidade", "Inteligência");
        for (Personagem personagem : personagens) {
            System.out.printf("| %-16s | %-15d | %-16.2f | %-16.2f | %-16.2f |\n", personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    private static void nivelSuperior(ArrayList<Personagem> personagens) {
        System.out.println("\n------------------------------- Personagens Nível Superior a 10 -------------------------------");
        System.out.printf("| %-16s | %-15s | %-16s | %-16s | %-16s |\n", "Nome", "Nível", "Força", "Agilidade", "Inteligência");
        for (Personagem personagem : personagens) {
            if (personagem.getNivel() > 10) {
                System.out.printf("| %-16s | %-15d | %-16.2f | %-16.2f | %-16.2f |\n", personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    private static void personagensComItens(ArrayList<Personagem> personagens) {
        System.out.println("\n------------------------------------ Personagens com Itens ------------------------------------");
        System.out.printf("| %-16s | %-15s | %-16s | %-16s | %-16s |\n", "Nome", "Nível", "Força", "Agilidade", "Inteligência");
        for (Personagem personagem : personagens) {
            switch (personagem) {
                case Guerreiro guerreiro -> {
                    if (guerreiro.temArmadura()) {
                        System.out.printf("| %-16s | %-15d | %-16.2f | %-16.2f | %-16.2f |\n", personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
                    }
                } case Mago mago -> {
                    if (mago.temItemNaMochila("Sementes de Abóbora")) {
                        System.out.printf("| %-16s | %-15d | %-16.2f | %-16.2f | %-16.2f |\n", personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
                    }
                } case Mercenario mercenario -> {
                    if (mercenario.temArma("Arco")) {
                        System.out.printf("| %-16s | %-15d | %-16.2f | %-16.2f | %-16.2f |\n", personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
                        }
                    }
                default -> {}
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    private static void estatisticasPersonagem(ArrayList<Personagem> personagens) {
        Personagem personagem = encontrarPersonagem(personagens);

        if(personagem != null) {
            System.out.printf("\nEstatísticas de %s:\nNível: %d\nForça: %.2f\nAgilidade: %.2f\nInteligência: %.2f\n",personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
        }else {
            System.out.println("\nPersonagem não encontrado!\n");
        }
    }

    private static  void subirNivelPersonagens(ArrayList<Personagem> personagens, Scanner sc) {
        char escolha;
        do {
            System.out.println("--------------------- Menu de Subir Niveis ---------------------");
            System.out.println("1 → Subir nível de apenas um personagem;");
            System.out.println("2 → Subir nível de todos os personagens;");
            System.out.println("3 → Voltar ao menu principal.");
            System.out.print("> ");

            escolha = sc.next().charAt(0);
            if(Character.isDigit(escolha) && escolha >= '1' && escolha < '3') {
                System.out.print("\nQuantos níveis quer subir: ");
                int niveis = sc.nextInt();

                if (niveis >= 0) {
                    switch (escolha) {
                        case '1':
                            Personagem personagem = encontrarPersonagem(personagens);
                            if (personagem != null) {
                                System.out.printf("\n%s antes de subir de nível:\nNível: %d\nForça: %.2f\nAgilidade: %.2f\nInteligência: %.2f\n", personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
                                subirNivel(personagem, niveis);
                                System.out.printf("\n%s depois de subir de nível:\nNível: %d\nForça: %.2f\nAgilidade: %.2f\nInteligência: %.2f\n", personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
                            } else {
                                System.out.println("\nPersonagem não encontrado!\n");
                            }
                            break;
                        case '2':
                            System.out.println("\nPersonagens antes subir o nível:");
                            imprimirPersonagens(personagens);
                            for (Personagem p : personagens) {
                                subirNivel(p, niveis);
                            }
                            System.out.println("\nPersonagens após subir o nível:");
                            imprimirPersonagens(personagens);
                            break;
                    }
                }else {
                    System.out.println("\nNúmero de niveís a subir inválido!\n");
                }
            }else {
                if(escolha != '3') {
                    System.out.println("\nOpção inválida, tente novamente.\n");
                }
            }
        }while(escolha != '3');
    }

    private static void subirNivel(Personagem personagem, int quantosNiveis) {
        switch (personagem) {
            case Guerreiro guerreiro -> {
                guerreiro.setForca(guerreiro.getForca() * (1.2 * quantosNiveis));
                guerreiro.setAgilidade(guerreiro.getAgilidade() * (1.1 * quantosNiveis));
                guerreiro.setInteligencia(guerreiro.getInteligencia() * (1.05 * quantosNiveis));
            }case Mago mago -> {
                mago.setForca(mago.getForca() * (1.05 * quantosNiveis));
                mago.setAgilidade(mago.getAgilidade() * (1.1 * quantosNiveis));
                mago.setInteligencia(mago.getInteligencia() * (1.2 * quantosNiveis));
            }case Mercenario mercenario -> {
                mercenario.setForca(mercenario.getForca() * (1.08 * quantosNiveis));
                mercenario.setAgilidade(mercenario.getAgilidade() * (1.2 * quantosNiveis));
                mercenario.setInteligencia(mercenario.getInteligencia() * (1.08 * quantosNiveis));
            }default -> {}
        }

        personagem.setNivel(personagem.getNivel() + quantosNiveis);
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