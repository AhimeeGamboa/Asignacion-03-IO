package com.mycompany.javaioas3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ASIGNACION3io {

    File archivo = new File("alumnos_io.txt");
    List<String> lineas = new ArrayList();
    
    public void escribir(String linea){
    
        leer();
        
        //ESCRITURA
        try(//1
             BufferedWriter escritor = 
               new BufferedWriter(//2
                 new OutputStreamWriter(//3
                   new FileOutputStream(archivo),
                         StandardCharsets.UTF_8
                 )//3
               )//2
            ){//1
                for(String linea_saved: lineas){
                    escritor.write(linea_saved);
                    escritor.newLine();
                }
                escritor.write(linea);
                escritor.newLine();                
                System.out.println("Archivo guardado con exito");
        }catch(IOException e){
                System.out.println(
                        "Error al escribir "
                                +e.getMessage());
            }
        
    }
    
        public void leer(){
        //Limpiamos arreglo para evitar duplicados
        lineas = new ArrayList(); 
        //LECTURA
        try(//1
               BufferedReader lector =
                       new BufferedReader(//2
                         new InputStreamReader(//3      
                            new FileInputStream(//4
                            archivo
                            ), StandardCharsets.UTF_8//4
                         )//3
                       )//2
                ){//1
            String linea = "";
            while((linea = lector.readLine()) 
                    != null){
                lineas.add(linea);
            }
        }catch(IOException e){
            System.out.println("Error al leer "
                    +e.getMessage());
        }
    }
    
    public List<String> getLista(){
        return lineas;
    }

    private void guardarTodo() {
        try (BufferedWriter escritor = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(archivo),
                    StandardCharsets.UTF_8
                )
            )) {
            for (String lineaSaved : lineas) {
                escritor.write(lineaSaved);
                escritor.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // Método para ACTUALIZAR por ID
    public void actualizarPorId(String id, String nuevoNombre) {
        leer(); 
        boolean encontrado = false;
        
        for (int i = 0; i < lineas.size(); i++) {
            if (lineas.get(i).startsWith(id)) {
                lineas.set(i, id + " - " + nuevoNombre);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            guardarTodo();
            System.out.println("Registro actualizado con éxito.");
        } else {
            System.out.println("No se encontró el ID: " + id);
        }
    }

    // Método para ELIMINAR por ID
    public void eliminarPorId(String id) {
        leer(); 
        boolean encontrado = false;
        
        for (int i = 0; i < lineas.size(); i++) {
            if (lineas.get(i).startsWith(id)) {
                lineas.remove(i);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            guardarTodo();
            System.out.println("Registro eliminado con éxito.");
        } else {
            System.out.println("No se encontró el ID: " + id);
        }
    }
}
