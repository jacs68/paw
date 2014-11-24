/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Comparator;

/**
 *
 * @author JACS
 */
public class LibroComprado implements Comparator<LibroComprado> {

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

    public LibroComprado() {

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
