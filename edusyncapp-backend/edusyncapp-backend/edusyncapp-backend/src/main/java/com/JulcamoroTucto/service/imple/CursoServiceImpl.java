package com.JulcamoroTucto.service.imple;

import com.JulcamoroTucto.model.Curso;
import com.JulcamoroTucto.repository.ICursoRepo;
import com.JulcamoroTucto.repository.IGeneRepo;
import com.JulcamoroTucto.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends GenericImple<Curso,Integer>implements ICursoService {

    private final ICursoRepo repo;

    @Override
    protected IGeneRepo<Curso, Integer> getRepo() {
        return repo;
    }
}