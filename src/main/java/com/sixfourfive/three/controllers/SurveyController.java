package com.sixfourfive.three.controllers;

import com.sixfourfive.three.entities.Survey;
import com.sixfourfive.three.repositories.SurveyRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class SurveyController {
    private final SurveyRepository surveyRepository;

    public SurveyController(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewSurvey(@RequestBody Survey survey) {
        surveyRepository.save(survey);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @DeleteMapping(path = "/remove")
    public String deleteSurveyById(@RequestParam Integer surveyId) {
        surveyRepository.deleteById(surveyId);
        return "Deleted";
    }

    @PutMapping(path = "/update")
    public String updateSurveyById(@RequestParam Integer surveyId, @RequestBody Survey survey) {
        survey.setId(surveyId);
        surveyRepository.save(survey);
        return "Updated";
    }
}
