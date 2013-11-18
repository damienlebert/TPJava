/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import fr.facetek.model.Facetek;
import fr.facetek.model.User;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author dlebert
 */
public class PropertiesServiceTest {
    
    @Test
    public void testProperties() throws IOException, Exception {
   
         //Création des utilisateurs
        String pathTest = "src/test/resources/users.csv";
            CsvInterface csvServiceLib = CsvFactory.getCsvServiceLib();
            List<User> listUtilisateurs = csvServiceLib.getUtilisateurs(pathTest);
            Facetek facetek = FacetekService.creerFacetek(listUtilisateurs);
            
            //Création des relations
            pathTest = "src/test/resources/relations.properties";
            PropertiesService.loadRelations(facetek, pathTest);
            
            
            
            User moi = FacetekService.getUtilisateurByLogin("dlebert", facetek);
            User unAmi = FacetekService.getUtilisateurByLogin("sdaclin", facetek);
            User unInconnu = FacetekService.getUtilisateurByLogin("avianey", facetek);
            
            //On test que les relations ont bien été crées
            assertTrue("La relation n'a pas été crée correctement", moi.enRelationAvec(unAmi) );
            assertFalse("Une relation à été crée alors qu'elle n'existait pas dans le fichier properties", moi.enRelationAvec(unInconnu) );
            
  
    }
}
