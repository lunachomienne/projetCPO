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
    
    public GrilleDeJeu(){
        
        matriceCellules=new CelluleChiffree[4][4];
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                matriceCellules[i][j]=new CelluleChiffree();
            }
        }
    }
    
    public GrilleDeJeu AjoutCase(){
        int valeur;
        Random random = new Random();
        valeur=random.nextInt(3) + 1;  
        
        int ligneAleatoire = random.nextInt(matriceCellules.length);
        int colonneAleatoire = random.nextInt(matriceCellules.length);
        if (matriceCellules[ligneAleatoire][colonneAleatoire].valeur==0){
            matriceCellules[ligneAleatoire][colonneAleatoire].valeur =valeur ;
        }else{
            AjoutCase();
        }
        return this;
    }
    
    public GrilleDeJeu GrilleDepart(){
        int valeur;
        Random random = new Random();
        valeur=random.nextInt(3) + 1;
        
        for (int i=0; i<5; i++){
            int ligneAleatoire = random.nextInt(matriceCellules.length);
            int colonneAleatoire = random.nextInt(matriceCellules[0].length);
            matriceCellules[ligneAleatoire][colonneAleatoire].valeur =valeur ;
        }
        return this;
    }
    
    public GrilleDeJeu deplacementG(){
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (j==1 || j==2){
                    if (matriceCellules[i][j].valeur==matriceCellules[i][j+1].valeur){
                        matriceCellules[i][j].valeur=2*matriceCellules[i][j].valeur;
                        matriceCellules[i][j].valeur=matriceCellules[i][j-1].valeur;
                    }  
                } 
                if (j==0){
                    if (matriceCellules[i][j].valeur==matriceCellules[i][j+1].valeur){
                        matriceCellules[i][j].valeur=2*matriceCellules[i][j].valeur;
                        
                    }
                }
                if (j==4){
                    if (matriceCellules[i][j-1].valeur==matriceCellules[i][j].valeur){
                        matriceCellules[i][j-1].valeur=2*matriceCellules[i][j-1].valeur;
                        matriceCellules[i][j].valeur=matriceCellules[i][j-1].valeur;
                    }
                }
            }
        }
        
        GrilleDeJeu grille=this.AjoutCase();
        return grille;
    }
    
    public GrilleDeJeu deplacementD(){
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (j==1 || j==2){
                    if (matriceCellules[i][j].valeur==matriceCellules[i][j+1].valeur){
                        matriceCellules[i][j+1].valeur=2*matriceCellules[i][j+1].valeur;
                        matriceCellules[i][j].valeur=matriceCellules[i][j-1].valeur;
                    }  
                } 
                if (j==0){
                    if (matriceCellules[i][j].valeur==matriceCellules[i][j+1].valeur){
                        matriceCellules[i][j+1].valeur=2*matriceCellules[i][j+1].valeur;
                        matriceCellules[i][j].valeur=0;
                        
                    }
                }
                if (j==4){
                    if (matriceCellules[i][j-1].valeur==matriceCellules[i][j].valeur){
                        matriceCellules[i][j].valeur=2*matriceCellules[i][j-1].valeur;
                        matriceCellules[i][j-1].valeur=matriceCellules[i][j-2].valeur;
                    }
                }
            }
        }
        GrilleDeJeu grille=this.AjoutCase();
        return grille;
    }
}

