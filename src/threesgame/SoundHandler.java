/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threesgame;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author lunac
 */
public class SoundHandler {
    
    public static Clip clip;
    boolean Mute=false;
 
    /**
     *cette fonction prend un chemin vers une piste audio et la lit
     * @param theme, 1 ou 2, qui va definir si on prend le path (l'audio) du mode dark ou light
     */
    public static void RunMusic(int theme) {
        
        String path1 = "C:\\Users\\lunac\\OneDrive - Fondation EPF\\projet cpo\\ThreesGame\\src\\threesgame\\music\\dark";
        String path2="C:\\Users\\lunac\\OneDrive - Fondation EPF\\projet cpo\\ThreesGame\\src\\threesgame\\music\\light";
        
        String path="";
        if (theme==2){
            path=path1;
        }
        if (theme==1){
            path=path2;
        }
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            
            // Utiliser la variable statique de la classe au lieu de déclarer une nouvelle variable locale
            clip = AudioSystem.getClip();
            
            try {
                clip.open(inputStream);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *cette fonction arrête la musique en cours 
     */
    public static void StopMusic() {
        // Vérifier  si le clip est différent de null avant de l'arrêter
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.flush();
        }
    }
}
