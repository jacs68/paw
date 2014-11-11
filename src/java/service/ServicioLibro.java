/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Libro;

/**
 *
 * @author JACS
 */
public class ServicioLibro {
    
    private static ConexionDB cn=new ConexionDB();
    private static Libro libro;
    
    public static Libro getLibro(String isbn) throws SQLException{        
        String query="SELECT * FROM libro where LIB_ISBN="+isbn;
        ResultSet rs=cn.ejecutarQuery(query);
        while(rs.next()){
            libro=new Libro(rs.getString("LIB_TITULO"),
                            rs.getString("LIB_AUTOR"),
                            rs.getString("LIB_ISBN"),
                            rs.getDouble("LIB_PRECIO"),
                            rs.getInt("LIB_STOCK"));                            
        }
        cn.cerrarConexion();
        return libro;
    }
}
