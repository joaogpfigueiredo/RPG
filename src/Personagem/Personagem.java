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
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int n) {
        this.nivel = n;
    }

    public double getForca() {
        return forca;
    }

    public void setForca(double f) {
        this.forca = f;
    }

    public double getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(double a) {
        this.agilidade = a;
    }


    public double getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(double i) {
        this.inteligencia = i;
    }


    @Override
    public String toString() {
        return "Nome: " + nome + "\nNível: " + nivel;
    }
}