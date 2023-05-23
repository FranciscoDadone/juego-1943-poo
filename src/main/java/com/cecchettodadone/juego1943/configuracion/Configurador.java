package com.cecchettodadone.juego1943.configuracion;

import javax.sql.rowset.serial.SerialJavaObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.JSONObject;

public class Configurador extends JFrame {

    JComboBox<String> boxVentana;
    JComboBox<String> boxAvion;
    JComboBox<String> boxMusica;
    JComboBox<String> boxDirecicon;
    JTextField tecla3;
    JTextField tecla9;
    JTextField tecla10;






    public static void main(String[] args) {
        new Configurador();
    }

    public Configurador() {

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel panelTitulo = new JPanel();
        //titulo configuracion general
        panelTitulo.add(new JLabel("<html><u>Configuracion General</u></html>"),BorderLayout.CENTER);

        //ventana o pantalla completa
        JPanel panelventana = new JPanel();
        panelventana.setLayout(new BorderLayout());
        panelventana.add(new JLabel("Selecione el formato: "), BorderLayout.WEST);

        boxVentana = new JComboBox<>();
        boxVentana.addItem("Ventana");
        boxVentana.addItem("Pantalla Completa");

        panelventana.add(boxVentana, BorderLayout.EAST);
        panelPrincipal.add(panelventana);

        //Sonido
        JPanel paanelSonido = new JPanel();
        paanelSonido.setLayout(new BoxLayout(paanelSonido, BoxLayout.X_AXIS));
        paanelSonido.add(new JLabel("Sonido:  "));

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

        paanelSonido.add(Box.createHorizontalGlue()); // Espacio flexible
        paanelSonido.add(checkSonido);
        panelPrincipal.add(paanelSonido);

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
        panelMusica.add(new JLabel("Selecionar musica:           "),BorderLayout.WEST);

        boxMusica = new JComboBox();
        boxMusica.addItem("Tema Original");
        boxMusica.addItem("Dua Lipa");

        panelMusica.add(boxMusica);
        panelPrincipal.add(panelMusica);

        //titulo teclas
        JPanel panelTituloTeclas = new JPanel();
        panelTituloTeclas.add(new JLabel("<html><u>Configuracion de Teclas</u></html>"));

        panelPrincipal.add(panelTituloTeclas);

        //Teclas

        JPanel panelTeclas = new JPanel();
        panelTeclas.setLayout(new BoxLayout(panelTeclas,BoxLayout.Y_AXIS));

        //tecla 3
        JPanel panelT3 = new JPanel();
        panelT3.setLayout(new BoxLayout(panelT3,BoxLayout.X_AXIS));
        panelT3.add(new JLabel("Pausar/Reanudar Juego:   "));

        tecla3 = new JTextField("");

        panelT3.add(tecla3);
        panelTeclas.add(panelT3);

        //teclas de Direccion
        JPanel panelDireccion = new JPanel();
        panelDireccion.setLayout(new BoxLayout(panelDireccion,BoxLayout.X_AXIS));
        panelDireccion.add(new JLabel("Telcas de Direccion:         "));

        boxDirecicon = new JComboBox<>();
        boxDirecicon.addItem("Flechas");
        boxDirecicon.addItem("A - W - S - D");

        panelDireccion.add(boxDirecicon);
        panelTeclas.add(panelDireccion);

        //tecla 9
        JPanel panelT9 = new JPanel();
        panelT9.setLayout(new BoxLayout(panelT9,BoxLayout.X_AXIS));
        panelT9.add(new JLabel("Disparar:                           "));

        tecla9 = new JTextField("");

        panelT9.add(tecla9);
        panelTeclas.add(panelT9);

        //tecla 10
        JPanel panelT10 = new JPanel();
        panelT10.setLayout(new BoxLayout(panelT10,BoxLayout.X_AXIS));
        panelT10.add(new JLabel("Ataque Especial:               "));

        tecla10 = new JTextField("");

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

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(getConfis());
            }
        });

        defecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setConfisDefecto();
            }
        });

        this.add(panelPrincipal);
        this.pack();
    }

    public JSONObject getConfis() {
        JSONObject json = new JSONObject();

        json.put("ventana",boxVentana.getSelectedItem());
        json.put("musica",boxMusica.getSelectedItem());
        json.put("avion",boxAvion.getSelectedItem());
        json.put("direccion",boxDirecicon.getSelectedItem());
        json.put("pausa",tecla3.getText());
        json.put("disparo",tecla9.getText());
        json.put("ataque_especial",tecla10.getText());

        return json;
    }

    public void setConfisDefecto() {
        boxVentana.setSelectedItem("Ventana");
        boxMusica.setSelectedItem("Tema Original");
        boxAvion.setSelectedItem("Avion Original");
        boxDirecicon.setSelectedItem("Flechas");
        tecla3.setText("Barra Espaciadora");
        tecla9.setText("x");
        tecla10.setText("z");
    }

    public void setCongis(JSONObject json) {

    }


}
