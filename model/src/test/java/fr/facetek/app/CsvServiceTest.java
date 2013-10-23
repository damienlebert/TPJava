/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import java.util.List;
import fr.facetek.model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dlebert
 */
public class CsvServiceTest {

    @Test
    public void testCsv() {
        String pathTest = "src/test/resources/users.csv";
        try {
            CsvInterface csvService = CsvFactory.getCsvService();
            CsvInterface csvServiceLib = CsvFactory.getCsvServiceLib();
            assertEquals("La classe de l'objet crée par la Factory ne correspond pas", csvService.getClass(), new CsvService().getClass());
            assertEquals("La classe de l'objet crée par la Factory ne correspond pas", csvServiceLib.getClass(), new CsvServiceLib().getClass());
            ArrayList<Utilisateur> utilisateurs = new ArrayList(csvService.getUtilisateurs(pathTest));
            ArrayList<Utilisateur> libUtilisateurs = new ArrayList(csvServiceLib.getUtilisateurs(pathTest));
      
            int i = 0;
            for (Utilisateur utilisateur : utilisateurs){
                Utilisateur libUtilisateur = libUtilisateurs.get(i);
                assertEquals("Les 2 méthode de chargement du même fichier n'ont pas rendu le même résultat", UtilisateurService.getAllInfos(utilisateur), UtilisateurService.getAllInfos(libUtilisateur));
                i++; 
            }
            
        } catch (IOException ex) {
            Logger.getLogger(CsvServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}