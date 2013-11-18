/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author dlebert
 */
public class Message {
    
    private User author;
    private String content;
    private Date date;
    private Wall wall;
    private List<Comment> comments = new ArrayList<>();

    public User getAuthor() {

        return this.author;
    }

    public String getContent() {

        return this.content;
    }
    
    public Date getDate() {

        return this.date;
    }
    
    public Wall getWall() {

        return this.wall;
    }
    
    public List<Comment> getCommentList(){
        
        return this.comments;
    }
    
    public Comment getComment( int index ){
        
        return this.comments.get(index);
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
    public void setWall(Wall wall) {

        this.wall = wall;
    }

    public void setCommentList(List<Comment> commentList){
        
        this.comments = commentList;
    }
    
    public void addComment(Comment comment){
        
        this.comments.add(comment);
    }
    
    public Comment getLastComment(){
        
        return this.comments.get(comments.size()-1);
    }
    
    public boolean containComment(Comment commentaire){
        boolean result = false;
        for (Comment commentaireMessage : this.comments){
            if (commentaireMessage.equals(commentaire)){
                
             result = true;   
            }
        }
        return result;
    }
    
    @Override
    public String toString(){
        String result = "Message de " + this.author.getEtatCivil() + "\n" ;
        result += this.date + "\n";
        result += this.content + "\n";
        
        for (Comment commentaire : this.comments){
            
            result += commentaire.toString();
        }
        
        return result;
    }
    
    
}
