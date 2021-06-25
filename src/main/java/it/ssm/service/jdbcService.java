package it.ssm.service;

import java.sql.SQLException;
import java.util.List;

public interface jdbcService<T> {
    public List<T> getUserById(String id) throws SQLException, ClassNotFoundException;
}
