package Personagem;

public class Mercenario extends Personagem {
    private String armaLonga;
    private int municoes;

    public Mercenario(String nome, int nivel, int municoes) {
        super(nome, nivel, 4, 10, 4);
        this.municoes = municoes;
        armaLongaMercenario();
    }

    private void armaLongaMercenario() {
        int item = (int) (Math.random() * 3) + 1;
        switch (item) {
            case 1:
                this.armaLonga = "Pedras";
                break;
            case 2:
                this.armaLonga = "Arco";
                break;
            case 3:
                this.armaLonga = "Pistola";
                break;
            default:
                break;
        }
    }

    public String getArmaLonga() {
        return this.armaLonga;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMercenário com arma " + armaLonga + " e " + municoes + " munições";
    }
}
