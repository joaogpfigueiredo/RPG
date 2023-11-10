package Personagem.Classes;

import Personagem.Personagem;

import java.util.ArrayList;
import java.util.Random;

public class Mago extends Personagem {
    private ArrayList<String> mochila = new ArrayList<>();

    public Mago(String nome, int nivel) {
        super(nome, nivel, 2, 4, 9);
        this.mochila = mochilaItens();
    }

    private ArrayList<String> mochilaItens() {
        Random random = new Random();
        int quantidade = random.nextInt(6) + 1;
        ArrayList<String> moch = new ArrayList<>();
        String[] itens = {"Sementes de Abóbora", "Sementes de Girasol", "Sementes de Sésamo", "Folhas de Acácia", "Folhas de Acônito", "Folhas de Verbena"};

        while (moch.size() < quantidade) {
            int item = random.nextInt(itens.length);
            if (!moch.contains(itens[item])) {
                moch.add(itens[item]);
            }
        }
        return moch;
    }

    public ArrayList<String> getItensMochila() {
        return this.mochila;
    }

    public void addItemMochila(String item) {
        this.mochila.add(item);
    }

    public void removerItemMochila(String item) {
        this.mochila.remove(item);
    }

    public boolean temItemNaMochila(String item) {
        return getItensMochila().contains(item);
    }

    public void subirNivel(int quantosNiveis) {
        setForca(getForca() * (1.05 * quantosNiveis));
        setAgilidade(getAgilidade() * (1.1 * quantosNiveis));
        setInteligencia(getInteligencia() * (1.2 * quantosNiveis));
        setNivel(getNivel() + quantosNiveis);
    }

    @Override
    public String toString() {
        return super.toString() + "\nA mochila deste mago" + (mochila.isEmpty() ? " está vazia!": " contém: " + getItensMochila());
    }
}
