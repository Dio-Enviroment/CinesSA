package modelo;

public class Asiento {
    private int columna;
    private int fila;

    public Asiento(int fil,int col) {
        this.fila=fil;
        this.columna=col;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }
}