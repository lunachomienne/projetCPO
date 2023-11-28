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
  
 CelluleChiffree celluleChiffreeAssociee;
 int largeur; // largeur en pixel de la cellule
 int hauteur; // hauteur en pixel de la cellule
 
  
 // constructeur (appelé depuis FenetrePrincipale)
 
 public CelluleGraphique(CelluleChiffree cellule) {
    celluleChiffreeAssociee=cellule;
    this.largeur = 3;
    this.hauteur = 5;
    celluleChiffreeAssociee.valeur =0;
 
 }
 
 @Override
 protected void paintComponent(Graphics g){
     super.paintComponents(g);
     this.setText(""+celluleChiffreeAssociee.valeur);
 }
 
 
}
