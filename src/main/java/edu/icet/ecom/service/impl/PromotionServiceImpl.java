package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Promotion;
import edu.icet.ecom.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PromotionServiceImpl implements PromotionService {
    @Override
    public void add(Promotion promotion) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Promotion promotion) {

    }

    @Override
    public Promotion search(Long id) {
        return null;
    }

    @Override
    public Promotion searchByName(String name) {
        return null;
    }

    @Override
    public List<Promotion> getALl() {
        return List.of();
    }
}
