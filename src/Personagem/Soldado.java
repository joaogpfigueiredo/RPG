package Personagem;

public class Soldado extends  Personagem {
    private String arma;

    public Soldado(String nome, int nivel, double forca, double agilidade, double inteligencia, String arma) {
        super(nome, nivel, forca, agilidade, inteligencia);
        this.arma = arma;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public boolean temArma(String arma) {
        return (getArma().equals(arma));
    }
}
