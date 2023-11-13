package Main.Personagem.Classes;

import Main.Personagem.Soldado;

/**
 * Sublasse Mercenário da classe de Soldado.
 */
public class Mercenario extends Soldado {

    /**
     * Variável que irá guardar a quantidade de munições do mercenário;
     */
    private int municoes;

    /**
     * Construtor da classe Mercenario.
     *
     * @param nome      Nome do mercenário.
     * @param nivel     Nível do mercenário.
     * @param arma      Array de strings que contém as opções de armas disponíveis para o mercenário.
     * @param municoes  Número de munições inicial do mercenário.
     */
    public Mercenario(String nome, int nivel, String[] arma, int municoes) {
        super(nome, nivel, 4, 10, 4, arma);
        this.municoes = municoes;
    }

    /**
     * Retorna o número de munições do mercenário em questão.
     *
     * @return Número de munições do mercenário.
     */
    public int getMunicoes() {
        return municoes;
    }

    /**
     * Define o número de munições do mercenário em questão.
     *
     * @param municoes Novo número de munições do mercenário.
     */
    public void setMunicoes(int municoes) {
        this.municoes = municoes;
    }

    /**
     * Adiciona mais munições ao mercenário em questão.
     *
     * @param municoesExtra Número adicional de munições a serem adicionadas.
     */
    public void addMunicoes(int municoesExtra) {
        this.municoes += municoesExtra;
    }

    /**
     * Aumenta o nível do mercenário de acordo com a quantidade de níveis especificada.
     *
     * @param quantosNiveis Número de níveis a aumentar.
     */
    public void subirNivel(int quantosNiveis) {
        if (quantosNiveis != 1) {
            for (int i = 1; i < quantosNiveis; i++) {
                setForca(getForca() + (getForca() * 0.08));
                setAgilidade(getAgilidade() + (getAgilidade() * 0.2));
                setInteligencia(getInteligencia() + (getInteligencia() * 0.08));
            }
        } else {
            setForca(getForca() + (getForca() * 0.08));
            setAgilidade(getAgilidade() + (getAgilidade() * 0.2));
            setInteligencia(getInteligencia() + (getInteligencia() * 0.08));
        }
    }

    /**
     * Método toString() da classe Mago.
     *
     * @return String que contém as estatísticas do mago, e todos os itens disponiveis na sua mochila.
     */
    @Override
    public String toString() {
        return super.toString() + "\nMercenário com " + getArma() + ((this.municoes == 0) ? " mas não possui munições!" : " e " + municoes + " munições!");
    }
}

