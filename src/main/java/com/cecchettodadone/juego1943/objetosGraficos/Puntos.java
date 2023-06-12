package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.ObjetoGrafico;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Puntos extends ObjetoGrafico {

    private int puntos;

    public Puntos () {
        this.setPosicion(10, 20);
        this.puntos = 0;
    }

    @Override
    public void update(double delta) {
        BufferedImage img = new BufferedImage(200, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.createGraphics();

        String s = "Score: " + puntos;
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics fm = g.getFontMetrics();
        int y = fm.getHeight();
        g.setColor(Color.WHITE);
        g.drawString(s, 0, y);

        this.setImagen(img);
    }

    public void agregarPuntos (int p) {
        this.puntos += p;
    }
}
