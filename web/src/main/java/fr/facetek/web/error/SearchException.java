/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.web.error;

import java.io.IOException;


/**
 *
 * @author dlebert
 */

public class SearchException extends Exception {

    public SearchException() {
        super();
    }

    public SearchException(String message) {
        super(message);
    }

    public SearchException(IOException e) {
        super(e);
    }

    public SearchException(String message, IOException e) {
        super(message, e);
    }
    
    public SearchException(Exception e) {
        super(e);
    }
    
    public SearchException(String message, Exception e) {
        super(message, e);
    }
    
}

