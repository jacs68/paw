/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author JACS
 */
public class ConexionDB {
    //@Resource(name = "jdbc/libreria") -- No lo acepta el web container --
    private DataSource ds;
    private ResultSet rs;
    private Connection cn;
    private Statement st;
    private Context ctx;
    
    public ResultSet ejecutarQuery(String query) throws SQLException, NamingException{
        ctx=new InitialContext();
        ds=(DataSource)ctx.lookup("java:comp/env/jdbc/libreria");
        cn=ds.getConnection();
        st=cn.createStatement();
        rs=st.executeQuery(query);
        return rs;        
    }
    
    public int actulizarDatos(String query) throws SQLException, NamingException{
        ctx=new InitialContext();
        ds=(DataSource)ctx.lookup("java:comp/env/jdbc/libreria");
        cn=ds.getConnection();
        st=cn.createStatement();
        return st.executeUpdate(query);
    }
    
    public void cerrarConexion() throws SQLException{
        if(cn!=null){
            cn.close();
        }
    }
}
