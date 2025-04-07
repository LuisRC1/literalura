package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.DatosBusquedaDTO;
import com.aluracursos.literalura.model.DatosLibroDTO;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvertidorDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner entradaTeclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "http://gutendex.com/books/?";
    private final String BUSQUEDA = "search=";
    private ConvertidorDatos convertidorDatos = new ConvertidorDatos();
    List<DatosLibroDTO> datosLibroDTO = new ArrayList<>();

    public void mostrarMenu() {
        System.out.println("1.- Agregar libro por nombre");
//        Busca los datos generales de los libros
        var nombreLibro = entradaTeclado.nextLine().toLowerCase();
        var json = consumoAPI.obtenerDatos(URL_BASE + BUSQUEDA + nombreLibro.replace(" ", "+"));
        System.out.println(json);
        var datosBusqueda = convertidorDatos.obtenerDatos(json, DatosBusquedaDTO.class);
        System.out.println(datosBusqueda);

        datosLibroDTO.addAll(datosBusqueda.libros());

//         Imprimir los libros obtenidos
        datosLibroDTO.forEach(System.out::println);
//        datosLibroDTO.forEach(datosLibro -> {
//            System.out.println("Título: " + datosLibro.titulo());
//            String autores = datosLibro.autores().stream()
//                    .map(autor -> autor.nombre() + " (Nació: " + autor.anioNacimiento() + ", Falleció: " + autor.anioFallecimiento() + ")")
//                    .collect(Collectors.joining(" | ")); // Separador entre autores
//            System.out.println("Autores: " + autores);
//        });
    }
}
