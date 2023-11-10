package Personagem.Classes;

import Personagem.Soldado;

public class Guerreiro extends Soldado {
    private boolean Armadura;

    public Guerreiro(String nome, int nivel, String[] arma, boolean Armadura) {
        super(nome, nivel, 10, 5, 3, arma);
        this.Armadura = Armadura;
    }

    public boolean temArmadura() {
        return this.Armadura;
    }

    public void removerArmadura() {
        this.Armadura = false;
    }

    public void subirNivel(int quantosNiveis) {
        setForca(getForca() * (1.2 * quantosNiveis));
        setAgilidade(getAgilidade() * (1.1 * quantosNiveis));
        setInteligencia(getInteligencia() * (1.05 * quantosNiveis));
        setNivel(getNivel() + quantosNiveis);
    }

    @Override
    public String toString() {
        return super.toString() + "\nGuerreiro" + (this.Armadura ? " com Armadura e " : " sem Armadura mas com ") + getArma();
    }
}