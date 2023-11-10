package Personagem.Classes;

import Personagem.Soldado;

public class Mercenario extends Soldado {
    private int municoes;

    public Mercenario(String nome, int nivel, String[] arma, int municoes) {
        super(nome, nivel, 4, 10, 4, arma);
        this.municoes = municoes;
    }

    public int getMunicoes() {
        return municoes;
    }

    public void setMunicoes(int municoes) {
        this.municoes = municoes;
    }

    public void addMunicoes(int municoesExtra) { this.municoes += municoesExtra; }

    public void subirNivel(int quantosNiveis) {
        setForca(getForca() * (1.08 * quantosNiveis));
        setAgilidade(getAgilidade() * (1.2 * quantosNiveis));
        setInteligencia(getInteligencia() * (1.08 * quantosNiveis));
        setNivel(getNivel() + quantosNiveis);
    }

    @Override
    public String toString() {
        return super.toString() + "\nMercenário com " + getArma() + ((this.municoes == 0) ? " mas não possui munições!": " e " + municoes + " munições!");
    }
}
