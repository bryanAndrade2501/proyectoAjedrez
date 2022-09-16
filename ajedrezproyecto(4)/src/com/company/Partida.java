package com.company;

import Menu.Opcionable;
import tableroAjedrez.Tablero;

import java.io.Serializable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida implements Opcionable, Serializable {
    Scanner entrada = new Scanner(System.in);
    protected Jugador jugador1;
    protected Jugador jugador2;
    protected Jugador turnoJ;
    protected Tablero tablero;

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = new Tablero(jugador1.piezas, jugador2.piezas);
        this.turnoJ = jugador1;
    }


    public void generarTurnos() throws IOException, ClassNotFoundException {
        //TODO:establecer fin de partida, haque y haque mate
        boolean finPartida = false;
        boolean controlDeTurnos;

        System.out.println("Presione cualquier tecla para jugar");
        tablero.imprimirTablero();
        do {
            System.out.println("Jugar turno (Enter) - Menu (M)");
            String op = entrada.nextLine().toUpperCase();
            if (op.equals("M")) {
                this.devolverOpciones();
                this.seleccionarOpcion();
            }
            System.out.println("Es el turno de " + turnoJ);

            controlDeTurnos = turnoJ.moverPieza(tablero);

            tablero.imprimirTablero();

            if (turnoJ == jugador1) {
                if (controlDeTurnos) continue;
                //turnoJ=jugador1;//Eliminar linea (solo para pruebas)
                turnoJ = jugador1;
            } else {
                if (controlDeTurnos) continue;
                turnoJ = jugador1;
            }

        } while (finPartida = true);
    }

    @Override
    public void devolverOpciones() {
        ArrayList<String> menuDeJuego = new ArrayList();
        menuDeJuego.add("1. Empezar partida");
        menuDeJuego.add("2. Cargar Partida");
        menuDeJuego.add("3. Guardar Partida");
        menuDeJuego.add("4. Salir");

        for (String s : menuDeJuego) {
            System.out.println(s + "\n");
        }
    }


    @Override
    public void seleccionarOpcion() throws IOException, ClassNotFoundException {
        int op = Integer.parseInt(entrada.nextLine());
        switch (op) {
            case 1://Empezar Partida
                this.generarTurnos();
            case 2://Cargar Partida
                CargadoPartida<Partida> partidaCargada = new CargadoPartida<Partida>("partida.data");
                partidaCargada.leerArchivo();
            case 3://Guardar Partida
                GuardadoPartida<Partida> partidaGuardada = new GuardadoPartida<Partida>("partida.data");
                partidaGuardada.escribirArchivo(this);
            case 4://Salir
                System.out.println("*** Gracias por jugar ***");
                System.exit(0);
            default:
        }
    }
}
