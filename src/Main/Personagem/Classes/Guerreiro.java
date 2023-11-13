package Main.Personagem.Classes;

import Main.Personagem.Soldado;

/**
 * Subclasse Guerreiro da classe Soldado.
 */
public class Guerreiro extends Soldado {

    /**
     * Variável que irá guardar o valor true caso o guerreiro tenha armadura e false caso contrário;
     */
    private boolean Armadura;

    /**
     * Construtor da classe Guerreiro.
     *
     * @param nome Nome do guerreiro.
     * @param nivel Nível do guerreiro.
     * @param arma Array de strings que contém as opções de armas disponíveis para o guerreiro.
     * @param Armadura Indica se o guerreiro possui armadura.
     */
    public Guerreiro(String nome, int nivel, String[] arma, boolean Armadura) {
        super(nome, nivel, 10, 5, 3, arma);
        this.Armadura = Armadura;
    }

    /**
     * Verifica se o guerreiro possui armadura.
     *
     * @return true se o guerreiro tem armadura, false caso contrário.
     */
    public boolean temArmadura() {
        return this.Armadura;
    }

    /**
     * Remove a armadura do guerreiro.
     */
    public void removerArmadura() {
        this.Armadura = false;
    }

    /**
     * Aumenta o nível do guerreiro de acordo com a quantidade de níveis especificada.
     *
     * @param quantosNiveis Número de níveis a aumentar.
     */
    public void subirNivel(int quantosNiveis) {
        if (quantosNiveis != 1) {
            for (int i = 1; i < quantosNiveis; i++) {
                setForca(getForca() + (getForca() * 0.2));
                setAgilidade(getAgilidade() + (getAgilidade() * 0.1));
                setInteligencia(getInteligencia() + (getInteligencia() * 0.05));
            }
        } else {
            setForca(getForca() + (getForca() * 0.2));
            setAgilidade(getAgilidade() + (getAgilidade() * 0.1));
            setInteligencia(getInteligencia() + (getInteligencia() * 0.05));
        }
    }

    /**
     * Método toString() da classe Guerreiro.
     *
     * @return String que contém as estatísticas do guerreiro, se ele tem armadura e a arma que ele está a usar.
     */
    @Override
    public String toString() {
        return super.toString() + "\nGuerreiro" + (this.Armadura ? " com Armadura e " : " sem Armadura mas com ") + getArma();
    }
}
