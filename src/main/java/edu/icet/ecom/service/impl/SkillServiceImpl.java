package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Skill;
import edu.icet.ecom.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    @Override
    public void add(Skill skill) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public Skill search(Long id) {
        return null;
    }

    @Override
    public List<Skill> getAll() {
        return List.of();
    }

    @Override
    public Skill searchByName(String name) {
        return null;
    }
}
