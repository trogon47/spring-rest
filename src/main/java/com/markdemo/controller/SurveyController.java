package com.markdemo.controller;

import com.markdemo.model.Question;
import com.markdemo.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}/questions")
    List<Question> retrieveQuestionsForService(@PathVariable String surveyId) {
        return surveyService.retrieveSurvey(surveyId).getQuestions();
    }

    @PostMapping("/surveys/{surveyId}/questions")
    ResponseEntity<Void> createQuestionForService(@PathVariable String surveyId,
    @RequestBody Question newQuestion) {
       Question question =  surveyService.addQuestion(surveyId, newQuestion);

       if (question == null) {
           return ResponseEntity.badRequest().build();
       }
        URI createdLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(question.getId()).toUri();
        return ResponseEntity.created(createdLocation).build();
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
