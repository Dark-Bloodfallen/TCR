import java.util.ArrayList;
import java.util.Scanner;

// Objet Employe
class Employe{
    private  String nom;
    private String type;
    private double salaire;
    private double bonus;
    private  double tSalaire;

    // Constructeur
    public Employe (String nom, String type){
        this.nom = nom;
        this.type = type;
        this.salaire = 0;
        this.bonus = 0;
        this.tSalaire = 0;
    }

    // Getter & setter
    public  void setSalaire(double salaire){
        this.salaire = salaire;
    }
    public  void setBonus(double bonus){
        this.bonus = bonus;
    }

    public void settSalaire(double tSalaire) {
        this.tSalaire = tSalaire;
    }

    public double getSalaire(){
        return  salaire;
    }
    public double getBonus(){
        return  bonus;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public double gettSalaire() {
        return tSalaire;
    }

    // methode d'affichage
    public void afficher(){
        System.out.println("Nom: "+ this.getNom());
        System.out.println("Type: "+ this.getType());
        System.out.println("salaire: "+ this.getSalaire());
        System.out.println("Bonus: "+ this.getBonus());
        System.out.println("Salaire total: "+ this.gettSalaire());
    }
}

// Fonction principale
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Employe> employes = new ArrayList<>();

        /// les bonus
        double bPermanent = 0.07;
        double bContractuel = 0.04;
        double bPartiel = 0.02;

        // recuperer le nombre d'employes
        System.out.println("Entrez le nombre d'employes");
        int nbEmployes = scanner.nextInt();
//        scanner.close();

        // enregistrements de donnees
        for (int i = 0; i < nbEmployes; i++){
            System.out.println("\n Entrez ne nom de l'employe #" + (i+1));
            String nom = scanner.next();
//            scanner.close();
            System.out.println("Entrez le type de l'employe \n 1.pour Permanent \t 2.pour Contractuel \t 3.pour Partiel");
            int type0 = scanner.nextInt();
            String type;
            //conversion de type
            switch (type0){
                case 1: type = "Permanent";break;
                case 2: type = "Contractuel";break;
                case 3: type = "Partiel";break;
                default:
                    System.out.println("Type non reconnu");
                    continue;
            }

            // creation d'employe
            Employe employe = new Employe(nom,type);
            // Enregistrement du reste des infos
            // pour permanent
            if (type0 == 1){
                System.out.println("Salaire fixe mensuel:");
                double salaire = scanner.nextDouble();
                employe.setSalaire(salaire);
//                System.out.println("Entrez le pourcentage de Bonus:");
//                double pbonus = scanner.nextDouble();
                // calcule du bonus
                double bonus = salaire*bPermanent;
                employe.setBonus(bonus);
                // calcule de salaire total
                double tsalaire = salaire+bonus;
                employe.settSalaire(tsalaire);
            }
            // pour contractuel
            else if (type0 == 2){
                System.out.println("Nombre d'heures effectuees:");
                int nbheure = scanner.nextInt();
                System.out.println("Taux horaire:");
                int thoraire = scanner.nextInt();
                double salaire = nbheure*thoraire;
                employe.setSalaire(salaire);
//                System.out.println("Entrez le pourcentage de Bonus:");
//                double pbonus = scanner.nextDouble();
                // calcule du bonus
                double bonus = salaire*bContractuel;
                employe.setBonus(bonus);
                // calcule de salaire total
                double tsalaire = salaire+bonus;
                employe.settSalaire(tsalaire);
            }
            // pour le partiel
            // pour contractuel
            else if (type0 == 3){
                System.out.println("Nombre d'heures effectuees:");
                int nbheure = scanner.nextInt();
                System.out.println("Taux horaire:");
                int thoraire = scanner.nextInt();
                double salaire = nbheure*thoraire;
                employe.setSalaire(salaire);
//                System.out.println("Entrez le pourcentage de Bonus:");
//                double pbonus = scanner.nextDouble();
                // calcule du bonus
                double bonus = salaire*bPartiel;
                employe.setBonus(bonus);
                // calcule de salaire total
                double tsalaire = salaire+bonus;
                employe.settSalaire(tsalaire);
            }
            employes.add(employe);
        }
        // salaire total
        double salaireTotal = 0;
        double bonusTotal = 0;

        // rapport des employés
        System.out.println("Rapport des employés:");
        for (Employe employe:employes){
            employe.afficher();
            salaireTotal += employe.getSalaire();
            bonusTotal += employe.getBonus();
        }
        System.out.println("Le salaire total à payer est: "+ salaireTotal);
        System.out.println("Le bonus total à payer est: "+ bonusTotal);
    }
}