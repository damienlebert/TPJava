/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import fr.facetek.model.Message;
import fr.facetek.model.Utilisateur;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dlebert
 */
public class CsvService {
    
    public static List<Utilisateur> lireCsv(String fileName) throws IOException{
        
        
        List<Utilisateur> utilisateurs = new ArrayList<>();
        
        FileSystem fs = FileSystems.getDefault();

        Path path = fs.getPath(fileName);
        
        try{
            System.out.println(path.toRealPath());
        }
        catch(NoSuchFileException ex){
	  System.out.println(path.toString()+" not found");
	}
        try (Scanner scanner = new Scanner(path)) {
            scanner.useDelimiter(System.getProperty("line.separator"));
            //Skiping first line (properties)
            parseCSVLine(scanner.next());
            
            while(scanner.hasNext()){
                //parse line to get users
                Utilisateur utilisateur = parseCSVLine(scanner.next());
                System.out.println(utilisateur.getAllInfos());
                utilisateurs.add(utilisateur);
            }
        }
        
        return utilisateurs;
       
    }
    
    private static Utilisateur parseCSVLine(String line) {
         Scanner scanner = new Scanner(line);
         scanner.useDelimiter("\\s*;\\s*");
         // Login
         String login = scanner.next();
         // Nom
         String nom = scanner.next().toUpperCase();
         //Prenom
         String prenom = scanner.next();
         prenom = prenom.replaceFirst(".",(prenom.charAt(0)+"").toUpperCase());
         // Email
         String mail = login + "@astek.fr";
         Utilisateur utilisateur = UtilisateurService.creerUtilisateur(nom, prenom, 20);
         utilisateur.setLogin(login);
         utilisateur.setMail(mail);
         
         return utilisateur;
    }
    
    
}
