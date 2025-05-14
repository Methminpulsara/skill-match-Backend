package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.entity.EmployeeEntity;
import edu.icet.ecom.repository.EmployeeDto;
import edu.icet.ecom.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    private  final EmployeeDto dto;
    private final ModelMapper mapper;

    @Override
    public Employee add(Employee employee) {
        EmployeeEntity employeeEntity = mapper.map(employee, EmployeeEntity.class);
        employeeEntity = dto.save(employeeEntity);
        return mapper.map(employeeEntity, Employee.class);
    }

    @Override
    public void delete(Long id) {
        dto.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        dto.save(mapper.map(employee, EmployeeEntity.class));
    }

    @Override
    public Employee search(Long id) {
        return mapper.map(dto.findById(id),Employee.class);
    }

    @Override
    public Employee searchByName(String name) {
        return mapper.map(dto.findByName(name),Employee.class);
    }

    @Override
    public List<Employee> getAll(Long companyId) {
        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> all = dto.findAllByCompanyCompanyId(companyId);
        all.forEach(employeeEntity -> employeeList.add(mapper.map(employeeEntity,Employee.class)));
        return employeeList;
    }

    @Override
    public Employee findByUserID(Long userID) {
        return mapper.map(dto.findByUserUserId(userID),Employee.class);
    }

    @Override
    public Employee updateProfileImage(Long employeeId, String profileImage) {

        EmployeeEntity employee = dto.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setProfileImage(profileImage);
        dto.save(employee);

        EmployeeEntity updatedEmployee = dto.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found after update"));

        return mapper.map(updatedEmployee, Employee.class);
    }

    @Override
    public Employee updateEmployeeDetails(Long employeeId, Employee employee) {

        EmployeeEntity employeeEntity = dto.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        employeeEntity.setName(employee.getName());
        employeeEntity.setDepartment(employee.getDepartment());
        employeeEntity.setLocation(employee.getLocation());
        employeeEntity.setPosition(employee.getPosition());
        employeeEntity.setPhoneNumber(employee.getPhoneNumber());

        dto.save(employeeEntity);

        EmployeeEntity updatedEmployee = dto.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Company not found after update"));
        return mapper.map(updatedEmployee, Employee.class);
    }
}