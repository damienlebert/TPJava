/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dlebert
 */
public class Facetek {
    private List<User> listUtilisateurs = new ArrayList<>();
    
    public List<User> getListUtilisateur(){
        
        return this.listUtilisateurs;
    }
    
    public User getUtilisateur( int index ){
        
        return this.listUtilisateurs.get(index);
    }
    
    public void setListUtilisateurs( List<User> utilisateurs ){
        
        this.listUtilisateurs = utilisateurs;
    }
    
    public void ajouterUtilisateur( User utilisateur ){
        
        this.listUtilisateurs.add(utilisateur);
    }
    
    
            
    
}
