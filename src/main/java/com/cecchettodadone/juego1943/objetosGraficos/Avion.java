package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;

public abstract class Avion extends ObjetoGrafico {

    protected int NAVE_DESPLAZAMIENTO_NORMAL;
    protected int desplazamiento = NAVE_DESPLAZAMIENTO_NORMAL;
    public void setDesplazamiento(int NAVE_DESPLAZAMIENTO_NORMAL) {
        this.NAVE_DESPLAZAMIENTO_NORMAL = NAVE_DESPLAZAMIENTO_NORMAL;
    }

    public Avion (int posX, int posY) {}

    @Override
    public void update(double delta) {}
}
