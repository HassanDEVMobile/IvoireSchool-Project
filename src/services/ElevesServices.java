package services;

import models.Eleves;

import java.util.*;

public class ElevesServices {
    Eleves eleves = new Eleves();

    //Methode permettant d'ajouter un élève dans une classe
    public void ajouterElevesDansUneClasse(Eleves eleves1){
       eleves.addEleve(eleves1);
   }

   //Methode permettant d'afficher la complète d'un élève
    public String afficherFicheEleve(String identifiant){
        List<Eleves> elevesList = eleves.findAllEleveEtablissement();
        int i = eleves.verificationEleve(identifiant);
       if(i != -1){
            return """
                        ========================================
                                      FICHE ÉLÈVE
                        ========================================
                        ID              : %s
                        Nom complet     : %s %s
                        Âge             : %d ans
                        Classe          : %s
                        ----------------------------------------
                        Moyenne         : %.2f
                        Statut          : %s ✓
                        ========================================
                        
                        """.formatted(elevesList.get(i).getIdentifiant(),elevesList.get(i).getNom(),elevesList.get(i).getPrenom(),elevesList.get(i).getAge(),elevesList.get(i).getClasse(),elevesList.get(i).getMoyenne(),elevesList.get(i).getStatut());
       }
       return "ÉLève introuble ou matricle incorrect ! ";
    }

    //Methode permettant d'afficher tous les élèves d'une classe
    public void afficherTousLesEleves(String nomclasses){
          eleves.findAll(nomclasses);
    }

    //Methode permettant de calculer la moyenne d'un etudiant
    public double calculerMoyenneEleve(String identifiant){

        Scanner scanner = new Scanner(System.in);
        int j = eleves.verificationEleve(identifiant);
        List<Eleves> elevesList = eleves.findAllEleveEtablissement();
        double somme = 0;
        double moyenne = 1;
        if(j != -1){
            for (int i=0;i<elevesList.get(j).notes.length;++i){
                System.out.println("Veuillez saisir la note numeros "+(i+1)+" : ");
                elevesList.get(j).notes[i] = scanner.nextDouble();
                somme += elevesList.get(j).notes[i];
            }
            moyenne = somme/elevesList.get(j).notes.length;
            elevesList.get(j).setMoyenne(moyenne);
            statutEleve(moyenne,j);
            return moyenne ;
        }
        else {
            return -1;
        }
    }

    //Cette methode permet d'affecter la moyenne et le statut d'un élève après avoir calculer la moyenne de l'élève dans methode "calculerMoyenneEleve"
    public void statutEleve(double moyenne , int indice){
        List<Eleves> elevesList = eleves.findAllEleveEtablissement();
        if (moyenne < 10){
           elevesList.get(indice).setStatut("Redoublant");
        }
        else {
            elevesList.get(indice).setStatut("Admis");
        }
    }




}
