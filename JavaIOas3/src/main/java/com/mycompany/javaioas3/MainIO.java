
package com.mycompany.javaioas3;

import java.util.Scanner;

public class MainIO {

    public static void main(String[] args) {
        
        ASIGNACION3io aio = new ASIGNACION3io();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n========== MENÚ ALUMNOS ==========");
            System.out.println("1. Ver lista de alumnos");
            System.out.println("2. Agregar alumno");
            System.out.println("3. Actualizar alumno por ID");
            System.out.println("4. Eliminar alumno por ID");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    aio.leer();
                    System.out.println("\n--- LISTA DE ALUMNOS ---");
                    if (aio.getLista().isEmpty()) {
                        System.out.println("No hay alumnos registrados.");
                    } else {
                        for (String alumno : aio.getLista()) {
                            System.out.println(alumno);
                        }
                    }
                    break;

                case "2":
                    System.out.print("Ingresa la matrícula/ID: ");
                    String idAgregar = scanner.nextLine();
                    System.out.print("Ingresa el Nombre Completo: ");
                    String nombreAgregar = scanner.nextLine();
                    
                    aio.escribir(idAgregar + " - " + nombreAgregar);
                    break;

                case "3":
                    System.out.print("Ingresa el ID del alumno a actualizar: ");
                    String idEditar = scanner.nextLine();
                    System.out.print("Ingresa el Nuevo Nombre Completo: ");
                    String nuevoNombre = scanner.nextLine();
                    
                    aio.actualizarPorId(idEditar, nuevoNombre);
                    break;

                case "4":
                    System.out.print("Ingresa el ID del alumno a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    
                    aio.eliminarPorId(idEliminar);
                    break;

                case "5":
                    salir = true;
                    System.out.println("¡Saliendo del programa!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}