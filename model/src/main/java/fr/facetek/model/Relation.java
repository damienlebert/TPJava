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
    
    private Utilisateur premierUtilisateur;
    private Utilisateur secondUtilisateur;
    private String type;

    // Getter
    
    public Utilisateur getPremierUtilisateur() {

        return this.premierUtilisateur;
    }

    public Utilisateur getSecondUtilisateur() {

        return this.secondUtilisateur;
    }

    public String getType() {

        return this.type;
    }
    
    //Setter
    
    public void setPremierUtilisateur(Utilisateur premierUtilisateur) {

        this.premierUtilisateur = premierUtilisateur;
    }
    public void setSecondUtilisateur(Utilisateur secondUtilisateur) {

        this.secondUtilisateur = secondUtilisateur;
    }
    public void setType(String type) {

        this.type = type;
    }
    
}
