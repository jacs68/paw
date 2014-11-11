/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import service.ServicioLibro;

/**
 *
 * @author JACS
 */
public class CarritoCompra {
    private Cliente cliente;
    private Date fecha;
    private ArrayList<LibroComprado> libros;

    public CarritoCompra(Cliente cliente, Date fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
        libros=new ArrayList<>();
    }
    
    public boolean agregarLibro(String isbn,int cantidad) throws SQLException{
        Libro libro=ServicioLibro.getLibro(isbn);
        LibroComprado lc=new LibroComprado(libro, cantidad);
        return libros.add(lc);
    }
        
    private class LibroComprado{
        Libro libro;
        int cantidad;

        public LibroComprado(Libro libro, int cantidad) {
            this.libro = libro;
            this.cantidad = cantidad;
        }
        
        
    }
}
