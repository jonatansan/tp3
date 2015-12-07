
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jonathan Milot
 */
public class JeuDeLaVie {

    //private static Grille grilleDeJeu;
    private static final ArrayList<Integer> nbThreads = new ArrayList<>(Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128, 256));

    //Functions tests et benchmark
    private static void runTests() {
        boolean erreur = false;
        int compteurErreur = 0;
        int compteurTest = 0;
        //Tests séquentiels
        for (int i = 0; i < Test.arrayTests.size(); i++) {

            Grille grilleDeJeu = Test.arrayTests.get(i);
            Grille grilleDeJeu_result = Test.arrayTests.get(i + 1);//new Grille(new boolean[ Test.arrayTests.get(i).x][ Test.arrayTests.get(i).y], Test.arrayTests.get(i).x, Test.arrayTests.get(i).y);

            methode_seq(grilleDeJeu, grilleDeJeu_result, Test.arrayTests.get(i).x, Test.arrayTests.get(i).y);

            if (!grillesEgales(grilleDeJeu_result, Test.arrayTests.get(i + 1), Test.arrayTests.get(i + 1).x, Test.arrayTests.get(i + 1).y)) {
                System.out.println("Erreur, la grille_test" + i / 2 + " a été mal calculée ! (méthode séquentielle)");
                erreur = true;
                ++compteurErreur;
            }
            ++i;
            ++compteurTest;
        }

        //Tests parallèles
        for (Integer nbThread : nbThreads) {
            for (int j = 0; j < Test.arrayTests.size(); j++) {
                Grille grilleDeJeu = Test.arrayTests.get(j);
                Grille grilleDeJeu_result = Test.arrayTests.get(j + 1);
                methode_par(nbThread, grilleDeJeu, grilleDeJeu_result, Test.arrayTests.get(j).x, Test.arrayTests.get(j).y);
                if (!grillesEgales(grilleDeJeu_result, Test.arrayTests.get(j + 1), Test.arrayTests.get(j).x, Test.arrayTests.get(j).y)) {
                    System.out.println("Erreur, la grille_test" + j / 2 + " a été mal calculée ! (méthode parallèle avec " + nbThread + " threads)");
                    erreur = true;
                    ++compteurErreur;
                }
                ++j;
                ++compteurTest;
            }
        }
        if (!erreur) {
            System.out.println("Tous les " + compteurTest + " tests passent !");
        } else {
            System.out.println(compteurErreur + "/" + compteurTest + " tests n'ont pas passés !");
        }
    }

    private static void runBenchmark() {
        
        int grilleSize = 30000;
        Grille grilleDeJeu = new Grille(new boolean[grilleSize][grilleSize], grilleSize, grilleSize);
        Grille grilleDeJeu_result = new Grille(new boolean[grilleSize][grilleSize], grilleSize, grilleSize);
        grilleDeJeu.populate(); // Met des valeurs dans la grille, histoire de ne pas avoir que des Faux
        
        long moyenneSeq = 0;
        
        System.out.println("Methode\t\tTemps (ms)");
        
        for (int i = 0; i < 3; i++) {

            long start = System.currentTimeMillis();
            methode_seq(grilleDeJeu, grilleDeJeu_result, grilleSize, grilleSize);
            long end = System.currentTimeMillis();
            moyenneSeq += end - start;
        }

        System.out.println("Séquentiel:\t" + (moyenneSeq / 3) + " (ms)");

        
        for (Integer nbThread : nbThreads) {
            long moyennePar = 0;
            for (int j = 0; j < 3; j++) {
                long start = System.currentTimeMillis();
                methode_par(nbThread, grilleDeJeu, grilleDeJeu_result, grilleSize, grilleSize);
                long end = System.currentTimeMillis();
                //System.out.println("Temps d'exécution " + nbThreads.get(i) + " threads : " + (end - start) + " ms."); 
                moyennePar += end - start;
            }
            System.out.println(nbThread + " threads:\t" + (moyennePar / 3) + " (ms)"); 
        }
    }

    // Fonctions utilitaires
    public static boolean grillesEgales(Grille grille1, Grille grille2, int x, int y) {
        assert (grille1.x == grille2.x && grille1.y == grille2.y);
        boolean equal = true;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grille1.grille[i][j] != grille2.grille[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int inf(int i, int n, int nbThreads) {
        return (int) (i * ((double) n / (double) nbThreads));
    }

    private static int sup(int i, int n, int nbThreads) {
        return (int) ((i + 1.0) * ((double) n / (double) nbThreads));
    }

    private static void methode_seq_i_j(Grille grille, Grille result, int i, int j, int x, int y) {
        assert (grille.x == result.x && grille.y == result.y);
        //System.out.println("Thread:" + Thread.currentThread().getId() + " calcule pour x de " + i + " à " + (j) + ".");
        for (int k = i; k < j; k++) {
            for (int l = 0; l < y; l++) {
                int nVoisinsVivants = 0;
                // Tester les voisins en ligne
                if (k > 0 && grille.grille[k - 1][l]) {
                    nVoisinsVivants++;
                }
                if (k < x - 1 && grille.grille[k + 1][l]) {
                    nVoisinsVivants++;
                }
                if (l > 0 && grille.grille[k][l - 1]) {
                    nVoisinsVivants++;
                }
                if (l < y - 1 && grille.grille[k][l + 1]) {
                    nVoisinsVivants++;
                }

                // Tester les voisins en diagonal
                if (k > 0 && l > 0 && grille.grille[k - 1][l - 1]) {
                    nVoisinsVivants++;
                }
                if (k > 0 && l < y - 1 && grille.grille[k - 1][l + 1]) {
                    nVoisinsVivants++;
                }
                if (k < x - 1 && l > 0 && grille.grille[k + 1][l - 1]) {
                    nVoisinsVivants++;
                }
                if (k < x - 1 && l < y - 1 && grille.grille[k + 1][l + 1]) {
                    nVoisinsVivants++;
                }

                if ((nVoisinsVivants == 2 || nVoisinsVivants == 3) && grille.grille[k][l]) {
                    result.grille[k][l] = true;
                } else if (nVoisinsVivants == 3) {
                    result.grille[k][l] = true;
                } else {
                    result.grille[k][l] = false;
                }
            }
        }
    }

    // Méthode Séquentielle
    private static void methode_seq(Grille grille, Grille result, int x, int y) {
        methode_seq_i_j(grille, result, 0, x, x, y);
    }

    // Méthode parallèle
    private static void methode_par(final int nbThreads, Grille grille, Grille result, int x, int y) {
        Thread[] threads = new Thread[nbThreads];

        for (int i = 0; i < nbThreads; i++) {
            final int x_f = x;
            final int y_f = y;
            final int i_f = i;
            threads[i] = new Thread() {
                @Override
                public void run() {
                    methode_seq_i_j(grille,
                            result,
                            inf(i_f, x_f, nbThreads),
                            sup(i_f, x_f, nbThreads),
                            x_f,
                            y_f);
                }
            };
            threads[i].start();
        }
        for (int i = 0; i < nbThreads; i++) {
            try {
                threads[i].join();
            } catch (Exception e) {
            }
        }
        //return result;
    }

    /**
     * @param args BenmarckOrTest parOrSeq nbThread
     */
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        switch (args[0]) {
            case "test":
                runTests();
                break;
            case "benchmark":
                runBenchmark();
                break;
            default:
                System.out.println("Argument \""+ args[0] +"\" inconnu. L'argument doit être \"test\" ou \"benchmark\".");
        }
    }
}
