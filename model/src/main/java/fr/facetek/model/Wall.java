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
public class Wall {
    
    private List<Message> messages = new ArrayList<>();
    private User owner;
    
    public List<Message> getMessages(){
        
        return this.messages;
    }
    
    public Message getMessage(int index){
        
        return this.messages.get(index);
    }
    
    public User getOwner(){
        
        return this.owner;
    }
    
    
    public void setMessages(List<Message> messages){
        
        this.messages = messages;
    }
    
    public void setOwner(User owner){
        
        this.owner = owner;
    }
    
    public void ajouterMessage(Message message){
        
        this.messages.add(message);
    }
    
    public Message getLastMessage(){
        
        return this.messages.get(messages.size()-1);
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
