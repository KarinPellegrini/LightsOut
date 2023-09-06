package model;

public class LightsOut {
	private int turnos;
	private boolean finalizado;
	

	private boolean[][] tablero;
	
	
	public String dameTablero() {
		StringBuilder tabla = new StringBuilder();
		tabla.append("[ ");
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tabla.append(tablero[i][j]).append(", ");
			}
			tabla.setLength(tabla.length()-2);
			tabla.append("\n");
		}
		tabla.setLength(tabla.length()-1);
		tabla.append(" ]");
		return tabla.toString();
	}
	
	
	private void inicializarJuego() { //acá esta la lógica del random
		for (int i = 0; i < tablero.length; i++) { // false: apagado, true: prendido
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = ((int) Math.round(Math.random()) == 1) ? true : false;
			}
		}
	}
	
	public LightsOut(int filaColumna) {
		tablero = new boolean[filaColumna][filaColumna];
		inicializarJuego(); // asigna los botones encendidos y apagados de forma random
		turnos = 0;
		finalizado = false;
	}
	

	
	public boolean cambiarEstado(int fila, int columna) {
		tablero[fila][columna] = (tablero[fila][columna]) ? false : true;
		return tablero[fila][columna];
	}
	
	public void incrementarContadorTurno() {
		if (finalizado!=true) turnos++;
	}
	
	public int getTurnos() {
		return turnos;
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}

	
	public boolean[][] getTablero(){
		return tablero;
	}
	
	public boolean estaEncendido(int fila, int columna) {
		return tablero[fila][columna];
	}
	
	public boolean estadoDelTablero() {
		boolean encendido = false;
		for(int fila = 0; fila < this.tablero.length; fila++) {
			for(int columna = 0; columna < this.tablero.length; columna++) {
				encendido |= estaEncendido(fila,columna); 
			}
		}
		return finalizado = (!encendido) ? true : false;
	}
	
	public void todosFalse() {
		for(int f = 0; f < this.tablero.length; f++) {
			for(int c = 0; c < this.tablero.length; c++) {
				this.tablero[f][c] = false;
			}
		}
	}
	
	
}	
