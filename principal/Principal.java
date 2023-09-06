package principal;

import java.awt.EventQueue;
import view.Interfaz;

public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}