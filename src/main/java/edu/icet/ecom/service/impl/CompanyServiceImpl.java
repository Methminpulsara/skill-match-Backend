package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Company;
import edu.icet.ecom.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    @Override
    public void add(Company company) {

    }

    @Override
    public void delete(Long companyId) {

    }

    @Override
    public Company search(Long companyId) {
        return null;
    }

    @Override
    public Company searchByName(String name) {
        return null;
    }

    @Override
    public void update(Company company) {

    }

    @Override
    public List<Company> getAll() {
        return List.of();
    }
}
