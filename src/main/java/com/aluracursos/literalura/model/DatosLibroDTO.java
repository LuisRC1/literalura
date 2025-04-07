package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibroDTO(
        Integer id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutorDTO> autores) {
}
