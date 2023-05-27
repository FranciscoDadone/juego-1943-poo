package com.cecchettodadone.juego1943.audio;

import com.cecchettodadone.juego1943.Util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sonido {

    Clip clip;

    public void iniciar(String nombre) {

        try {
            File file = Util.getFile("musica/" + nombre + ".wav");
            clip = AudioSystem.getClip();
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void parar() {
        clip.stop();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }


}
