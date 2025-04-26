package edu.icet.ecom.service;

import edu.icet.ecom.dto.Employee;
import java.util.*;

public interface EmployeeService {

    Employee add (Employee employee);
    void delete(Long id);
    void update(Employee employee);
    Employee search(Long id);
    Employee searchByName(String name);
    List<Employee> getAll(Long companyId);
    Employee findByUserID(Long userID);

    boolean updateProfileImage(Long employeeId, String profileImage);
}
