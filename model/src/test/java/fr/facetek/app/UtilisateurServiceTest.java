/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;


import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import fr.facetek.model.*;

/**
 *
 * @author dlebert
 */
public class UtilisateurServiceTest {
    @Test
    public void testUtilisateur() {
       
     Utilisateur unTest = UtilisateurService.creerUtilisateur("Lebert", "Damien");   
     Utilisateur deuxTest = UtilisateurService.creerUtilisateur("The", "Naab");   
     Relation relation = UtilisateurService.creerRelation(unTest, deuxTest);
        
        System.out.println(relation.toString());
        assertNotNull("Les utilisateurs n'ont pas été trouvé", relation.toString().matches(unTest.getEtatCivil() + " " + deuxTest.getEtatCivil() + " sont " + relation.getType()));
    }    
}
