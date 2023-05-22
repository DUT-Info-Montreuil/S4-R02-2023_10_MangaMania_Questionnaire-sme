package fr.iut.montreuil.R4_S02_2023.questionnaire.sme.impl;

import entities.bo.QuestionFichierBO;
import impl.QuestionLoaderService;
import models.IQuestionLoader;
import org.junit.jupiter.api.Test;
import utilities.exceptions.FileFormatInvalidException;
import utilities.exceptions.FileQuestionEmptyException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;

public class IQuestionLoaderTest {
    private IQuestionLoader questionLoaderService;

    @Test
    public void TestFilepath() {
//        //ERROR PATH
        assertThrows(FileNotFoundException.class, () -> {
            QuestionLoaderService questionLoaderService = new QuestionLoaderService();
            questionLoaderService.chargementQuestionnaires("toto");
        });
    }
    @Test
    public void testEmptyFile() {
        //TEST EMPTY FILE
        assertThrows(FileQuestionEmptyException.class, () -> {
            QuestionLoaderService questionLoaderService = new QuestionLoaderService();
            questionLoaderService.chargementQuestionnaires("src\\test\\java\\fr\\iut\\montreuil\\R4_S02_2023\\questionnaire\\sme\\ressources\\questionsQuizz_vide.csv");
        });
    }

    @Test
    public void fileFormat () {
        //FORMAT INVALIDE

        assertThrows(FileFormatInvalidException.class, () -> {
            QuestionLoaderService questionLoaderService = new QuestionLoaderService();
            questionLoaderService.chargementQuestionnaires("src\\test\\java\\fr\\iut\\montreuil\\R4_S02_2023\\questionnaire\\sme\\ressources\\FormatErrorQuestionsQuizz_V1.1.csv");
        });

    }
    @Test
    public void testDeaultQuestion(){
        //TEST OK
        try {
            List<QuestionFichierBO> questionFichierBOS = new ArrayList<>();
            QuestionFichierBO quest1 = new QuestionFichierBO(1,1,"fr","De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?","Tee",1,"Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.","https://fr.wikipedia.org/wiki/Matériel_de_golf");
            QuestionFichierBO quest2 = new QuestionFichierBO(1,2,"fr","Quel sport de raquette porte le nom de la ville anglaise où il fut inventé ?","Badminton",1,"Le badminton est toujours pratiqué en intérieur car avec le vent, en extérieur, le volant peut brusquement changer de direction.","https://fr.wikipedia.org/wiki/Badminton");
            QuestionFichierBO quest3 = new QuestionFichierBO(1,3,"fr","Combien y a-t-il de joueurs sur le terrain dans une équipe de football ?","Onze",1,"Codifié par les Britanniques à la fin du XIXe siècle, le football s'est doté en 1904 d'une fédération internationale, la FIFA.","https://fr.wikipedia.org/wiki/Football");

            questionLoaderService = new QuestionLoaderService();
            questionFichierBOS = questionLoaderService.chargementQuestionnaires("src\\test\\java\\fr\\iut\\montreuil\\R4_S02_2023\\questionnaire\\sme\\ressources\\questionsQuizz_V1.1.csv");
            assertEquals(questionFichierBOS.get(0), quest1);
            assertEquals(questionFichierBOS.get(1), quest2);
            assertEquals(questionFichierBOS.get(2), quest3);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}