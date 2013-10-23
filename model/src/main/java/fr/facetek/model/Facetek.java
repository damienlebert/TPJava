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
    private List<Utilisateur> listUtilisateurs = new ArrayList<>();
    
    public List<Utilisateur> getListUtilisateur(){
        
        return this.listUtilisateurs;
    }
    
    public Utilisateur getUtilisateur( int index ){
        
        return this.listUtilisateurs.get(index);
    }
    
    public void setListUtilisateurs( List<Utilisateur> utilisateurs ){
        
        this.listUtilisateurs = utilisateurs;
    }
    
    public void ajouterUtilisateur( Utilisateur utilisateur ){
        
        this.listUtilisateurs.add(utilisateur);
    }
    
    
            
    
}
