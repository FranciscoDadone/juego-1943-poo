package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.ObjetoGrafico;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Texto extends ObjetoGrafico {

    private String texto;
    private int fontSize, w, h;

    public Texto (String texto, int fontSize, int x, int y, int w, int h) {
        this.texto = texto;
        this.fontSize = fontSize;
        this.w = w;
        this.h = h;
        this.setPosicion(x, y);
    }

    @Override
    public void update(double delta) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.createGraphics();

        g.setFont(new Font("Arial", Font.BOLD, this.fontSize));
        FontMetrics fm = g.getFontMetrics();
        int x = img.getWidth() - fm.stringWidth(texto);
        int y = fm.getHeight();
        g.setColor(Color.WHITE);
        g.drawString(texto, x, y);

        this.setImagen(img);
    }
}
