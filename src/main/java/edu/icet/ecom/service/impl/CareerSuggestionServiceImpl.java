package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.CareerSuggestion;
import edu.icet.ecom.entity.CareerSuggestionEntity;
import edu.icet.ecom.entity.EmployeeEntity;
import edu.icet.ecom.entity.SkillEntity;
import edu.icet.ecom.repository.CareerSuggestionRepository;
import edu.icet.ecom.repository.EmployeeDto;
import edu.icet.ecom.service.CareerSuggestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CareerSuggestionServiceImpl implements CareerSuggestionService {

    private final CareerSuggestionRepository repository;
    private final EmployeeDto employeeRepository;
    private final ModelMapper mapper;


    @Override
    public List<CareerSuggestion> careerSuggestions(Long employeeId) {
        // Fetch the employee by ID
        EmployeeEntity employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Extract skill names from the employee's skills
        List<String> skillNames = employee.getSkills().stream()
                .map(SkillEntity::getName)
                .collect(Collectors.toList());

        // Query the database for matching career suggestions
        List<CareerSuggestionEntity> suggestions = repository.findSuggestionsByEmployeeSkills(skillNames);

        // Convert the entity list to DTO list using ModelMapper
        return suggestions.stream()
                .map(suggestion -> mapper.map(suggestion, CareerSuggestion.class))
                .collect(Collectors.toList());
    }
}