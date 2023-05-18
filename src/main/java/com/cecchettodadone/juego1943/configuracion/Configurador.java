package com.cecchettodadone.juego1943.configuracion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JLabel txtT1 = new JLabel("Ventana/Pantalla Completa:");
        JTextField tecla1 = new JTextField("");

        panelT1.add(txtT1);
        panelT1.add(tecla1);
        panelTeclas.add(panelT1);

        //tecla 2
        JPanel panelT2 = new JPanel();
        panelT2.setLayout(new BoxLayout(panelT2,BoxLayout.X_AXIS));

        JLabel txtT2 = new JLabel("Activar/Desactivar Sonido:");
        JTextField tecla2 = new JTextField("");

        panelT2.add(txtT2);
        panelT2.add(tecla2);
        panelTeclas.add(panelT2);

        //tecla 3
        JPanel panelT3 = new JPanel();
        panelT3.setLayout(new BoxLayout(panelT3,BoxLayout.X_AXIS));

        JLabel txtT3 = new JLabel("Pausar/Reanudar Juego:");
        JTextField tecla3 = new JTextField("");

        panelT3.add(txtT3);
        panelT3.add(tecla3);
        panelTeclas.add(panelT3);

        //tecla 4
        JPanel panelT4 = new JPanel();
        panelT4.setLayout(new BoxLayout(panelT4,BoxLayout.X_AXIS));

        JLabel txtT4 = new JLabel("                         Izquierda:");
        JTextField tecla4 = new JTextField("");

        panelT4.add(txtT4);
        panelT4.add(tecla4);
        panelTeclas.add(panelT4);

        //tecla 5
        JPanel panelT5 = new JPanel();
        panelT5.setLayout(new BoxLayout(panelT5,BoxLayout.X_AXIS));

        JLabel txtT5 = new JLabel("                           Derecha:");
        JTextField tecla5 = new JTextField("");

        panelT5.add(txtT5);
        panelT5.add(tecla5);
        panelTeclas.add(panelT5);

        //tecla 6
        JPanel panelT6 = new JPanel();
        panelT6.setLayout(new BoxLayout(panelT6,BoxLayout.X_AXIS));

        JLabel txtT6 = new JLabel("                              Arriba:");
        JTextField tecla6 = new JTextField("");

        panelT6.add(txtT6);
        panelT6.add(tecla6);
        panelTeclas.add(panelT6);

        //tecla 7
        JPanel panelT7 = new JPanel();
        panelT7.setLayout(new BoxLayout(panelT7,BoxLayout.X_AXIS));

        JLabel txtT7 = new JLabel("                              abajo:");
        JTextField tecla7 = new JTextField("");

        panelT7.add(txtT7);
        panelT7.add(tecla7);
        panelTeclas.add(panelT7);

        //tecla 8
        JPanel panelT8 = new JPanel();
        panelT8.setLayout(new BoxLayout(panelT8,BoxLayout.X_AXIS));

        JLabel txtT8 = new JLabel("                              abajo:");
        JTextField tecla8 = new JTextField("");

        panelT8.add(txtT8);
        panelT8.add(tecla8);
        panelTeclas.add(panelT8);

        //tecla 9
        JPanel panelT9 = new JPanel();
        panelT9.setLayout(new BoxLayout(panelT9,BoxLayout.X_AXIS));

        JLabel txtT9 = new JLabel("                              Disparar:");
        JTextField tecla9 = new JTextField("");

        panelT9.add(txtT9);
        panelT9.add(tecla9);
        panelTeclas.add(panelT9);

        //tecla 10
        JPanel panelT10 = new JPanel();
        panelT10.setLayout(new BoxLayout(panelT10,BoxLayout.X_AXIS));

        JLabel txtT10 = new JLabel("                   Ataque Especial:");
        JTextField tecla10 = new JTextField("");

        panelT10.add(txtT10);
        panelT10.add(tecla10);
        panelTeclas.add(panelT10);


        //botones de guardar y por defecto
        JPanel botones = new JPanel();
        botones.setLayout(new BorderLayout());
        JButton guardar = new JButton("Guardar");
        JButton defecto = new JButton("Confis por defecto");
        botones.add(guardar,BorderLayout.WEST);
        botones.add(defecto,BorderLayout.EAST);

        panelPrincipal.add(panelTeclas);
        panelPrincipal.add(botones);
        this.add(panelPrincipal);
        this.pack();
    }

}
