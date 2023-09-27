import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat format = new DecimalFormat("#.###");
            float r100, r50, r10, r2;
            int nb100, nb50, nb10, nb2, nb1;

            System.out.println("Saisissez la somme");
            float somme = Float.parseFloat(scanner.next());

            nb100 = (int) (somme/100);
            r100 = somme%100;

            nb50 = (int) (r100/50);
            r50 = r100%50;

            nb10 = (int) (r50/10);
            r10 = r50%10;

            nb2 = (int) (r10/2);
            r2 = r10%2;

            nb1 = (int) r2;

            float reste = Float.parseFloat(format.format(r2-nb1));

        System.out.println("Le nombre de billets de 100 est:"+nb100);
        System.out.println("Le nombre de billets de 50 est:"+nb50);
        System.out.println("Le nombre de billets de 10 est:"+nb10);
        System.out.println("Le nombre de pieces de 2 est:"+nb2);
        System.out.println("Le nombre de pieces de 1 est:"+nb1);
        System.out.println("Le reste est:"+reste);


    }
}