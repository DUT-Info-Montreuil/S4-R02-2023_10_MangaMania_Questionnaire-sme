package entities.bo;

import java.util.Objects;

public class QuestionFichierBO {
    private int Id;
    private int num;
    private String langue;
    private String libelle;
    private String réponse;
    private int difficulte;
    private String explication;
    private String reference;

    public QuestionFichierBO(int id, int num, String langue, String libelle, String réponse, int difficulte, String explication, String reference) {
        Id = id;
        this.num = num;
        this.langue = langue;
        this.libelle = libelle;
        this.réponse = réponse;
        this.difficulte = difficulte;
        this.explication = explication;
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionFichierBO that = (QuestionFichierBO) o;
        return Id == that.Id && num == that.num && difficulte == that.difficulte && langue.equals(that.langue) && libelle.equals(that.libelle) && réponse.equals(that.réponse) && explication.equals(that.explication) && reference.equals(that.reference);
    }

}
