/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc413.assignment2;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eiffel + kmehta
 */
public interface DAO<T> {
    
    T get(int id) throws SQLException;
    //List<T> getAll() throws SQLException;
    int save(T e) throws SQLException;
    int insert(T e) throws SQLException;
    int update(T e) throws SQLException;
    int delete(T e) throws SQLException;
    
}
