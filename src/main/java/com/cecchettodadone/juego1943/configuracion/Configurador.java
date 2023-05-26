package com.cecchettodadone.juego1943.configuracion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.interfaces.EdECKey;
import java.util.Arrays;
import java.util.List;
import com.sun.source.tree.BreakTree;
import org.json.JSONObject;

public class Configurador extends JFrame {
    static JComboBox<String> boxVentana;
    static JComboBox<String> boxAvion;
    static JComboBox<String> boxMusica;
    static JComboBox<String> boxDirecicon;
    static JTextField pausar;
    static JTextField disparar;
    static JTextField ataqueEspecial;


    public Configurador() {

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

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
        checkSonido.addActionListener(e -> {
            if (checkSonido.isSelected())
                checkSonido.setText("Activado");
            else
                checkSonido.setText("Desactivado");
        });

        paanelSonido.add(Box.createHorizontalGlue()); // Espacio flexible
        paanelSonido.add(checkSonido);
        panelPrincipal.add(paanelSonido);

        //Avion
        JPanel panelAvion = new JPanel();
        panelAvion.setLayout(new BorderLayout());
        JLabel txtAvion = new JLabel("Selecionar Avion:         ");
        boxAvion = new JComboBox<>();
        boxAvion.addItem("Avion Original");
        boxAvion.addItem("Eurofigther");
        boxAvion.addItem("F-22 Raptor");
        panelAvion.add(txtAvion,BorderLayout.WEST);
        panelAvion.add(boxAvion,BorderLayout.EAST);
        panelPrincipal.add(panelAvion);

        //Musica
        JPanel panelMusica = new JPanel(new BorderLayout());
        panelMusica.add(new JLabel("Selecionar musica:           "),BorderLayout.WEST);

        boxMusica = new JComboBox<>();
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

        pausar = new JTextField("esc");

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

        disparar = new JTextField("barra espaciadora");

        panelT9.add(disparar);
        panelTeclas.add(panelT9);

        //tecla 10
        JPanel panelT10 = new JPanel();
        panelT10.setLayout(new BoxLayout(panelT10,BoxLayout.X_AXIS));
        panelT10.add(new JLabel("Ataque Especial:               "));

        ataqueEspecial = new JTextField("z");

        panelT10.add(ataqueEspecial);
        panelTeclas.add(panelT10);


        //botones de cargar, guardar y por defecto
        JPanel botones = new JPanel();
        botones.setLayout(new BorderLayout());

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCargar = new JButton("Cargar Confi");

        botones.add(btnGuardar,BorderLayout.EAST);
        botones.add(btnCargar,BorderLayout.WEST);

        btnGuardar.addActionListener(e -> guardarConfi());
        btnCargar.addActionListener(e -> cargarConfis());

        panelPrincipal.add(panelTeclas);
        panelPrincipal.add(botones);

        this.add(panelPrincipal);
        this.pack();
        this.setLocationRelativeTo(null);
    }

     public static JSONObject getConfis() {

        JSONObject json = new JSONObject();

        json.put("ventana",boxVentana.getSelectedItem());
        json.put("musica",boxMusica.getSelectedItem());
        json.put("avion",boxAvion.getSelectedItem());
        json.put("direccion",boxDirecicon.getSelectedItem());
        json.put("pausa", pausar.getText());
        json.put("disparo", disparar.getText());
        json.put("ataque_especial", ataqueEspecial.getText());

         System.out.println(json);

        return json;
    }

    public static JSONObject getConfiguracionDefecto() {
        JSONObject json = new JSONObject();

        json.put("ventana/completa","ventana");
        json.put("ataqueEspecial","z");
        json.put("disparo","barra espaciadora");
        json.put("musica","Tema original");
        json.put("pausa","esq");
        json.put("avion","Avion original");
        json.put("direccion","flechas");

        return json;
    }

    public static void setConfisDefecto() {
        boxVentana.setSelectedItem("Ventana");
        boxMusica.setSelectedItem("Tema Original");
        boxAvion.setSelectedItem("Avion Original");
        boxDirecicon.setSelectedItem("Flechas");
        pausar.setText("Barra Espaciadora");
        disparar.setText("x");
        ataqueEspecial.setText("z");
    }

    private void cargarConfis() {
        File file = new File("src/main/resources/configuraciones");
        String[] archivos = file.list();
        int eleccion = 0;

        if (archivos.length!=0){
            for (int i = 0; i < archivos.length; i++) {
                archivos[i] = archivos[i].substring(0, archivos[i].lastIndexOf("."));
            }
            eleccion = JOptionPane.showOptionDialog(null, "Selecciona una configuracion", "Opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, archivos, archivos[0]);
            JOptionPane.showMessageDialog(null, "Configuracion cargada", "", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);

            try (BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/configuraciones/" + archivos[eleccion] + ".txt"))) {
                StringBuilder contenido = new StringBuilder();
                String line;
                while ((line = lector.readLine()) != null) {
                    contenido.append(line);
                }
                System.out.println(contenido);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        else{
            JOptionPane.showMessageDialog(null, "No hay configuraciones guardadas", "", JOptionPane.INFORMATION_MESSAGE);
        }
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
            JOptionPane.showMessageDialog(null, "La configuracion se guardo con exito", "", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(null, "Esta configuracion ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }




}

