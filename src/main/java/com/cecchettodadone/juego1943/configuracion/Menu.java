package com.cecchettodadone.juego1943.configuracion;
import com.cecchettodadone.juego1943.Juego1943;

import com.cecchettodadone.juego1943.audio.Sonido;
import org.json.JSONObject;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

import com.cecchettodadone.juego1943.configuracion.Configurador;

public class Menu extends JFrame {

    PanelImagen panelImagen = new PanelImagen();
    JSONObject configuracion;
    boolean bandera = false;
    Sonido sonido;

    public Menu(Juego1943 juego) {
        this.setVisible(true);
        this.setTitle("1943");
        this.setSize(new Dimension(496, 680));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        sonido = new Sonido();
        sonido.iniciar("musicaConfiguracion");
        sonido.loop();


        Border marco = BorderFactory.createLineBorder(Color.BLACK,2);

        //ImageIcon jugar = new ImageIcon(getClass().getResource("/imagenes/juegos/juego1943/menu/jugar.png"));
        JButton jugar = new JButton("Jugar");
        jugar.setSize(new Dimension(150,50));
        jugar.setLocation(50,400);
        jugar.setContentAreaFilled(false);
        //btn.setBorderPainted(false);
        jugar.setFont(new Font("Arial",Font.BOLD,20));
        jugar.setForeground(Color.BLACK);
        jugar.setBorder(marco);



        jugar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jugar.setForeground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jugar.setForeground(Color.BLACK);
            }
        });

        JButton confis = new JButton("Configuracion");
        confis.setSize(new Dimension(150,50));
        confis.setLocation(300,400);
        confis.setContentAreaFilled(false);
        //btn.setBorderPainted(false);
        confis.setFont(new Font("Arial",Font.BOLD,20));
        confis.setForeground(Color.BLACK);
        confis.setBorder(marco);


        confis.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                confis.setForeground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                confis.setForeground(Color.BLACK);
            }
        });

        this.add(jugar);
        this.add(confis);
        this.add(panelImagen);
        this.setLocationRelativeTo(null);


        jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bandera) {
                    juego.run(1 / 60, Configurador.getConfis());
                    sonido.parar();
                }
                else {
                    juego.run(1/60,Configurador.getConfiguracionDefecto());
                    sonido.parar();
                }
            }
        });

        confis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bandera = true;
                new Configurador();
            }
        });
    }
}

