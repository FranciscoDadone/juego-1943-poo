package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;

import java.awt.*;
import java.awt.image.BufferedImage;

public class VidaJefe extends ObjetoGrafico {
    private double cantidadVida;
    private BufferedImage vida;
    private Graphics gVida;
    private int widthFondo = Juego1943.getFrame().getWidth() / 5;
    private int width = widthFondo - 6;

    public VidaJefe() {
        this.cantidadVida = 0;
        this.setPosicion(Juego1943.getFrame().getWidth() - 280, 40);
    }
    @Override
    public void update(double delta) {

        this.cantidadVida = (Juego1943.jefeFinal != null) ? Juego1943.jefeFinal.getVida() : 0;

        if (this.cantidadVida > 100)
            this.setCantidadVida(100);

        vida = new BufferedImage(widthFondo, 20, BufferedImage.TYPE_INT_ARGB);

        BufferedImage fondo = new BufferedImage(widthFondo, 20, BufferedImage.TYPE_INT_ARGB);
        Graphics gFondo = fondo.getGraphics();
        gFondo.setColor(Color.DARK_GRAY);
        gFondo.fillRect(0,0,widthFondo,30);

        gVida = vida.getGraphics();
        gVida.drawImage(fondo, 0, 0, widthFondo, 30, null);

        int wVida = (int) (width * (cantidadVida / 100));

        BufferedImage rojo = new BufferedImage(width / 4, 14, BufferedImage.TYPE_INT_ARGB);
        Graphics gRojo = rojo.getGraphics();
        gRojo.setColor(Color.RED);
        gRojo.fillRect(0, 0, width, 14);
        gVida.drawImage(rojo, 3, 3, wVida, 14, null);

        if (cantidadVida > 0) this.setImagen(vida);
        else this.setImagen(null);
    }

    public double getCantidadVida() {
        return cantidadVida;
    }

    public void bajarVida(int valor) {
        setCantidadVida(getCantidadVida()-valor);
    }
    public void subirVida(int valor) {
        setCantidadVida(getCantidadVida()+valor);
    }

    public void setCantidadVida(double cantidadVida) {
        this.cantidadVida = cantidadVida;
    }
}
