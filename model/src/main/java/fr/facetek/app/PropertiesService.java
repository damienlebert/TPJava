/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import fr.facetek.model.Facetek;
import fr.facetek.model.Relation;
import fr.facetek.model.Utilisateur;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

/**
 *
 * @author dlebert
 */
public class PropertiesService {
    
    public static Properties loadProperties(String path){
        
        String configPath=path;
	Properties properties = new Properties();
	//reading stuff
	try {
            FileInputStream in = new FileInputStream(configPath);
            properties.load(in);
            
	} catch (IOException e) {
            
		System.out.println("Unable to load config file."); 
	}
        return properties;
    }
    
    public static void loadRelations(Facetek facetek, String path){
        
	Properties properties= PropertiesService.loadProperties(path);
	
        //reading stuff
	Iterator it = properties.keySet().iterator();
        while (it.hasNext()){
            String log = (String) it.next(); 
            String logAmi = properties.getProperty(log);
            Utilisateur utilisateur = FacetekService.getUtilisateurByLogin(log, facetek);
            Utilisateur utilisateurAmi = FacetekService.getUtilisateurByLogin(logAmi, facetek);
            UtilisateurService.creerRelation(utilisateur, utilisateurAmi);
        }
    }
}
