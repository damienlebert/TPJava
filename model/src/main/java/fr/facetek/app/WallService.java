/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import fr.facetek.model.*;
import java.util.Date;

/**
 *
 * @author dlebert
 */
public class WallService {
    
    public static Message creerMessage(Utilisateur auteur, String contenu){
        
        Message message = new Message();
        message.setAuteur(auteur);
        message.setContenu(contenu);
        message.setDate(new Date());
        
        return message;
    }
    
    //Poster un message sur son propre mur
    public static void posterMessage(Message message){
        Utilisateur utilisateur = message.getAuteur();
        Mur mur = utilisateur.getMur();
        mur.ajouterMessage(message);
        message.setMur(mur);
         
    }
    
    //Poster un message ur le mur d'un autre utilisateur
    public static void posterMessage(Message message, Utilisateur utilisateurCible){
        Utilisateur utilisateur = message.getAuteur();
        if (utilisateur.enRelationAvec(utilisateurCible)){
            Mur mur = utilisateurCible.getMur();
            mur.ajouterMessage(message); 
            message.setMur(mur);
        } else{
            
            System.out.println("Impossible d'écrire sur le mur d'un inconnu");
        }
    }
    
    
    public static Commentaire creerCommentaire(Utilisateur auteur, String contenu){
        
        Commentaire commentaire = new Commentaire();
        commentaire.setAuteur(auteur);
        commentaire.setContenu(contenu);
        commentaire.setDate(new Date());
        
        return commentaire;
    }
    
    public static void posterCommentaire(Commentaire commentaire, Message message){
        Utilisateur source = commentaire.getAuteur();
        Utilisateur cible = message.getMur().getProprietaire();
        if (cible.enRelationAvec(source) || source.equals(cible)){
            message.ajouterCommentaire(commentaire);
            commentaire.setMessage(message);
        } else{
            
            System.out.println("Impossible de commenter un message sur le mur d'un inconnu");
        }
    }
    
   
}
