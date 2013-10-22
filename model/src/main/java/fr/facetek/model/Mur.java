/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dlebert
 */
public class Mur {
    
    private List<Message> messages = new ArrayList<Message>();
    private Utilisateur proprietaire;
    
    public List<Message> getMessages(){
        
        return this.messages;
    }
    
    public Utilisateur getProprietaire(){
        
        return this.proprietaire;
    }
    
    
    public void setMessages(List<Message> messages){
        
        this.messages = messages;
    }
    
    public void setProprietaire(Utilisateur proprietaire){
        
        this.proprietaire = proprietaire;
    }
    
    public void ajouterMessage(Message message){
        
        this.messages.add(message);
    }
    
    public Message getLastMessage(){
        
        return this.messages.get(messages.size()-1);
    }
    
    public Message getMessage(int index){
        
        return this.messages.get(index);
    }
    
    public boolean contientMessage(Message message){
        boolean result = false;
        for (Message messageMur : this.messages){
            if (messageMur.equals(message)){
                
             result = true;   
            }
        }
        return result;
    }
    
    @Override
    public String toString(){
        
        String result = "Mur : \n";
        for (Message message : this.messages){
            result += message.toString() + "\n";
        }
        return result;
    }
    
    
    
    
}
