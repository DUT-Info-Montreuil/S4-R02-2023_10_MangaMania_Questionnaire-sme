package fr.iut.montreuil.R4_S02_2023.questionnaire_sme.mocks;

import entities.bo.QuestionFichierBO;
import models.IQuestionLoader;
import utilities.exceptions.FileFormatInvalidException;
import utilities.exceptions.FileQuestionEmptyException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ErreurChargementfichiers implements IQuestionLoader {


    @Override
    public List<QuestionFichierBO> chargementQuestionnaires(String filename) throws FileFormatInvalidException, FileQuestionEmptyException, FileNotFoundException {
        if (filename.equals(null))
            throw new FileNotFoundException();
        boolean canRead = verifierLectureCSV(filename);

        if (canRead)
            throw new FileFormatInvalidException();
        else
            return null;
    }
    public static boolean verifierLectureCSV(String nomFichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
            String ligne = reader.readLine();
            return ligne != null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}