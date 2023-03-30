package com.example.miniprojet;

public class Dechet {
    private String nom;
    private String matiere;
    private int tmp;
    private String description;
    private boolean bio;

    public Dechet(String nom, String matiere, int tmp,String description,int biodeg){
        this.nom = nom;
        this.matiere = matiere;
        this.tmp = tmp;
        this.description = description;
        if(biodeg==0){
            this.bio = false;
        } else {
            this.bio = true;
        }
    }

    public String getNom() {
        return nom;
    }

    public String getMatiere() {
        return matiere;
    }

    public int getTmp() {
        return tmp;
    }

    public String getDescription() {
        return description;
    }

    public boolean getBio() {
        return bio;
    }

    public String getLabel(){
        if (this.matiere==null){
            return  this.nom;
        } else {
            return this.nom+" ("+this.matiere+")";
        }
    }
}
