package models;

public class Eleves extends Personnes{
    //Attribut
    private String classe;
    private double[] notes = new double[10];

    //Constructeur
    public Eleves(String identifiant, String nom, String prenom, int age,String classe){
        super(identifiant, nom, prenom, age);
        this.classe = classe;
    }

    //Getters
    public String getClasse() {return classe;}

    public double[] getNotes() {return notes;}

    public void salut(){
        System.out.println("Salut");
    }
}
