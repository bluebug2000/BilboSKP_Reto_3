package view;

import control.BilboSKP;

public class App {

	public static void main(String[] args) {
		try {
			BilboSKP.cargarSalasOnline();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
