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
            int ligneAleatoire = random.nextInt(matriceCellules.length - 1);
            int colonneAleatoire = random.nextInt(matriceCellules[0].length - 1);

            if (matriceCellules[ligneAleatoire][colonneAleatoire].valeur == 0) {
                matriceCellules[ligneAleatoire][colonneAleatoire].valeur = valeur;
                caseVideTrouvee = true;
            }
        }

       
    }

    public GrilleDeJeu GrilleDepart() {
        int valeur;
        Random random = new Random();
        valeur = random.nextInt(3) + 1;

        for (int i=0; i<5; i++){
            AjoutCase();
        }
        return this;
    }

    public GrilleDeJeu deplacementG() {
        
        System.out.println(this);
        for (int i = 0; i < 4; i++) {
            int j = 0;
            while (j < 3
                    && matriceCellules[i][j].valeur != 0
                    && matriceCellules[i][j].valeur != matriceCellules[i][j + 1].valeur
                    && matriceCellules[i][j].valeur + matriceCellules[i][j + 1].valeur != 3) {
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
            // sinon je n'ai pas décalé
            if (matriceCellules[i][j].valeur==matriceCellules[i][j+1].valeur){
                matriceCellules[i][j].valeur+=matriceCellules[i][j+1].valeur;
                matriceCellules[i][j].valeur=0;
            }

        }
        System.out.println(this);
        
        AjoutCase();
        return this;
    }

    public GrilleDeJeu deplacementD() {
        
        System.out.println(this);
        for (int i = 0; i < 4; i++) {
            int j = 1;
            while (j < 4
                    && matriceCellules[i][j].valeur != 0
                    && matriceCellules[i][j].valeur != matriceCellules[i][j -1].valeur
                    && matriceCellules[i][j].valeur + matriceCellules[i][j -1].valeur != 3) {
                j++;
            }
            // je décale
            for (int k = j; k < 4; k++) {
                matriceCellules[i][k].valeur = matriceCellules[i][k-1].valeur;
            }
            // j'ai du décaler 
            if (j <4 ){
                matriceCellules[i][0].valeur = 0;
            }
            // sinon je n'ai pas décalé
            if (matriceCellules[i][j].valeur==matriceCellules[i][j-1].valeur){
                matriceCellules[i][j].valeur*=2;
            }
        }
        System.out.println(this);
        AjoutCase();

        return this;
        
        
    }

    public GrilleDeJeu deplacementUp() {
        System.out.println(this);
        for (int j = 0; j < 4; j++) {
            int i = 0;
            while (i < 3
                    && matriceCellules[i][j].valeur != 0
                    && matriceCellules[i][j].valeur != matriceCellules[i+1][j].valeur
                    && matriceCellules[i][j].valeur + matriceCellules[i+1][j].valeur != 3) {
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
            // sinon je n'ai pas décalé

        }
        System.out.println(this);

        AjoutCase();
        return this;
    }
    
    public GrilleDeJeu deplacementDown(){
        System.out.println(this);
        for (int j = 0; j < 4; j++) {
            int i = 1;
            while (i < 4
                    && matriceCellules[i][j].valeur != 0
                    && matriceCellules[i][j].valeur != matriceCellules[i-1][j].valeur
                    && matriceCellules[i][j].valeur + matriceCellules[i-1][j].valeur != 3) {
                i++;
            }
            // je décale
            for (int k = i; k < 4; k++) {
                matriceCellules[k][j].valeur = matriceCellules[k-1][j].valeur;
            }
            // j'ai du décaler 
            if (i <4 ){
                matriceCellules[0][j].valeur = 0;
            }
            // sinon je n'ai pas décalé

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
