/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechas;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Upao
 */
public class Fechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(date.format(new Date()));
    }
    
}
