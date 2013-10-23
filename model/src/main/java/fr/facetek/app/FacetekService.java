/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import fr.facetek.model.Facetek;
import fr.facetek.model.Utilisateur;
import java.util.List;

/**
 *
 * @author dlebert
 */
public class FacetekService {
    
    public static Facetek creerFacetek(List<Utilisateur> listUtilisateurs){
        
        Facetek facetek = new Facetek();
        facetek.setListUtilisateurs(listUtilisateurs);
        
        return facetek;
    }
    
    // Retourne l'objet Utilisateur correspondant au login passé en paramètre 
    // Retourne null si aucun utilisateur ne correspond
    public static Utilisateur getUtilisateurByLogin(String login, Facetek facetek){
        Utilisateur utilisateur = null;
        for (Utilisateur curUtilisateur : facetek.getListUtilisateur()){
            if ( curUtilisateur.getLogin().equalsIgnoreCase(login)){
                utilisateur = curUtilisateur;
            }
        }
        return utilisateur;
    }
    
    // Retourne une chaine de caractère contenant les information de chaque utilisateur
    public static String showUtilisateurs(Facetek facetek){
        String result = "Utilisateurs de facetek :\n";
        for (Utilisateur curUtilisateur : facetek.getListUtilisateur()){
            result += "====================================================== \n";
            result += UtilisateurService.getAllInfos(curUtilisateur);
            
        }
        return result;
    }
    // Retourne une chaine de caractère contenant pour chaque utilisateur:
    //      - Ses infos
    //      - Ses relations
    //      - Le contenu de son mur
    public static String showEverything(Facetek facetek){
        String result = "Utilisateurs de facetek :\n";
        for (Utilisateur curUtilisateur : facetek.getListUtilisateur()){
            result += "====================================================== \n";
            result += UtilisateurService.getAllInfos(curUtilisateur);
            result += UtilisateurService.showRelations(curUtilisateur);
            result += UtilisateurService.showMur(curUtilisateur);
            
        }
        return result;
    }
    
}
