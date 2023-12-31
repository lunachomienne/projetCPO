/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package threesgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
//import java.util.Timer;
import javax.swing.Timer;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

/**
 *
 * @author lunac
 */
public class FenetrePrincipale extends javax.swing.JFrame {

    /**
     * Creates new form FenetrePrincipale
     */
    GrilleDeJeu grille;
    int nbCoups=0;
    int score=0;
    //boolean sound=false;
    Reglages f=new Reglages ();
    private int time = 60;
    int Theme=1;
    
    
    public void InitialiserPartie(){
        
        grille.GrilleDepart();
        
    }
    
    public FenetrePrincipale(boolean mode) {
        
        initComponents();     
       
        
        tempsRestant.setText("");
        if (mode==true){        //si le mode sélectionné est la Course contre la Montre:
            tempsRestant.setText("" + time);                            // création d'un décompte 
            Timer timer = new Timer(1000, new ActionListener() {
            private boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                time--;
                tempsRestant.setText("" + time);

                if (time < 15) {
                    // dès qu'il reste 15 secondes 
                    Font policeNormale = tempsRestant.getFont();
                    visible = !visible;
                    tempsRestant.setVisible(visible);       // le JLabel du décompte clignote
                    tempsRestant.setFont(new Font(policeNormale.getName(), Font.BOLD, policeNormale.getSize()));
                    tempsRestant.setForeground(Color.RED);      // le décompte est en rouge, en caractère gras
                }

                if (time <= 0) {        // dès que le temps est écoulé, la partie est finie
                    ((Timer)e.getSource()).stop();
                    score = grille.CalculScore();
                    FenetreDefaite f = new FenetreDefaite(nbCoups, score); //une fenêtre défaite s'ouvre
                    f.setVisible(true);
                    FenetrePrincipale.this.dispose();
                }
            }
            });
            timer.start();
        }
        
        int rand;
        this.grille= new GrilleDeJeu();
        InitialiserPartie();
        Random random = new Random();
        rand=random.nextInt(4) + 1;
        GrilleJeu.setLayout(new GridLayout(4, 4));
        
