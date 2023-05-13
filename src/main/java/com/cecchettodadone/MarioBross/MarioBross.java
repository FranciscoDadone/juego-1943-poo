package com.cecchettodadone.MarioBross;

import com.cecchettodadone.lanzador.Juego;

import javax.swing.*;
import java.awt.*;

public class MarioBross extends Juego {

    public MarioBross() {
        setNombre("Mario Bross");
        setVersion("1.0");
        setDescripcion("Juego de un Fontanero");
        setDesarrolladores("Ramiro Cecchetto y Francisco Dadone");
        setImagenPortada(new ImageIcon(this.getClass().getResource("/imagenes/MarioBross.png")));
    }

    @Override
    public void run() {
        JOptionPane.showMessageDialog(null,
                this.getNombre()+" no esta disponible pero podes jugar un 1943", "Error ", JOptionPane.ERROR_MESSAGE);

    }
}
