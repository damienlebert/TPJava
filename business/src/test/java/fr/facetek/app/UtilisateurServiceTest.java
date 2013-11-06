/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;


import org.junit.Test;
import fr.facetek.model.*;
import org.junit.Assert;

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
       
        // Test 1 : Utilisateur crée correctement   
        Utilisateur unTest = UtilisateurService.creerUtilisateur("Lebert", "Damien");   
        Assert.assertEquals("L'utilisateur n'a pas été crée correctement", "dlebert", unTest.getLogin());

        // Test 2 : Relation entre deux utilisateurs
        Utilisateur deuxTest = UtilisateurService.creerUtilisateur("The", "Naab");   
        Relation relation = UtilisateurService.creerRelation(unTest, deuxTest);
        System.out.println(relation.toString());
        Assert.assertNotNull("Les utilisateurs n'ont pas été trouvé", relation.toString().matches(unTest.getEtatCivil() + " " + deuxTest.getEtatCivil() + " sont " + relation.getType()));
        
        // Test 3 : Création d'une relation déjà existente
        try {
            relation = UtilisateurService.creerRelation(unTest, deuxTest);
        } catch ( Exception e ){
            //expected
            relation = null;
        }
        Assert.assertNull(relation);
        
        
    }    
}
