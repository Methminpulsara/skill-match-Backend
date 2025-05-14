package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Skill;
import edu.icet.ecom.entity.SkillEntity;
import edu.icet.ecom.repository.SkillDto;
import edu.icet.ecom.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillDto dto;
    private final ModelMapper mapper;

    @Override
    public Skill add(Skill skill) {
        SkillEntity skillEntity = mapper.map(skill,SkillEntity.class);
        skillEntity = dto.save(skillEntity);
        return mapper.map(skillEntity,Skill.class);
    }

    @Override
    public void delete(Long id) {
        dto.deleteById(id);
    }

    @Override
    public void update(Skill skill) {
        dto.save(mapper.map(skill, SkillEntity.class));
    }

    @Override
    public Skill search(Long id) {
        return mapper.map(dto.findById(id),Skill.class);
    }

    @Override
    public List<Skill> getAll() {

        List<Skill> skillList = new ArrayList<>();
        List<SkillEntity> all = dto.findAll();
        all.forEach(skillEntity -> {
            skillList.add(mapper.map(skillEntity,Skill.class));
        });
        return skillList;
    }

    @Override
    public List<Skill> findByName(String name) {

        List<Skill> skillList = new ArrayList<>();
        List<SkillEntity> allByName = dto.findAllByName(name);
        allByName.forEach(skillEntity -> {
            skillList.add(mapper.map(skillEntity,Skill.class));
        });
        return skillList;
    }

    @Override
    public List<Skill> findAllBYEmployeeIDAndStatus(Long employeeId, String status) {

        List<Skill> skillList = new ArrayList<>();
        List<SkillEntity> allByEmployeeEmployeeId = dto.findAllByEmployeeEmployeeIdAndStatus(employeeId, status);
        allByEmployeeEmployeeId.forEach(employee->{
            skillList.add(mapper.map(employee,Skill.class));
        });
        return skillList;
    }


}
