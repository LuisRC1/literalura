package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosBusquedaDTO(
        @JsonAlias("count") Integer totalResultados,
        @JsonAlias("results") List<DatosLibroDTO> libros) {
}
