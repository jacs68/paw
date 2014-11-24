/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import modelo.Libro;

/**
 *
 * @author JACS
 */
public class ServicioLibro {
    
    private static ConexionDB cn=new ConexionDB();
    private static Libro libro;
    
    public static Libro getLibro(String isbn) throws SQLException, NamingException{        
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
    
    public static void actualizarStock(String isbn,int cantidad) throws SQLException, NamingException{
       String query="UPDATE libro set LIB_CANT=LIB_CANTIDAD + "+cantidad
               + " WHERE LIB_ISBN="+isbn; 
       cn.actulizarDatos(query);
       cn.cerrarConexion();       
    }
}
