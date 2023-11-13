package Main.Personagem.Classes;

import Main.Personagem.Personagem;

import java.util.ArrayList;
import java.util.Random;

/**
 * Sublasse Mago da classe de Personagem.
 */
public class Mago extends Personagem {

    /**
     * ArrayList que irá servir de mochila e guardar os itens do mago;
     */
    private ArrayList<String> mochila = new ArrayList<>();

    /**
     * Construtor da classe Mago.
     *
     * @param nome  Nome do mago.
     * @param nivel Nível do mago.
     */
    public Mago(String nome, int nivel) {
        super(nome, nivel, 2, 4, 9);
        this.mochila = mochilaItens();
    }

    /**
     * Gera aleatoriamente itens para a mochila do mago.
     *
     * @return Uma ArrayList de strings contendo os itens na mochila do mago.
     */
    private ArrayList<String> mochilaItens() {
        Random random = new Random();
        int quantidade = random.nextInt(6) + 1;
        ArrayList<String> moch = new ArrayList<>();
        String[] itens = {"Sementes de Abóbora", "Sementes de Girassol", "Sementes de Sésamo", "Folhas de Acácia", "Folhas de Acônito", "Folhas de Verbena"};

        while (moch.size() < quantidade) {
            int item = random.nextInt(itens.length);
            if (!moch.contains(itens[item])) {
                moch.add(itens[item]);
            }
        }
        return moch;
    }

    /**
     * Retorna o ArrayList com os itens que o mago tem.
     *
     * @return ArrayList de strings que possui os itens presentes na mochila do mago.
     */
    public ArrayList<String> getItensMochila() {
        return this.mochila;
    }

    /**
     * Adiciona um item à mochila do mago em questão.
     *
     * @param item Item a ser adicionado à mochila.
     */
    public void addItemMochila(String item) {
        this.mochila.add(item);
    }

    /**
     * Remove um item da mochila do mgo em questão.
     *
     * @param item Item a ser removido da mochila.
     */
    public void removerItemMochila(String item) {
        this.mochila.remove(item);
    }

    /**
     * Verifica se um item está na mochila do mago.
     *
     * @param item Item a ser verificado.
     * @return true se o item está na mochila, false caso contrário.
     */
    public boolean temItemNaMochila(String item) {
        return getItensMochila().contains(item);
    }

    /**
     * Aumenta o nível do mago de acordo com a quantidade de níveis especificada.
     *
     * @param quantosNiveis Número de níveis a aumentar.
     */
    public void subirNivel(int quantosNiveis) {
        if (quantosNiveis != 1) {
            for (int i = 1; i < quantosNiveis; i++) {
                setForca(getForca() + (getForca() * 0.05));
                setAgilidade(getAgilidade() + (getAgilidade() * 0.1));
                setInteligencia(getInteligencia() + (getInteligencia() * 0.2));
            }
        } else {
            setForca(getForca() + (getForca() * 0.05));
            setAgilidade(getAgilidade() + (getAgilidade() * 0.1));
            setInteligencia(getInteligencia() + (getInteligencia() * 0.2));
        }
    }

    /**
     * Método toString() da classe Mago.
     *
     * @return String que contém as estatísticas do mago, e todos os itens disponiveis na sua mochila.
     */
    @Override
    public String toString() {
        return super.toString() + "\nA mochila deste mago" + (mochila.isEmpty() ? " está vazia!" : " contém: " + getItensMochila());
    }
}
