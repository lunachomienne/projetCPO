/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package threesgame;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import static threesgame.SoundHandler.clip;

/**
 *
 * @author lunac
 */
public class Reglages extends javax.swing.JFrame {

    /**
     * Creates new form Reglages
     */
   
    
    int mode=1;
    public Reglages() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        music = new javax.swing.JCheckBox();
        quitter = new javax.swing.JButton();
        theme = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel1.setText("Réglages");

        music.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        music.setText("musique  on/off");
        music.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicActionPerformed(evt);
            }
        });

        quitter.setBackground(new java.awt.Color(255, 102, 102));
        quitter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        quitter.setText("X");
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });

        theme.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        theme.setText("thème sombre/clair");
        theme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 399, Short.MAX_VALUE)
                .addComponent(quitter)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(music, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(theme, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(music)
                .addGap(31, 31, 31)
                .addComponent(theme)
                .addGap(100, 100, 100)
                .addComponent(quitter)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void musicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicActionPerformed
        // TODO add your handling code here:
        
        if (music.isSelected()){   
            
          SoundHandler.RunMusic(mode);   
          music.setText("musique On");
        }
        
        else{
            SoundHandler.StopMusic();
            music.setText("musique Off");
        }
    }//GEN-LAST:event_musicActionPerformed

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_quitterActionPerformed

    private void themeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeActionPerformed
        //selon le thème slectionné:
        
        if (theme.isSelected()){
            mode=2;
            music.setSelected(false);
            SoundHandler.StopMusic();       //des qu'un theme est choisi, la musique est arrêtée pour ne pas qu'elle recommence par dessus la nouvelle
            theme.setText("Thème sombre");
            music.setText("musique Off");
            FenetrePrincipale.GrilleJeu.setBackground(Color.decode("#0B0B61"));
            FenetrePrincipale.upButton.setBackground(Color.decode("#0B0B61"));
            FenetrePrincipale.downButton.setBackground(Color.decode("#0B0B61"));
            FenetrePrincipale.leftButton.setBackground(Color.decode("#0B0B61"));
            FenetrePrincipale.GrilleJeu.setForeground(Color.decode("#0B0B61"));
            FenetrePrincipale.upButton.setForeground(Color.decode("#BDBDBD"));
            FenetrePrincipale.downButton.setForeground(Color.decode("#BDBDBD"));
            FenetrePrincipale.leftButton.setForeground(Color.decode("#BDBDBD"));
            FenetrePrincipale.rightButton.setForeground(Color.decode("#BDBDBD"));
            FenetrePrincipale.rightButton.setBackground(Color.decode("#0B0B61"));
            FenetrePrincipale.reglages.setBackground(Color.decode("#B40404"));
            FenetrePrincipale.deco1.setIcon(new ImageIcon("C:\\Users\\lunac\\OneDrive - Fondation EPF\\projet cpo\\ThreesGame\\src\\images\\dark 1 (1).jpg"));
            
        }   
        else{
            mode=1;
            music.setSelected(false);
            SoundHandler.StopMusic();       
            theme.setText("Thème clair");
            music.setText("musique Off");
            FenetrePrincipale.GrilleJeu.setBackground(Color.decode("#00BFFF"));
            FenetrePrincipale.upButton.setBackground(Color.decode("#00BFFF"));
            FenetrePrincipale.downButton.setBackground(Color.decode("#00BFFF"));
            FenetrePrincipale.leftButton.setBackground(Color.decode("#00BFFF"));
            FenetrePrincipale.rightButton.setBackground(Color.decode("#00BFFF"));
            FenetrePrincipale.GrilleJeu.setForeground(Color.decode("#000000"));
            FenetrePrincipale.upButton.setForeground(Color.decode("#000000"));
            FenetrePrincipale.downButton.setForeground(Color.decode("#000000"));
            FenetrePrincipale.leftButton.setForeground(Color.decode("#000000"));
            FenetrePrincipale.rightButton.setForeground(Color.decode("#000000"));
            FenetrePrincipale.reglages.setBackground(Color.decode("#FA58AC"));
            FenetrePrincipale.deco1.setIcon(new ImageIcon("C:\\Users\\lunac\\OneDrive - Fondation EPF\\projet cpo\\ThreesGame\\src\\images\\light 1 (1).jpg"));
            
        }
    }//GEN-LAST:event_themeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reglages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reglages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reglages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reglages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reglages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox music;
    private javax.swing.JButton quitter;
    private javax.swing.JCheckBox theme;
    // End of variables declaration//GEN-END:variables
}
