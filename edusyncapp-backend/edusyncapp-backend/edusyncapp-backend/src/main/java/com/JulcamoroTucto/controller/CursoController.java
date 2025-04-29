package com.JulcamoroTucto.controller;


import com.JulcamoroTucto.assembler.CursoAssembler;
import com.JulcamoroTucto.dto.Cursodto;
import com.JulcamoroTucto.model.Curso;
import com.JulcamoroTucto.service.ICursoService;
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
@RequestMapping("/cursos")
public class CursoController {

    private final ICursoService service;
    private final CursoAssembler assembler;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Cursodto>>> findAll() throws Exception {
        List<Curso> list = service.findAll();
        List<EntityModel<Cursodto>> cursosResource = list.stream()
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(cursosResource));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Cursodto>> findById(@PathVariable("id") Integer id) throws Exception {
        Curso curso = service.findById(id);
        EntityModel<Cursodto> cursoResource = assembler.toModel(curso);
        return ResponseEntity.ok(cursoResource);
    }

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody Curso curso) throws Exception {
        Curso newCurso = service.save(curso);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newCurso.getIdCurso()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Cursodto>> update(@PathVariable("id") Integer id, @RequestBody Curso curso) throws Exception {
        Curso updatedCurso = service.update(curso, id);
        EntityModel<Cursodto> cursoResource = assembler.toModel(updatedCurso);
        return ResponseEntity.ok(cursoResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
