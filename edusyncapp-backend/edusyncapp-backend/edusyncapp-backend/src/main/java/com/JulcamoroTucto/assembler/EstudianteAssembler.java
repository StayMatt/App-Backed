package com.JulcamoroTucto.assembler;


import com.JulcamoroTucto.dto.Estudiantedto;
import com.JulcamoroTucto.controller.EstudianteController;
import com.JulcamoroTucto.model.Estudiante;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class EstudianteAssembler {

    // Método para convertir la entidad Estudiante a Estudiantedto y agregar enlaces HATEOAS
    public EntityModel<Estudiantedto> toModel(Estudiante estudiante) {
        // Convertir la entidad Estudiante a su DTO correspondiente
        Estudiantedto estudianteDTO = new Estudiantedto(
                estudiante.getIdEstud(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getEmail(),
                estudiante.getCarrera()
        );

        EntityModel<Estudiantedto> studentResource = EntityModel.of(estudianteDTO);
        Link selfLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(EstudianteController.class).getClass()
        ).slash(estudiante.getIdEstud()).withSelfRel();

        Link updateLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(EstudianteController.class).getClass()
        ).slash(estudiante.getIdEstud()).withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(EstudianteController.class).getClass()
        ).slash(estudiante.getIdEstud()).withRel("delete");

        studentResource.add(selfLink, updateLink, deleteLink);

        return studentResource;
    }

}
