package controllers;

import java.util.Scanner;
import models.Persona;
import views.ShowConsole;

public class MetodoBuqueda {
    private Persona[] personas;
    private ShowConsole pantalla;

    public MetodoBuqueda(Persona[] personas) {
        this.personas = personas;
        this.pantalla = new ShowConsole(new Scanner(System.in)); 
        ordenarArreglo();
         
    }

    private void ordenarArreglo() {
        for (int i = 0; i < personas.length - 1; i++) {
            for (int j = 0; j < personas.length - 1 - i; j++) {
                if (personas[j].getEdad() > personas[j + 1].getEdad()) {
                    Persona temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }
    }
 
    private int findPersonByEdad(int code) {
        int bajo = 0;
        int alto = personas.length - 1;
       
        String arregloCompleto = imprimirArreglo(bajo, alto);
        pantalla.showMessage(arregloCompleto);
        
        while (bajo <= alto) {
            int central = (bajo + alto) / 2;
            int valorCentro = personas[central].getEdad();
            
            String direccion;
            if (valorCentro == code) {
                direccion = "ENCONTRADO";
            } else if (valorCentro > code) {
                direccion = "IZQUIERDA";
            } else {
                direccion = "DERECHA";
            }
            
            String mensaje = "bajo = " + bajo + "    alto = " + alto + 
                            "    centro = " + central + 
                            "    valorCentro = " + valorCentro +
                            "    --> " + direccion;
            
            pantalla.showMessage(mensaje);
            
            if (valorCentro == code) {
                return central;
            }
            if (valorCentro > code) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
            
            if (bajo <= alto) {
                String subArreglo = imprimirArreglo(bajo, alto);
                pantalla.showMessage(subArreglo);
            }
        }
        return -1;
    }
    
    private String imprimirArreglo(int inicio, int fin) {
        String resultado = "";
        for (int i = inicio; i <= fin; i++) {
            resultado += personas[i].getEdad();
            if (i < fin) {
                resultado += " | ";
            }
        }
        return resultado;
    }
    
    public void showPersonByEdad() {
        int edadBuscada = pantalla.inputEdad();
        
        int indice = findPersonByEdad(edadBuscada);
        
        if (indice != -1) {
            String nombre = personas[indice].getNombre();
            pantalla.showMessage("\nLa persona con la edad " + edadBuscada + 
                               " es " + nombre);
        } else {
            pantalla.showMessage("\nNo se encontró persona con edad " + edadBuscada);
        }
    }
}