package com.cecchettodadone.juego1943.objetosGraficos.bonus;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.objetosGraficos.Avion;

import java.awt.*;
import java.util.Random;


public class Bonus extends ObjetoGrafico {
    public static Bonus getBonus() {
        Random rand = new Random();

        Bonus bonus = null;

        switch (rand.nextInt(8)) {
            case 0:
                bonus = new Pow(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
                break;
            case 1:
                bonus = new Ametralladora(rand.nextInt(Juego1943.getFrame().getHeight()), 0); new Ametralladora(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
                break;
            case 2:
                bonus = new Auto(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
                break;
            case 3:
                bonus = new Escopeta(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
                break;
            case 4:
                bonus = new Refuerzo(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
                break;
            case 5:
                bonus = new EstrellaNinja(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
                break;
            case 6:
                bonus = new Laser(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
                break;
            case 7:
                bonus = new SuperShell(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
                break;
        }

        return bonus;
    }

    @Override
    public void update(double delta) {

    }
}
