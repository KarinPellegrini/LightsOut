package presenter;

import model.LightsOut;

public class Presenter {
	private LightsOut game;
	
	public Presenter(int numeroNivel) {
		game = new LightsOut(numeroNivel);
	}
	
	public int largoDelTablero() {
		return game.getTablero().length;
	}
	
	public boolean estaEncendida(int fila, int col) {
		return game.estaEncendido(fila, col);
	}
	
	public void cambiarEstado(int fila, int col) {
		game.cambiarEstado(fila, col);
	}
	
	public int sumarUnTurno() {
		game.incrementarContadorTurno();
		return game.getTurnos();
	}
	
	public void estadoDelTablero() {
		System.out.println(game.dameTablero()+"\n");
	}
	
	public boolean verificaEstadoDelTablero() {
		return game.estadoDelTablero();
	}
	
	public void todosFalse() {
		game.todosFalse();
	}
	
}
