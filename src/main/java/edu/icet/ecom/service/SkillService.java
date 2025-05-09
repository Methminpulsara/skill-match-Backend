package edu.icet.ecom.service;

import edu.icet.ecom.dto.Skill;

import java.util.*;

public interface SkillService {

    Skill add (Skill skill);
    void delete (Long id);
    void update(Skill skill);
    Skill search(Long id);
    List <Skill> getAll();
    List<Skill> findByName(String name);

    List<Skill> findAllBYEmployeeIDAndStatus(Long employeeId,String status);
}
