package com.cecchettodadone.juego1943.confis;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Configurador extends JFrame {

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
        JComboBox<String> boxVentana = new JComboBox<>();
        boxVentana.addItem("Ventana");
        boxVentana.addItem("Pantalla Completa");
        panelventana.add(txtVentana, BorderLayout.WEST);
        panelventana.add(boxVentana, BorderLayout.EAST);
        panelPrincipal.add(panelventana);

        //Sonido
        JPanel sonidoPanel = new JPanel();
        sonidoPanel.setLayout(new BoxLayout(sonidoPanel, BoxLayout.X_AXIS));
        JLabel txtSonido = new JLabel("Sonido:  ");
        JCheckBox checkSonido = new JCheckBox("Activado");
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
        JComboBox boxAvion = new JComboBox();
        boxAvion.addItem("Avion Original");
        boxAvion.addItem("Eurofigther");
        boxAvion.addItem("F-22 Raptor");
        panelAvion.add(txtAvion,BorderLayout.WEST);
        panelAvion.add(boxAvion,BorderLayout.EAST);
        panelPrincipal.add(panelAvion);

        //Musica
        JPanel panelMusica = new JPanel(new BorderLayout());
        JLabel txtMusica = new JLabel("Selecionar musica:           ");
        JComboBox boxMusica = new JComboBox();
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

        JLabel txtT1 = new JLabel("Activar/Desactivar efectos de sonido:");
        txtT1.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextArea tecla1 = new JTextArea("");
        tecla1.setBackground(Color.WHITE);
        tecla1.setForeground(Color.BLACK);
        tecla1.setBorder(new LineBorder(Color.BLACK));

        panelT1.add(txtT1);
        panelT1.add(tecla1);
        panelTeclas.add(panelT1);

        //tecla 1
        JPanel panelT2 = new JPanel();
        panelT2.setLayout(new BoxLayout(panelT2,BoxLayout.X_AXIS));

        JLabel txtT2 = new JLabel("Iquierda:");
        txtT2.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextArea tecla2 = new JTextArea("");
        tecla2.setBackground(Color.WHITE);
        tecla2.setForeground(Color.BLACK);
        tecla2.setBorder(new LineBorder(Color.BLACK));

        panelT2.add(txtT2);
        panelT2.add(tecla2);
        panelTeclas.add(panelT2);



        panelPrincipal.add(panelTeclas);
        this.add(panelPrincipal);
        this.pack();
    }

}
