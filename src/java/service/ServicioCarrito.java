/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

/**
 *
 * @author Upao
 */
public class ServicioCarrito {
    
    private static final ConexionDB cn=new ConexionDB();
    private static ResultSet rs;
    
    public static int guardarCarrito(String dni) throws SQLException, NamingException{
        int idCliente=0;
        SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
        int idCarrito=0;
        String queryCliente="SELECT USR_ID FROM cliente WHERE CLIE_DNI='"+dni+"'";
        String queryIdCarrito="SELECT CARR_ID FROM carrito ORDER BY CARR_ID DESC LIMIT 1";        
        rs=cn.ejecutarQuery(queryCliente);
        while(rs.next()){
            idCliente=rs.getInt("USR_ID");
        }
        String queryCarrito="INSERT INTO carrito(CARR_FECHA,USR_ID) "
                + "VALUES('"+date.format(new Date())+"',"+idCliente+")";        
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
        rs=cn.ejecutarQuery(queryLibro);
        while(rs.next()){
            idLibro=rs.getInt("LIB_ID");
        }
        String queryDetalle="INSERT INTO detalle_carrito "
                + "VALUES("+idLibro+","+idCarrito+","+cantidad+")";
        guardo=cn.actulizarDatos(queryDetalle);
        return guardo;
    }
}
