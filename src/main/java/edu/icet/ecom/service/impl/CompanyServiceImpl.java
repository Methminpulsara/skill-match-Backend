package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Company;
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
    public void add(Company company) {
        dto.save(mapper.map(company, CompanyEntity.class));
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
    public List<Company> getAll() {
        List<Company> companyList = new ArrayList<>();
        List<CompanyEntity> all = dto.findAll();
        all.forEach(companyEntity -> {
            companyList.add(mapper.map(companyEntity,Company.class));
        });
        return companyList;
    }
}
