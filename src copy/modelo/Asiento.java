package modelo;

public class Asiento {
    private String columna;
    private String fila;

    public Asiento(String asiento) {
        this.columna=""+asiento.charAt(0);
        this.fila=""+asiento.charAt(1);
    }

    public String getColumna() {
        return columna;
    }

    public String getFila() {
        return fila;
    }
}