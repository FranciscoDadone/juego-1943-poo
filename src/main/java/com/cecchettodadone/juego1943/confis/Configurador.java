package com.cecchettodadone.juego1943.confis;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import javax.swing.text.html.ObjectView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;

import org.json.JSONObject;

public class  Configurador extends JFrame {
    JSONObject json;

    JComboBox<String> boxVentana;
    JCheckBox checkSonido;
    JComboBox boxAvion;
    JComboBox boxMusica;
    JTextField tecla1;
    JTextField tecla2;
    JTextField tecla3;
    JTextField tecla4;
    JTextField tecla5;
    JTextField tecla6;
    JTextField tecla7;
    JTextField tecla8;
    JTextField tecla9;


    public Configurador() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));
        this.setResizable(false);

        //titulo configuracion general
        JPanel panelTitulo = new JPanel();
        //panelTitulo.setLayout(new BorderLayout());
        JLabel txtTitulo = new JLabel("<html><u>Configuracion General</u></html>");
        panelTitulo.add(txtTitulo,BorderLayout.CENTER);
        panelPrincipal.add(panelTitulo);

        //ventana o pantalla completa
        JPanel panelventana = new JPanel();
        panelventana.setLayout(new BorderLayout());
        JLabel txtVentana = new JLabel("Seleccionar vista:  ");
        boxVentana = new JComboBox<>();
        boxVentana.addItem("Ventana");
        boxVentana.addItem("Pantalla Completa");
        panelventana.add(txtVentana, BorderLayout.WEST);
        panelventana.add(boxVentana, BorderLayout.EAST);
        panelPrincipal.add(panelventana);

        //Sonido
        JPanel sonidoPanel = new JPanel();
        sonidoPanel.setLayout(new BoxLayout(sonidoPanel, BoxLayout.X_AXIS));
        JLabel txtSonido = new JLabel("Sonido:  ");
        checkSonido = new JCheckBox("Activado");
        checkSonido.setSelected(true);
        checkSonido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkSonido.isSelected())
                    checkSonido.setText("Activado");
                else
                    checkSonido.setText("Desactivado");
            }
        });
        sonidoPanel.add(txtSonido);
        sonidoPanel.add(Box.createHorizontalGlue()); // Espacio flexible
        sonidoPanel.add(checkSonido);
        panelPrincipal.add(sonidoPanel);

        //Avion
        JPanel panelAvion = new JPanel();
        panelAvion.setLayout(new BorderLayout());
        JLabel txtAvion = new JLabel("Selecionar Avion:         ");
        boxAvion = new JComboBox();
        boxAvion.addItem("Avion Original");
        boxAvion.addItem("Eurofigther");
        boxAvion.addItem("F-22 Raptor");
        panelAvion.add(txtAvion,BorderLayout.WEST);
        panelAvion.add(boxAvion,BorderLayout.EAST);
        panelPrincipal.add(panelAvion);

        //Musica
        JPanel panelMusica = new JPanel(new BorderLayout());
        JLabel txtMusica = new JLabel("Selecionar musica:           ");
        boxMusica = new JComboBox();
        boxMusica.addItem("Tema Original");
        boxMusica.addItem("Dua Lipa");
        panelMusica.add(txtMusica,BorderLayout.WEST);
        panelMusica.add(boxMusica);
        panelPrincipal.add(panelMusica);

        //titulo teclas
        JPanel panelTituloTeclas = new JPanel();

        JLabel txtTituloTeclas = new JLabel("<html><u>Configuracion de Teclas</u></html>");

        panelTituloTeclas.add(txtTituloTeclas);
        panelPrincipal.add(panelTituloTeclas);

        //Teclas

        JPanel panelTeclas = new JPanel();
        panelTeclas.setLayout(new BoxLayout(panelTeclas,BoxLayout.Y_AXIS));

        //tecla 1
        JPanel panelT1 = new JPanel();
        panelT1.setLayout(new BoxLayout(panelT1,BoxLayout.X_AXIS));

        JLabel txtT1 = new JLabel("Activar/Desactivar Efectos de Sonido:");
        tecla1 = new JTextField("");

        panelT1.add(txtT1);
        panelT1.add(tecla1);
        panelTeclas.add(panelT1);

        //tecla 2
        JPanel panelT2 = new JPanel();
        panelT2.setLayout(new BoxLayout(panelT2,BoxLayout.X_AXIS));

        JLabel txtT2 = new JLabel("Activar/Desactivar Musica de Fondo:");
        tecla2 = new JTextField("");

        panelT2.add(txtT2);
        panelT2.add(tecla2);
        panelTeclas.add(panelT2);

        //tecla 3
        JPanel panelT3 = new JPanel();
        panelT3.setLayout(new BoxLayout(panelT3,BoxLayout.X_AXIS));

        JLabel txtT3 = new JLabel("Pausar/Reanudar Juego:");
        tecla3 = new JTextField("");

        panelT3.add(txtT3);
        panelT3.add(tecla3);
        panelTeclas.add(panelT3);

        //teclas direccion
        JPanel panelDireccion = new JPanel();
        panelDireccion.setLayout(new BoxLayout(panelDireccion,BoxLayout.X_AXIS));

        JLabel txtDireccion = new JLabel("<html>Selecione las teclas<br>Que quiera para moverse:</html>");
        panelDireccion.add(txtDireccion);

        JComboBox direccion = new JComboBox();
        direccion.addItem("Flechas");
        direccion.addItem("A/W/S/D");
        panelDireccion.add(direccion);

        panelTeclas.add(panelDireccion);

        //tecla 8
        JPanel panelT8 = new JPanel();
        panelT8.setLayout(new BoxLayout(panelT8,BoxLayout.X_AXIS));

        JLabel txtT8 = new JLabel("                              Disparar:");
        tecla8 = new JTextField("");

        panelT8.add(txtT8);
        panelT8.add(tecla8);
        panelTeclas.add(panelT8);

        //tecla 10
        JPanel panelT9 = new JPanel();
        panelT9.setLayout(new BoxLayout(panelT9,BoxLayout.X_AXIS));

        JLabel txtT9 = new JLabel("                   Ataque Especial:");
        tecla9 = new JTextField("");

        panelT9.add(txtT9);
        panelT9.add(tecla9);
        panelTeclas.add(panelT9);


        //botones de guardar y por defecto
        JPanel botones = new JPanel();
        botones.setLayout(new BorderLayout());
        JButton guardar = new JButton("Guardar");
        JButton defecto = new JButton("Confis por defecto");
        botones.add(guardar,BorderLayout.WEST);
        botones.add(defecto,BorderLayout.EAST);

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        defecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultConfigs();
            }
        });

        panelPrincipal.add(panelTeclas);
        panelPrincipal.add(botones);
        this.add(panelPrincipal);
        //this.pack();
        this.setSize(265,380);
    }

    public void setDefaultConfigs() {
        tecla1.setText("q");
        tecla2.setText("w");
        tecla3.setText("Barra espaciadora");
        /*
        tecla4.setText("←");
        tecla5.setText("→");
        tecla6.setText("↑");
        tecla7.setText("↓");
        */
        tecla8.setText("x");
        tecla9.setText("z");
    }

}
