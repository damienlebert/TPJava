/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;


import org.junit.Test;
import fr.facetek.model.*;
import org.junit.Assert;
import static fr.facetek.app.UtilisateurService.*;

/**
 *
 * @author dlebert
 */
public class UtilisateurServiceTest {
    
    /**
     * Test 1 : Création d'un utilisateur
     * Test 2 : Création d'une relation entre deux utilisateurs
     * Test 3 : Création d'une relation déjà existente
     */
    @Test
    public void testUtilisateur() throws Exception {
       
        // Test 1 : User crée correctement   
        User firstUser = createUser("Lebert", "Damien");   
        Assert.assertEquals("L'utilisateur n'a pas été crée correctement", "dlebert", firstUser.getLogin());

        // Test 2 : Relation entre deux utilisateurs
        User secondUser = createUser("Test", "User");   
        Relation relation =  creerRelation(firstUser, secondUser);
        Assert.assertTrue("Les utilisateurs n'ont pas été trouvé", firstUser.enRelationAvec(secondUser));
        
        // Test 3 : Création d'une relation déjà existente
        try {
            relation = creerRelation(firstUser, secondUser);
        } catch ( Exception e ){
            //expected
            relation = null;
        }
        Assert.assertNull("Il devrait être impossible de créer une relation déjà existente", relation);
    }    
}
