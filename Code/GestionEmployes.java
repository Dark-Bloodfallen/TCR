import java.util.ArrayList;
import java.util.Scanner;

class Employe {
    private String nom;
    private String type;
    private double salaire;
    private double bonus;

    public Employe(String nom, String type) {
        this.nom = nom;
        this.type = type;
        this.salaire = 0;
        this.bonus = 0;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public void setBonus(double bonus) {
        
        this.bonus = bonus;
    }

    public double getSalaire() {
        return salaire;
    }

    public double getBonus() {
        return bonus;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }
}

public class GestionEmployes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employe> employes = new ArrayList<>();

        System.out.print("Entrez le nombre total d'employés : ");
        int nombreEmployes = scanner.nextInt();

        for (int i = 0; i < nombreEmployes; i++) {
            System.out.println("\nSaisie pour l'employé #" + (i + 1));
            System.out.print("Nom de l'employé : ");
            String nom = scanner.next();
            System.out.print("Type d'employé (permanent, contractuel ou partiel) : ");
            String type = scanner.new();
            Employe employe = new Employe(nom, type);

            if (type.equals("permanent")) {
                System.out.print("Salaire mensuel fixe : ");
                double salaire = scanner.nextDouble();
                employe.setSalaire(salaire);
                employe.setBonus(2); // Bonus de 2% pour les permanents
            } else if (type.equals("contractuel") || type.equals("partiel")) {
                System.out.print("Nombre d'heures travaillées : ");
                int heuresTravaillees = scanner.nextInt();
                System.out.print("Taux horaire : ");
                double tauxHoraire = scanner.nextDouble();
                double salaire = heuresTravaillees * tauxHoraire;
                employe.setSalaire(salaire);

                if (type.equals("contractuel")) {
                    employe.setBonus(4); // Bonus de 4% pour les contractuels
                } else {
                    employe.setBonus(8); // Bonus de 8% pour les employés à temps partiel
                }
            } else {
                System.out.println("Type d'employé invalide. Veuillez entrer 'permanent', 'contractuel' ou 'partiel'.");
                i--; // Répéter la saisie pour le même employé.
                continue;
            }

            employes.add(employe);
        }

        double salaireTotal = 0;

        System.out.println("\nRapport des employés :\n");
        for (Employe employe : employes) {
            double bonus = (employe.getSalaire() * employe.getBonus()) / 100;
            double salaireTotalEmploye = employe.getSalaire() + bonus;
            salaireTotal += salaireTotalEmploye;

            System.out.println("Nom : " + employe.getNom());
            System.out.println("Type : " + employe.getType());
            System.out.println("Salaire de base : " + employe.getSalaire());
            System.out.println("Pourcentage de bonus : " + employe.getBonus() + "%");
            System.out.println("Montant du bonus : " + bonus);
            System.out.println("Salaire total : " + salaireTotalEmploye);
            System.out.println();
        }

        System.out.println("Salaire total payé à tous les employés (y compris les bonus) : " + salaireTotal);
    }
}
