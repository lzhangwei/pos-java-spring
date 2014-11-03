package com.thoughtworks.pos.dao.impl;

import com.thoughtworks.pos.dao.ItemDao;
import com.thoughtworks.pos.model.Item;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ItemDaoImpl implements ItemDao{

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ItemDaoImpl(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Item> getItems() {
        return null;
    }

    @Override
    public Item getItemByBarcode(String barcode) {
        return null;
    }
}
