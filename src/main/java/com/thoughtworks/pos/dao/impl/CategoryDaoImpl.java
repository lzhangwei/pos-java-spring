package com.thoughtworks.pos.dao.impl;

import com.thoughtworks.pos.dao.CategoryDao;
import com.thoughtworks.pos.model.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDaoImpl implements CategoryDao{

    private DataSource dataSource;
    
    @Override
    public Category getCategoryById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM categories WHERE id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            Category category = null;
            if(resultSet.next()) {
                category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
            }
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
