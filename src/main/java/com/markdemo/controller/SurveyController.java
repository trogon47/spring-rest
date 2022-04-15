package com.markdemo.controller;

import com.markdemo.model.Question;
import com.markdemo.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}/questions")
    List<Question> retrieveQuestionsForService(@PathVariable String surveyId) {
        return surveyService.retrieveSurvey(surveyId).getQuestions();
    }

    @GetMapping("/surveys/{surveyId}/question/{questionId}")
    Question retrieveQuestionForSurvey(@PathVariable String surveyId,
                                       @PathVariable String questionId) {
        if (surveyId == null || questionId == null) {
            return null;
        }
        return surveyService.retrieveQuestion(surveyId, questionId);
    }
}
