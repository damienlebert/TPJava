/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import fr.facetek.model.Facetek;
import fr.facetek.model.User;
import java.util.List;

/**
 *
 * @author dlebert
 */
public class FacetekService {
    
    public static Facetek creerFacetek(List<User> listUtilisateurs){
        
        Facetek facetek = new Facetek();
        facetek.setListUtilisateurs(listUtilisateurs);
        
        return facetek;
    }
    
    // Retourne l'objet User correspondant au login passé en paramètre 
    // Retourne null si aucun utilisateur ne correspond
    public static User getUtilisateurByLogin(String login, Facetek facetek){
        User utilisateur = null;
        for (User curUtilisateur : facetek.getListUtilisateur()){
            if ( curUtilisateur.getLogin().equalsIgnoreCase(login)){
                utilisateur = curUtilisateur;
            }
        }
        return utilisateur;
    }
    
    // Retourne une chaine de caractère contenant les information de chaque utilisateur
    public static String showUtilisateurs(Facetek facetek){
        String result = "Utilisateurs de facetek :\n";
        for (User curUtilisateur : facetek.getListUtilisateur()){
            result += "====================================================== \n";
            result += UserService.getAllInfos(curUtilisateur);
            
        }
        return result;
    }
    // Retourne une chaine de caractère contenant pour chaque utilisateur:
    //      - Ses infos
    //      - Ses relations
    //      - Le contenu de son mur
    public static String showEverything(Facetek facetek){
        String result = "Utilisateurs de facetek :\n";
        for (User curUtilisateur : facetek.getListUtilisateur()){
            result += "====================================================== \n";
            result += UserService.getAllInfos(curUtilisateur);
            result += UserService.showRelations(curUtilisateur);
            result += UserService.showMur(curUtilisateur);
            
        }
        return result;
    }
    
}
