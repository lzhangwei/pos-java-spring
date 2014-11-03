package com.thoughtworks.pos.dao.impl;

import com.thoughtworks.pos.dao.PromotionDao;
import com.thoughtworks.pos.model.Promotion;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

public class PromotionDaoImpl implements PromotionDao, InitializingBean {
    @Override
    public Promotion getPromotionById(int id) {
        return null;
    }

    @Override
    public List<Promotion> getPromotionsByItemId(int id) {
        return null;
    }

    @Override
    public int getPromotionDiscount(int id) {
        return 0;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
