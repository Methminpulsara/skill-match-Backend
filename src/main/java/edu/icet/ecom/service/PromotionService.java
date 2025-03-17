package edu.icet.ecom.service;

import edu.icet.ecom.dto.Promotion;
import java.util.*;

public interface PromotionService {

    void add (Promotion promotion);
    void delete (Long id );
    void update(Promotion promotion);
    Promotion search(Long id);
    Promotion searchByName(String name);
    List<Promotion> getALl ();

}
