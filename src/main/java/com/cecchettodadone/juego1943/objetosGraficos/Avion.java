package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;

public abstract class Avion extends ObjetoGrafico {
    public static final int NAVE_DESPLAZAMIENTO_NORMAL = 400;
    protected int velDesplazamiento = NAVE_DESPLAZAMIENTO_NORMAL;



    public void setDesplazamiento(int vel) {
        this.velDesplazamiento = vel;
    }

    public int getDesplazamiento () {
        return this.velDesplazamiento;
    }
}
