/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
public class Grille {

    public boolean[][] grille;
    public int x;
    public int y;

    Grille(boolean[][] _grille, int _x, int _y) {
        this.grille = _grille;
        this.x = _x;
        this.y = _y;
    }

    public void populate() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grille[i][j] = (i + j % 2 == 0);
            }
        }
    }

    public boolean equal(Grille g) {
        assert (this.x == g.x && this.y == g.y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (this.grille[i][j] != g.grille[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

}
