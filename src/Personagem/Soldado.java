package Personagem;

public abstract class Soldado extends Personagem {
    private String arma;

    public Soldado(String nome, int nivel, double forca, double agilidade, double inteligencia, String[] armas) {
        super(nome, nivel, forca, agilidade, inteligencia);
        this.arma = escolherArma(armas);
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String escolherArma(String[] armas) {
        int index = (int) (Math.random() * armas.length);
        return armas[index];
    }

    public boolean temArma(String arma) {
        return (getArma().equals(arma));
    }

    public abstract void subirNivel(int quantosNiveis);
}