        for (int i=0; i < 4; i++) {
            for (int j=0; j < 4; j++ ) {
            CelluleGraphique bouton_cellule = new CelluleGraphique(grille.matriceCellules[i][j]);
            if(j==rand){
                bouton_cellule.celluleChiffreeAssociee.valeur=random.nextInt(3) + 1;
                if (bouton_cellule.celluleChiffreeAssociee.valeur!=0){
                    bouton_cellule.setText(""+bouton_cellule.celluleChiffreeAssociee.valeur);
                    rand=random.nextInt(4)+1;
                }
                
            }
            if (i==rand){
                bouton_cellule.celluleChiffreeAssociee.valeur=random.nextInt(3) + 1;
                if (bouton_cellule.celluleChiffreeAssociee.valeur!=0){
                    bouton_cellule.setText(""+ bouton_cellule.celluleChiffreeAssociee.valeur);
                    rand=random.nextInt(4)+1; 
                }
            }
            GrilleJeu.add(bouton_cellule); // ajout au Jpanel PanneauGrille
            }        
        }
        
        
        
        
        
        
        // association des jButtons aux touches flêches du clavier
        bindButtonToKey(leftButton, KeyEvent.VK_LEFT);
        bindButtonToKey(rightButton, KeyEvent.VK_RIGHT);
        bindButtonToKey(upButton, KeyEvent.VK_UP);
        bindButtonToKey(downButton, KeyEvent.VK_DOWN);
       
        
        
        
    }
    
    
    // fonction permettant l'associationd'un bouton à une touche du clavier
    private void bindButtonToKey(JButton button, int keyCode) {
        
        InputMap inputMap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = button.getActionMap();

        String key = "key" + keyCode;

        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0, false), key);
        actionMap.put(key, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
            }
        });
    }
       
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        GrilleJeu = new javax.swing.JPanel();
        leftButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        reglages = new javax.swing.JButton();
        tempsRestant = new javax.swing.JLabel();
        deco1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(445, 540));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GrilleJeu.setBackground(new java.awt.Color(102, 204, 255));
        GrilleJeu.setLayout(new java.awt.GridLayout());
        getContentPane().add(GrilleJeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 249, 360));

        leftButton.setBackground(new java.awt.Color(102, 204, 255));
        leftButton.setFont(new java.awt.Font("Bauhaus 93", 0, 12)); // NOI18N
        leftButton.setText("left");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });
        getContentPane().add(leftButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 48, -1));

        upButton.setBackground(new java.awt.Color(102, 204, 255));
        upButton.setFont(new java.awt.Font("Bauhaus 93", 0, 12)); // NOI18N
        upButton.setText("up");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        getContentPane().add(upButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 60, -1));

        downButton.setBackground(new java.awt.Color(102, 204, 255));
        downButton.setFont(new java.awt.Font("Bauhaus 93", 0, 12)); // NOI18N
        downButton.setText("down");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        getContentPane().add(downButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 60, -1));

        rightButton.setBackground(new java.awt.Color(102, 204, 255));
        rightButton.setFont(new java.awt.Font("Bauhaus 93", 0, 12)); // NOI18N
        rightButton.setText("right");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });
        getContentPane().add(rightButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 55, -1));

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 497, -1, -1));

        reglages.setBackground(new java.awt.Color(255, 153, 204));
        reglages.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        reglages.setText("Accéder aux réglages");
        reglages.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                reglagesComponentShown(evt);
            }
        });
        reglages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reglagesActionPerformed(evt);
            }
        });
        getContentPane().add(reglages, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 249, 25));

        tempsRestant.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tempsRestant.setText("jLabel1");
        getContentPane().add(tempsRestant, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 42, 37, -1));

        deco1.setText(" ");
        getContentPane().add(deco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        //actions effectuées lors du clic gauche (même principe pour tous les boutons de mouvements):
        
        nbCoups+=1;  //le nb de coups s'incrémente de 1 à chaque mvt
        this.grille.deplacementG();
        GrilleJeu.repaint();     
        if (grille.VerifGrille()==true){  // si la grille est pleine, on calcule le score total, ouvre la fenetre defaite, et ferme la partie
            score=grille.CalculScore();
            
            FenetreDefaite f=new FenetreDefaite(nbCoups, score);
            f.setVisible(true);
            this.dispose();
        }
        
        System.out.println(this.grille);
        System.out.println(nbCoups);
        
    }//GEN-LAST:event_leftButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        // TODO add your handling code here:
        nbCoups+=1;
        this.grille.deplacementDown();
        GrilleJeu.repaint();
        
        if (grille.VerifGrille()==true ){
            score=grille.CalculScore();
            FenetreDefaite f=new FenetreDefaite(nbCoups, score);
            f.setVisible(true);
            this.dispose();
            
        }
        
        System.out.println(this.grille);
    }//GEN-LAST:event_downButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        // TODO add your handling code here:
        nbCoups+=1;
        this.grille.deplacementUp();
        GrilleJeu.repaint();
        if (grille.VerifGrille()==true ){
            score=grille.CalculScore();  
            FenetreDefaite f=new FenetreDefaite(nbCoups, score);
            f.setVisible(true);
            this.dispose(); 
        } 
        
        
        System.out.println(this.grille);
    }//GEN-LAST:event_upButtonActionPerformed

    private void reglagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reglagesActionPerformed
        //actions lorsques la touche reglage est touchée:
        
        f.setVisible(true);   //ouverture d'une page d'options
   
    }//GEN-LAST:event_reglagesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        SoundHandler.StopMusic();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        // TODO add your handling code here:
        nbCoups+=1;
        this.grille.deplacementD();
        GrilleJeu.repaint();
        if (grille.VerifGrille()==true){
            score=grille.CalculScore();
            FenetreDefaite f=new FenetreDefaite(nbCoups, score);
            f.setVisible(true);
            this.dispose();
        }

        System.out.println(this.grille);
    }//GEN-LAST:event_rightButtonActionPerformed

    private void reglagesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_reglagesComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_reglagesComponentShown

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel GrilleJeu;
    public static javax.swing.JLabel deco1;
    public static javax.swing.JButton downButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    public static javax.swing.JButton leftButton;
    public static javax.swing.JButton reglages;
    public static javax.swing.JButton rightButton;
    private javax.swing.JLabel tempsRestant;
    public static javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
}
