/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.model;

/**
 *
 * @author dlebert
 */
public class Relation {
    
    private User premierUtilisateur;
    private User secondUtilisateur;
    private String type;

    // Getter
    
    public User getPremierUtilisateur() {

        return this.premierUtilisateur;
    }

    public User getSecondUtilisateur() {

        return this.secondUtilisateur;
    }

    public String getType() {

        return this.type;
    }
    
    //Setter
    
    public void setPremierUtilisateur(User premierUtilisateur) {

        this.premierUtilisateur = premierUtilisateur;
    }
    public void setSecondUtilisateur(User secondUtilisateur) {

        this.secondUtilisateur = secondUtilisateur;
    }
    public void setType(String type) {

        this.type = type;
    }
    
    @Override
    public String toString(){
    
        return(premierUtilisateur.getEtatCivil()+ " et " +  secondUtilisateur.getEtatCivil() + " sont " + this.type + "\n"); 
    }
    
    public String toString(User utilisateur){
        
        String result;
        
        if (this.premierUtilisateur.equals(utilisateur)){
            result = premierUtilisateur.getEtatCivil() + " est " + this.type + " avec " + secondUtilisateur.getEtatCivil();
        } else{
           result = secondUtilisateur.getEtatCivil() + " est " + this.type + " avec " + premierUtilisateur.getEtatCivil();
        }
        result += "\n";
        return(result); 
    }
    
}
