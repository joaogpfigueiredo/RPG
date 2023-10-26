package Personagem;

public class Guerreiro extends Personagem {
    private boolean temArmadura;
    private String arma;

    public Guerreiro(String nome, int nivel, boolean temArmadura) {
        super(nome, nivel, 10, 5, 3);
        this.temArmadura = temArmadura;
        armaGuerreiro();
    }

    private void armaGuerreiro() {
        int item = (int) (Math.random() * 3) + 1;
        switch (item) {
            case 1:
                this.arma = "Espada";
                break;
            case 2:
                this.arma = "Faca";
                break;
            case 3:
                this.arma = "Machado";
                break;
            default:
                break;
        }
    }

    public boolean temArmadura() {
        return this.temArmadura;
    }

    @Override
    public String toString() {
        return super.toString() + "\nGuerreiro" + (temArmadura ? " com Armadura e " : " sem Armadura mas com ") + arma;
    }
}