package entities.dto;

import entities.bo.QuestionFichierBO;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionnaireDTO {
    public List<QuestionFichierDTO> questionsDTO;
    public int[] questionsReussiteStats;
    public QuestionnaireStatistiqueDTO questionnaireStatistiqueDTO;

    public QuestionnaireDTO(List<QuestionFichierBO> questionsBO,int s) {
        this.questionsDTO = questionsBO.stream()
                .map((QuestionFichierBO x) -> new QuestionFichierDTO(x.getId(), x.getNum(), x.getLangue(), x.getLibelle(),
                        x.getRéponse(), x.getDifficulte(), x.getExplication(), x.getReference()))
                .collect(Collectors.toList());
        this.questionsReussiteStats = new int[questionsDTO.size()];
    }
    public QuestionnaireDTO(List<QuestionFichierDTO> questionsDTO) {
        this.questionsDTO = questionsDTO;
        this.questionsReussiteStats = new int[questionsDTO.size()];
    }

    public List<QuestionFichierDTO> getQuestionsDTO() {
        return questionsDTO;
    }

    public int[] getQuestionsReussiteStats() {
        return questionsReussiteStats;
    }
}
