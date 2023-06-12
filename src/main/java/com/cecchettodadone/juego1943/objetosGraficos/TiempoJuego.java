package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TiempoJuego extends ObjetoGrafico {

    private int segundos;
    private int counter;
    private int frameWidth = Juego1943.getFrame().getWidth();
    private int frameHeight = Juego1943.getFrame().getHeight();

    public TiempoJuego () {
        this.segundos = 10;
        this.setPosicion((frameWidth / 2) - 300, frameHeight - 80);
    }


    @Override
    public void update(double delta) {
        BufferedImage img = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.createGraphics();

        String s = Integer.toString(segundos);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        FontMetrics fm = g.getFontMetrics();
        int x = img.getWidth() - fm.stringWidth(s);
        int y = fm.getHeight();
        g.setColor(Color.WHITE);
        g.drawString(s, x, y);

        this.setImagen(img);

        if (this.segundos > 0) counter++;
        if (((int) (delta * counter)) > 0 && this.segundos > 0) {
            counter = 0;
            this.segundos -= 1;
        }

    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
}
