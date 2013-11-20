/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;


import fr.facetek.model.*;
import static org.junit.Assert.*;
import org.junit.Test;
import static fr.facetek.app.WallService.*;
import static fr.facetek.app.UserService.*;
/**
 *
 * @author dlebert
 */
public class WallServiceTest {
    
    @Test
    public void testWall() throws Exception {
       
        User moi = createUser("Lebert", "Damien"); 
        User unAmi = createUser("Super", "Poto");  
        creerRelation(moi, unAmi);
        User unInconnu = createUser("Justin", "Inconnu");
        creerRelation(unInconnu, unAmi);
        
        //Creation d'un message sur son propre mur
        
        String textMessage = "Je suis un super message de test sur mon propre mur";
        Message message = creerMessage(moi, textMessage);
        posterMessage(message);
        assertTrue("Le message n'a pas été crée correctement", moi.getWall().contientMessage(message));
        
        //Création d'un message sur le mur d'un ami
        
        textMessage = "Je suis un super message de test sur le mur de mon ami";
        message = creerMessage(moi, textMessage);
        
        
        posterMessage(message, unAmi);
        assertTrue("Le message n'a pas été crée correctement", unAmi.getWall().contientMessage(message));
        
        posterMessage(message, unInconnu);
        assertFalse("Il devrai être impossible d'écrire sur le mur d'un inconnu", unInconnu.getWall().contientMessage(message));
        
        
        //Création d'un commentaire sur un message
        
        //Création du commentaire
        String textCommentaire = "Je suis un super Commentaire";
        Comment commentaire = creerCommentaire(moi, textCommentaire);
        
        //Commenter un post sur son mur 
        message = moi.getWall().getLastMessage();
        posterCommentaire(commentaire, message);
        assertTrue("Le commentaire n'a pas été posté correctement", message.containComment(commentaire));
         
        //Commenter un post sur le mur d'un ami
        message = unAmi.getWall().getLastMessage();
        posterCommentaire(commentaire, message);
        assertTrue("Le commentaire n'a pas été posté correctement", message.containComment(commentaire));
        
        //Création d'un message sur le mur de inconnu posté par un ami
        textMessage = "Mon ami écrit sur le mur d'un inconnu";
        message = creerMessage(unAmi, textMessage);
        posterMessage(message, unInconnu);
        
        posterCommentaire(commentaire, message);
        assertTrue("Je devrai pouvoir commenter le message d'un ami sur le mur d'un inconnu", message.containComment(commentaire));
        
         //Création d'un message sur le mur de inconnu posté par un inconnu
        textMessage = "Un inconnu écrit sur sont propre mur...";
        message = creerMessage(unInconnu, textMessage);
        posterMessage(message);
        
        posterCommentaire(commentaire, message);
        assertFalse("Je ne devrai pas pouvoir commenter le message d'un inconnu sur le mur d'un inconnu", message.containComment(commentaire));
        
        
        System.out.println("======================================================");
        System.out.println(moi.toString());
        System.out.println(showMur(moi));
        System.out.println(showRelations(moi));
        System.out.println("======================================================");
        System.out.println(unAmi.toString());
        System.out.println(showMur(unAmi));
        System.out.println(showRelations(unAmi));
        System.out.println("======================================================");
        System.out.println(unInconnu.toString());
        System.out.println(showMur(unInconnu));
        System.out.println(showRelations(unInconnu));
        
        
        
    }  
}
