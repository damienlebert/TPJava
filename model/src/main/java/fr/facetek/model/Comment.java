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
public class Comment {
    
    private User author;
    private String content;
    private Date date;
    private Message message;

    public User getAuthor() {

        return this.author;
    }

    public String getContent() {

        return this.content;
    }
    
    public Date getDate() {

        return this.date;
    }
    public Message getMessage(){
        
        return this.message;
    }

    public void setAuthor(User author) {

        this.author = author;
    }
    
    public void setContent(String content) {

        this.content = content;
    }
    
    public void setDate(Date date) {

        this.date = date;
    }
    
    public void setMessage(Message message){
        this.message = message;
    }
    
    @Override
    public String toString(){
        String result = "\tCommentaire de " + this.author.getEtatCivil() + "\n" ;
        result += "\t" + this.date + "\n";
        result += "\t" + this.content;
        
        return result;
    }
    
}
