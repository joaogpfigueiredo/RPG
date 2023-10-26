package Personagem;

import java.util.Random;

public class Mago extends Personagem {
    private String mochila;

    public Mago(String nome, int nivel) {
        super(nome, nivel, 2, 4, 9);
        mochilaItens();
    }

    private void mochilaItens() {
        int item = (int) (Math.random() * 6) + 1;
        switch (item) {
            case 1:
                this.mochila = "Sementes de Abóbora";
                break;
            case 2:
                this.mochila = "Sementes de Girasol";
                break;
            case 3:
                this.mochila = "Sementes de Sésamo";
                break;
            case 4:
                this.mochila = "Folhas de Acácia";
                break;
            case 5:
                this.mochila = "Folhas de Acônito";
                break;
            case 6:
                this.mochila = "Folhas de Verbena";
                break;
            default:
                break;
        }
    }

    public String getItensMochila() {
        return  this.mochila;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMago com mochila de " + mochila;
    }
}
