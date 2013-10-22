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

/**
 *
 * @author dlebert
 */
public class CsvServiceTest {

@Test
    public void testCsv() {

        try {
            List<Utilisateur> utilisateurs = CsvService.lireCsv("src/test/resources/users.csv");
            utilisateurs = CsvServiceLib.lireCsv("src/test/resources/users.csv");
        } catch (IOException ex) {
            Logger.getLogger(CsvServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}