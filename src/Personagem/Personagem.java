package Personagem;

public class Personagem {
    private String nome;
    private int nivel;
    private double forca;
    private double agilidade;
    private double inteligencia;

    public Personagem(String nome, int nivel, double forca, double agilidade, double inteligencia) {
        this.nome = nome;
        this.nivel = nivel;
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
    }

    public String getNome() {
        return this.nome;
    }

    public void mudarNome(String nome) { this.nome = nome; };

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getForca() {
        return forca;
    }

    public void setForca(double forca) {
        this.forca = forca;
    }

    public double getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(double agilidade) {
        this.agilidade = agilidade;
    }

    public double getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(double inteligencia) {
        this.inteligencia = inteligencia;
    }


    @Override
    public String toString() {
        return "Nome: " + nome + "\nNível: " + nivel;
    }
}
