package com.cecchettodadone.juego1943.objetosGraficos.enemigos;

import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.objetosGraficos.Municion;

public abstract class JefeFinal extends ObjetoGrafico {
    public abstract void recibirDanio (Municion municion);

    public abstract int getVida ();
}
