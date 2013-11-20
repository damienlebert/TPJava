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
public class UserService {
    
    
    /**
     * Create a fr.facetek.model.User instance with given firstName and lastName
     * @param firstName
     * @param lastName
     * @return The created user
    */
    public static User createUser(String firstName, String lastName){
        
        User user = new User();
        Wall mur = new Wall();
        String login = lastName.charAt(0) + firstName;
        login = login.toLowerCase();
        
        String mail = login + "@astek.fr";
        
        user.setLastName(firstName);
        user.setFirstName(lastName);
        user.setLogin(login);
        user.setMail(mail);
        user.setWall(mur);
        mur.setOwner(user);
        
        return user;
    }

    /**
     * Create a fr.facetek.model.Relation between the two fr.facetek.model.user given in parameter 
     * @param premierUtilisateur
     * @param secondUtilisateur
     * @return The new fr.facetek.model.Relation
     * @throws Exception 
     */
    public static Relation creerRelation(User premierUtilisateur, User secondUtilisateur) throws Exception{
        
        //Preconditions
        if(premierUtilisateur.enRelationAvec(secondUtilisateur)){
            throw new Exception("These users are already related !");
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
    
    /**
     * Method to retrieve user info in a string version
     * @param utilisateur
     * @return A string containing all user infos
    */
    public static String getAllInfos(User utilisateur){
        
        String result = "Nom : " + utilisateur.getLastName() + "\n";
        result += "Prenom : " + utilisateur.getFirstName() + "\n";
        result += "Login : " + utilisateur.getLogin() + "\n";
        result += "Mail : " + utilisateur.getMail();
        
        result += "\n";
        return result;
    }
        
    //Retourne une chaine de caractère contenant le contenu du mur de l'utilisateur passé en paramètre 
    /**
     * Method to retrieve user wall in a string version
     * @param utilisateur
     * @return A string containing the user's wall
     */
    public static String showMur(User utilisateur){
        
        return utilisateur.getWall().toString();
    }
    
    /**
     * Method to retrieve user relations in a string version
     * @param utilisateur
     * @return A string containing all user relations
     */
    public static String showRelations(User utilisateur){
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
