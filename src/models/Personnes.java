package models;



public abstract class Personnes {

    //Attribut
    private String identifiant;
    private String nom;
    private String prenom;
    private int age;

    //Constructeur
    public Personnes(String identifiant, String nom, String prenom, int age) {
      this.identifiant = identifiant;
      this.nom = nom;
      this.prenom = prenom;
      this.age = age;
    }

    public Personnes(){}
    //Getters
    public String getIdentifiant() {return identifiant;}

    public String getPrenom() {return prenom;}

    public int getAge() {return age;}

    public String getNom() {return nom;}

}