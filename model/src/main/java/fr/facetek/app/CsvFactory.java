/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

/**
 *
 * @author dlebert
 */
public class CsvFactory {
    
    public static CsvService getCsvService(){
        return new CsvService();
    }
    
    public static CsvServiceLib getCsvServiceLib(){
        return new CsvServiceLib();
    }    
    
}
