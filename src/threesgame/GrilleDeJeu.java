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
        Random random = new Random();
        int valeur = random.nextInt(3) + 1; // Pour obtenir des valeurs entre 1 et 3 inclus

        boolean caseVideTrouvee = false;

        while (!caseVideTrouvee) {
            int ligneAleatoire = random.nextInt(matriceCellules.length-1);
            int colonneAleatoire = random.nextInt(matriceCellules[0].length-1);

            if (matriceCellules[ligneAleatoire][colonneAleatoire].valeur == 0) {
                matriceCellules[ligneAleatoire][colonneAleatoire].valeur = valeur;
                caseVideTrouvee = true;
            }
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
                if (j==0 || j==1 || j==2){
                    if (matriceCellules[i][j].valeur==matriceCellules[i][j+1].valeur){
                        matriceCellules[i][j].valeur*=2;
                        if (j==0){
                            matriceCellules[i][j+1]=matriceCellules[i][j+2];
                            matriceCellules[i][j+2]=matriceCellules[i][j+3];
                            matriceCellules[i][j+3].valeur=0;
                            
                        }
                        if (j==1){
                            matriceCellules[i][j+1]=matriceCellules[i][j+2];
                            matriceCellules[i][j+2].valeur=0;
                        }
                        if (j==2){
                            matriceCellules[i][j+1].valeur=0;
                        }
                        
                    }
                    if (matriceCellules[i][j].valeur==0){
                        matriceCellules[i][j]=matriceCellules[i][j+1];
                    }
                    
                    
                    
                }
                if (j==3){
                    if (matriceCellules[i][j-1].valeur==0){
                        matriceCellules[i][j-1]=matriceCellules[i][j];
                    }
                    
                }
                
            }
        }
        AjoutCase();
        return this;
    }
    
    public GrilleDeJeu deplacementD(){
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (j==3 || j==1 || j==2){
                    if (matriceCellules[i][j].valeur==matriceCellules[i][j-1].valeur){
                        matriceCellules[i][j].valeur*=2;
                        if (j==3){
                            matriceCellules[i][j-1]=matriceCellules[i][j-2];
                            matriceCellules[i][j-2]=matriceCellules[i][j-3];
                            matriceCellules[i][j-3].valeur=0;
                            
                        }
                        if (j==2){
                            matriceCellules[i][j-1]=matriceCellules[i][j-2];
                            matriceCellules[i][j-2].valeur=0;
                        }
                        if (j==1){
                            matriceCellules[i][j-1].valeur=0;
                        }
                        
                   
                        if (matriceCellules[i][j].valeur==0){
                            matriceCellules[i][j]=matriceCellules[i][j-1];
                        }
                    
                    
                }
                if (j==0){
                    if (matriceCellules[i][j+1].valeur==0){
                        matriceCellules[i][j+1]=matriceCellules[i][j];
                    }
                }
            }
        }
        }
        AjoutCase();
        return this;
    }
    
    public GrilleDeJeu deplacementUp(){
        for (int i=0; i<4; i++){
          for (int j=0; j<4; j++){
              if (i==1){
                  if (matriceCellules[i][j].valeur==matriceCellules[i+1][j].valeur){
                      matriceCellules[i][j].valeur=2*matriceCellules[i][j].valeur;
                      matriceCellules[i+1][j]=matriceCellules[i+2][j];
                  }else{
                      if (matriceCellules[i][j].valeur==0){
                          matriceCellules[i][j]=matriceCellules[i-1][j];
                      }
                  }
                  
              }
              if (i==0){
                  if (matriceCellules[i+1][j].valeur==matriceCellules[i][j].valeur){
                      matriceCellules[i][j].valeur=2*matriceCellules[i][j].valeur;
                      matriceCellules[i+1][j].valeur=matriceCellules[i+2][j].valeur;
                    }
              }
              if (i==2){
                  if (matriceCellules[i][j].valeur==matriceCellules[i+1][j].valeur){
                      matriceCellules[i][j].valeur=2*matriceCellules[i][j].valeur;
                      matriceCellules[i+1][j].valeur=0;
                  }
             }
              if (i==3){
                  if (matriceCellules[i][j].valeur==matriceCellules[i-1][j].valeur){
                      matriceCellules[i-1][j].valeur=2*matriceCellules[i][j].valeur;
                      matriceCellules[i][j].valeur=0;
                  }
              }
        }
    
        }
    AjoutCase();
    return this;
    }
}

