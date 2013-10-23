/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.app;

import fr.facetek.model.Utilisateur;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author dlebert
 */
public interface CsvInterface {
    public  List<Utilisateur> getUtilisateurs(String fileName) throws IOException;
}
