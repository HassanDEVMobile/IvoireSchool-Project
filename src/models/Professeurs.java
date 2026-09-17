package models;

public class Professeurs extends Personnes{
    //Attribut
     private String matiereEnseigner;
     private String anneeExperience;

     //Constructeur
    public Professeurs(String identifiant, String nom, String prenom, int age,String matiereEnseigner,String anneeExperience){
        super(identifiant, nom, prenom, age);
        this.matiereEnseigner = matiereEnseigner;
        this.anneeExperience = anneeExperience;
    }

    //Getters
    public String getMatiereEnseigner() {return matiereEnseigner;}

    public String getAnneeExperience() {return anneeExperience;}
}
