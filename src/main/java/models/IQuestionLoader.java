package models;

import entities.bo.QuestionFichierBO;
import utilities.exceptions.FileFormatInvalidException;
import utilities.exceptions.FileQuestionEmptyException;

import java.io.FileNotFoundException;
import java.util.List;

public interface IQuestionLoader {
    public List<QuestionFichierBO> chargementQuestionnaires(String filename) throws
             FileFormatInvalidException, FileQuestionEmptyException, FileNotFoundException;
}
