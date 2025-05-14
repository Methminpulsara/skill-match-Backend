package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Promotion;
import edu.icet.ecom.dto.SkillAnalytics;
import edu.icet.ecom.entity.SkillAnalyticsEntity;
import edu.icet.ecom.repository.SkillAnalyticsDto;
import edu.icet.ecom.service.SkillAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class SkillAnalyticsServiceImpl implements SkillAnalyticsService {

    private final SkillAnalyticsDto dto;
    private final ModelMapper mapper;

    @Override
    public void add(SkillAnalytics analytics) {
        dto.save(mapper.map(analytics, SkillAnalyticsEntity.class));
    }

    @Override
    public void delete(Long id) {
        dto.deleteById(id);
    }

    @Override
    public void update(SkillAnalytics analytics) {
        dto.save(mapper.map(analytics, SkillAnalyticsEntity.class));
    }

    @Override
    public SkillAnalytics search(Long id) {
        return mapper.map(dto.findById(id), SkillAnalytics.class);
    }

    @Override
    public List<SkillAnalytics> getAll() {
        List<SkillAnalytics> list = new ArrayList<>();
        List<SkillAnalyticsEntity> all = dto.findAll();
        all.forEach(skillAnalyticsEntity -> {
            list.add(mapper.map(skillAnalyticsEntity, SkillAnalytics.class));
        });
        return list;
    }

}
