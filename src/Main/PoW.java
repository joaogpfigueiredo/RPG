package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Main.Personagem.*;
import Main.Personagem.Classes.Guerreiro;
import Main.Personagem.Classes.Mago;
import Main.Personagem.Classes.Mercenario;

/**
 * Classe principal do nosso RPG, aqui estão os principais métodos
 * estes vão desde imprimir personagens até subir o seu nível.
 *
 * @author João Figueiredo
 * @version 1.14
 */

public class PoW {

    /**
     * Lista dos personagens existentes;
     */
    ArrayList<Personagem> personagens = new ArrayList<>();

    /**
     * Scanner utilizado em toda a class PoW;
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Construtor encarregue de criar as 15 personagens do nosso RPG.
     */
    public PoW() {
        criarPersonagens();
    }

    /**
     * Esta é a nossa main onde todos os nossos métodos são chamados, o
     * utilizador pode escolher o que pretende fazer através do menu.
     *
     * @param args args vazio
     */
    public static void main(String[] args) {

        PoW personagens = new PoW();

        char escolha;
        do {
            System.out.println("--------------------- Menu ---------------------");
            System.out.println("1 → Visualizar todas as personagens existentes;");
            System.out.println("2 → Visualizar todas as personagens com nível superior a 10;");
            System.out.println("3 → Visualizar todos os Guerreiros com Armadura, Magos com sementes de abóbora e Mercenários com arcos;");
            System.out.println("4 → Visualizar estatísticas de um personagem;");
            System.out.println("5 → Subir níveis de personagens;");
            System.out.println("6 → Fechar o jogo.");
            System.out.print("> ");
            escolha = sc.next().charAt(0);

            switch (escolha) {
                case '1':
                    personagens.imprimirPersonagens();
                    break;
                case '2':
                    personagens.nivelSuperior();
                    break;
                case '3':
                    personagens.personagensComItens();
                    break;
                case '4':
                    personagens.estatisticasPersonagem();
                    break;
                case '5':
                    personagens.subirNivelPersonagens();
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

    /**
     * Este método gera aleatóriamente um número que vai corresponder ao nível de um personagem.
     * @param max Nível máximo com que o personagem pode ser gerado
     * @return Número aleatório entre 1 e max
     */
    private int nivelRandom(int max) {
        return new Random().nextInt(max) + 1;
    }

    /**
     * Método que cria os nossos personagens.
     */
    private void criarPersonagens() {
        for (int i = 1; i <= 5; i++) {
            personagens.add(new Guerreiro("Guerreiro " + i, nivelRandom(25), new String[] {"Espada", "Machado", "Faca"}, (int) (Math.random() * 2) == 1));
            personagens.add(new Mago("Mago " + i, nivelRandom(25)));
            personagens.add(new Mercenario("Mercenário " + i, nivelRandom(25), new String[] {"Arco", "Pistola", "Pedras"}, (int) (Math.random() * 20) + 5));
        }

        for(Personagem personagem: personagens) {
            if(personagem.getNivel() != 1) {
                personagem.subirNivel(personagem.getNivel());
            }
        }
    }

    /**
     * Método responsável pela impressão da tabela de personagens.
     */
    private void imprimirPersonagens() {
        System.out.println("\n------------------------------------ Tabela de Personagens ------------------------------------");
        System.out.printf("| %-16s | %-15s | %-16s | %-16s | %-16s |\n", "Nome", "Nível", "Força", "Agilidade", "Inteligência");
        for (Personagem personagem : personagens) {
            System.out.printf("| %-16s | %-15d | %-16.2f | %-16.2f | %-16.2f |\n", personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    /**
     * Neste método é feita a tabela de personagens com nível superio a 10.
     */
    private void nivelSuperior() {
        System.out.println("\n------------------------------- Personagens Nível Superior a 10 -------------------------------");
        System.out.printf("| %-16s | %-15s | %-16s | %-16s | %-16s |\n", "Nome", "Nível", "Força", "Agilidade", "Inteligência");
        for (Personagem personagem : personagens) {
            if (personagem.getNivel() > 10) {
                System.out.printf("| %-16s | %-15d | %-16.2f | %-16.2f | %-16.2f |\n", personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    /**
     * A tabela de personagens com certos itens vai ser gerada neste método, como por exemplo:
     * Guerreiros com Armadura;
     * Magos com Sementes de Abóbora na sua mochila;
     * Mercenários com Arco.
     */
    private void personagensComItens() {
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

    /**
     * No seguinte método o utilizador pode escolher um dos
     * personagens para inspecionar as suas estatísticas.
     */
    private void estatisticasPersonagem() {
        Personagem personagem = encontrarPersonagem();

        if(personagem != null) {
            System.out.print("\n");
            switch (personagem) {
                case Guerreiro guerreiro -> {
                    System.out.println(guerreiro);
                }case Mago mago -> {
                    System.out.println(mago);
                }case Mercenario mercenario -> {
                    System.out.println(mercenario);
                }default -> {}
            }
            System.out.print("\n");
        }else {
            System.out.println("\nPersonagem não encontrado!\n");
        }
    }

    /**
     * Método encarregado de subir o nível dos personagens, neste método temos duas hipóteses subir uma quantidade de níveis x de:
     * Um personagem em concreto;
     * Todos os personagens existentes.
     */
    private void subirNivelPersonagens() {
        char escolha;
        do {
            System.out.println("--------------------- Menu de Subir Niveis ---------------------");
            System.out.println("1 → Subir nível de apenas um personagem;");
            System.out.println("2 → Subir nível de todos os personagens;");
            System.out.println("3 → Voltar ao menu principal.");
            System.out.print("> ");

            escolha = sc.next().charAt(0);
            sc.nextLine();

            if(Character.isDigit(escolha) && escolha >= '1' && escolha < '3') {
                System.out.print("\nQuantos níveis quer subir: ");
                String niveis = sc.nextLine();

                for(int n = 0; n < niveis.length(); n++) {
                    if(!Character.isDigit(niveis.charAt(n))) {
                        niveis = "0";
                        break;
                    }
                }

                if (Integer.parseInt(niveis) > 0) {
                    switch (escolha) {
                        case '1':
                            Personagem personagem = encontrarPersonagem();
                            if (personagem != null) {
                                System.out.printf("\n%s antes de subir de nível:\nNível: %d\nForça: %.2f\nAgilidade: %.2f\nInteligência: %.2f\n", personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
                                personagem.subirNivel(Integer.parseInt(niveis));
                                personagem.setNivel(personagem.getNivel() + Integer.parseInt(niveis));
                                System.out.printf("\n%s depois de subir de nível:\nNível: %d\nForça: %.2f\nAgilidade: %.2f\nInteligência: %.2f\n", personagem.getNome(), personagem.getNivel(), personagem.getForca(), personagem.getAgilidade(), personagem.getInteligencia());
                            } else {
                                System.out.println("\nPersonagem não encontrado!\n");
                            }
                            break;
                        case '2':
                            System.out.println("\nPersonagens antes subir o nível:");
                            imprimirPersonagens();
                            for (Personagem p : personagens) {
                                p.subirNivel(Integer.parseInt(niveis));
                                p.setNivel(p.getNivel() + Integer.parseInt(niveis));
                            }
                            System.out.println("\nPersonagens após subir o nível:");
                            imprimirPersonagens();
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

    /**
     * Método incumbido de encontrar um personagem através do seu nome.
     * @return Retorna o personagem que o utilizador quer encontrar.
     */
    private Personagem encontrarPersonagem()  {
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