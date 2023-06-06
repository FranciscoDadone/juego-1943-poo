package com.cecchettodadone.juego1943.objetosGraficos.bonus;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.objetosGraficos.AvionJugador;

import java.sql.Ref;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Random;


public abstract class Bonus extends ObjetoGrafico{
    static Bonus bonus = null;

    public static Bonus getBonus() {
        Random rand = new Random();


        switch (rand.nextInt(3)) {
            case 0:
                bonus = new Ametralladora(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
                break;
            case 1:
                bonus = new Auto(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
                break;
            case 2:
                bonus = new Escopeta(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
                break;
            case 3:
                bonus = new Pow(rand.nextInt(Juego1943.getFrame().getHeight()), 0);
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

    public abstract void action();

    public static Bonus getBonus(int posX, int posY) {
        Random rand = new Random();


        switch (rand.nextInt(3)) {
            case 0:
                bonus = new Ametralladora(posX, posY);
                break;
            case 1:
                bonus = new Auto(posX, posY);
                break;
            case 2:
                bonus = new Escopeta(posX, posY);
                break;
            case 3:
                bonus = new Pow(posX, posY);
                break;
            case 4:
                bonus = new Refuerzo(posX, posY);
                break;
            case 5:
                bonus = new EstrellaNinja(posX, posY);
                break;
            case 6:
                bonus = new Laser(posX, posY);
                break;
            case 7:
                bonus = new SuperShell(posX, posY);
                break;
        }

        return bonus;
    }

    public static void action(Bonus bonus) {
        bonus.action();
    }

    @Override
    public void update(double delta) {

    }

}
