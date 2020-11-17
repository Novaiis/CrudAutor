/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author Lucas Novais
 */
public class TesteCon {
    public static  void main(String args[]) throws SQLException{
     AutorDAO c1 = new AutorDAO();
     c1.abrirBanco();
   }
}
