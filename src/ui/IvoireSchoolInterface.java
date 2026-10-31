package ui;


import models.Eleves;
import models.Professeurs;
import services.ElevesServices;
import services.ProfesseursServices;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class IvoireSchoolInterface {
    Scanner sc = new Scanner(System.in);
    ElevesServices elevesServices = new ElevesServices();
    //Methode Principale
   public void demarrer(){
       int choix;
       do{

           //Variable
           String menu = """
            ================IVOIRESCHOOL================
            1-Ajouter un élève dans une classe
            2-Ajouter un professeur à l'établissement
            3-Afficher les informations complete d'un élève
            4-Afficher les informations complete d'un professeur
            5-Calculer la moyenne d'un élève d'une classe
            6-Verifier si un élève est admis ou redoublant
            7-Afficher tous les élèves d'une classe 
            0-Quitter l'application
            
            Veuillez faire un choix :
             """;
           System.out.println(menu);
           choix = sc.nextInt();
           choixOptions(choix,variableClasse());
       }while(choix != 0);

   }


   /*
   Cette methode represente les differentes options
    */
    public void choixOptions(int choix , String nomClasse){
        int cptr = 0;
       Scanner sc = new Scanner(System.in);
        if (choix == 1){
            System.out.println(nomClasse);
            int reponse = sc.nextInt();
            switch (reponse){
                case 1 :  ajouterEleveDansUneClasse("6ème",reponse);
                    break;
                case 2 : ajouterEleveDansUneClasse("5ème",reponse);
                    break;
                case 3 :ajouterEleveDansUneClasse("4ème",reponse);
                    break;
                case 4 :ajouterEleveDansUneClasse("3ème",reponse);
                    break;
                case 5 :ajouterEleveDansUneClasse("2nd",reponse);
                    break;
                case 6 :ajouterEleveDansUneClasse("1ère",reponse);
                    break;
                case 7 :ajouterEleveDansUneClasse("Terminale",reponse);
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
           calculerMoyenneEleve();
        }else if (choix == 6){

        }else if (choix == 7){
           System.out.println("saisisser le nom de la classe : ");
           String reponse  = sc.nextLine();
            rechercherTousLesEleves(reponse);
           // rechercherTousLesEleves();


        } else{
            System.out.println(" Fermeture de l'application réussie ... ");
        }

    }



   //Cette methode permet d'ajouter un élève dans une classe
   private void ajouterEleveDansUneClasse(String nomDeLaClasse,int choix){
       Scanner sc = new Scanner(System.in);
           String identifiant = generateurIdentifiant(2);
           System.out.println("Veuillez saisir le nom de l'élève numéro :");
           String nom = sc.nextLine();
           System.out.println("Veuillez saisir le prenom de l'élève numéro :");
           String prenom = sc.nextLine();
           System.out.println("Veuillez saisir l'age de l'élève numéro :");
           int age = sc.nextInt();
           String nomClasse = nomDeLaClasse;
           Eleves eleves = new Eleves(identifiant, nom, prenom, age, nomClasse);
           elevesServices.ajouterElevesDansUneClasse(eleves);

   }



   //methode permettant d'ajouter un professeur dans l'établissemnt
    private void ajouterProfesseurDansEtablissement(){
        ProfesseursServices professeursServices = new ProfesseursServices();
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez vous ajouter combien de professeur à cet établissement ? :");
        int nombreProfesseur = sc.nextInt();
        for (int i = 0;i<nombreProfesseur;i++) {
            String identifiant = generateurIdentifiant(3);
            System.out.println("Veuillez saisir le nom du professeur :");
            String nom = sc.nextLine();
            sc.nextLine();
            System.out.println("Veuillez saisir le prenom du professeur numéro "+ (i+1) +" :");
            String prenom = sc.nextLine();
            System.out.println("Veuillez saisir l'age du professeur numéro "+ (i+1) +" :");
            int age = sc.nextInt();
            System.out.println("Veuillez saisir la matiere enseigner par le professeur numéro "+ (i+1) +" :");
            String matiereEnseigner = sc.nextLine();
            sc.nextLine();
            System.out.println("Veuillez saisir l'anné d'expérience du professeur numéro "+ (i+1) +" :");
            int anneeExperience = sc.nextInt();
            Professeurs professeurs = new Professeurs(identifiant, nom, prenom, age,matiereEnseigner,anneeExperience);
            System.out.println(professeursServices.addProfesseurs(professeurs));
        }
    }



    //Methode permettant d'afficher la fiche d'un élève
    private void rechercheEleves(){
       Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'identifiant de l'élève a rechercher :");
        String identifiant = sc.nextLine();
        System.out.println(elevesServices.afficherFicheEleve(identifiant));;
    }


    //Methode permettant d'afficher la fiche d'un professeur
    private void rechercheProfesseur(){
       ProfesseursServices professeursServices = new ProfesseursServices();
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'identifiant de l'élève a rechercher :");
        String identifiant = sc.nextLine();
        professeursServices.afficherFicheProfesseurs(identifiant);
    }

    //Methode permettant de rechercher tous les élèves d'une classe
    private void rechercherTousLesEleves(String nomClasse){
        elevesServices.afficherTousLesEleves(nomClasse);
       // elevesServices.afficherTousLesElevesEtablissement();
    }

    //Metode permettant de calculer la moyenne d'un élève
    private void calculerMoyenneEleve(){
        System.out.println("Veuillez saisir le matricule de l'élève : ");
        String identifiant = sc.next();
        System.out.println(elevesServices.calculerMoyenneEleve(identifiant));

    }

    //Methode qui retourne une variable contenant toutes les classes de l'établissement
     private String variableClasse(){
        String classe;
        return  classe= """
               1-6ème
               2-5ème
               3-4ème
               4-3ème
               5-2nd
               6-1ère
               7-Terminal
               
               Veuillez faire un choix : 
               """;
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
