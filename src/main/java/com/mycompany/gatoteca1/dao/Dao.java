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
 * @param <T> tipo de objeto con el que trabaja el dao
 */
public interface Dao<T> {

    /** Metodo para obtener una entidad mediante su id
     *
     * @param id variable que hace referencia al id del objeto que se quiere obtener
     * @return devuelve el objeto
     * @throws SQLException es lanzada en caso de no poder realizarse la operacion
     */
    public T get(int id) throws SQLException;

    /** Metodo para obtener todos los objetos de una entidad 
     *
     * @return devuelve la lista de todos los objetos de una entidad
     * @throws SQLException es lanzada en caso de no poder realizarse la operacion
     */
    public List<T> getAll() throws SQLException;

    /** Metodo para guardar los datos de una entidad
     *
     * @param t variable que hace referencia al objeto que se quiere guardar
     * @return devuelve true en caso de que se haya podido guardar, false en el caso contrario
     * @throws SQLException es lanzada en caso de no poder realizarse la operacion
     */
    public boolean save(T t) throws SQLException;

    /** Metodo para modificar los datos de una entidad
     *
     * @param t variable que hace referencia al objeto que se quiere modificar
     * @return devuelve true en caso de que se haya podido modificar, false en el caso contrario
     * @throws SQLException es lanzada en caso de no poder realizarse la operacion
     */
    public boolean update(T t) throws SQLException;

    /** Metodo para eliminar una entidad mediante su id
     *
     * @param id variable que hace referencia al id del objeto que se quiere eliminar
     * @return devuelve true en caso de que se haya podido eliminar, false en el caso contrario
     * @throws SQLException es lanzada en caso de no poder realizarse la operacion
     */
    public boolean delete(int id) throws SQLException;
}
