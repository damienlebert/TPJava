/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.facetek.model;

/**
 *
 * @author dlebert
 */
public class Utilisateur {

    private String nom;
    private String prenom;
    private int age;
    private Mur mur;

    public String getNom() {

        return this.nom;
    }

    public String getPrenom() {

        return this.prenom;
    }

    public int getAge() {

        return this.age;
    }
    
    public Mur getMur() {

        return this.mur;
    }
    public void setNom(String nom) {

        this.nom = nom;
    }
    public void setPrenom(String prenom) {

        this.prenom = prenom;
    }
    public void setAge(int age) {

        this.age = age;
    }
    public void setMur(Mur mur) {

        this.mur = mur;
    }

}
