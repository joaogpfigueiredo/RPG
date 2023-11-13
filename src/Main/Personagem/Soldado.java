package Main.Personagem;

/**
 * Subclasse da classe Personagem que representa um guerreiro ou mercenário.
 */
public abstract class Soldado extends Personagem {

    /**
     * Variável que irá guardar a arma do personagem;
     */
    private String arma;

    /**
     * Construtor da classe Soldado.
     *
     * @param nome Nome do soldado.
     * @param nivel Nível do soldado.
     * @param forca Força do soldado.
     * @param agilidade Agilidade do soldado.
     * @param inteligencia Inteligência do soldado.
     * @param armas Array de strings que possui as opções de armas disponíveis para o personagem.
     */
    public Soldado(String nome, int nivel, double forca, double agilidade, double inteligencia, String[] armas) {
        super(nome, nivel, forca, agilidade, inteligencia);
        this.arma = escolherArma(armas);
    }

    /**
     * Retorna a arma do personagem em questão.
     *
     * @return Arma do personagem.
     */
    public String getArma() {
        return arma;
    }

    /**
     * Define a arma do personagem.
     *
     * @param arma Nova arma do personagem.
     */
    public void setArma(String arma) {
        this.arma = arma;
    }

    /**
     * Escolhe aleatoriamente uma arma do array de opções de armas.
     *
     * @param armas Um array de strings que contém as opções de armas disponíveis.
     * @return Arma escolhida aleatoriamente.
     */
    public String escolherArma(String[] armas) {
        int index = (int) (Math.random() * armas.length);
        return armas[index];
    }

    /**
     * Verifica se o personagem tem uma arma específica.
     *
     * @param arma Arma a ser verificada.
     * @return true se o soldado possui a arma, false caso contrário.
     */
    public boolean temArma(String arma) {
        return getArma().equals(arma);
    }

    /**
     * Método abstrato para aumentar o nível do personagem.
     *
     * @param quantosNiveis Número de níveis a aumentar.
     */
    public abstract void subirNivel(int quantosNiveis);
}
