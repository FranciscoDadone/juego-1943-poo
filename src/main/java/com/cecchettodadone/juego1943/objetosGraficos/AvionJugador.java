package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.Util;
import com.cecchettodadone.juego1943.audio.Sonido;
import com.cecchettodadone.juego1943.configuracion.Configurador;
import com.cecchettodadone.juego1943.objetosGraficos.bonus.Ametralladora;
import com.cecchettodadone.juego1943.objetosGraficos.bonus.Bonus;
import com.entropyinteractive.Keyboard;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class AvionJugador extends Avion {
    private final int SEGUNDA_IMG_DOBLANDO_TMR = (int)Util.FRAME_RATE / 2;
    private int doblandoTmr = 0;
    private SombraAvionJugador sombra;
    private BufferedImage avion,avionDoblandoDerecha1, avionDoblandoIzquierda1, avionDoblandoDerecha2, avionDoblandoIzquierda2, avionDisparandoIzquierda1, avionDisparandoIzquierda2, avionDisparando, avionDisparandoDerecha1, avionDisparandoDerecha2;
    private int arriba;
    private int abajo;
    private int izquierda;
    private int derecha;
    private int disparo;
    private int ataqueEspecial;

    private int laser;
    private boolean alcance;
    private boolean rafaga;
    private boolean escopeta;
    private boolean tiroAncho;
    private boolean superShell;


    private boolean lasercito;
    private Direccion direc;

    public AvionJugador (int posX, int posY) {
        setDesplazamiento(300);
        avion = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion.png");
        avionDoblandoDerecha1 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_derecha1.png");
        avionDoblandoDerecha2 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_derecha2.png");
        avionDoblandoIzquierda1 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_izquierda1.png");
        avionDoblandoIzquierda2 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_izquierda2.png");

        avionDisparando = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_disparando.png");
        avionDisparandoIzquierda1 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_disparando_izq1.png");
        avionDisparandoIzquierda2 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_disparando_derecha2.png");
        avionDisparandoDerecha1 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_disparando_derecha2.png");
        avionDisparandoDerecha2 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_disparando_derecha2.png");


        sombra = new SombraAvionJugador(this);

        this.setImagen(avion);
        this.setPosicion(posX, posY);
        this.setDimensiones(new Dimension(75, 48));

        if (Configurador.getDireccion().equals("Flechas")) {
            arriba = KeyEvent.VK_UP;
            abajo = KeyEvent.VK_DOWN;
            izquierda = KeyEvent.VK_LEFT;
            derecha = KeyEvent.VK_RIGHT;
        }
        else {
            arriba = KeyEvent.VK_W;
            abajo = KeyEvent.VK_S;
            izquierda = KeyEvent.VK_A;
            derecha = KeyEvent.VK_D;
        }

        if (Configurador.getDisparo().equals("barra espaciadora"))  disparo = KeyEvent.VK_SPACE;
        else disparo = KeyEvent.getExtendedKeyCodeForChar(Configurador.getDisparo().charAt(0));

    }

    @Override
    public void update(double delta) {

        sombra.update(delta);

        Keyboard teclado = Juego1943.getFrame().getKeyboard();
        double velocidad = velDesplazamiento * delta; // Velocidad lineal

        double desplazamientoX = 0;
        double desplazamientoY = 0;

        if (teclado.isKeyPressed(abajo)) desplazamientoY += velocidad;
        if (teclado.isKeyPressed(arriba)) desplazamientoY -= velocidad;

        if (teclado.isKeyPressed(izquierda)) {
            desplazamientoX -= velocidad;
            this.setImagen((!isDisparando) ? avionDoblandoIzquierda1 : avionDisparandoIzquierda1);
            doblandoTmr++;
            setDireccion(Direccion.izquierda1);
            if (velDesplazamiento < 1000) velDesplazamiento += 10;
            if (doblandoTmr >= SEGUNDA_IMG_DOBLANDO_TMR) {
                this.setImagen((!isDisparando) ? avionDoblandoIzquierda2 : avionDisparandoIzquierda2);
                setDireccion(Direccion.izquierda2);
            }
        }

        if (teclado.isKeyPressed(derecha)) {
            desplazamientoX += velocidad;
            this.setImagen((!isDisparando) ? avionDoblandoDerecha1 : avionDisparandoDerecha1);
            doblandoTmr++;
            setDireccion(Direccion.derecha1);
            if (velDesplazamiento < 1000) velDesplazamiento += 10;
            if (doblandoTmr >= SEGUNDA_IMG_DOBLANDO_TMR) {
                this.setImagen((!isDisparando) ? avionDoblandoDerecha2 : avionDisparandoDerecha2);
                setDireccion(Direccion.derecha2);
            }
        }

        if (desplazamientoX != 0 && desplazamientoY != 0) {
            // Movimiento en diagonal
            double distanciaDiagonal = Math.sqrt(desplazamientoX * desplazamientoX + desplazamientoY * desplazamientoY);
            double factorNormalizacion = velocidad / distanciaDiagonal;
            desplazamientoX *= factorNormalizacion;
            desplazamientoY *= factorNormalizacion;
        }

        if (!teclado.isKeyPressed(derecha) && !teclado.isKeyPressed(izquierda))
            setDireccion(Direccion.adelante);

        if (!teclado.isKeyPressed(derecha) && !teclado.isKeyPressed(izquierda)) {
            this.setImagen((!isDisparando) ? avion : avionDisparando);
            doblandoTmr = 0;
            velDesplazamiento = NAVE_DESPLAZAMIENTO_NORMAL;
        }

        this.setPosicionX(this.getX() + desplazamientoX);
        this.setPosicionY(this.getY() + desplazamientoY);

        // Colisión contra las paredes del frame
        if (this.getX() + this.getDimensiones().getWidth() > Juego1943.getFrame().getWidth()) {
            this.setPosicionX(Juego1943.getFrame().getWidth() - this.getDimensiones().getWidth());
        }
        if (this.getY() + this.getDimensiones().getHeight() * 2 > Juego1943.getFrame().getHeight()) {
            this.setPosicionY(Juego1943.getFrame().getHeight() - this.getDimensiones().getHeight() * 2);
        }

        if (this.getX() <= 0) this.setPosicionX(0);
        if (this.getY() <= this.getDimensiones().getHeight()) this.setPosicionY(this.getDimensiones().getHeight());

        if (!rafaga) {
            if (teclado.isKeyPressed(disparo)) {
                isDisparando = false;
                if (!barra) {
                    disparar();
                    isDisparando = true;
                    barra = true;
                }
            } else barra = false;
        } else {
            if (teclado.isKeyPressed(disparo)) {
                if ((int)(contador * delta) != 0) {
                    disparar();
                    isDisparando = true;
                    contador = 0;
                } else {
                    contador += 15;
                    isDisparando = false;
                }
            }
        }
    }

    public void disparar () {



        if (superShell){

            Juego1943.municiones.add(new BalaSuperShell((int) this.getX() + 10, (int) this.getY() - 20, 90));
            Juego1943.municiones.add(new BalaSuperShell((int) this.getX() + this.getDimensiones().width - 10, (int) this.getY() - 20, 90));

        } else {
            if (lasercito) {
                Juego1943.municiones.add(new BalaLaser((int) this.getX() + 10, (int) this.getY() - 20, 90));
                Juego1943.municiones.add(new BalaLaser((int) this.getX() + this.getDimensiones().width - 10, (int) this.getY() - 20, 90));


            } else {
                Juego1943.municiones.add(!escopeta ? new Bala((int) this.getX() + 10, (int) this.getY() - 20, 90, alcance) : new BalaEscopeta((int) this.getX() + 10, (int) this.getY() - 20, 90, alcance));
                Juego1943.municiones.add(!escopeta ? new Bala((int) this.getX() + this.getDimensiones().width - 10, (int) this.getY() - 20, 90, alcance) : new BalaEscopeta((int) this.getX() + this.getDimensiones().width - 10, (int) this.getY() - 20, 90, alcance));

                if (tiroAncho) {
                    Juego1943.municiones.add(!escopeta ? new Bala((int) this.getX() + 10, (int) this.getY() - 20, 45, alcance) : new BalaEscopeta((int) this.getX() + 10, (int) this.getY() - 20, 45, alcance));
                    Juego1943.municiones.add(!escopeta ? new Bala((int) this.getX() + this.getDimensiones().width - 10, (int) this.getY() - 20, 135, alcance) : new BalaEscopeta((int) this.getX() + this.getDimensiones().width - 10, (int) this.getY() - 20, 135, alcance));
                }
            }
        }


    }

    public int getDisparo() {
        return disparo;
    }

    public void setDisparo(int disparo) {
        this.disparo = disparo;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getLaser() {
        return laser;
    }

    public void setLaser(int laser) {
        this.laser = laser;
    }

    public boolean isLasercito() {
        return lasercito;
    }

    public void setLasercito(boolean lasercito) {
        this.lasercito = lasercito;
    }

    public boolean isAlcance() {
        return alcance;
    }

    public boolean isRafaga() {
        return rafaga;
    }
    public boolean isEscopeta() {
        return escopeta ;
    }

    public void setEscopeta(boolean escopeta) {
        this.escopeta = escopeta;
    }

    public boolean isTiroAncho() {
        return tiroAncho;
    }

    public void setTiroAncho(boolean tiroAncho) {
        this.tiroAncho = tiroAncho;
    }

    public void setAlcance(boolean alcance) {
        this.alcance = alcance;
    }

    boolean isDisparando = false, barra = false;

    public void setRafaga(boolean rafaga) {
        this.rafaga = rafaga;
    }

    int contador = 0;


    public Direccion getDirec() {
        return direc;
    }

    private void setDireccion(Direccion direc) {
        this.direc = direc;
    }

    public boolean isSuperShell() {
        return superShell;
    }

    public void setSuperShell(boolean superShell) {
        this.superShell = superShell;
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        sombra.draw(g);
    }
}
