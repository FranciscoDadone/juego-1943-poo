package com.cecchettodadone.lanzador;

import com.cecchettodadone.MarioBross.MarioBross;
import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.lanzador.gui.RecuadroJuego;
import com.entropyinteractive.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import java.awt.*;
import java.awt.event.*; //eventos

import java.awt.image.*;  //imagenes
import javax.imageio.*; //imagenes

import java.awt.Graphics2D;

import java.awt.geom.*; //Point2d
import java.util.LinkedList;

import java.util.*;
import java.text.*;

public class SistemaDeJuego extends JGame {


    Date dInit = new Date();
    Date dAhora;
    SimpleDateFormat ft = new SimpleDateFormat ("mm:ss");
    final double NAVE_DESPLAZAMIENTO=150.0;

    BufferedImage img_fondo = null;

    Personaje ovni=new Personaje();

    public static void main(String[] args) {

        SistemaDeJuego game = new SistemaDeJuego();
        System.out.println("asd");
        game.run(1.0 / 60.0);
        System.exit(0);
    }

    public SistemaDeJuego() {
        super("App", 800, 600);
        System.out.println(appProperties.stringPropertyNames());
    }

    public void gameStartup() {
        System.out.println("gameStartup");
        try{
            img_fondo= ImageIO.read(getClass().getClassLoader().getResourceAsStream("imagenes/fondo.jpg"));
            System.out.println(img_fondo);
            ovni.setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("imagenes/ufo.png")));

            ovni.setPosicion(getWidth() / 2,getHeight() / 2 );
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    public void gameUpdate(double delta) {
        Keyboard keyboard = this.getKeyboard();

        // Procesar teclas de direccion
        if (keyboard.isKeyPressed(KeyEvent.VK_UP)){
            ovni.setY( ovni.getY() - NAVE_DESPLAZAMIENTO * delta);
            //shipY -= NAVE_DESPLAZAMIENTO * delta;
        }

        if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)){
            //shipY += NAVE_DESPLAZAMIENTO * delta;
            ovni.setY( ovni.getY() + NAVE_DESPLAZAMIENTO * delta);
        }

        if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)){
            ///shipX -= NAVE_DESPLAZAMIENTO * delta;
            ovni.setX( ovni.getX() - NAVE_DESPLAZAMIENTO * delta);
        }

        if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)){
            //shipX += NAVE_DESPLAZAMIENTO * delta;
            ovni.setX( ovni.getX() + NAVE_DESPLAZAMIENTO * delta);
        }




        // Esc fin del juego
        LinkedList < KeyEvent > keyEvents = keyboard.getEvents();
        for (KeyEvent event: keyEvents) {
            if ((event.getID() == KeyEvent.KEY_PRESSED) &&
                (event.getKeyCode() == KeyEvent.VK_ESCAPE)) {
                stop();
            }
        }


        ovni.update(delta);

    }

    public void gameDraw(Graphics2D g) {

        dAhora= new Date( );
        long dateDiff = dAhora.getTime() - dInit.getTime();
        long diffSeconds = dateDiff / 1000 % 60;
        long diffMinutes = dateDiff / (60 * 1000) % 60;


        g.drawImage(img_fondo,0,0,null);// imagen de fondo

        g.setColor(Color.black);
        g.drawString("Tiempo de Juego: "+diffMinutes+":"+diffSeconds,12,42);
        g.drawString("Tecla ESC = Fin del Juego ",592,42);

        g.setColor(Color.white);
        g.drawString("Tiempo de Juego: "+diffMinutes+":"+diffSeconds,10,40);
        g.drawString("Tecla ESC = Fin del Juego ",590,40);


        ovni.draw(g);








    }

    public void gameShutdown() {
        Log.info(getClass().getSimpleName(), "Shutting down game");
    }
}


class Personaje{

    BufferedImage imagen=null;
    private Point2D.Double posicion  = new Point2D.Double();

    public Personaje(){

    }

    public void setImagen(BufferedImage img){
        this.imagen=img;

    }

    public void setPosicion(double x, double y){
        posicion.setLocation(x, y);
    }

    public void setX(double x){
        posicion.x=x;
    }

    public void setY(double y){
        posicion.y=y;
    }
    public double getX(){
        return posicion.getX();
    }

    public double getY(){
        return posicion.getY();
    }
    public void update(double delta){

    }

    public void draw(Graphics2D g){
        g.drawImage(imagen,(int)posicion.getX(),(int)posicion.getY(),null);
    }
}


//public class SistemaDeJuego extends JFrame {
//
//    public  SistemaDeJuego() {
//        this.setVisible(true);
////        this.setSize(new Dimension(800,800)); // Toolkit.getDefaultToolkit().getScreenSize()
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setBackground(Color.DARK_GRAY);
//
//        JPanel panelTitulo = new JPanel();
//        panelTitulo.setBackground(Color.DARK_GRAY);
//        JLabel titulo = new JLabel("SISTEMA DE JUEGO");
//        titulo.setForeground(Color.WHITE);
//        titulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
//        panelTitulo.add(titulo);
//
//        JPanel juegos = new JPanel();
//        juegos.setLayout(new FlowLayout());
//        juegos.add(new RecuadroJuego(new Juego1943()));
//        juegos.add(new RecuadroJuego(new MarioBross()));
//
////        juegos.add(new RecuadroJuego());
////        juegos.add(new RecuadroJuego());
////        juegos.add(new RecuadroJuego());
//
//        this.add(juegos, BorderLayout.CENTER);
//
//
//        this.add(panelTitulo, BorderLayout.NORTH);
//        this.pack();
//        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
//    }
//
//}
