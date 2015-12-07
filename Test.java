
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jonathan
 */
public class Test {

    public static Grille grille_test0 = new Grille(new boolean[][]{{false, false, false, false, false},
    {false, false, true, false, false},
    {false, false, true, false, false},
    {false, false, true, false, false},
    {false, false, false, false, false}},
            5,
            5);
    
    public static Grille grille_test0_result = new Grille(new boolean[][]{{false, false, false, false, false},
    {false, false, false, false, false},
    {false, true, true, true, false},
    {false, false, false, false, false},
    {false, false, false, false, false}},
            5,
            5);
    
    public static Grille grille_test1 = new Grille(new boolean[][]{{true, true, false, true, true},
    {true, false, false, false, true},
    {false, false, false, false, false},
    {true, false, false, false, true},
    {true, true, false, true, true}},
            5,
            5);
    
    public static Grille grille_test1_result = new Grille(new boolean[][]{{true, true, false, true, true},
    {true, true, false, true, true},
    {false, false, false, false, false},
    {true, true, false, true, true},
    {true, true, false, true, true}},
            5,
            5);
    
    public static Grille grille_test2 = new Grille(new boolean[][]{
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, true, true, true, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, true, false, false, false, false, false, true, false, false},
    {false, true, false, false, false, false, false, true, false, false},
    {false, true, false, false, false, false, false, true, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, true, true, true, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false}},
            10,
            10);
        
    public static Grille grille_test2_result = new Grille(new boolean[][]{
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {true, true, true, false, false, false, true, true, true, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false}},
            10,
            10);
    
    public static Grille grille_test3 = new Grille(new boolean[][]{
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {true, true, true, false, false, false, true, true, true, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false}},
            10,
            10);
    
    public static Grille grille_test3_result = new Grille(new boolean[][]{
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, true, true, true, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, true, false, false, false, false, false, true, false, false},
    {false, true, false, false, false, false, false, true, false, false},
    {false, true, false, false, false, false, false, true, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, true, true, true, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false}},
            10,
            10);
    
    

    public static ArrayList<Grille> arrayTests = new ArrayList<Grille>() {
        {
            add(grille_test0);
            add(grille_test0_result);
            add(grille_test1);
            add(grille_test1_result);
            add(grille_test2);
            add(grille_test2_result);
            add(grille_test3); 
            add(grille_test3_result);
        }
    };
}
