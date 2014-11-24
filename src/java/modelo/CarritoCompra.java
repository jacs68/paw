/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.naming.NamingException;
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
    
    public boolean agregarLibro(String isbn,int cantidad) throws SQLException, NamingException{
        Libro libro=ServicioLibro.getLibro(isbn);
        LibroComprado lc=new LibroComprado(libro, cantidad);
        ServicioLibro.actualizarStock(isbn,cantidad*-1);
        return libros.add(lc);
    }
    
    private void eliminarLibro(String isbn,int cantidad) throws SQLException, NamingException{
        Libro l=new Libro(isbn);
        LibroComprado lc=new LibroComprado(l, cantidad);
        Collections.sort(libros, lc);
        int pos=Collections.binarySearch(libros, lc, lc);
        if(pos>=0){
            libros.remove(pos);
            ServicioLibro.actualizarStock(isbn, cantidad);
        }            
    }
        
    private class LibroComprado implements Comparator<LibroComprado>{
        Libro libro;
        int cantidad;

        public Libro getLibro() {
            return libro;
        }

        public void setLibro(Libro libro) {
            this.libro = libro;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
        
        public LibroComprado(){
            
        }

        public LibroComprado(Libro libro, int cantidad) {
            this.libro = libro;
            this.cantidad = cantidad;
        }

        @Override
        public int compare(LibroComprado o1, LibroComprado o2) {
            return o1.getLibro().getIsbn().compareTo(o2.getLibro().getIsbn());
        }
        
        
    }
}
