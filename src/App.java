import controllers.MetodoBuqueda;
import java.util.Scanner;
import models.Persona;
import views.ShowConsole;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShowConsole console = new ShowConsole(scanner);
        
        int cantidad = console.inputCantidadPersonas();
        Persona[] personas = new Persona[cantidad];
        
        for(int i = 0; i < cantidad; i++) {
            System.out.println("\nDatos de la persona #" + (i+1));
            String nombre = console.inputNombre();
            int edad = console.inputEdadPersona();
            personas[i] = new Persona(nombre, edad);
        }
        
        MetodoBuqueda buscar = new MetodoBuqueda(personas);
        buscar.showPersonByEdad();
        
        scanner.close();
    }
}