/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import fr.facetek.model.*;

/**
 *
 * @author dlebert
 */
public class UtilisateurService {
  
    
    
    public static Utilisateur creerUtilisateur(String nom, String prenom, int age){
        
        Utilisateur utilisateur = new Utilisateur();
        Mur mur = new Mur();
    
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setAge(age);
        utilisateur.setMur(mur);
        mur.setProprietaire(utilisateur);
        
        return utilisateur;
    }
    
    public static Relation creerRelation(Utilisateur premierUtilisateur, Utilisateur secondUtilisateur){
   
        Relation relation = new Relation();
        
        relation.setPremierUtilisateur(premierUtilisateur);
        relation.setSecondUtilisateur(secondUtilisateur);
        relation.setType("Amis");
        premierUtilisateur.ajouterRelation(relation);
        secondUtilisateur.ajouterRelation(relation);
        
        return relation;
    }
    
}
