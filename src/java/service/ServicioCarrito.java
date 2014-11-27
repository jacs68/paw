/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.naming.NamingException;

/**
 *
 * @author Upao
 */
public class ServicioCarrito {
    
    private static final ConexionDB cn=new ConexionDB();
    private static ResultSet rs;
    
    public static int guardarCarrito(String dni) throws SQLException, NamingException{
        int idCliente=0;
        int idCarrito=0;
        String queryCliente="SELECT USR_ID FROM cliente WHERE CLIE_DNI='"+dni+"'";
        String queryIdCarrito="SELECT CARR_ID FROM carrito ORDER BY CARR_ID LIMIT 1";
        String queryCarrito="INSERT INTO carrito(CARR_FECHA,USR_ID "
                + "VALUES("+new Date()+","+idCliente+")";
        rs=cn.ejecutarQuery(queryCliente);
        while(rs.next()){
            idCliente=rs.getInt("USR_ID");
        }
        cn.actulizarDatos(queryCarrito);
        rs=cn.ejecutarQuery(queryIdCarrito);
        while(rs.next()){
            idCarrito=rs.getInt("CARR_ID");            
        }
        cn.cerrarConexion();
        return idCarrito;        
    }

    public static int guardarDetalle(int idCarrito, String isbn, int cantidad) throws SQLException, NamingException {
        int idLibro=0;
        int guardo=0;
        String queryLibro="SELECT LIB_ID FROM libro WHERE LIB_ISBN='"+isbn+"'";
        String queryDetalle="INSERT INTO detalle_carrito "
                + "VALUES("+idCarrito+","+idLibro+","+cantidad+")";
        rs=cn.ejecutarQuery(queryLibro);
        while(rs.next()){
            idLibro=rs.getInt("LIB_ID");
        }
        guardo=cn.actulizarDatos(queryDetalle);
        return guardo;
    }
}
