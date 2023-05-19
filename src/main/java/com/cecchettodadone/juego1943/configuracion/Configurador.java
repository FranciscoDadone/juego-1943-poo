package com.cecchettodadone.juego1943.configuracion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONTokener;

public class Configurador extends JFrame {

    public static void main(String[] args) {
        new Configurador();
    }

    JComboBox<String> boxVentana;
    JComboBox<String> boxMusica;
    JCheckBox checkSonido;
    JComboBox boxAvion;
    JTextField tecla3;
    JTextField tecla4;
    JTextField tecla5;
    JComboBox direccion;

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

        JLabel txtDireccion = new JLabel("Selecione las teclas de direccion:");

        direccion = new JComboBox();
        direccion.addItem("Flechas");
        direccion.addItem("A/W/S/D");

        panelDireccion.add(txtDireccion);
        panelDireccion.add(direccion);
        panelTeclas.add(panelDireccion);

        //tecla 4
        JPanel panelT4 = new JPanel();
        panelT4.setLayout(new BoxLayout(panelT4,BoxLayout.X_AXIS));

        JLabel txtT4 = new JLabel("                              Disparar:");
        tecla4 = new JTextField("");

        panelT4.add(txtT4);
        panelT4.add(tecla4);
        panelTeclas.add(panelT4);

        //tecla 5
        JPanel panelT5 = new JPanel();
        panelT5.setLayout(new BoxLayout(panelT5,BoxLayout.X_AXIS));

        JLabel txtT5 = new JLabel("                   Ataque Especial:");
        JTextField tecla5 = new JTextField("");

        panelT5.add(txtT5);
        panelT5.add(tecla5);
        panelTeclas.add(panelT5);


        //botones de guardar y por defecto
        JPanel botones = new JPanel();
        botones.setLayout(new BorderLayout());

        JButton guardar = new JButton("Guardar");
        JButton defecto = new JButton("Confis por defecto");

        botones.add(guardar,BorderLayout.EAST);
        botones.add(defecto,BorderLayout.WEST);

        JPanel botonCargar = new JPanel(new BorderLayout());
        JButton cargaConfis = new JButton("Cargar configuracion");
        botonCargar.add(cargaConfis,BorderLayout.WEST);

        cargaConfis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new SelectorConfiguraciones();
                System.out.println(getConfis());
            }
        });

        defecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boxVentana.setSelectedItem("Ventana");
                checkSonido.setSelected(true);
                boxMusica.setSelectedItem("Tema Original");
                boxAvion.setSelectedItem("Avion Original");
                tecla3.setText("Barra espaciadora");
                direccion.setSelectedItem("flechas");
                tecla4.setText("x");
                tecla5.setText("z");
            }
        });

        panelPrincipal.add(panelTeclas);
        panelPrincipal.add(botones);
        panelPrincipal.add(botonCargar);
        this.add(panelPrincipal);
        this.pack();
    }

    private JSONObject getConfis() {

    }

    private void setConfiguracion(JSONObject json) {

    }

}
