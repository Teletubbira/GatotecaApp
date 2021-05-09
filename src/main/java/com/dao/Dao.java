/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irasema
 */
public interface Dao<T> {
    T get(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    boolean save(T t) throws SQLException;
    boolean update(T t) throws SQLException;
    boolean delete(int id) throws SQLException;
}
