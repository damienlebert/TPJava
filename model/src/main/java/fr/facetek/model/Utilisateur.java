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
public class Utilisateur {

    private String nom;
    private String prenom;
    private String login;
    private String mail;
    private int age;
    private Mur mur;
    private List<Relation> relations = new ArrayList<Relation>();

    //Getter
    
    public String getNom() {

        return this.nom;
    }

    public String getPrenom() {

        return this.prenom;
    }
    
    public String getLogin() {

        return this.login;
    }
    
    public String getMail() {

        return this.mail;
    }

    public int getAge() {

        return this.age;
    }
    
    public Mur getMur() {

        return this.mur;
    }
    
    public List<Relation> getRelations(){
        
        return this.relations;
    }
    
    //Setter
    
    public void setNom(String nom) {

        this.nom = nom;
    }
    public void setPrenom(String prenom) {

        this.prenom = prenom;
    }
    public void setLogin(String login) {

        this.login = login;
    }
    public void setMail(String mail) {

        this.mail = mail;
    }
    public void setAge(int age) {

        this.age = age;
    }
    public void setMur(Mur mur) {

        this.mur = mur;
    }
    
    public void setRelations(List<Relation> relations){
        
        this.relations = relations;
    }
    
    
    public void ajouterRelation(Relation relation){
        
        this.relations.add(relation);
    }
    
    public boolean enRelationAvec(Utilisateur utilisateur){
        
        boolean result = false; 
        for (Relation relation : this.relations){
            if((relation.getPremierUtilisateur().equals(this) && relation.getSecondUtilisateur().equals(utilisateur))||(relation.getPremierUtilisateur().equals(utilisateur) && relation.getSecondUtilisateur().equals(this))){
                
                result = true;
            }
        }     
        return result;
    }
    
    public String getEtatCivil(){
    
        String nomFormate = this.nom.toUpperCase();
        String prenomFormate = this.prenom;
        
        return (nomFormate + " "  + prenomFormate);
    }
    
    public String getAllInfos(){
        
        String result = "Nom : " +this.nom + "\n";
        result += "Prenom : " +this.prenom + "\n";
        result += "Login : " +this.login + "\n";
        result += "Mail : " +this.mail + "\n";
        
        return result;
    }
    
    @Override
    public String toString(){
        
        String result = "Nom : " +this.nom + "\n";
        result += "Prenom : " +this.prenom + "\n";
        result += "Login : " +this.login + "\n";
        result += "Mail : " +this.mail + "\n";
        
        return result;
    }
    
    public String showMur(){
        
        return this.mur.toString();
    }
    
    public String showRelations(){
        String result = "Relations : \n";
        if (this.relations.isEmpty()){
            result += "Aucunes relations";
        }
        else{
            for (Relation relation : this.relations){
                result += relation.toString(this);
            }
        }
        
        
        return result;
    }
    
}
