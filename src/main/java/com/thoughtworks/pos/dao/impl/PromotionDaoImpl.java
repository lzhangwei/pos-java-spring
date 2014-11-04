package com.thoughtworks.pos.dao.impl;

import com.thoughtworks.pos.dao.PromotionDao;
import com.thoughtworks.pos.model.Promotion;
import com.thoughtworks.pos.model.PromotionFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionDaoImpl implements PromotionDao, InitializingBean {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PromotionDaoImpl(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Promotion getPromotionById(int id) {
        String sql = "SELECT * FROM promotions WHERE id= : id";

        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("id", id);

        return namedParameterJdbcTemplate.query(sql, namedParameters, new PromotionMapper()).get(0);
    }

    @Override
    public List<Promotion> getPromotionsByItemId(int id) {
        String sql = "SELECT type FROM items_promotions,promotions WHERE itemId=:id AND promotionId=id";

        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("id", id);

        return namedParameterJdbcTemplate.query(sql, namedParameters, new PromotionMapper());
    }

    @Override
    public int getPromotionDiscount(int id) {
        String sql = "SELECT discount FROM items_promotions WHERE itemId=:id AND promotionId=3";

        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("id", id);

        return namedParameterJdbcTemplate.query(sql, namedParameters, new PromotionDiscountMapper()).get(0);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null) {
            throw new BeanCreationException("Must set DataSource on CategoryDaoImpl");
        }
        if(namedParameterJdbcTemplate == null) {
            throw new BeanCreationException("Null NamedParameterJdbcTemplate on CategoryDaoImpl");
        }
    }

    private static final class PromotionMapper implements RowMapper<Promotion> {
        @Override
        public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {
            int type = rs.getInt("type");
            return PromotionFactory.getPromotionByType(type);
        }
    }

    private static final class PromotionDiscountMapper implements RowMapper<Integer> {
        @Override
        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            int discount = rs.getInt("discount");
            return discount;
        }
    }
}
