/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author Sistemas
 */
public class ServicioUsuario {
    private static ConexionDB cn=new ConexionDB();
    
    public static int getUsuario(String usr,String psw) throws SQLException, NamingException{
        int id=0;
        String query="SELECT * from usuario WHERE USR_NOMBRE='"+usr+"'"
                + " AND USR_PASSWORD='"+psw+"'";        
        ResultSet rs=cn.ejecutarQuery(query);
        while(rs.next()){
            id=rs.getInt("USR_ID");
        }
        cn.cerrarConexion();
        return id;        
    }
    
    public static Cliente getCliente(int id) throws SQLException, NamingException{
        Cliente c=null;
        String query="SELECT * FROM cliente WHERE USR_ID="+id;
        ResultSet rs=cn.ejecutarQuery(query);
        while(rs.next()){
            String nombre=rs.getString("CLIE_NOMBRE");
            String apPaterno=rs.getString("CLIE_AP_PATERNO");
            String apMaterno=rs.getString("CLIE_AP_MATERNO");
            String dni=rs.getString("CLIE_DNI");
            c=new Cliente();
            c.setNombre(nombre);
            c.setApPaterno(apPaterno);
            c.setApMaterno(apMaterno);
            c.setDni(dni);
        }
        cn.cerrarConexion();
        return c;
    }
}
