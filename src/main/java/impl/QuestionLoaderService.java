package impl;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.exceptions.CsvException;
import utilities.exceptions.FileFormatInvalidException;
import utilities.exceptions.FileQuestionEmptyException;
import entities.bo.QuestionFichierBO;
import models.IQuestionLoader;

import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class QuestionLoaderService implements IQuestionLoader {
    @Override
    public List<QuestionFichierBO> chargementQuestionnaires(String filename)
            throws FileNotFoundException, FileFormatInvalidException, FileQuestionEmptyException {
        List<QuestionFichierBO> questions = new ArrayList<>();
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        try{
            CSVReader reader = new CSVReaderBuilder(new FileReader(filename)).withCSVParser(csvParser).build();
            List<String[]> rows = manageParsError(reader.readAll());
            for (String[] row : rows) {
                QuestionFichierBO question = new QuestionFichierBO(Integer.parseInt(row[0]),Integer.parseInt(row[1]),row[2],row[3],row[4],Integer.parseInt(row[5]),row[6],row[7]);
                questions.add(question);
            }
        }catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (FileQuestionEmptyException e) {
            throw new FileQuestionEmptyException();
        }catch (Exception e) {
            throw new FileFormatInvalidException();
        }

        return questions;
    }

    private List<String[]> manageParsError(List<String[]> rows) throws FileQuestionEmptyException{
        if(rows.isEmpty())
            throw new FileQuestionEmptyException();

        if(rows.get(0)[0].contains("\uFEFF"))
            rows.get(0)[0] = rows.get(0)[0].replace("\uFEFF","");

        if(rows.get(0)[0].equals(""))
            throw new FileQuestionEmptyException();
        return rows;
    }
}
