/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gatoteca1.dao;

import java.sql.SQLException;
import java.util.List;

/** Interfaz que va a definir los comportamientos de los daos
 *
 * @author Irasema
 * @param <T>
 */
public interface Dao<T> {

    /** Metodo para obtener una entidad mediante su id
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public T get(int id) throws SQLException;

    /** Metodo para obtener todos los objetos de una entidad 
     *
     * @return
     * @throws SQLException
     */
    public List<T> getAll() throws SQLException;

    /** Metodo para guardar los datos de una entidad
     *
     * @param t
     * @return
     * @throws SQLException
     */
    public boolean save(T t) throws SQLException;

    /** Metodo para modificar los datos de una entidad
     *
     * @param t
     * @return
     * @throws SQLException
     */
    public boolean update(T t) throws SQLException;

    /** Metodo para eliminar una entidad mediante su id
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean delete(int id) throws SQLException;
}
