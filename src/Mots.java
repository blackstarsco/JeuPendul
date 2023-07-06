
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Classe fournie avec l'enonce du TP2 INF1120 E23.
 *
 * @author Melanie Lord
 * @version E23
 */
public class Mots {

   private static final ArrayList<String> MOTS_NIVEAU_1 = new ArrayList<>();
   private static final ArrayList<String> MOTS_NIVEAU_2 = new ArrayList<>();
   private static final ArrayList<String> MOTS_NIVEAU_3 = new ArrayList<>();
   private static final String FIC_MOTS = "mots.txt";

   /**
    * Lit le fichier mots.txt et place les mots dans les listes MOTS_NIVEAU_1, 
    * MOTS_NIVEAU_2 et MOTS_NIVEAU_3, selon leur nombre de lettres.
    */
   public static void initMots() {
      Path cheminFic;
      
      try {
         cheminFic = Paths.get(FIC_MOTS);
         
         Files.lines(cheminFic)
            .filter(ligne -> !ligne.trim().isEmpty() && !ligne.startsWith("#"))
            .forEach(m -> {
               if (m.length() <= 6) 
                  MOTS_NIVEAU_1.add(m);
               else if (m.length() <= 12) 
                  MOTS_NIVEAU_2.add(m);
               else 
                  MOTS_NIVEAU_3.add(m);
            });

      } catch (Exception e) {
         System.err.println("\n\nERREUR DE LECTURE DU FICHIER mots.txt !!!\n"
            + "Veuillez verifier que le fichier mots.txt se trouve bien a la "
            + "racine de votre projet.\n\n");
      }
   }
   
   /**
    * Cette methode retourne un mot du niveau de difficulte donne tire au hasard.
    * NiveauDifficulte = 1 : mot de 6 lettres ou moins. NiveauDifficulte = 2 :
    * mot entre 7 et 12 lettres. NiveauDifficulte = 3 : mot de plus de 12
    * lettres.
    *
    * @param niveauDifficulte le niveau de difficulte du mot retourne.
    * @return un mot tire au hasard selon niveauDifficulte si celui-ci est entre
    *         1 et 3 inclus. Sinon, retourne null.
    */
   public static String tirerUnMot(int niveauDifficulte) {
      String mot = null;
      
      switch (niveauDifficulte) {
         case 1:
            mot = MOTS_NIVEAU_1.get(tirerUnNombre(0, MOTS_NIVEAU_1.size() - 1));
            break;
         case 2:
            mot = MOTS_NIVEAU_2.get(tirerUnNombre(0, MOTS_NIVEAU_2.size() - 1));
            break;
         case 3:
            mot = MOTS_NIVEAU_3.get(tirerUnNombre(0, MOTS_NIVEAU_3.size() - 1));
            break;
      }
      
      return mot;
   }

   /**
    * Cette methode retourne un nombre entier tire au hasard entre min et max
    * inclusivement.
    *
    * @param min la borne minimale du nombre a tirer
    * @param max la borne maximale du nombre a tirer
    * @return un entier tire au hasard entre min et max inclusivement.
    */
   private static int tirerUnNombre(int min, int max) {
      return (int) (Math.random() * (max - min) + min + 0.5);
   }
   
}
