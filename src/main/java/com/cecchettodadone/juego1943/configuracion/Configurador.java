package com.cecchettodadone.juego1943.configuracion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

public class Configurador extends JFrame {

    public static void main(String[] args) {
        new Configurador();
    }

    JComboBox<String> boxVentana;
    JComboBox<String> boxAvion;
    JComboBox<String> boxMusica;
    JComboBox<String> boxDirecicon;
    JTextField pausar;
    JTextField disparar;
    JTextField ataqueEspecial;


    public Configurador() {

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));

        //titulo configuracion general
        JPanel panelTitulo = new JPanel();
        panelTitulo.add(new JLabel("<html><u>Configuracion General</u></html>"),BorderLayout.CENTER);

        panelPrincipal.add(panelTitulo);

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

        pausar = new JTextField("");

        panelT3.add(pausar);
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

        disparar = new JTextField("");

        panelT9.add(disparar);
        panelTeclas.add(panelT9);

        //tecla 10
        JPanel panelT10 = new JPanel();
        panelT10.setLayout(new BoxLayout(panelT10,BoxLayout.X_AXIS));
        panelT10.add(new JLabel("Ataque Especial:               "));

        ataqueEspecial = new JTextField("");

        panelT10.add(ataqueEspecial);
        panelTeclas.add(panelT10);


        //botones de cargar, guardar y por defecto
        JPanel botones = new JPanel();
        botones.setLayout(new BorderLayout());

        JButton btnGuardar = new JButton("Guardar");
        JButton bvtnDefecto = new JButton("Confis por defecto");

        botones.add(btnGuardar,BorderLayout.EAST);
        botones.add(bvtnDefecto,BorderLayout.WEST);

        panelPrincipal.add(panelTeclas);
        panelPrincipal.add(botones);

        JLabel errorConfis = new JLabel("<html>Configuracion existente<br>intente de nuevo<br>    </html>");
        errorConfis.setVisible(false);
        errorConfis.setForeground(Color.RED);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarConfi();
            }
        });

        bvtnDefecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setConfisDefecto();
            }
        });


        JPanel botonAux = new JPanel(new BorderLayout());
        JButton btnCargar = new JButton("Cargar Confi");

        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("src/main/resources/configuraciones");
                String[] archivos = file.list();

                for (int i=0 ; i<archivos.length; i++ ) {
                    archivos[i] = archivos[i].substring(0,archivos[i].lastIndexOf("."));
                }

                int eleccion = JOptionPane.showOptionDialog(null, "Selecciona una configuracion", "Opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, archivos, archivos[0]);

//                System.out.println(archivos[eleccion]+".txt");
            }
        });

        botonAux.add(btnCargar,BorderLayout.WEST);
        botonAux.add(errorConfis,BorderLayout.EAST);
        panelPrincipal.add(botonAux);


        this.add(panelPrincipal);
        this.pack();
        this.setSize(new Dimension(getWidth(),getHeight()+10));
    }

    public JSONObject getConfis() {
        JSONObject json = new JSONObject();

        json.put("ventana",boxVentana.getSelectedItem());
        json.put("musica",boxMusica.getSelectedItem());
        json.put("avion",boxAvion.getSelectedItem());
        json.put("direccion",boxDirecicon.getSelectedItem());
        json.put("pausa", pausar.getText());
        json.put("disparo", disparar.getText());
        json.put("ataque_especial", ataqueEspecial.getText());

        return json;
    }

    public void setConfisDefecto() {
        boxVentana.setSelectedItem("Ventana");
        boxMusica.setSelectedItem("Tema Original");
        boxAvion.setSelectedItem("Avion Original");
        boxDirecicon.setSelectedItem("Flechas");
        pausar.setText("Barra Espaciadora");
        disparar.setText("x");
        ataqueEspecial.setText("z");
    }

    public void setCongis(JSONObject json) {
        boxVentana.setSelectedItem(json.getString("ventana"));
    }

    private void guardarConfi() {
        File directorio = new File("src/main/resources/configuraciones");
        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre:", "Nombre", JOptionPane.PLAIN_MESSAGE);

        List<String> archivos = Arrays.asList(directorio.list());

        FileWriter escritor = null;

        if (!archivos.contains(nombre + ".txt")) {
            try {
                File archivo = new File(directorio, nombre + ".txt");
                escritor = new FileWriter(archivo);
                escritor.write(getConfis().toString());
                System.out.println(getConfis().toString());
            } catch (Exception a) {
                System.out.println(a);
            } finally {
                try {
                    if (escritor != null) {
                        escritor.close();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esta configuracion ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}

