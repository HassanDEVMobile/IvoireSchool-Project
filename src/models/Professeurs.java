package models;

public class Professeurs extends Personnes{
    //Attribut
     private String matiereEnseigner;
     private int anneeExperience;

     //Constructeur
    public Professeurs(String identifiant, String nom, String prenom, int age,String matiereEnseigner,int anneeExperience){
        super(identifiant, nom, prenom, age);
        this.matiereEnseigner = matiereEnseigner;
        this.anneeExperience = anneeExperience;
    }

    public Professeurs(){}

    //Getters
    public String getMatiereEnseigner() {return matiereEnseigner;}

    public int getAnneeExperience() {return anneeExperience;}
}
