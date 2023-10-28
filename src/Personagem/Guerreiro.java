package Personagem;

public class Guerreiro extends Soldado {
    private boolean Armadura;

    public Guerreiro(String nome, int nivel, String arma, boolean Armadura) {
        super(nome, nivel, 10, 5, 3, arma);
        this.Armadura = Armadura;
    }

    public boolean temArmadura() {
        return this.Armadura;
    }

    public void removeArmadura() {
        this.Armadura = false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nGuerreiro" + (this.Armadura ? " com Armadura e " : " sem Armadura mas com ") + getArma();
    }
}