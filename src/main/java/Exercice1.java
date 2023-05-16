import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercice1 {

    public static void main(String[] args){



        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une chaîne de caractères : ");
        String chaine = scanner.nextLine();
        chaine = chaine.replaceAll("\\s", ""); // Supprime les espaces
        chaine = chaine.toLowerCase(); // Convertit tous les caractères en minuscules

        Map<Character, Integer> occurences = new HashMap<Character, Integer>();

        for (int i = 0; i < chaine.length(); i++) {
            char lettre = chaine.charAt(i);
            Integer compteur = occurences.get(lettre);
            if (compteur == null) {
                occurences.put(lettre, 1);
            } else {
                occurences.put(lettre, compteur + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : occurences.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }
}
