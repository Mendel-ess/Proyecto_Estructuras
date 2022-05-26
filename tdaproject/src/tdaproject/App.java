package tdaproject;
import gui.VentanaPrincipal;

public class App {
	
	public App() {
		mostrarInterfaz();
	}
	
	public void mostrarInterfaz() {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}
}
