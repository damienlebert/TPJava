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
    
    public static Message creerMessage(User auteur, String contenu){
        
        Message message = new Message();
        message.setAuthor(auteur);
        message.setContent(contenu);
        message.setDate(new Date());
        
        return message;
    }
    
    //Poster un message sur son propre mur
    public static void posterMessage(Message message){
        User utilisateur = message.getAuthor();
        Wall mur = utilisateur.getWall();
        mur.ajouterMessage(message);
        message.setWall(mur);
         
    }
    
    //Poster un message ur le mur d'un autre utilisateur
    public static void posterMessage(Message message, User utilisateurCible){
        User utilisateur = message.getAuthor();
        if (utilisateur.enRelationAvec(utilisateurCible)){
            Wall mur = utilisateurCible.getWall();
            mur.ajouterMessage(message); 
            message.setWall(mur);
        } else{
            
            System.out.println("Impossible d'écrire sur le mur d'un inconnu");
        }
    }
    
    
    public static Comment creerCommentaire(User auteur, String contenu){
        
        Comment commentaire = new Comment();
        commentaire.setAuthor(auteur);
        commentaire.setContent(contenu);
        commentaire.setDate(new Date());
        
        return commentaire;
    }
    
    // Poster un commentaire sur un message.
    // Retourne un message d'erreur si l'auteur n'est ni ami avec le propriétaire du mur sur lequel se trouve le message, ni ami avec l'auteur du message
    public static void posterCommentaire(Comment commentaire, Message message){
        User source = commentaire.getAuthor();
        User cible = message.getWall().getOwner();
        if (source.equals(cible) || cible.enRelationAvec(source) || source.enRelationAvec(message.getAuthor()) || source.equals(message.getAuthor())){
            
            message.addComment(commentaire);
            commentaire.setMessage(message);
        } else{
            
            System.out.println("Impossible de commenter un message sur le mur d'un inconnu");
        }
    }
    
   
}
