# 🏫 IvoireSchool Project

Application console développée en **Java** permettant la gestion administrative et pédagogique d'un établissement scolaire (élèves, professeurs, classes, moyennes et statuts d'admission).

---

## 📋 Fonctionnalités

* **Gestion des élèves :**
  * Inscription d'un élève dans une classe spécifique (`6ème`, `5ème`, `4ème`, `3ème`, `2nd`, `1ère`, `Terminale`).
  * Génération automatique d'un matricule unique au format `IVC-XX`.
  * Consultation de la fiche complète d'un élève (ID, nom, prénom, âge, classe, moyenne, statut).
  * Affichage de la liste des élèves d'une classe donnée.
* **Gestion des professeurs :**
  * Enregistrement d'un professeur avec génération automatique d'un identifiant (`IVC-XXX`)[cite: 1].
  * Consultation de la fiche détaillée d'un professeur (matière enseignée, années d'expérience)[cite: 1].
* **Suivi académique :**
  * Saisie des notes (sur 10 évaluations) et calcul automatique de la moyenne générale[cite: 1].
  * Attribution automatique du statut académique (`Admis` si moyenne ≥ 10, `Redoublant` sinon)[cite: 1].

---

## 🏗️ Architecture du projet

Le projet suit une architecture en couches séparant les modèles, la logique métier et l'interface utilisateur[cite: 1] :

```text
IvoireSchool Project/
└── src/
    ├── Main.java                       # Point d'entrée de l'application
    ├── models/
    │   ├── Personnes.java              # Classe abstraite mère (identifiant, nom, prénom, âge)
    │   ├── Eleves.java                 # Modèle Élève (classe, notes, moyenne, statut)
    │   └── Professeurs.java            # Modèle Professeur (matière, expérience)
    ├── services/
    │   ├── ElevesServices.java         # Logique métier liée aux élèves et au calcul de moyennes
    │   └── ProfesseursServices.java    # Logique métier liée aux professeurs
    └── ui/
        └── IvoireSchoolInterface.java  # Menu interactif en ligne de commande (CLI)
