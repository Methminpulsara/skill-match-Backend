package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void add(Employee employee) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public Employee search(Long id) {
        return null;
    }

    @Override
    public Employee searchByName(String name) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return List.of();
    }
}
