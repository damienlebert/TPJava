/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import au.com.bytecode.opencsv.CSVReader;
import fr.facetek.model.User;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dlebert
 */
public class CsvServiceLib implements CsvInterface{
    
    @Override
    public List<User> getUtilisateurs(String fileName) throws IOException{
        
            List<User> utilisateurs = new ArrayList<>();
            
            CSVReader reader = new CSVReader(new FileReader(fileName), ';');
            String [] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                
                // Login
                String login = nextLine[0];
                // Nom
                String nom = nextLine[1].toUpperCase();
                //Prenom
                String prenom = nextLine[2];
                prenom = prenom.replaceFirst(".",(prenom.charAt(0)+"").toUpperCase());
                // Email
                String mail = login + "@astek.fr";
                User utilisateur = UserService.createUser(nom, prenom);
                utilisateur.setLogin(login);
                utilisateur.setMail(mail);
               
                utilisateurs.add(utilisateur);
            }
    
            
            return utilisateurs;
    }
}
