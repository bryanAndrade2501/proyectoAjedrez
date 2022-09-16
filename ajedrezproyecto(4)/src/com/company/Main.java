package com.company;

import movimientos.*;
import tableroAjedrez.*;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        //TODO: Mover a partida. 15-20, 22, 23.
        Pieza[] piezasEstandar1 = {new Torre(), new Caballo(), new Alfil(),
                new Rey(), new Reina(), new Alfil(new Diagonal()), new Caballo(), new Torre(),
                new Torre(), new Torre(), new Torre(), new Torre(), new Torre(), new Torre(),
                new Torre(), new Torre()
        };
        Pieza[] piezasEstandar2 = {new Torre(), new Caballo(), new Alfil(),
                new Rey(), new Reina(), new Alfil(new Diagonal()), new Caballo(), new Torre(),
                new Peon(), new Peon(), new Peon(), new Peon(), new Peon(), new Peon(), new Peon(), new Peon()
        };

        Jugador jugador1 = new Jugador("Xavier", piezasEstandar1);
        Jugador jugador2 = new Jugador("Kevin", piezasEstandar2);

        Partida partida = new Partida(jugador1, jugador2);

        partida.devolverOpciones();
        try {
            partida.seleccionarOpcion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            partida.generarTurnos();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
