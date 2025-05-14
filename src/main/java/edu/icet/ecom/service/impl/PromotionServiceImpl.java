package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Promotion;
import edu.icet.ecom.entity.PromotionEntity;
import edu.icet.ecom.repository.PromotionDto;
import edu.icet.ecom.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PromotionServiceImpl implements PromotionService {

    private final PromotionDto dto;
    private final ModelMapper mapper;

    @Override
    public void add(Promotion promotion) {
        dto.save(mapper.map(promotion, PromotionEntity.class));
    }

    @Override
    public void delete(Long id) {
        dto.deleteById(id);
    }

    @Override
    public void update(Promotion promotion) {
        dto.save(mapper.map(promotion, PromotionEntity.class));
    }

    @Override
    public Promotion search(Long id) {
        return mapper.map(dto.findById(id),Promotion.class);
    }

    @Override
    public Promotion searchByName(String name) {
        return mapper.map(dto.findByName(name),Promotion.class);
    }

    @Override
    public List<Promotion> getALl() {
        List<Promotion>  promotionList= new ArrayList<>();
        List<PromotionEntity> all = dto.findAll();
        all.forEach(promotionEntity -> {
            promotionList.add(mapper.map(promotionEntity,Promotion.class));
        });
        return promotionList;
    }

}
