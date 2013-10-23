/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;


import fr.facetek.model.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author dlebert
 */
public class WallServiceTest {
    @Test
    public void testWall() {
       
        Utilisateur moi = UtilisateurService.creerUtilisateur("Lebert", "Damien"); 
        Utilisateur unAmi = UtilisateurService.creerUtilisateur("Super", "Poto");  
        UtilisateurService.creerRelation(moi, unAmi);
        Utilisateur unInconnu = UtilisateurService.creerUtilisateur("Justin", "Inconnu");
        UtilisateurService.creerRelation(unInconnu, unAmi);
        //Creation d'un message sur son propre mur
        
        String textMessage = "Je suis un super message de test sur mon propre mur";
        Message message = WallService.creerMessage(moi, textMessage);
        WallService.posterMessage(message);
        assertTrue("Le message n'a pas été crée correctement", moi.getMur().contientMessage(message));
        
        //Création d'un message sur le mur d'un ami
        
        textMessage = "Je suis un super message de test sur le mur de mon ami";
        message = WallService.creerMessage(moi, textMessage);
        
        
        WallService.posterMessage(message, unAmi);
        assertTrue("Le message n'a pas été crée correctement", unAmi.getMur().contientMessage(message));
        
        WallService.posterMessage(message, unInconnu);
        assertFalse("Il devrai être impossible d'écrire sur le mur d'un inconnu", unInconnu.getMur().contientMessage(message));
        
        
        //Création d'un commentaire sur un message
        
        //Création du commentaire
        String textCommentaire = "Je suis un super Commentaire";
        Commentaire commentaire = WallService.creerCommentaire(moi, textCommentaire);
        
        //Commenter un post sur son mur 
        message = moi.getMur().getLastMessage();
        WallService.posterCommentaire(commentaire, message);
        assertTrue("Le commentaire n'a pas été posté correctement", message.contientCommentaire(commentaire));
         
        //Commenter un post sur le mur d'un ami
        message = unAmi.getMur().getLastMessage();
        WallService.posterCommentaire(commentaire, message);
        assertTrue("Le commentaire n'a pas été posté correctement", message.contientCommentaire(commentaire));
        
        //Création d'un message sur le mur de inconnu posté par un ami
        textMessage = "Mon ami écrit sur le mur d'un inconnu";
        message = WallService.creerMessage(unAmi, textMessage);
        WallService.posterMessage(message, unInconnu);
        
        WallService.posterCommentaire(commentaire, message);
        assertTrue("Je devrai pouvoir commenter le message d'un ami sur le mur d'un inconnu", message.contientCommentaire(commentaire));
        
         //Création d'un message sur le mur de inconnu posté par un inconnu
        textMessage = "Un inconnu écrit sur sont propre mur...";
        message = WallService.creerMessage(unInconnu, textMessage);
        WallService.posterMessage(message);
        
        WallService.posterCommentaire(commentaire, message);
        assertFalse("Je ne devrai pas pouvoir commenter le message d'un inconnu sur le mur d'un inconnu", message.contientCommentaire(commentaire));
        
        
        System.out.println("======================================================");
        System.out.println(moi.toString());
        System.out.println(UtilisateurService.showMur(moi));
        System.out.println(UtilisateurService.showRelations(moi));
        System.out.println("======================================================");
        System.out.println(unAmi.toString());
        System.out.println(UtilisateurService.showMur(unAmi));
        System.out.println(UtilisateurService.showRelations(unAmi));
        System.out.println("======================================================");
        System.out.println(unInconnu.toString());
        System.out.println(UtilisateurService.showMur(unInconnu));
        System.out.println(UtilisateurService.showRelations(unInconnu));
        
        
        
    }  
}
