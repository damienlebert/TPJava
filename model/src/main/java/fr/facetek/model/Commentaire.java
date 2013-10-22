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
public class Commentaire {
    
    private Utilisateur auteur;
    private String contenu;
    private Date date;
    private Message message;

    public Utilisateur getAuteur() {

        return this.auteur;
    }

    public String getContenu() {

        return this.contenu;
    }
    
    public Date getDate() {

        return this.date;
    }
    public Message getMessage(){
        
        return this.message;
    }

    public void setAuteur(Utilisateur auteur) {

        this.auteur = auteur;
    }
    
    public void setContenu(String contenu) {

        this.contenu = contenu;
    }
    
    public void setDate(Date date) {

        this.date = date;
    }
    
    public void setMessage(Message message){
        this.message = message;
    }
    
    @Override
    public String toString(){
        String result = "\tCommentaire de " + this.auteur.getEtatCivil() + "\n" ;
        result += "\t" + this.date + "\n";
        result += "\t" + this.contenu;
        
        return result;
    }
    
}
