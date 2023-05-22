package models;

import entities.dto.QuestionnaireDTO;
import entities.dto.QuestionnaireStatistiqueDTO;

public interface IQuestionnaireStatistique {
    public QuestionnaireStatistiqueDTO majStatistiqueQuestionnaire(QuestionnaireDTO questionnnaireDTO);
    public QuestionnaireStatistiqueDTO recupeStatistiqueQuestionnaire(QuestionnaireDTO questionnnaireDTO);

}
