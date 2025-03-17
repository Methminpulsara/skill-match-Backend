package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Promotion;
import edu.icet.ecom.dto.SkillAnalytics;
import edu.icet.ecom.service.SkillAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class SkillAnalyticsServiceImpl implements SkillAnalyticsService {
    @Override
    public void add(SkillAnalytics analytics) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(SkillAnalytics analytics) {

    }

    @Override
    public SkillAnalytics search(Long id) {
        return null;
    }

    @Override
    public List<SkillAnalytics> getAll() {
        return List.of();
    }

    @Override
    public Promotion searchByName(String name) {
        return null;
    }
}
