package utilities.enums;

public enum Difficulte {
    Simple(1),
    Intermedaire(2),
    Expert(3);
    private int valeur;

    Difficulte(int valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }
}