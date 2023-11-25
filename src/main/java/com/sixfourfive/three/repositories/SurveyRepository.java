package com.sixfourfive.three.repositories;

import com.sixfourfive.three.entities.Survey;
import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, Integer> {
}
