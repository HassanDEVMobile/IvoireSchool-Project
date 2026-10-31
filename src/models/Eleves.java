package models;

import services.ElevesServices;

import java.util.*;

public class Eleves extends Personnes{

    //Classe scanner
    Scanner sc = new Scanner(System.in);
    private List<Eleves> enregistrementEleves = new ArrayList<>();
    //Attribut
    private String classe;
    public double[] notes = new double[10];
    private double moyenne = 0;
    private String  statut = "Aucun";

    //Constructeur
    public Eleves(String identifiant, String nom, String prenom, int age,String classe){
        super(identifiant, nom, prenom, age);
        this.classe = classe;
    }

    public Eleves(){}

    //Getters
    public String getClasse() {return classe;}

    public double[] getNotes() {return notes;}

    public double getMoyenne() {return moyenne;}

    public String getStatut() {return statut;}


    public String toString(){return null;}

    //  Setters
    public void setMoyenne(double moyenne){this.moyenne = moyenne;}
    public void setStatut(String statut){this.statut = statut;}

   //Sauvegarde des données
    public void addEleve(Eleves eleves1){
        this.enregistrementEleves.add(eleves1);
    }

    public String afficherFicheEleve(String identifiant){
        for(int i = 0;i<enregistrementEleves.size();i++){
            if (enregistrementEleves.get(i).getIdentifiant().equals(identifiant)){

            }
        }
        return "ÉLève introuble ou matricle incorrect ! ";
    }

    public void findAll(String nomClasse){
      for (int i = 0;i<this.enregistrementEleves.size();i++){
          if(enregistrementEleves.get(i).getClasse().equals(nomClasse)){
              System.out.println("Identifiant "+enregistrementEleves.get(i).getIdentifiant()+" , Nom : "+enregistrementEleves.get(i).getNom()+" , Prenom : "+enregistrementEleves.get(i).getPrenom() +" , Age : "+enregistrementEleves.get(i).getAge());
          }
      }
    }

    public int verificationEleve(String identifiant){
        for(int i = 0;i<enregistrementEleves.size();i++){
            if (enregistrementEleves.get(i).getIdentifiant().equals(identifiant)){return i;}
        }
        return -1;
    }

    public List<Eleves> findAllEleveEtablissement(){
        List<Eleves> elevesEtablissement = new ArrayList<>();

        for(Eleves eleves : this.enregistrementEleves){
            elevesEtablissement.add(eleves);
        }
        return elevesEtablissement;
    }





}
