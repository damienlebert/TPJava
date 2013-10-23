/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import fr.facetek.model.Commentaire;
import fr.facetek.model.Facetek;
import fr.facetek.model.Message;
import fr.facetek.model.Relation;
import fr.facetek.model.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author dlebert
 */
public class FacetekTest {
    
    @Test
    public void FacetekTest(){     
        
        
        //Initialisation des données
        String pathTest = "src/test/resources/users.csv";
        try {
            //Création des utilisateurs
            CsvInterface csvServiceLib = CsvFactory.getCsvServiceLib();
            List<Utilisateur> listUtilisateurs = csvServiceLib.getUtilisateurs(pathTest);
            Facetek facetek = FacetekService.creerFacetek(listUtilisateurs);
            
            //Création des relations
            pathTest = "src/test/resources/relations.properties";
            PropertiesService.loadRelations(facetek, pathTest);
            
            Utilisateur moi = FacetekService.getUtilisateurByLogin("dlebert", facetek);
            Utilisateur unAmi = FacetekService.getUtilisateurByLogin("sdaclin", facetek);
            Utilisateur unInconnu = FacetekService.getUtilisateurByLogin("avianey", facetek);
            //Ecriture des messages
            
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
            
            //Affichage du résultat
            System.out.println(FacetekService.showEverything(facetek));        

        } catch (IOException ex) {
            Logger.getLogger(CsvServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
