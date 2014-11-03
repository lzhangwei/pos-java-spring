package com.thoughtworks.pos.dao.impl;

import com.thoughtworks.pos.dao.CategoryDao;
import com.thoughtworks.pos.model.Category;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CategoryDaoImpl implements CategoryDao, InitializingBean{

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CategoryDaoImpl(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM categories WHERE id = :categoryId";

        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("categoryId", id);

        return namedParameterJdbcTemplate.query(sql, namedParameters, new CategoryMapper()).get(0);
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

    private static final class CategoryMapper implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            return category;
        }
    }
}
