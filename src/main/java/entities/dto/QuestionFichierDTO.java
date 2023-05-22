package entities.dto;

import utilities.enums.Difficulte;

public class QuestionFichierDTO {
        private int Id;
        private int num;
        private String langue;
        private String libelle;
        private String réponse;
        private Difficulte difficulte;
        private String explication;
        private String reference;

        public QuestionFichierDTO(int id, int num, String langue, String libelle, String réponse, int difficulte, String explication, String reference) {
                Id = id;
                this.num = num;
                this.langue = langue;
                this.libelle = libelle;
                this.réponse = réponse;
                this.difficulte = Difficulte.valueOf(String.valueOf(difficulte));
                this.explication = explication;
                this.reference = reference;
        }

        public int getId() {
                return Id;
        }

        public void setId(int id) {
                Id = id;
        }

        public int getNum() {
                return num;
        }

        public void setNum(int num) {
                this.num = num;
        }

        public String getLangue() {
                return langue;
        }

        public void setLangue(String langue) {
                this.langue = langue;
        }

        public String getLibelle() {
                return libelle;
        }

        public void setLibelle(String libelle) {
                this.libelle = libelle;
        }

        public String getRéponse() {
                return réponse;
        }

        public void setRéponse(String réponse) {
                this.réponse = réponse;
        }

        public Difficulte getDifficulte() {
                return difficulte;
        }

        public void setDifficulte(Difficulte difficulte) {
                this.difficulte = difficulte;
        }

        public String getExplication() {
                return explication;
        }

        public void setExplication(String explication) {
                this.explication = explication;
        }

        public String getReference() {
                return reference;
        }

        public void setReference(String reference) {
                this.reference = reference;
        }
}
