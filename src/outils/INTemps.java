package outils;

import java.util.regex.Pattern;

public class INTemps {
    private static String getTexte(String modele, String format) {
        String texte;
        boolean erreur;
        do {
            erreur = false;
            texte = IN.getString();
            if (!Pattern.matches(modele, texte)) {
                System.out.println("Veuillez entrer une réponse au format " + format + " !");
                erreur = true;
            }
        } while (erreur);
        return texte;
    }
    public static String getTexteDate() {
        return getTexte("^[0-3]{0,1}[0-9]{1}/[0-1]{0,1}[0-9]{1}/[0-9]{4}$", "[3]9/[1]9/9999");
    }
    public static String getTexteHeure() {
        return getTexte("^[0-2]{0,1}[0-9]{1}:[0-5]{1}[0-9]{1}", "[2]9:59");
    }
    public static String getTexteDuree() {
        return getTexte("^[0-9]+:[0-9]{2}$", "[9]9:99");
    }
}
