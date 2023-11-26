/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threesgame;

import java.awt.Graphics;
import static java.lang.Math.random;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author lunac
 */
public class CelluleGraphique extends JButton {
    
 int largeur; // largeur en pixel de la cellule
 int hauteur; // hauteur en pixel de la cellule
 int valeur;
  
 // constructeur (appelé depuis FenetrePrincipale)
 
 public CelluleGraphique() {
 this.largeur = 3;
 this.hauteur = 5;
 Random random = new Random();
 valeur=random.nextInt(3) + 1;
 
 }
 
 public void addCell(CelluleGraphique cell){
     if (valeur==1){
         
     }
 }
 
}
