package edu.icet.ecom.service;

import edu.icet.ecom.dto.Skill;
import java.util.*;

public interface SkillService {

    void add (Skill skill);
    void delete (Long id);
    void update(Skill skill);
    Skill search(Long id);
    List <Skill> getAll();
    Skill searchByName(String name);
}
