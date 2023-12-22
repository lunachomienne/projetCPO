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
 
    public static void RunMusic(String path) {
        path = "C:\\Users\\lunac\\OneDrive - Fondation EPF\\projet cpo\\ThreesGame\\src\\threesgame\\music\\backgroundMusic";
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            
            // Utilisez la variable statique de la classe au lieu de déclarer une nouvelle variable locale
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
    
    public static void StopMusic() {
        // Vérifiez si le clip est différent de null avant de l'arrêter
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.flush();
        }
    }
}
