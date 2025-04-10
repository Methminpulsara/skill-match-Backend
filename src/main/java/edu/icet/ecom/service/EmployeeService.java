package edu.icet.ecom.service;

import edu.icet.ecom.dto.Employee;
import java.util.*;

public interface EmployeeService {

    void add (Employee employee);
    void delete(Long id);
    void update(Employee employee);
    Employee search(Long id);
    Employee searchByName(String name);
    List<Employee> getAll();
    Employee findByUserID(Long userID);

}
