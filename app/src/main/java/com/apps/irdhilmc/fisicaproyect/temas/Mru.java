package com.apps.irdhilmc.fisicaproyect.temas;

import com.apps.irdhilmc.fisicaproyect.base.BaseOperacionesImpl;

/**
 * Created by irvinmarin on 10/06/2019.
 */

public class Mru {
    private static Mru mruInstance;
    double tiempo = 0;
    double distancia = 0;
    double velocidad = 0;


    private Mru() {
    }

    public static synchronized Mru getInstance() {
        if (mruInstance == null) {
            mruInstance = new Mru();
        }
        return mruInstance;
    }


    public double calcularDistancia(double velocidad, double tiempo) {
        return velocidad * tiempo;
    }

    public double calcularTiempo(double distancia, double velocidad) {
        return distancia / velocidad;
    }

    public double calcularVelocidad(double distancia, double tiempo) {
        return distancia * tiempo;
    }


}
