package fr.iut.montreuil.R4_S02_2023.questionnaire.sme.mocks;

import entities.bo.QuestionFichierBO;
import models.IQuestionLoader;
import utilities.exceptions.FileFormatInvalidException;
import utilities.exceptions.FileQuestionEmptyException;

import java.io.FileNotFoundException;
import java.util.List;

public class ErreurQuestionnaireVideMock implements IQuestionLoader {
    @Override
    public List<QuestionFichierBO> chargementQuestionnaires(String filename) throws FileFormatInvalidException, FileQuestionEmptyException, FileNotFoundException {
        throw new FileQuestionEmptyException();
    }
}
