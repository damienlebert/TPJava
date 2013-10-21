/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.model;

import java.util.Date;



/**
 *
 * @author dlebert
 */
public class Message {
    
    private String titre;
    private String contenu;
    private Date date;

    public String getNom() {

        return this.titre;
    }

    public String getPrenom() {

        return this.contenu;
    }
    
    public Date getDate() {

        return this.date;
    }

    public void setNom(String nom) {

        this.titre = nom;
    }
    
    public void setContenu(String contenu) {

        this.contenu = contenu;
    }
    
    public void setDate(Date date) {

        this.date = date;
    }
    
}
