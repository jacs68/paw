/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.naming.NamingException;
import service.ServicioCarrito;
import service.ServicioLibro;

/**
 *
 * @author JACS
 */
public class CarritoCompra {
    private Cliente cliente;
    private Date fecha;
    private ArrayList<LibroComprado> libros;
    
    public CarritoCompra(){
        
    }

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
    
    public Libro getUltimoComprado(){
        Libro l=libros.get(libros.size()-1).getLibro();
        return l;
    }
    
    public ArrayList<LibroComprado> getLibros(){
        return libros;
    } 
    
    public void guardarCarrito() throws SQLException, NamingException{
        int idCarrito;
        idCarrito=ServicioCarrito.guardarCarrito(cliente.getDni());
        for(LibroComprado lc:libros){
            ServicioCarrito.guardarDetalle(idCarrito,lc.getLibro().getIsbn(),lc.getCantidad());
        }
        
        
    }

    public void eliminarLibro(String isbn) {
        int posLibro;
        Collections.sort(libros, new LibroComprado());
        posLibro=Collections.binarySearch(libros, new LibroComprado(new Libro(isbn), 0), new LibroComprado());
        if(posLibro>=0){
            libros.remove(posLibro);
        }
    }
}