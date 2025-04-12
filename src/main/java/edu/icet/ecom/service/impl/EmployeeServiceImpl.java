package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.entity.CompanyEntity;
import edu.icet.ecom.entity.EmployeeEntity;
import edu.icet.ecom.entity.UserEntity;
import edu.icet.ecom.repository.CompanyDto;
import edu.icet.ecom.repository.EmployeeDto;
import edu.icet.ecom.repository.UserDto;
import edu.icet.ecom.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeDto dto;
    final ModelMapper mapper;
    final UserDto userDto;
    final CompanyDto companyDto;


    @Override
    public Employee add(Employee employee) {
        // Map base fields
        EmployeeEntity employeeEntity = mapper.map(employee, EmployeeEntity.class);

        // Manually resolve UserEntity from userId
        if (employee.getUserid() == null) {
            throw new IllegalArgumentException("User ID must not be null");
        }
        UserEntity user = userDto.findById(employee.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));
        employeeEntity.setUser(user);

        // Optionally set company
        if (employee.getCompanyid() != null) {
            CompanyEntity company = companyDto.findById(employee.getCompanyid())
                    .orElseThrow(() -> new RuntimeException("Company not found"));
            employeeEntity.setCompany(company);
        }

        // Save
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
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> all = dto.findAll();
        all.forEach(employeeEntity -> {
            employeeList.add(mapper.map(employeeEntity,Employee.class));
        });
        return employeeList;
    }

    @Override
    public Employee findByUserID(Long userID) {
        return mapper.map(dto.findByUserUserId(userID),Employee.class);
    }
}