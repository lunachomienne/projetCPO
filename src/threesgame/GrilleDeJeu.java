/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threesgame;

import java.util.Random;

/**
 *
 * @author lunac
 */
public class GrilleDeJeu {

    public CelluleChiffree[][] matriceCellules;

    public GrilleDeJeu() {

        matriceCellules = new CelluleChiffree[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriceCellules[i][j] = new CelluleChiffree();
            }
        }
    }

    public void AjoutCase() {
        Random random = new Random();
        int valeur = random.nextInt(3) + 1; // Pour obtenir des valeurs entre 1 et 3 inclus

        boolean caseVideTrouvee = false;

        while (!caseVideTrouvee) {
            int ligneAleatoire = random.nextInt(matriceCellules.length);
            int colonneAleatoire = random.nextInt(matriceCellules[0].length);

            if (matriceCellules[ligneAleatoire][colonneAleatoire].valeur == 0) {
                matriceCellules[ligneAleatoire][colonneAleatoire].valeur = valeur;
                caseVideTrouvee = true;
            }
        }
    }

    /**
     * Verifie si la grille est remplie ou non
     * @return un boolean, true si elle est remplie, false sinon
     */
    public boolean VerifGrille(){
        boolean tot = true; // Initialisez tot à true

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matriceCellules[i][j].valeur == 0) {
                    // S'il y a une case vide, tot est false et sortez de la méthode
                    tot = false;
                    return tot;
                }
            }
        }

        // Si aucune case vide n'a été trouvée, tot reste true
        return tot;
    }
    

    public GrilleDeJeu GrilleDepart() {
        

        for (int i=0; i<5; i++){
            AjoutCase();
        }
        return this;
    }

    /**
     *réalise le deplacement à gauche, deplace toutes les cases vers la gauche quand c'est possible, additionne les valeurs qu'il faut.
     * @return une grille de jeu modifiée
     */
    public GrilleDeJeu deplacementG() {
        
        System.out.println(this);
        for (int i = 0; i < 4; i++) {
            int j = 0;
            while (j < 3
                    && matriceCellules[i][j].valeur != 0
                    && matriceCellules[i][j].valeur != matriceCellules[i][j + 1].valeur
                    && (matriceCellules[i][j].valeur + matriceCellules[i][j + 1].valeur != 3 || matriceCellules[i][j].valeur ==3 || matriceCellules[i][j+1].valeur ==3)) {
                j++;
            }
                        
            // je dois fusionner, je fusionne
            if (j < 3 && ((matriceCellules[i][j].valeur==matriceCellules[i][j+1].valeur)|| (matriceCellules[i][j].valeur>0 && matriceCellules[i][j+1].valeur>0 && matriceCellules[i][j].valeur + matriceCellules[i][j + 1].valeur == 3))){
                matriceCellules[i][j].valeur+=matriceCellules[i][j+1].valeur;
                matriceCellules[i][j+1].valeur=0;
                j++;
            }
            
            
            // je décale
            for (int k = j; k < 3; k++) {
                matriceCellules[i][k].valeur = matriceCellules[i][k + 1].valeur;
            }
            // j'ai du décaler 
            if (j <3 ){
                matriceCellules[i][3].valeur = 0;


        }
        }
        System.out.println(this);
        
        AjoutCase();
        return this;
    }

    /**
     *réalise le deplacement à droite, deplace toutes les cases vers la droite quand c'est possible, additionne les valeurs qu'il faut.
     * @return une grille modifiée
     */
    public GrilleDeJeu deplacementD() {
   System.out.println(this);
        for (int i = 0; i < 4; i++) {
            int j = 3;
            while (j  > 0
                    && matriceCellules[i][j].valeur != 0
                    && matriceCellules[i][j].valeur != matriceCellules[i][j - 1].valeur
                    && (matriceCellules[i][j].valeur + matriceCellules[i][j - 1].valeur != 3 || matriceCellules[i][j].valeur ==3 || matriceCellules[i][j-1].valeur ==3)) {
                j--;
            }
                        
            // je dois fusionner, je fusionne
            if (j > 0  && (matriceCellules[i][j].valeur==matriceCellules[i][j-1].valeur || (matriceCellules[i][j].valeur>0 && matriceCellules[i][j-1].valeur>0 && matriceCellules[i][j].valeur + matriceCellules[i][j - 1].valeur == 3))){
                matriceCellules[i][j].valeur+=matriceCellules[i][j-1].valeur;
                matriceCellules[i][j-1].valeur=0;
                j--;
            }
            
            
            // je décale
            for (int k = j; k > 0; k--) {
                matriceCellules[i][k].valeur = matriceCellules[i][k - 1].valeur;
            }
            // j'ai du décaler 
            if (j >0 ){
                matriceCellules[i][0].valeur = 0;


        }
        }
        System.out.println(this);
        
        AjoutCase();
        return this;     
    }

    /**
     *réalise le deplacement vers le haut, deplace toutes les cases vers le haut quand c'est possible, additionne les valeurs qu'il faut.
     * @return une grille modifiée
     */
    public GrilleDeJeu deplacementUp() {
        System.out.println(this);
        for (int j = 0; j < 4; j++) {
            int i = 0;
            while (i < 3
                    && matriceCellules[i][j].valeur != 0
                    && matriceCellules[i][j].valeur != matriceCellules[i+1][j].valeur
                    && (matriceCellules[i][j].valeur + matriceCellules[i+1][j].valeur != 3 || matriceCellules[i][j].valeur ==3 || matriceCellules[i+1][j].valeur ==3)) {
                i++;
            }
                        
            // je dois fusionner, je fusionne
            if (i < 3 && (matriceCellules[i][j].valeur==matriceCellules[i+1][j].valeur || (matriceCellules[i][j].valeur>0 && matriceCellules[i+1][j].valeur>0 && matriceCellules[i][j].valeur + matriceCellules[i+1][j].valeur == 3))){
                
                matriceCellules[i][j].valeur+=matriceCellules[i+1][j].valeur;
                matriceCellules[i+1][j].valeur=0;
                i++;
            }
            
            
            // je décale
            for (int k = i; k < 3; k++) {
                matriceCellules[k][j].valeur = matriceCellules[k+1][j].valeur;
            }
            // j'ai du décaler 
            if (i <3 ){
                matriceCellules[3][j].valeur = 0;


        }
        }
        System.out.println(this);
        
        AjoutCase();
        return this;
    }
    
    /**
     *réalise le deplacement vers le bas, deplace toutes les cases vers le bas quand c'est possible, additionne les valeurs qu'il faut.
     * @return une grille modifiée
     */
    public GrilleDeJeu deplacementDown(){
        System.out.println(this);
        for (int j = 0; j < 4; j++) {
            int i = 3;
            while (i > 0
                    && matriceCellules[i][j].valeur != 0
                    && matriceCellules[i][j].valeur != matriceCellules[i-1][j].valeur
                    && (matriceCellules[i][j].valeur + matriceCellules[i-1][j].valeur != 3 || matriceCellules[i][j].valeur ==3 || matriceCellules[i-1][j].valeur ==3)) {
                i--;
            }
                        
            // je dois fusionner, je fusionne
            if (i > 0 && (matriceCellules[i][j].valeur==matriceCellules[i-1][j].valeur || (matriceCellules[i][j].valeur>0 && matriceCellules[i-1][j].valeur>0 && matriceCellules[i][j].valeur + matriceCellules[i-1][j].valeur == 3))){
                while ((matriceCellules[i][j].valeur!=matriceCellules[i-1][j].valeur && (matriceCellules[i][j].valeur==1 || matriceCellules[i][j].valeur==2))){
                matriceCellules[i][j].valeur+=matriceCellules[i-1][j].valeur;
                matriceCellules[i-1][j].valeur=0;
                i--;
            }
            }
            
            
            // je décale
            for (int k = i; k > 0; k--) {
                matriceCellules[k][j].valeur = matriceCellules[k-1][j].valeur;
            }
            // j'ai du décaler 
            if (i >0 ){
                matriceCellules[0][j].valeur = 0;


        }
        }
        System.out.println(this);
        
        AjoutCase();
        return this;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result += matriceCellules[i][j];
            }
            result += "\n";
        }
        return result;

    }
}
