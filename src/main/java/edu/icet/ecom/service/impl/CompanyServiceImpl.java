package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Company;
import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.entity.CompanyEntity;
import edu.icet.ecom.repository.CompanyDto;
import edu.icet.ecom.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    final CompanyDto dto;
    final ModelMapper mapper;
    @Override
    public Company add(Company company) {
        CompanyEntity companyEntity = mapper.map(company, CompanyEntity.class);
        companyEntity = dto.save(companyEntity);
        return mapper.map(companyEntity, Company.class);
    }



    @Override
    public void delete(Long companyId) {
        dto.deleteById(companyId);
    }

    @Override
    public Company search(Long companyId) {
        return mapper.map(dto.findById(companyId),Company.class);
    }

    @Override
    public Company searchByName(String name) {
        return mapper.map(dto.findByName(name),Company.class);
    }

    @Override
    public void update(Company company) {
        dto.save(mapper.map(company, CompanyEntity.class));
    }

    @Override
    public List<Company> getAllActiveCompanies() {
        List<Company> companyList = new ArrayList<>();
        List<CompanyEntity> all = dto.findAllActiveCompanies();
        all.forEach(companyEntity -> {
            companyList.add(mapper.map(companyEntity,Company.class));
        });
        return companyList;
    }

    @Override
    public Company findUserByUserID(Long userId) {
        return mapper.map(dto.findByUserUserId(userId),Company.class);
    }

    @Override
    public Company updateProfileImage(Long employeeId, String profileImage) {

        CompanyEntity company = dto.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        company.setProfileImage(profileImage);
        dto.save(company);

        CompanyEntity updatedCompany = dto.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found after update"));

        return mapper.map(updatedCompany, Company.class);
    }

    @Override
    public Company updateCompanyDetails(Long companyId, Company company) {

        // Find the company by its ID
        CompanyEntity companyEntity = dto.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        // Update the company details using the passed Company object
        companyEntity.setName(company.getName());
        companyEntity.setSize(company.getSize());
        companyEntity.setContact(company.getContact());
        companyEntity.setAbout(company.getAbout());
        companyEntity.setLocation(company.getLocation());

        // Save the updated company entity
        dto.save(companyEntity);

        // Fetch the updated company from the database
        CompanyEntity updatedCompanyEntity = dto.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found after update"));

        // Map the updated CompanyEntity to the Company model
        return mapper.map(updatedCompanyEntity, Company.class);
    }

}
