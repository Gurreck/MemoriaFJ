/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.uisil.practicaprogramada3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author DANIEL
 */
public class PracticaProgramada3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listaNombres = new ArrayList<>();
        Set<String> nombresUnicos = new HashSet<>();
        Stack<String> historial = new Stack<>();
        Map<String, String> agenda = new HashMap<>();
        

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar todos los nombres");
            System.out.println("3. Mostrar nombres únicos");
            System.out.println("4. Mostrar agenda completa");
            System.out.println("5. Deshacer última acción");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    listaNombres.add(nombre);
                    nombresUnicos.add(nombre);
                    historial.push(nombre);
                    agenda.put(nombre, telefono);

                    System.out.println("Contacto agregado.");
                    break;

                case 2:
                    System.out.println("Todos los nombres: " + listaNombres);
                    break;

                case 3:
                    System.out.println("Nombres únicos: " + nombresUnicos);
                    break;

                case 4:
                    System.out.println("Agenda:");
                    for (String nom : agenda.keySet()) {
                        System.out.println(nom + " → " + agenda.get(nom));
                    }
                    break;

                case 5:
                    if (!historial.isEmpty()) {
                        String ultimo = historial.pop();
                        listaNombres.remove(ultimo);
                        nombresUnicos.remove(ultimo);
                        agenda.remove(ultimo);
                        System.out.println("Deshecho: " + ultimo);
                    } else {
                        System.out.println("No hay acciones para deshacer.");
                    }
                    break;

                case 6:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
