import java.util.Scanner;

public class Exercice3 {



        private static final String[] dizaines = { "", "dix", "vingt", "trente", "quarante", "cinquante", "soixante", "soixante-dix", "quatre-vingt", "quatre-vingt-dix" };
        private static final String[] unites = { "", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf" };

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez un nombre : ");
            int nombre = scanner.nextInt();

            String resultat = convertirEnLettres(nombre);
            System.out.println(resultat);
        }

        private static String convertirEnLettres(int nombre) {
            if (nombre < 0 || nombre > 999) {
                throw new IllegalArgumentException("Le nombre doit être compris entre 0 et 999.");
            }

            if (nombre == 0) {
                return "zéro";
            }

            String resultat = "";

            int centaines = nombre / 100;
            if (centaines > 0) {
                resultat += unites[centaines] + " cent ";
            }

            int dizainesEtUnites = nombre % 100;
            if (dizainesEtUnites > 0) {
                if (dizainesEtUnites < 20) {
                    resultat += unites[dizainesEtUnites];
                } else {
                    int dizaine = dizainesEtUnites / 10;
                    int unite = dizainesEtUnites % 10;
                    if (unite == 0 && dizaine == 7 || unite == 1) {
                        resultat += dizaines[dizaine] + " et " + unites[unite + 10];
                    } else {
                        resultat += dizaines[dizaine];
                        if (unite > 0) {
                            resultat += "-" + unites[unite];
                        }
                    }
                }
            }

            return resultat;
        }

    }



