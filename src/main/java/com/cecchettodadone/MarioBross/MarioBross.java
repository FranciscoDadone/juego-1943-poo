package com.cecchettodadone.MarioBross;

import com.cecchettodadone.lanzador.Juego;
import org.json.JSONObject;

import javax.swing.*;

public class MarioBross extends Juego {

    public MarioBross() {
        setNombre("Mario Bross");
        setVersion("1.0");
        setDescripcion("Juego de un Fontanero");
        setDesarrolladores("Ramiro Cecchetto y Francisco Dadone");
        setImagenPortada(new ImageIcon(this.getClass().getResource("/imagenes/juegos/mario_bross/MarioBross.png")));
        setImplementado(false);
    }


    @Override
    public void run(double fps) {}

    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, "Mario Bross no esta disponible. \n pero podes jugar un 1943 ", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
