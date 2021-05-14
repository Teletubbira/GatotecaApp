/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irasema
 * @param <T>
 */
public interface Dao<T> {

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    T get(int id) throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    List<T> getAll() throws SQLException;

    /**
     *
     * @param t
     * @return
     * @throws SQLException
     */
    boolean save(T t) throws SQLException;

    /**
     *
     * @param t
     * @return
     * @throws SQLException
     */
    boolean update(T t) throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    boolean delete(int id) throws SQLException;
}
