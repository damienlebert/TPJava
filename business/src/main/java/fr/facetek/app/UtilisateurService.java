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
   
    public static Utilisateur creerUtilisateur(String nom, String prenom){
        
        Utilisateur utilisateur = new Utilisateur();
        Mur mur = new Mur();
        String login = prenom.charAt(0) + nom;
        login = login.toLowerCase();
        
        String mail = login + "@astek.fr";
        
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setLogin(login);
        utilisateur.setMail(mail);
        utilisateur.setMur(mur);
        mur.setProprietaire(utilisateur);
        
        return utilisateur;
    }
    
    public static Utilisateur creerUtilisateur(String nom, String prenom, String login, String mail){
        
        Utilisateur utilisateur = new Utilisateur();
        Mur mur = new Mur();
        
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setLogin(login);
        utilisateur.setMail(mail);
        utilisateur.setMur(mur);
        mur.setProprietaire(utilisateur);
        
        return utilisateur;
    }

    public static Relation creerRelation(Utilisateur premierUtilisateur, Utilisateur secondUtilisateur) throws Exception{
        
        //Preconditions
        if(premierUtilisateur.enRelationAvec(secondUtilisateur)){
            throw new Exception("Il existe déjà une relation entre ces deux utilisateur");
        }
        
        //Traitement
        Relation relation = new Relation();
        relation.setPremierUtilisateur(premierUtilisateur);
        relation.setSecondUtilisateur(secondUtilisateur);
        relation.setType("Amis");
        premierUtilisateur.ajouterRelation(relation);
        secondUtilisateur.ajouterRelation(relation);
        
        return relation;
    }
    
    // Retourne une chaine de caractère contenant les informations de l'utilisateur (nom, prenom, login, mail)
    public static String getAllInfos(Utilisateur utilisateur){
        
        String result = "Nom : " + utilisateur.getNom() + "\n";
        result += "Prenom : " + utilisateur.getPrenom() + "\n";
        result += "Login : " + utilisateur.getLogin() + "\n";
        result += "Mail : " + utilisateur.getMail();
        
        result += "\n";
        return result;
    }
        
    //Retourne une chaine de caractère contenant le contenu du mur de l'utilisateur passé en paramètre    
    public static String showMur(Utilisateur utilisateur){
        
        return utilisateur.getMur().toString();
    }
    
    //Retourne une chaine de caractère contenant les relations de l'utilisateur passé en paramètre
    public static String showRelations(Utilisateur utilisateur){
        String result = "Relations : \n";
        if (utilisateur.getRelations().isEmpty()){
            result += "Aucunes relations";
        }
        else{
            for (Relation relation : utilisateur.getRelations()){
                result += relation.toString(utilisateur);
            }
        }
        result += "\n";
        return result;
    }
    
}
