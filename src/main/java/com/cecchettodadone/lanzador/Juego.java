package com.cecchettodadone.lanzador;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.KeyListener;

public abstract class Juego {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrolladores() {
        return desarrolladores;
    }

    public void setDesarrolladores(String desarrolladores) {
        this.desarrolladores = desarrolladores;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ImageIcon getImagenPortada() {
        return imagenPortada;
    }

    public void setImagenPortada(ImageIcon imagenPortada) {
        this.imagenPortada = imagenPortada;
    }

    public abstract void run (double fps);
    public abstract void run ();

    private String nombre;
    private String desarrolladores;
    private String version;
    private String descripcion;
    private ImageIcon imagenPortada;

    private boolean implementado;

    public boolean isImplementado() {
        return implementado;
    }

    public void setImplementado(boolean implementado) {
        this.implementado = implementado;
    }

}
