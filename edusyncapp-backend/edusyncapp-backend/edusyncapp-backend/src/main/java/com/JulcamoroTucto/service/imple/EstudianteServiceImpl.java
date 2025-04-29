package com.JulcamoroTucto.service.imple;

import com.JulcamoroTucto.model.Estudiante;
import com.JulcamoroTucto.repository.IEstudianteRepo;
import com.JulcamoroTucto.repository.IGeneRepo;
import com.JulcamoroTucto.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl  extends GenericImple<Estudiante, Integer>implements IEstudianteService {
    private final IEstudianteRepo repo;

    @Override
    protected IGeneRepo<Estudiante, Integer> getRepo() {
        return repo;
    }
}
