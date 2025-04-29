package com.JulcamoroTucto.controller;

import com.JulcamoroTucto.assembler.EstudianteAssembler;
import com.JulcamoroTucto.dto.Estudiantedto;
import com.JulcamoroTucto.model.Estudiante;
import com.JulcamoroTucto.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final IEstudianteService service;
    private final EstudianteAssembler assembler;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Estudiantedto>>> findAll() throws Exception {
        List<Estudiante> list = service.findAll();
        List<EntityModel<Estudiantedto>> estudiantesResource = list.stream()
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(estudiantesResource));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Estudiantedto>> findById(@PathVariable("id") Integer id) throws Exception {
        Estudiante estudiante = service.findById(id);
        EntityModel<Estudiantedto> estudianteResource = assembler.toModel(estudiante);
        return ResponseEntity.ok(estudianteResource);
    }

    @PostMapping
    public ResponseEntity<Estudiante> save(@RequestBody Estudiante estudiante) throws Exception {
        Estudiante newEstudiante = service.save(estudiante);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newEstudiante.getIdEstud()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Estudiantedto>> update(@PathVariable("id") Integer id, @RequestBody Estudiante estudiante) throws Exception {
        Estudiante updatedEstudiante = service.update(estudiante, id);
        EntityModel<Estudiantedto> estudianteResource = assembler.toModel(updatedEstudiante);
        return ResponseEntity.ok(estudianteResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}