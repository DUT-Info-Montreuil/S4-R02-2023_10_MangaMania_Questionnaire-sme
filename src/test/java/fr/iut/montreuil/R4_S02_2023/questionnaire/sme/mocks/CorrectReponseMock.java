package fr.iut.montreuil.R4_S02_2023.questionnaire.sme.mocks;

import entities.bo.QuestionFichierBO;
import models.IQuestionLoader;
import utilities.exceptions.FileFormatInvalidException;
import utilities.exceptions.FileQuestionEmptyException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CorrectReponseMock implements IQuestionLoader {
    @Override
    public List<QuestionFichierBO> chargementQuestionnaires(String filename) throws FileFormatInvalidException, FileQuestionEmptyException, FileNotFoundException {
        List<QuestionFichierBO> questionFichierBOS = new ArrayList<>();
        QuestionFichierBO quest1 = new QuestionFichierBO(1,1,"fr","De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?","Tee",1,"Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.","https://fr.wikipedia.org/wiki/Matériel_de_golf");
        QuestionFichierBO quest2 = new QuestionFichierBO(1,2,"fr","Quel sport de raquette porte le nom de la ville anglaise où il fut inventé ?","Badminton",1,"Le badminton est toujours pratiqué en intérieur car avec le vent, en extérieur, le volant peut brusquement changer de direction.","https://fr.wikipedia.org/wiki/Badminton");
        QuestionFichierBO quest3 = new QuestionFichierBO(1,3,"fr","Combien y a-t-il de joueurs sur le terrain dans une équipe de football ?","Onze",1,"Codifié par les Britanniques à la fin du XIXe siècle, le football s'est doté en 1904 d'une fédération internationale, la FIFA.","https://fr.wikipedia.org/wiki/Football");

        questionFichierBOS.add(quest1);
        questionFichierBOS.add(quest2);
        questionFichierBOS.add(quest3);

        return questionFichierBOS;
    }
}
