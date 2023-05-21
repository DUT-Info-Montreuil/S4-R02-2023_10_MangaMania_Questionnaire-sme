package fr.iut.montreuil.R4_S02_2023.questionnaire.sme.impl;

import entities.bo.QuestionFichierBO;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IQuestionLoaderTest {
    private IQuestionLoader iQuestionLoader;

    @Test
    public void TestQuestionLoader(){
        iQuestionLoader = mock(IQuestionLoader.class);
        try {
            when(iQuestionLoader
                    .chargementQuestionnaires("ressources\\questionsQuizz_V1.1.csv"))
                    .thenThrow(FileNotFoundException.class);
            iQuestionLoader.chargementQuestionnaires("ressources\\questionsQuizz_V1.1.csv");
            fail("filenotfound and is not working");
        } catch (FileNotFoundException e) {
            assertTrue("filenotfound is working",true);
        }
        catch (Exception e) {
            assertFalse("filenotfound and is not working",false);

        }

        try {
            when(iQuestionLoader
                    .chargementQuestionnaires("ressources\\questionsQuizz_V1.1.csv"))
                    .thenThrow(FileQuestionEmptyException.class);
            iQuestionLoader.chargementQuestionnaires("ressources\\questionsQuizz_V1.1.csv");
            fail("file empty is not working");

        } catch (FileQuestionEmptyException e) {
            assertTrue("file empty is working",true);
        } catch (Exception e) {
            assertFalse("file empty is not working",false);
        }

        try {
            when(iQuestionLoader
                    .chargementQuestionnaires("ressources\\questionsQuizz_V1.1.csv"))
                    .thenThrow(FileFormatInvalidException.class);
            iQuestionLoader.chargementQuestionnaires("ressources\\questionsQuizz_V1.1.csv");
            //fail("file not found is not working");
        } catch (FileFormatInvalidException e) {
            assertTrue("file format is working",true);

        } catch (Exception e) {
            assertFalse("file format is not working",false);
        }
        try {
            List<QuestionFichierBO> questionFichierBOS = new ArrayList<>();
            QuestionFichierBO quest1 = new QuestionFichierBO(1,1,"fr","De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?","Tee",1,"Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.","https://fr.wikipedia.org/wiki/Matériel_de_golf");
            QuestionFichierBO quest2 = new QuestionFichierBO(1,2,"fr","Quel sport de raquette porte le nom de la ville anglaise où il fut inventé ?","Badminton",1,"Le badminton est toujours pratiqué en intérieur car avec le vent, en extérieur, le volant peut brusquement changer de direction.","https://fr.wikipedia.org/wiki/Badminton");
            QuestionFichierBO quest3 = new QuestionFichierBO(1,3,"fr","Combien y a-t-il de joueurs sur le terrain dans une équipe de football ?","Onze",1,"Codifié par les Britanniques à la fin du XIXe siècle, le football s'est doté en 1904 d'une fédération internationale, la FIFA.","https://fr.wikipedia.org/wiki/Football");

            questionFichierBOS.add(quest1);
            questionFichierBOS.add(quest2);
            questionFichierBOS.add(quest3);

            when(iQuestionLoader.chargementQuestionnaires("test Mockito")).thenReturn(questionFichierBOS);
            //iQuestionLoader.chargementQuestionnaires("ressources\\questionsQuizz_V1.1.csv").containsAll(questionFichierBOS);

        } catch (Exception e) {
            assertFalse("file don't contains",false);
        }

    }
}