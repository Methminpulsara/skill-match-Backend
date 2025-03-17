package edu.icet.ecom.service;
import edu.icet.ecom.dto.Promotion;
import edu.icet.ecom.dto.SkillAnalytics;

import java.util.*;

public interface SkillAnalyticsService {

    void add(SkillAnalytics analytics);
    void delete (Long id);
    void update (SkillAnalytics analytics);
    SkillAnalytics search(Long id);
    List<SkillAnalytics> getAll();

    Promotion searchByName(String name);
}
