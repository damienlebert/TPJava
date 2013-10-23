/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author dlebert
 */
public class Message {
    
    private Utilisateur auteur;
    private String contenu;
    private Date date;
    private Mur mur;
    private List<Commentaire> commentaires = new ArrayList<Commentaire>();

    public Utilisateur getAuteur() {

        return this.auteur;
    }

    public String getContenu() {

        return this.contenu;
    }
    
    public Date getDate() {

        return this.date;
    }
    
    public Mur getMur() {

        return this.mur;
    }
    
    public List<Commentaire> getCommentaire(){
        
        return this.commentaires;
    }
    
    public Commentaire getCommentaire( int index ){
        
        return this.commentaires.get(index);
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
    public void setMur(Mur mur) {

        this.mur = mur;
    }

    public void setCommentaire(List<Commentaire> commentaires){
        
        this.commentaires = commentaires;
    }
    
    public void ajouterCommentaire(Commentaire commentaire){
        
        this.commentaires.add(commentaire);
    }
    
    public Commentaire getLastCommentaire(){
        
        return this.commentaires.get(commentaires.size()-1);
    }
    
    public boolean contientCommentaire(Commentaire commentaire){
        boolean result = false;
        for (Commentaire commentaireMessage : this.commentaires){
            if (commentaireMessage.equals(commentaire)){
                
             result = true;   
            }
        }
        return result;
    }
    
    @Override
    public String toString(){
        String result = "Message de " + this.auteur.getEtatCivil() + "\n" ;
        result += this.date + "\n";
        result += this.contenu + "\n";
        
        for (Commentaire commentaire : this.commentaires){
            
            result += commentaire.toString();
        }
        
        return result;
    }
    
    
}
