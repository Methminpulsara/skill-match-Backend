package edu.icet.ecom.service;

import edu.icet.ecom.dto.CareerSuggestion;
import java.util.List;


public interface CareerSuggestionService {
  List<CareerSuggestion> careerSuggestions(Long employeeId);
}
