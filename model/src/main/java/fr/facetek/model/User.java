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
public class User {

    private String lastName;
    private String firstName;
    private String login;
    private String mail;
    private Wall wall;
    private List<Relation> relations = new ArrayList<>();

    //Getter
    
    public String getLastName() {

        return this.lastName;
    }

    public String getFirstName() {

        return this.firstName;
    }
    
    public String getLogin() {

        return this.login;
    }
    
    public String getMail() {

        return this.mail;
    }
    
    public Wall getWall() {

        return this.wall;
    }
    
    public List<Relation> getRelations(){
        
        return this.relations;
    }
    
    public Relation getRelation( int index ){
        
        return this.relations.get( index );
    }
    
    //Setter
    
    public void setLastName(String nom) {

        this.lastName = nom;
    }
    public void setFirstName(String prenom) {

        this.firstName = prenom;
    }
    public void setLogin(String login) {

        this.login = login;
    }
    public void setMail(String mail) {

        this.mail = mail;
    }
    
    public void setWall(Wall mur) {

        this.wall = mur;
    }
    
    public void setRelations(List<Relation> relations){
        
        this.relations = relations;
    }
    
    
    public void ajouterRelation(Relation relation){
        
        this.relations.add(relation);
    }
    
    public boolean enRelationAvec(User utilisateur){
        
        boolean result = false; 
        for (Relation relation : this.relations){
            if((relation.getPremierUtilisateur().equals(this) && relation.getSecondUtilisateur().equals(utilisateur))||(relation.getPremierUtilisateur().equals(utilisateur) && relation.getSecondUtilisateur().equals(this))){
                
                result = true;
            }
        }     
        return result;
    }
    
    public String getEtatCivil(){
    
        String nomFormate = this.lastName.toUpperCase();
        String prenomFormate = this.firstName;
        
        return (nomFormate + " "  + prenomFormate);
    }
    
    @Override
    public String toString(){
        
        String result = "Nom : " +this.lastName + "\n";
        result += "Prenom : " +this.firstName + "\n";
        result += "Login : " +this.login + "\n";
        result += "Mail : " +this.mail + "\n";
        
        return result;
    }
}
