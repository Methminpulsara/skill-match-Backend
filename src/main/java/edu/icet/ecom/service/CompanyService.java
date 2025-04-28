package edu.icet.ecom.service;

import edu.icet.ecom.dto.Company;
import edu.icet.ecom.dto.Employee;

import java.util.*;

public interface CompanyService {

    Company add (Company company);
    void delete(Long companyId);
    Company search(Long companyId);
    Company searchByName(String name);
    void update (Company company);
    List<Company> getAllActiveCompanies();
    Company findUserByUserID(Long userId);
    Company updateProfileImage(Long companyId, String profileImage);
    Company updateCompanyDetails(Long companyId , Company company);
}
