package com.JulcamoroTucto.assembler;

import com.JulcamoroTucto.dto.Cursodto;
import com.JulcamoroTucto.controller.CursoController;
import com.JulcamoroTucto.model.Curso;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class CursoAssembler {

    // Método para convertir la entidad Curso a Cursodto y agregar enlaces HATEOAS
    public EntityModel<Cursodto> toModel(Curso curso) {
        // Convertir la entidad Curso a su DTO correspondiente
        Cursodto cursoDTO = new Cursodto(
                curso.getIdCurso(),
                curso.getNombre(),
                curso.getCodigo(),
                curso.getDescripcion(),
                curso.getCreditos()
        );

        // Crear el modelo de la entidad con el DTO
        EntityModel<Cursodto> cursoResource = EntityModel.of(cursoDTO);

        // Crear los enlaces HATEOAS
        Link selfLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(CursoController.class).getClass()
        ).slash(curso.getIdCurso()).withSelfRel();

        Link updateLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(CursoController.class).getClass()
        ).slash(curso.getIdCurso()).withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(CursoController.class).getClass()
        ).slash(curso.getIdCurso()).withRel("delete");

        cursoResource.add(selfLink, updateLink, deleteLink);

        return cursoResource;
    }
}