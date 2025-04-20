package views;

import java.util.Scanner;

public class ShowConsole {
    private Scanner scanner;

    public ShowConsole(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public int inputEdad() {
        System.out.println("Ingrese la edad que desea buscar: ");
        return scanner.nextInt(); 
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}