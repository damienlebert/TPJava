/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import fr.facetek.model.User;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dlebert
 */
public class CsvService implements CsvInterface{
    
    @Override
    public List<User> getUtilisateurs(String fileName) throws IOException{
        
        List<User> utilisateurs = new ArrayList<>();
        
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath(fileName);
        
        try (Scanner scanner = new Scanner(path)) {
            scanner.useDelimiter(System.getProperty("line.separator"));
            //Skiping first line (properties)
            parseCSVLine(scanner.next());
            
            while(scanner.hasNext()){
                //parse line to get users
                User utilisateur = parseCSVLine(scanner.next());
                utilisateurs.add(utilisateur);
            }
        }
        
        return utilisateurs;
       
    }
    
    private static User parseCSVLine(String line) {
         Scanner scanner = new Scanner(line);
         scanner.useDelimiter("\\s*;\\s*");
         // Login
         String login = scanner.next();
         // Nom en majuscule
         String nom = scanner.next().toUpperCase();
         //Prenom, premiere lettre en majuscule
         String prenom = scanner.next();
         prenom = prenom.replaceFirst(".",(prenom.charAt(0)+"").toUpperCase());
         // Email ( login@astek.fr )
         String mail = login + "@astek.fr";
         
         User utilisateur = UserService.createUser(nom, prenom);
         utilisateur.setLogin(login);
         utilisateur.setMail(mail);
         
         return utilisateur;
    }
    
    
}
