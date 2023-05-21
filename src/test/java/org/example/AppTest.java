package org.example;

import entities.bo.QuestionFichierBO;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import models.IQuestionLoader;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.exceptions.FileFormatInvalidException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    private IQuestionLoader iQuestionLoader;

    /**
     * Rigourous Test 🙂
     */
    public void testApp()
    {
        try {
            iQuestionLoader = mock(IQuestionLoader.class);
            List<QuestionFichierBO> questionFichierBOS = new ArrayList<>();
            when(iQuestionLoader.chargementQuestionnaires("test Mockito")).thenReturn(questionFichierBOS);
        } catch (Exception e) {
        }

        try {
            when(iQuestionLoader
                    .chargementQuestionnaires("fakePath\\thisFileDontExist"))
                    .thenThrow(FileNotFoundException.class);

            iQuestionLoader.chargementQuestionnaires("fakePath\\thisFileDontExist");
            fail("filenotfound is not working");
        } catch (Exception e) {
            assertTrue("filenotfound is working",true);
        }
    }
}