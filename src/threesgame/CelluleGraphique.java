/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threesgame;

import java.awt.Color;
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
     super.paintComponent(g);
     if (celluleChiffreeAssociee.valeur!=0){
        this.setText(""+celluleChiffreeAssociee.valeur);

        if (celluleChiffreeAssociee.valeur == 1 || celluleChiffreeAssociee.valeur == 2 ) {
                setBackground(Color.decode("#FBEFF8"));
        }
        
        if (celluleChiffreeAssociee.valeur == 3) {
                setBackground(Color.decode("#F6CEEC"));       
        }
        
        if (celluleChiffreeAssociee.valeur == 6) {
            setBackground(Color.decode("#F781D8"));
        }
        
        if (celluleChiffreeAssociee.valeur == 12) {
            setBackground(Color.decode("#FF00BF"));
        }
        
        if (celluleChiffreeAssociee.valeur == 24) {
            setBackground(Color.decode("#DF01D7"));
        }
        
        if (celluleChiffreeAssociee.valeur == 48) {
            setBackground(Color.decode("#A901DB"));
        }
        
        if (celluleChiffreeAssociee.valeur == 96) {
            setBackground(Color.decode("#7401DF"));
        }
        
        if (celluleChiffreeAssociee.valeur == 192) {
            setBackground(Color.decode("#3A01DF"));
        }
        
        if (celluleChiffreeAssociee.valeur == 384) {
            setBackground(Color.decode("#0174DF"));
        }
        
        if (celluleChiffreeAssociee.valeur == 768) {
            setBackground(Color.decode("#01DFD7"));
        }
     }
     else {
         this.setText("");
         setBackground(Color.WHITE);
     }
 
 }
 
 
}
