package edu.icet.ecom.service;

import edu.icet.ecom.dto.Company;
import java.util.*;

public interface CompanyService {

    Company add (Company company);
    void delete(Long companyId);
    Company search(Long companyId);
    Company searchByName(String name);
    void update (Company company);
    List<Company> getAllActiveCompanies();

}
