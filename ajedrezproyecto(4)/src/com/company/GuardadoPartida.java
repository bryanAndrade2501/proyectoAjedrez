package com.company;

import archivo.LecturaEscritura;

public class GuardadoPartida<Partida> extends LecturaEscritura<Partida> {
    public GuardadoPartida(String nombreDeArchivo) {
        super(nombreDeArchivo);
    }
}
