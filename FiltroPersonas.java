package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}

public class FiltroPersonas {
    public static <T> List<T> filtrar(List<T> elementos, Predicate<T> filtro) {
        List<T> resultado = new ArrayList<>();
        for (T elemento : elementos) {
            if (filtro.test(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan", 25));
        personas.add(new Persona("María", 35));
        personas.add(new Persona("Carlos", 40));
        personas.add(new Persona("Laura", 28));

        // Expresión lambda para filtrar personas mayores de 30 años
        Predicate<Persona> filtroEdad = persona -> persona.getEdad() > 30;

        // Filtrar y mostrar los nombres de las personas mayores de 30 años
        List<Persona> personasFiltradas = filtrar(personas, filtroEdad);
        System.out.println("Personas mayores de 30 años:");
        for (Persona persona : personasFiltradas) {
            System.out.println(persona.getNombre());
        }
    }
}