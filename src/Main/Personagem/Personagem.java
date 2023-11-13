package Main.Personagem;

/**
 * Classe gerenciadora das estatísticas dos personagens, como por exemplo força, agilidade, inteligência, etc...
 */

public abstract class Personagem {

    /**
     * Variável que irá guardar o nome do personagem;
     */
    private String nome;
    /**
     * Variável que irá guardar o nível do personagem;
     */
    private int nivel;
    /**
     * Variável que irá guardar a força do personagem;
     */
    private double forca;
    /**
     * Variável que irá guardar a agilidade do personagem;
     */
    private double agilidade;
    /**
     * Variável que irá guardar a inteligência do personagem;
     */
    private double inteligencia;

    /**
     * Construtor da classe Personagem.
     *
     * @param nome Nome do personagem.
     * @param nivel Nível do personagem.
     * @param forca Força do personagem.
     * @param agilidade Agilidade do personagem.
     * @param inteligencia Inteligência do personagem.
     */
    public Personagem(String nome, int nivel, double forca, double agilidade, double inteligencia) {
        this.nome = nome;
        this.nivel = nivel;
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
    }

    /**
     * Retorna o nome do personagem.
     *
     * @return Nome do personagem.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Altera o nome do personagem em questão.
     *
     * @param nome Novo nome do personagem.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nivel do personagem.
     *
     * @return Nível do personagem.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * O nível do personagem é substituido por um valor novo.
     *
     * @param nivel Novo nível do personagem.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Retorna a força do personagem.
     *
     * @return Força do personagem.
     */
    public double getForca() {
        return forca;
    }

    /**
     * Atribui um novo valor de força ao personagem.
     *
     * @param forca Nova força do personagem.
     */
    public void setForca(double forca) {
        this.forca = forca;
    }

    /**
     * Retorna a agilidade do personagem.
     *
     * @return Agilidade do personagem.
     */
    public double getAgilidade() {
        return agilidade;
    }

    /**
     * Define uma nova agilidade para o personagem.
     *
     * @param agilidade Nova agilidade do personagem.
     */
    public void setAgilidade(double agilidade) {
        this.agilidade = agilidade;
    }

    /**
     * Retorna a inteligência do personagem
     * Retorna a inteligência do personagem
     *
     * @return Inteligência do personagem.
     */
    public double getInteligencia() {
        return inteligencia;
    }

    /**
     * Define a inteligência do personagem.
     *
     * @param inteligencia Nova inteligência do personagem.
     */
    public void setInteligencia(double inteligencia) {
        this.inteligencia = inteligencia;
    }

    /**
     * Método abstrato para aumentar o nível do personagem.
     *
     * @param quantosNiveis Número de níveis a aumentar.
     */
    public abstract void subirNivel(int quantosNiveis);

    /**
     * Método toString() da classe Personagem.
     *
     * @return String que contém as estatísticas do personagem.
     */
    @Override
    public String toString() {
        return String.format("Nome: %s\nNível: %d\nForça: %.2f\nAgilidade: %.2f\nInteligência: %.2f", getNome(), getNivel(), getForca(), getAgilidade(), getInteligencia());
    }
}
