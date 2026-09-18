package ui;


import models.Eleves;
import models.Professeurs;
import services.ElevesServices;
import services.ProfesseursServices;

import java.util.Random;
import java.util.Scanner;

public class IvoireSchoolInterface {

    //Methode Principale
   public void menu(){
       int choix;
       do{
           ElevesServices elevesServices = new ElevesServices();
           ProfesseursServices professeursServices = new ProfesseursServices();
           //Variable
           String menu = """
            ================IVOIRESCHOOL================
            1-Ajouter un élève dans une classe
            2-Ajouter un professeur à l'établissement
            3-Afficher les informations complete d'un élève
            4-Afficher les informations complete d'un professeur
            5-Calculer la moyenne d'un élève d'une classe
            6-Verifier si un élève est admis ou redoublant
            0-Quitter l'application
            
            Veuillez faire un choix :
             """;
           String classe= """
               1-6ème
               2-5ème
               3-4ème
               4-3ème
               5-2nd
               6-1ère
               7-Terminal
               
               Veuillez choisir la classe dans laquelle vous voulez ajouter l'élève : 
               """;

           Scanner sc = new Scanner(System.in);
           System.out.println(menu);
           choix = sc.nextInt();
           choixOptions(choix,classe);
       }while(choix != 0);

   }


   /*
   Cette methode represente les differentes options
    */
    public void choixOptions(int choix , String classe){
       Scanner sc = new Scanner(System.in);
        if (choix == 1){
            System.out.println(classe);
            int reponse = sc.nextInt();
            switch (reponse){
                case 1 : ajouterEleveDansUneClasse("6ème");
                    break;
                case 2 : ajouterEleveDansUneClasse("5ème");
                    break;
                case 3 :ajouterEleveDansUneClasse("4ème");
                    break;
                case 4 :ajouterEleveDansUneClasse("3ème");
                    break;
                case 5 :ajouterEleveDansUneClasse("2nd");
                    break;
                case 6 :ajouterEleveDansUneClasse("1ère");
                    break;
                case 7 :ajouterEleveDansUneClasse("Terminale");
                    break;
                default:
                    System.out.println("Choix de classe invalide !");
                    break;
            }
        }
        else if (choix == 2) {
            ajouterProfesseurDansEtablissement();
        }else if (choix == 3){
            rechercheEleves();
        }else if (choix == 4){
            rechercheProfesseur();
        } else if (choix == 5)  {

        }else if (choix == 6){

        }else{
            System.out.println(" Fermeture de l'application réussie ... ");
        }

    }




   //Cette methode permet d'ajouter un élève dans une classe
   private void ajouterEleveDansUneClasse(String nomDeLaClasse){
       ElevesServices elevesServices = new ElevesServices();
       Scanner sc = new Scanner(System.in);
       System.out.println("Voulez vous ajouter combien d'élève à cet classe ? :");
       int nombreEleves = sc.nextInt();
       for (int i = 0;i<nombreEleves;i++) {
           String identifiant = generateurIdentifiant(2);
           System.out.println("Veuillez saisir le nom de l'élève :");
           String nom = sc.nextLine();
           sc.nextLine();
           System.out.println("Veuillez saisir le prenom de l'élève :");
           String prenom = sc.nextLine();
           System.out.println("Veuillez saisir l'age de l'élève :");
           int age = sc.nextInt();
           String nomClasse = nomDeLaClasse;
           Eleves eleves = new Eleves(identifiant, nom, prenom, age, nomClasse);
           System.out.println(elevesServices.addEleves(eleves));
       }
   }


   //methode permettant d'ajouter un professeur dans l'établissemnt
    private void ajouterProfesseurDansEtablissement(){
        ProfesseursServices professeursServices = new ProfesseursServices();
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez vous ajouter combien de professeur à cet établissement ? :");
        int nombreProfesseur = sc.nextInt();
        for (int i = 0;i<nombreProfesseur;i++) {
            String identifiant = generateurIdentifiant(2);
            System.out.println("Veuillez saisir le nom du professeur :");
            String nom = sc.nextLine();
            sc.nextLine();
            System.out.println("Veuillez saisir le prenom du professeur :");
            String prenom = sc.nextLine();
            System.out.println("Veuillez saisir l'age du professeur :");
            int age = sc.nextInt();
            System.out.println("Veuillez saisir la matiere enseigner par le professeur :");
            String matiereEnseigner = sc.nextLine();
            sc.nextLine();
            System.out.println("Veuillez saisir l'anné d'expérience du professeur :");
           int anneeExperience = sc.nextInt();
            Professeurs professeurs = new Professeurs(identifiant, nom, prenom, age,matiereEnseigner,anneeExperience);
            System.out.println(professeursServices.addProfesseurs(professeurs));
        }
    }



    //Methode permettant d'afficher la fiche d'un élève
    public void rechercheEleves(){
       ElevesServices elevesServices = new ElevesServices();
       Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'identifiant de l'élève a rechercher :");
        String identifiant = sc.nextLine();
        elevesServices.AfficherFicheEleve(identifiant);
    }


    //Methode permettant d'afficher la fiche d'un professeur
    public void rechercheProfesseur(){
       ProfesseursServices professeursServices = new ProfesseursServices();
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'identifiant de l'élève a rechercher :");
        String identifiant = sc.nextLine();
        professeursServices.afficherFicheProfesseurs(identifiant);
    }


   //methode permettant de générer un identifiant automatiquement
   private String generateurIdentifiant(int taille){
       final String CARACTERE_AUTORISE = "0123456789";
       StringBuilder stringBuilder = new StringBuilder("IVC-");
       Random random = new Random();

       for (int i=0;i<taille;i++){
           int nb = random.nextInt(CARACTERE_AUTORISE.length());
           stringBuilder.append(CARACTERE_AUTORISE.charAt(nb));
       }
       return stringBuilder.toString();
   }

}
