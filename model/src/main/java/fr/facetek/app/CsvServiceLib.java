/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import au.com.bytecode.opencsv.CSVReader;
import fr.facetek.model.Utilisateur;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dlebert
 */
public class CsvServiceLib {
    
    
    public static List<Utilisateur> lireCsv(String fileName) throws IOException{
       
    
            List<Utilisateur> utilisateurs = new ArrayList<>();
            
            
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
                Utilisateur utilisateur = UtilisateurService.creerUtilisateur(nom, prenom, 20);
                utilisateur.setLogin(login);
                utilisateur.setMail(mail);
                
                System.out.println(utilisateur.getAllInfos());
                utilisateurs.add(utilisateur);
            }
    
            
            return utilisateurs;
    }
}
