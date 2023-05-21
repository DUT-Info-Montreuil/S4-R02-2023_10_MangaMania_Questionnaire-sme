package entities.bo;

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
}
